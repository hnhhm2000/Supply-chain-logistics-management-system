package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Air;
import cn.fpa.logistics.entity.Ground;
import cn.fpa.logistics.entity.vo.AirVo;
import cn.fpa.logistics.entity.vo.GroundVo;
import cn.fpa.logistics.service.IAirService;
import cn.fpa.logistics.service.IGroundService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-23
 */
@RestController
@CrossOrigin
@RequestMapping("/ground")
public class GroundController {
    @Resource
    IGroundService groundService;
    @PostMapping("/addGround")
    public R addQuote(@RequestBody Ground ground){
        groundService.save(ground);
        return  R.ok();
    }
    @GetMapping("/deleteGroundById")
    public R deleteQuoteById(@RequestParam("id") String id){
//
        groundService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateGround")
    public R updateQuote(@RequestBody Ground ground){
        groundService.updateById(ground);
        return  R.ok();
    }
    @PostMapping ("/queryGroundList")
    public R queryQuoteList(@RequestBody GroundVo vo){
        LambdaQueryWrapper<Ground> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(Ground::getStatus, vo.getStatus());
        }
        if(StringUtils.isNotEmpty(vo.getGroundNumber())){
            String id = vo.getGroundNumber();
            if(StringUtils.isNotEmpty(id))
                id=id.replace("GOC","");
            vo.setGroundNumber(id);
            lambdaQueryWrapper.eq(Ground::getId,vo.getGroundNumber());
        }

        if(StringUtils.isNotEmpty(vo.getOrigin())){
            lambdaQueryWrapper.eq(Ground::getOrigin,vo.getOrigin());
        }
        if(StringUtils.isNotEmpty(vo.getDestination())){
            lambdaQueryWrapper.eq(Ground::getDestination,vo.getDestination());
        }
        if(vo.getBeginDate()!=null ){
            String format = DateUtil.format(vo.getBeginDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.ge(Ground::getDeparture,format);
        }
        if( vo.getEndDate()!=null){
            String format = DateUtil.format(vo.getEndDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.le(Ground::getArrival,format);
        }

        lambdaQueryWrapper.orderByDesc(Ground::getCreateTime);
        int total = groundService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Ground> list = groundService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setGroundNumber("GOC"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("groundList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getGroundDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){

        Ground byId = groundService.getById(id);
        if(byId!=null) {
            byId.setGroundNumber("GOC" + byId.getId());
        }
        return  R.ok().data("groundInfo",byId);
    }

}
