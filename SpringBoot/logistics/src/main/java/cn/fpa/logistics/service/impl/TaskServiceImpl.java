package cn.fpa.logistics.service.impl;

import cn.fpa.logistics.entity.Task;
import cn.fpa.logistics.mapper.TaskMapper;
import cn.fpa.logistics.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-22
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

}
