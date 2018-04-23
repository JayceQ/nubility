package net.badme.modules.ucar.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.badme.modules.ucar.entity.UcarOrderEntity;
import net.badme.modules.ucar.service.UcarOrderService;
import net.badme.common.utils.PageUtils;
import net.badme.common.utils.R;



/**
 * 订单信息
 *
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-23 21:41:25
 */
@RestController
@RequestMapping("ucar/order")
public class UcarOrderController {
    @Autowired
    private UcarOrderService ucarOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ucar:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ucarOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    @RequiresPermissions("ucar:order:info")
    public R info(@PathVariable("orderId") Long orderId){
			UcarOrderEntity ucarOrder = ucarOrderService.selectById(orderId);

        return R.ok().put("ucarOrder", ucarOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("ucar:order:save")
    public R save(@RequestBody UcarOrderEntity ucarOrder){
			ucarOrderService.insert(ucarOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ucar:order:update")
    public R update(@RequestBody UcarOrderEntity ucarOrder){
			ucarOrderService.updateById(ucarOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ucar:order:delete")
    public R delete(@RequestBody Long[] orderIds){
			ucarOrderService.deleteBatchIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
