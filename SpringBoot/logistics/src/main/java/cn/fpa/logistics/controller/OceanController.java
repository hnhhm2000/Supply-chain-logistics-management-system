package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Ground;
import cn.fpa.logistics.entity.Ocean;
import cn.fpa.logistics.entity.vo.GroundVo;
import cn.fpa.logistics.entity.vo.OceanVo;
import cn.fpa.logistics.service.IGroundService;
import cn.fpa.logistics.service.IOceanService;
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
@RequestMapping("/ocean")
public class OceanController {
    @Resource
    IOceanService oceanService;
    @PostMapping("/addOcean")
    public R addQuote(@RequestBody Ocean ocean){
        oceanService.save(ocean);
        return  R.ok();
    }
    @GetMapping("/deleteOceanById")
    public R deleteQuoteById(@RequestParam("id") String id){
//
        oceanService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateOcean")
    public R updateQuote(@RequestBody Ocean ocean){
        oceanService.updateById(ocean);
        return  R.ok();
    }
    @PostMapping ("/queryOceanList")
    public R queryQuoteList(@RequestBody OceanVo vo){
        LambdaQueryWrapper<Ocean> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(Ocean::getStatus, vo.getStatus());
        }



        if(StringUtils.isNotEmpty(vo.getCreateBy())){
            lambdaQueryWrapper.eq(Ocean::getCreateBy,vo.getCreateBy());
        }

        if(vo.getBeginDate()!=null ){
            String format = DateUtil.format(vo.getBeginDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.ge(Ocean::getDeparture,format);
        }
        if( vo.getEndDate()!=null){
            String format = DateUtil.format(vo.getEndDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.le(Ocean::getArrival,format);
        }

        lambdaQueryWrapper.orderByDesc(Ocean::getCreateTime);
        int total = oceanService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Ocean> list = oceanService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setOceanNumber("OOD"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("oceanList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getOceanDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){

        Ocean byId = oceanService.getById(id);
        if(byId!=null) {
            byId.setOceanNumber("OOD" + byId.getId());
        }
        return  R.ok().data("oceanInfo",byId);
    }

}
