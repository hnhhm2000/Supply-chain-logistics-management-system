package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Receipt;
import cn.fpa.logistics.entity.Release;
import cn.fpa.logistics.entity.vo.ReceiptVo;
import cn.fpa.logistics.entity.vo.ReleaseVo;
import cn.fpa.logistics.service.IReceiptService;
import cn.fpa.logistics.service.IReleaseService;
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
@RequestMapping("/release")
public class ReleaseController {
    @Resource
    IReleaseService releaseService;
    @PostMapping("/addRelease")
    public R addQuote(@RequestBody Release release){
        releaseService.save(release);
        return  R.ok();
    }
    @GetMapping("/deleteReleaseById")
    public R deleteQuoteById(@RequestParam("id") String id){
//
        releaseService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateRelease")
    public R updateQuote(@RequestBody Release release){
        releaseService.updateById(release);
        return  R.ok();
    }
    @PostMapping ("/queryReleaseList")
    public R queryQuoteList(@RequestBody ReleaseVo vo){
        LambdaQueryWrapper<Release> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getStatus())) {
            lambdaQueryWrapper.eq(Release::getStatus, vo.getStatus());
        }
        if(StringUtils.isNotEmpty(vo.getReleaseNumber())){
            String id = vo.getReleaseNumber();
            if(StringUtils.isNotEmpty(id))
                id=id.replace("WRO","");
            vo.setReleaseNumber(id);
            lambdaQueryWrapper.eq(Release::getId,vo.getReleaseNumber());
        }

        if(StringUtils.isNotEmpty(vo.getCreateBy())){
            lambdaQueryWrapper.eq(Release::getCreateBy,vo.getCreateBy());
        }

        lambdaQueryWrapper.orderByDesc(Release::getCreateTime);
        int total = releaseService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        List<Release> list = releaseService.list(lambdaQueryWrapper);
        list.stream().forEach(q->{
            q.setReleaseNumber("WRO"+q.getId());
        });
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("releaseList",list);
        return  R.ok().data(map);
    }
    @GetMapping("/getReceiptDetailsById")
    public R getQuoteDetailsById(@RequestParam("id") String id){

        Release byId = releaseService.getById(id);
        if(byId!=null) {
            byId.setReleaseNumber("WRO" + byId.getId());
        }
        return  R.ok().data("releaseInfo",byId);
    }

}
