package cn.fpa.logistics.service.impl;

import cn.fpa.logistics.entity.User;
import cn.fpa.logistics.mapper.UserMapper;
import cn.fpa.logistics.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
