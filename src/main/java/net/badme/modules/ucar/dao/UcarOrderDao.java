package net.badme.modules.ucar.dao;

import net.badme.modules.ucar.entity.UcarOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单信息
 * 
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-23 21:41:25
 */
@Mapper
public interface UcarOrderDao extends BaseMapper<UcarOrderEntity> {

    void updateStatus(UcarOrderEntity ucarOrder);
}
