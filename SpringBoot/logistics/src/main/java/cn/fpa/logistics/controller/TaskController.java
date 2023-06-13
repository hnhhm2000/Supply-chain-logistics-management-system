package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.entity.Quote;
import cn.fpa.logistics.entity.Task;
import cn.fpa.logistics.entity.User;
import cn.fpa.logistics.entity.vo.TaskVo;
import cn.fpa.logistics.service.IQuoteService;
import cn.fpa.logistics.service.ITaskService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
@RequestMapping("/task")
public class TaskController {
    @Resource
    ITaskService taskService;
    @PostMapping("/addTask")
    public R addQuote(@RequestBody Task task){
        taskService.save(task);
        return  R.ok();
    }
    @GetMapping("/deleteTaskById")
    public R deleteQuoteById(@RequestParam("id") String id){
        taskService.removeById(id);
        return  R.ok();
    }
    @PostMapping("/updateTask")
    public R updateQuote(@RequestBody Task task){

        taskService.updateById(task);
        return  R.ok();
    }
    @PostMapping("/getTaskList")
    public R getTaskList(@RequestBody TaskVo vo){
        LambdaQueryWrapper<Task> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        int total = taskService.list(lambdaQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        lambdaQueryWrapper.last(sql);
        lambdaQueryWrapper.orderByDesc(Task::getCreateTime);
        List<Task> list = taskService.list(lambdaQueryWrapper);
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("taskList",list);
        return  R.ok().data(map);
    }

}
