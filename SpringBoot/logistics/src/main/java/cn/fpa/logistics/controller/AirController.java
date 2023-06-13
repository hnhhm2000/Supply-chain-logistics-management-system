package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Air;
import cn.fpa.logistics.entity.Release;
import cn.fpa.logistics.entity.vo.AirVo;
import cn.fpa.logistics.entity.vo.ReleaseVo;
import cn.fpa.logistics.service.IAirService;
import cn.fpa.logistics.service.IReleaseService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
@RequestMapping("/air")
public class AirController {
    @Resource
    IAirService airService;
    @PostMapping("/addAir")
    public R addQuote(@RequestBody Air air){
        airService.save(air);
        return  R.ok();
    }
    @GetMapping("/deleteAirById")
    public R deleteQuoteById(@RequestParam("id") String id){
//
        airService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateAir")
    public R updateQuote(@RequestBody Air air){
        airService.updateById(air);
        return  R.ok();
    }
    @PostMapping ("/queryAirList")
    public R queryQuoteList(@RequestBody AirVo vo){
        LambdaQueryWrapper<Air> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(Air::getStatus, vo.getStatus());
        }
        if(StringUtils.isNotEmpty(vo.getAirNumber())){
            String id = vo.getAirNumber();
            if(StringUtils.isNotEmpty(id))
                id=id.replace("AIR","");
            vo.setAirNumber(id);
            lambdaQueryWrapper.eq(Air::getId,vo.getAirNumber());
        }

        if(StringUtils.isNotEmpty(vo.getOrigin())){
            lambdaQueryWrapper.eq(Air::getOrigin,vo.getOrigin());
        }
        if(StringUtils.isNotEmpty(vo.getDestination())){
            lambdaQueryWrapper.eq(Air::getDestination,vo.getDestination());
        }
        if(vo.getBeginDate()!=null ){
            String format = DateUtil.format(vo.getBeginDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.ge(Air::getDeparture,format);
        }
        if( vo.getEndDate()!=null){
            String format = DateUtil.format(vo.getEndDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.le(Air::getArrival,format);
        }

        lambdaQueryWrapper.orderByDesc(Air::getCreateTime);
        int total = airService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Air> list = airService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setAirNumber("AIR"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("airList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getAirDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){

        Air byId = airService.getById(id);
        if(byId!=null) {
            byId.setAirNumber("AIR" + byId.getId());
        }
        return  R.ok().data("airInfo",byId);
    }


}
