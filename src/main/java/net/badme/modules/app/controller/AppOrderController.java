package net.badme.modules.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.badme.common.utils.R;
import net.badme.modules.sys.entity.SysUserEntity;
import net.badme.modules.sys.service.SysUserService;
import net.badme.modules.ucar.entity.UcarOrderEntity;
import net.badme.modules.ucar.service.UcarOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


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
    private UcarOrderService orderService;

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("countOrder")
    @ApiOperation("忽略Token验证测试")
    public R save(HttpServletRequest request){
        UcarOrderEntity order  = new UcarOrderEntity();
        order.setOrderName("优卡白条");
        order.setApplyMobile(request.getParameter("applyMobile"));
        String recommendMobile = request.getParameter("recommendMobile");
        SysUserEntity user = sysUserService.selectByPhone(recommendMobile);
        if(user == null){
            return R.error(400,"没有此荐人！");
        }
        order.setRecommendName(user.getChineseName());
        order.setRecommendMobile(recommendMobile);
        order.setCreateTime(new Date());
        String agent = request.getHeader("user-agent");
        order.setOrigin(agent.indexOf("Android")>0?"安卓":agent.indexOf("iPhone")>0?"苹果":"其他");
        orderService.save(order);
        return R.ok();
    }


}
