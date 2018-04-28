package net.badme.modules.ucar.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private UcarOrderDao orderDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String)params.get("key");
        String start = (String)params.get("start");
        String end = (String)params.get("end");
        Date start2 = new Date(0);
        Date end2 = new Date(2124467175000L);
        if(start != null && end != null){
            start2 =new Date(Long.parseLong(start)) ;
            end2 = new Date(Long.parseLong(end));
        }
        Page<UcarOrderEntity> page = this.selectPage(
                new Query<UcarOrderEntity>(params).getPage(),
                new EntityWrapper<UcarOrderEntity>().like(StringUtils.isNotBlank(key),"recommend_name", key)
                .or().like(StringUtils.isNotBlank(key),"recommend_mobile", key)
                        .andNew().between( "create_time",start2,end2).orderBy("create_time",false)
        );

        return new PageUtils(page);
    }

    @Override
    public void save(UcarOrderEntity order) {
        this.insert(order);
    }

    @Override
    public void updateStatus(UcarOrderEntity ucarOrder) {
        orderDao.updateStatus(ucarOrder);
    }

}
