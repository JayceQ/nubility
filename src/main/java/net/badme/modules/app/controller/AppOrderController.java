package net.badme.modules.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.badme.common.utils.DateUtils;
import net.badme.common.utils.PageUtils;
import net.badme.common.utils.R;
import net.badme.modules.ucar.entity.OrderEntity;
import net.badme.modules.ucar.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


/**
 * 订单信息
 *
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-22 21:04:18
 */
@RestController
@RequestMapping("/app/order")
@Api("APP测试接口")
public class AppOrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

    @GetMapping("countOrder")
    @ApiOperation("忽略Token验证测试")
    public R save(HttpServletRequest request){
        System.out.println(DateUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        System.out.println(request.getParameter("applyMobile"));
        System.out.println(request.getParameter("recommendMobile"));
        System.out.println(request.getRequestURL());
        System.out.println(request.getHeader("user-agent"));
        return R.ok();
    }


}
