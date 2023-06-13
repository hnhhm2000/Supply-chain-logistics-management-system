package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Quote;
import cn.fpa.logistics.entity.ShipmentOrder;
import cn.fpa.logistics.entity.vo.QuoteVo;
import cn.fpa.logistics.entity.vo.ShipmentOrderVo;
import cn.fpa.logistics.service.IQuoteService;
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
@RequestMapping("/shipmentOrder")
public class ShipmentOrderController {
    @Resource
    IShipmentOrderService shipmentOrderService;
    @PostMapping("/addShipmentOrder")
    public R addQuote(@RequestBody ShipmentOrder shipmentOrder){
        shipmentOrderService.save(shipmentOrder);
        return  R.ok();
    }
    @GetMapping("/deleteShipmentOrderById")
    public R deleteQuoteById(@RequestParam("id") String id){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        shipmentOrderService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateShipmentOrder")
    public R updateQuote(@RequestBody ShipmentOrder shipmentOrder){
        shipmentOrderService.updateById(shipmentOrder);
        return  R.ok();
    }
    @PostMapping ("/queryShipmentOrderList")
    public R queryQuoteList(@RequestBody ShipmentOrderVo vo){
        LambdaQueryWrapper<ShipmentOrder> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(ShipmentOrder::getStatus, vo.getStatus());
        }
        if(StringUtils.isNotEmpty(vo.getShipmentOrderNumber())){
            String id = vo.getShipmentOrderNumber();
            if(StringUtils.isNotEmpty(id))
                id=id.replace("SAO","");
            vo.setShipmentOrderNumber(id);
            lambdaQueryWrapper.eq(ShipmentOrder::getId,vo.getShipmentOrderNumber());
        }
        if(StringUtils.isNotEmpty(vo.getCreateBy())){
            lambdaQueryWrapper.eq(ShipmentOrder::getCreateBy,vo.getCreateBy());
        }
        if(vo.getDeparture()!=null){
            String format = DateUtil.format(vo.getDeparture(), "yyyy-MM-dd");
            lambdaQueryWrapper.like(ShipmentOrder::getDeparture,format);
        }
        if(StringUtils.isNotEmpty(vo.getShipper())){
            lambdaQueryWrapper.eq(ShipmentOrder::getShipper,vo.getShipper());
        }
        if(StringUtils.isNotEmpty(vo.getConsignee())){
            lambdaQueryWrapper.eq(ShipmentOrder::getConsignee,vo.getConsignee());
        }

        lambdaQueryWrapper.orderByDesc(ShipmentOrder::getCreateTime);
        int total = shipmentOrderService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<ShipmentOrder> list = shipmentOrderService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setShipmentOrderNumber("SAO"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("shipmentOrderList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getShipmentOrderDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        ShipmentOrder byId = shipmentOrderService.getById(id);
        if(byId!=null) {
            byId.setShipmentOrderNumber("SAO" + byId.getId());
        }
        return  R.ok().data("shipmentOrderInfo",byId);
    }
}
