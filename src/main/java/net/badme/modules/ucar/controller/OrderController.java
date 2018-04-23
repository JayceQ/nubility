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

import net.badme.modules.ucar.entity.OrderEntity;
import net.badme.modules.ucar.service.OrderService;
import net.badme.common.utils.PageUtils;
import net.badme.common.utils.R;

import javax.servlet.http.HttpServletRequest;


/**
 * 订单信息
 *
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-22 21:04:18
 */
@RestController
@RequestMapping("ucar/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("ucar:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    @RequiresPermissions("ucar:order:info")
    public R info(@PathVariable("orderId") Long orderId){
			OrderEntity order = orderService.selectById(orderId);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ucar:order:save")
    public R save(@RequestBody OrderEntity order ,HttpServletRequest request){
			orderService.insert(order);
        System.out.println(order.getApplyMobile());
        System.out.println(order.getRecommendMobile());
        System.out.println(request.getRequestURL());
        System.out.println(request.getHeader("user-agent"));
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("ucar:order:update")
    public R update(@RequestBody OrderEntity order){
			orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("ucar:order:delete")
    public R delete(@RequestBody Long[] orderIds){
			orderService.deleteBatchIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
