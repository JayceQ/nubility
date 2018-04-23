package net.badme.modules.ucar.service;

import com.baomidou.mybatisplus.service.IService;
import net.badme.common.utils.PageUtils;
import net.badme.modules.ucar.entity.UcarOrderEntity;

import java.util.Map;

/**
 * 订单信息
 *
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-23 21:41:25
 */
public interface UcarOrderService extends IService<UcarOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void save(UcarOrderEntity order);
}

