package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Inventory;
import cn.fpa.logistics.entity.Receipt;
import cn.fpa.logistics.entity.vo.InventoryVo;
import cn.fpa.logistics.entity.vo.ReceiptVo;
import cn.fpa.logistics.service.IInventoryService;
import cn.fpa.logistics.service.IReceiptService;
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
@RequestMapping("/inventory")
public class InventoryController {
    @Resource
    IInventoryService inventoryService;
    @PostMapping("/addInventory")
    public R addQuote(@RequestBody Inventory inventory){
        inventoryService.save(inventory);
        return  R.ok();
    }
    @GetMapping("/deleteInventoryById")
    public R deleteQuoteById(@RequestParam("id") String id){
//
        inventoryService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateInventory")
    public R updateQuote(@RequestBody Inventory inventory){
        inventoryService.updateById(inventory);
        return  R.ok();
    }
    @PostMapping ("/queryInventoryList")
    public R queryQuoteList(@RequestBody InventoryVo vo){
        LambdaQueryWrapper<Inventory> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(Inventory::getStatus, vo.getStatus());
        }
        if(StringUtils.isNotEmpty(vo.getReceiptNumber())){

            lambdaQueryWrapper.eq(Inventory::getReceiptNumber,vo.getReceiptNumber());
        }

        if(StringUtils.isNotEmpty(vo.getShipper())){
            lambdaQueryWrapper.eq(Inventory::getShipper,vo.getShipper());
        }
        if(StringUtils.isNotEmpty(vo.getConsignee())){
            lambdaQueryWrapper.eq(Inventory::getConsignee,vo.getConsignee());
        }

        lambdaQueryWrapper.orderByDesc(Inventory::getCreateTime);
        int total = inventoryService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Inventory> list = inventoryService.list(lambdaQueryWrapper);
//        list.stream().forEach(q->{
//            q.setReceiptNumber("WRI"+q.getId());
//        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("inventoryList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getInventoryDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){

        Inventory byId = inventoryService.getById(id);
//        if(byId!=null) {
//            byId.setReceiptNumber("WRI" + byId.getId());
//        }
        return  R.ok().data("inventoryInfo",byId);
    }

}
