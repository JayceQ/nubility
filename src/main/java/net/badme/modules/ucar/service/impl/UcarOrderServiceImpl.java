package net.badme.modules.ucar.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import net.badme.common.utils.PageUtils;
import net.badme.common.utils.Query;

import net.badme.modules.ucar.dao.UcarOrderDao;
import net.badme.modules.ucar.entity.UcarOrderEntity;
import net.badme.modules.ucar.service.UcarOrderService;


@Service("ucarOrderService")
public class UcarOrderServiceImpl extends ServiceImpl<UcarOrderDao, UcarOrderEntity> implements UcarOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UcarOrderEntity> page = this.selectPage(
                new Query<UcarOrderEntity>(params).getPage(),
                new EntityWrapper<UcarOrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void save(UcarOrderEntity order) {
        this.insert(order);
    }

}
