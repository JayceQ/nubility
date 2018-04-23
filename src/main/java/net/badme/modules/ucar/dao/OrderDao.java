package net.badme.modules.ucar.dao;

import net.badme.modules.ucar.entity.OrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单信息
 * 
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-22 21:04:18
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
