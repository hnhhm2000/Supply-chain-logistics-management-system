package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.*;
import cn.fpa.logistics.entity.vo.QuoteVo;
import cn.fpa.logistics.service.*;
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
 * @since 2023-05-19
 */
@RestController
@CrossOrigin
@RequestMapping("/quote")
public class QuoteController {
    @Resource
    IQuoteService quoteService;
    @Resource
    IUserService userService;

    @Resource
    IInventoryService inventoryService;
    @Resource
    IInvoiceService invoiceService;
    @Resource
    IFeeService feeService;
    @Resource
    IBillService billService;
    @Resource
    ITaskService taskService;
    @PostMapping("/addQuote")
    public R addQuote(@RequestBody Quote quote){
        quoteService.save(quote);
        return  R.ok();
    }
    @GetMapping("/deleteQuoteById")
    public R deleteQuoteById(@RequestParam("id") String id){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        quoteService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateQuote")
    public R updateQuote(@RequestBody Quote quote){
//        String id = quote.getId();
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
//        quote.setId(id);
        quoteService.updateById(quote);
        return  R.ok();
    }
    @PostMapping ("/queryQuoteList")
    public R queryQuoteList(@RequestBody QuoteVo quoteVo){
        LambdaQueryWrapper<Quote> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(quoteVo.getStatus())) {
            lambdaQueryWrapper.eq(Quote::getStatus, quoteVo.getStatus());
        }
        if(StringUtils.isNotEmpty(quoteVo.getQuoteNumber())){
            String id = quoteVo.getQuoteNumber();
            if(StringUtils.isNotEmpty(id))
                id=id.replace("QUO","");
            quoteVo.setQuoteNumber(id);
            lambdaQueryWrapper.eq(Quote::getId,quoteVo.getQuoteNumber());
        }
        if(StringUtils.isNotEmpty(quoteVo.getMode())){
            lambdaQueryWrapper.eq(Quote::getMode,quoteVo.getMode());
        }
        if(StringUtils.isNotEmpty(quoteVo.getCustomer())){
            lambdaQueryWrapper.like(Quote::getCustomer,quoteVo.getCustomer());
        }
        if(StringUtils.isNotEmpty(quoteVo.getOrigin())){
            lambdaQueryWrapper.eq(Quote::getOrigin,quoteVo.getOrigin());
        }
        if(StringUtils.isNotEmpty(quoteVo.getDestination())){
            lambdaQueryWrapper.eq(Quote::getDestination,quoteVo.getDestination());
        }
        if(StringUtils.isNotEmpty(quoteVo.getCarrier())){
            lambdaQueryWrapper.like(Quote::getCarrier,quoteVo.getCarrier());
        }
        if(StringUtils.isNotEmpty(quoteVo.getUpdateBy())){
            lambdaQueryWrapper.like(Quote::getUpdateBy,quoteVo.getUpdateBy());
        }
        if(quoteVo.getCreatedDate()!=null){
            lambdaQueryWrapper.ge(Quote::getCreatedDate,quoteVo.getCreatedDate());
        }
        if(quoteVo.getUntilDate()!=null){
            lambdaQueryWrapper.le(Quote::getUntilDate,quoteVo.getUntilDate());
        }
        lambdaQueryWrapper.orderByDesc(Quote::getCreateTime);
        int total = quoteService.list(lambdaQueryWrapper).size();
        String sql="limit "+(quoteVo.getCurrPage()-1)* quoteVo.getPageSize()+","+((quoteVo.getCurrPage()-1)* quoteVo.getPageSize()+quoteVo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Quote> list = quoteService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setQuoteNumber("QUO"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",quoteVo.getCurrPage());
        map.put("pageSize",quoteVo.getPageSize());
        map.put("total",total);//总数量
        map.put("quoteList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getQuoteDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        Quote byId = quoteService.getById(id);
        if(byId!=null) {
            byId.setQuoteNumber("QUO" + byId.getId());
        }
        return  R.ok().data("quoteInfo",byId);
    }

    @PostMapping("/addFee")
    public  R addFee(@RequestBody Fee fee){
        feeService.save(fee);
        return  R.ok();
    }
    @PostMapping("/updateFee")
    public  R updateFee(@RequestBody Fee fee){
        feeService.save(fee);
        return  R.ok();
    }
    @GetMapping("/deleteFeeById")
    public R deleteFeeById(@RequestParam("id") String id){
        invoiceService.remove(new LambdaQueryWrapper<Invoice>().eq(Invoice::getFeeId,id));
        billService.remove(new LambdaQueryWrapper<Bill>().eq(Bill::getFeeId,id));
        feeService.removeById(id);
        return  R.ok();
    }
    @GetMapping("/getFeeList")
    public R getFeeList(@RequestParam("id") String id){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        List<Fee> list = feeService.list(new LambdaQueryWrapper<Fee>().eq(Fee::getUserId, id));
        return  R.ok().data("feeList",list);
    }

    @PostMapping("/generateInvoice")
    public  R generateInvoice(@RequestBody Invoice invoice){
        Fee byId = feeService.getById(invoice.getFeeId());
        byId.setStatus("已开票");
        feeService.updateById(byId);
        invoiceService.save(invoice);
        return  R.ok();
    }
    @PostMapping("/generateBill")
    public  R generateBill(@RequestBody Bill bill){
        Fee byId = feeService.getById(bill.getFeeId());
        byId.setStatus("已开票");
        feeService.updateById(byId);
        billService.save(bill);
        return  R.ok();
    }
    @PostMapping("/addTask")
    public R addTask(@RequestBody Task task){
        taskService.save(task);
        return  R.ok();
    }
    @GetMapping("/deleteTaskById")
    public R deleteTaskById(@RequestParam("id") String id){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        taskService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateTask")
    public R updateQuote(@RequestBody Task task){
//        String id = quote.getId();
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
//        quote.setId(id);
        taskService.updateById(task);
        return  R.ok();
    }
    @GetMapping("/getTaskList")
    public R getQuoteList(@RequestParam("id") String id){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        List<Task> list = taskService.list(new LambdaQueryWrapper<Task>().eq(Task::getQuoteId, id));//报价id
//        list.stream().forEach(r->{
//            r.setN("QUO"+r.getId());
//        });
        return  R.ok().data("taskList",list);
    }



}
