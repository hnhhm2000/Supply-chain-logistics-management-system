package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.PickupDelivery;
import cn.fpa.logistics.entity.Receipt;
import cn.fpa.logistics.entity.vo.PickupDeliveryVo;
import cn.fpa.logistics.entity.vo.ReceiptVo;
import cn.fpa.logistics.service.IPickupDeliveryService;
import cn.fpa.logistics.service.IReceiptService;
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
@RequestMapping("/receipt")
public class ReceiptController {
    @Resource
    IReceiptService receiptService;
    @PostMapping("/addReceipt")
    public R addQuote(@RequestBody Receipt receipt){
        receiptService.save(receipt);
        return  R.ok();
    }
    @GetMapping("/deleteReceiptById")
    public R deleteQuoteById(@RequestParam("id") String id){
//
        receiptService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateReceipt")
    public R updateQuote(@RequestBody Receipt receipt){
        receiptService.updateById(receipt);
        return  R.ok();
    }
    @PostMapping ("/queryReceiptList")
    public R queryQuoteList(@RequestBody ReceiptVo vo){
        LambdaQueryWrapper<Receipt> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(Receipt::getStatus, vo.getStatus());
        }
        if(StringUtils.isNotEmpty(vo.getReceiptNumber())){
            String id = vo.getReceiptNumber();
            if(StringUtils.isNotEmpty(id))
                id=id.replace("WRI","");
            vo.setReceiptNumber(id);
            lambdaQueryWrapper.eq(Receipt::getId,vo.getReceiptNumber());
        }

        if(StringUtils.isNotEmpty(vo.getCreateBy())){
            lambdaQueryWrapper.eq(Receipt::getCreateBy,vo.getCreateBy());
        }

        lambdaQueryWrapper.orderByDesc(Receipt::getCreateTime);
        int total = receiptService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Receipt> list = receiptService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setReceiptNumber("WRI"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("receiptList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getReceiptDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){

        Receipt byId = receiptService.getById(id);
        if(byId!=null) {
            byId.setReceiptNumber("WRI" + byId.getId());
        }
        return  R.ok().data("receiptInfo",byId);
    }

}
