package cn.fpa.logistics.service.impl;

import cn.fpa.logistics.entity.ShipmentOrder;
import cn.fpa.logistics.mapper.ShipmentOrderMapper;
import cn.fpa.logistics.service.IShipmentOrderService;
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
public class ShipmentOrderServiceImpl extends ServiceImpl<ShipmentOrderMapper, ShipmentOrder> implements IShipmentOrderService {

}
