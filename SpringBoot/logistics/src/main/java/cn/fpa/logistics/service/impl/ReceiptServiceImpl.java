package cn.fpa.logistics.service.impl;

import cn.fpa.logistics.entity.Receipt;
import cn.fpa.logistics.mapper.ReceiptMapper;
import cn.fpa.logistics.service.IReceiptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-23
 */
@Service
public class ReceiptServiceImpl extends ServiceImpl<ReceiptMapper, Receipt> implements IReceiptService {

}
