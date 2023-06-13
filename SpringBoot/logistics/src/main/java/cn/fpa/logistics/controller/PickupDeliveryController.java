package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.PickupDelivery;
import cn.fpa.logistics.entity.ShipmentOrder;
import cn.fpa.logistics.entity.vo.PickupDeliveryVo;
import cn.fpa.logistics.entity.vo.ShipmentOrderVo;
import cn.fpa.logistics.service.IPickupDeliveryService;
import cn.fpa.logistics.service.IShipmentOrderService;
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
 * @since 2023-05-22
 */
@RestController
@CrossOrigin
@RequestMapping("/pickupDelivery")
public class PickupDeliveryController {
    @Resource
    IPickupDeliveryService pickupDeliveryService;
    @PostMapping("/addPickupDelivery")
    public R addQuote(@RequestBody PickupDelivery pickupDelivery){
        pickupDeliveryService.save(pickupDelivery);
        return  R.ok();
    }
    @GetMapping("/deletePickupDeliveryById")
    public R deleteQuoteById(@RequestParam("id") String id){
//
        pickupDeliveryService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updatePickupDelivery")
    public R updateQuote(@RequestBody PickupDelivery pickupDelivery){
        pickupDeliveryService.updateById(pickupDelivery);
        return  R.ok();
    }
    @PostMapping ("/queryPickupDeliveryList")
    public R queryQuoteList(@RequestBody PickupDeliveryVo vo){
        LambdaQueryWrapper<PickupDelivery> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(PickupDelivery::getStatus, vo.getStatus());
        }
        if(StringUtils.isNotEmpty(vo.getPickupDeliveryNumber())){
            String id = vo.getPickupDeliveryNumber();
            if(StringUtils.isNotEmpty(id))
                id=id.replace("PKD","");
            vo.setPickupDeliveryNumber(id);
            lambdaQueryWrapper.eq(PickupDelivery::getId,vo.getPickupDeliveryNumber());
        }
        if(StringUtils.isNotEmpty(vo.getCreateBy())){
            lambdaQueryWrapper.eq(PickupDelivery::getCreateBy,vo.getCreateBy());
        }
        if(vo.getPickupDate()!=null){
            String format = DateUtil.format(vo.getPickupDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.eq(PickupDelivery::getPickupDate,format);
        }
        if(StringUtils.isNotEmpty(vo.getCustomer())){
            lambdaQueryWrapper.eq(PickupDelivery::getCustomer,vo.getCustomer());
        }

        lambdaQueryWrapper.orderByDesc(PickupDelivery::getCreateTime);
        int total = pickupDeliveryService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<PickupDelivery> list = pickupDeliveryService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setPickupDeliveryNumber("PKD"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("pickupDeliveryList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getPickupDeliveryDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){

        PickupDelivery byId = pickupDeliveryService.getById(id);
        if(byId!=null) {
            byId.setPickupDeliveryNumber("PKD" + byId.getId());
        }
        return  R.ok().data("pickupDeliveryInfo",byId);
    }

}
