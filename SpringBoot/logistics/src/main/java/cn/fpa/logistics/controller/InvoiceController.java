package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Invoice;
import cn.fpa.logistics.entity.Ocean;
import cn.fpa.logistics.entity.vo.InvoiceVo;
import cn.fpa.logistics.entity.vo.OceanVo;
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
@RequestMapping("/invoice")
public class InvoiceController {
    @Resource
    IInvoiceService invoiceService;
    @PostMapping("/queryInvoiceList")
    public R queryQuoteList(@RequestBody InvoiceVo vo){
        LambdaQueryWrapper<Invoice> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getInvoiceNumber())){
            String inv = vo.getInvoiceNumber().replace("INV", "");
            lambdaQueryWrapper.eq(Invoice::getId,inv);
        }
        if(StringUtils.isNotEmpty(vo.getPayment())) {
            lambdaQueryWrapper.eq(Invoice::getPayment, vo.getPayment());
        }
        if(StringUtils.isNotEmpty(vo.getCreateBy())){
            lambdaQueryWrapper.eq(Invoice::getCreateBy,vo.getCreateBy());
        }

        if(vo.getBeginDate()!=null ){
            String format = DateUtil.format(vo.getBeginDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.ge(Invoice::getKaiDate,format);
        }
        if( vo.getEndDate()!=null){
            String format = DateUtil.format(vo.getEndDate(), "yyyy-MM-dd");
            lambdaQueryWrapper.le(Invoice::getDueDate,format);
        }

        lambdaQueryWrapper.orderByDesc(Invoice::getCreateTime);
        int total = invoiceService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Invoice> list = invoiceService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setInvoiceNumber("INV"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("invoiceList",list);
        return  R.ok().data(map);
    }
}
