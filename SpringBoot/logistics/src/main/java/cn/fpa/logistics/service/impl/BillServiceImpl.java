package cn.fpa.logistics.service.impl;

import cn.fpa.logistics.entity.Bill;
import cn.fpa.logistics.mapper.BillMapper;
import cn.fpa.logistics.service.IBillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-29
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements IBillService {

}
