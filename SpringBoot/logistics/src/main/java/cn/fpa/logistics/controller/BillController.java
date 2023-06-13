package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Bill;
import cn.fpa.logistics.entity.Invoice;
import cn.fpa.logistics.entity.vo.BillVo;
import cn.fpa.logistics.entity.vo.InvoiceVo;
import cn.fpa.logistics.service.IBillService;
import cn.fpa.logistics.service.IInvoiceService;
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
 * @since 2023-05-29
 */
@RestController
@CrossOrigin
@RequestMapping("/bill")
public class BillController {
    @Resource
    IBillService billService;
    @PostMapping("/queryBillList")
    public R queryQuoteList(@RequestBody BillVo vo){
        LambdaQueryWrapper<Bill> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getBillNumber())){
            String inv = vo.getBillNumber().replace("B", "");
            lambdaQueryWrapper.eq(Bill::getId,inv);
        }

        if(StringUtils.isNotEmpty(vo.getCreateBy())){
            lambdaQueryWrapper.eq(Bill::getCreateBy,vo.getCreateBy());
        }

        lambdaQueryWrapper.orderByDesc(Bill::getCreateTime);
        int total = billService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Bill> list = billService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setBillNumber("B"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("billList",list);
        return  R.ok().data(map);
    }
}
