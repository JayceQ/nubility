package net.badme.modules.ucar.service;

import com.baomidou.mybatisplus.service.IService;
import net.badme.common.utils.PageUtils;
import net.badme.modules.ucar.entity.OrderEntity;

import java.util.Map;

/**
 * 订单信息
 *
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-22 21:04:18
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

