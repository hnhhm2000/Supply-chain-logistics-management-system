package cn.fpa.logistics.service.impl;

import cn.fpa.logistics.entity.Quote;
import cn.fpa.logistics.mapper.QuoteMapper;
import cn.fpa.logistics.service.IQuoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-19
 */
@Service
public class QuoteServiceImpl extends ServiceImpl<QuoteMapper, Quote> implements IQuoteService {

}
