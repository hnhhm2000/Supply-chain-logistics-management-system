package cn.fpa.logistics.service.impl;

import cn.fpa.logistics.entity.Invoice;
import cn.fpa.logistics.mapper.InvoiceMapper;
import cn.fpa.logistics.service.IInvoiceService;
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
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements IInvoiceService {

}
