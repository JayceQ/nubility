package net.badme.modules.ucar.controller;

import net.badme.common.utils.DownloadUtils;
import net.badme.common.utils.PageUtils;
import net.badme.common.utils.QRCodeUtils;
import net.badme.common.utils.R;
import net.badme.modules.sys.entity.SysUserEntity;
import net.badme.modules.sys.service.SysUserService;
import net.badme.modules.ucar.entity.UcarOrderEntity;
import net.badme.modules.ucar.service.UcarOrderService;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;


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

    @Autowired
    private SysUserService sysUserService;

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
        System.out.println(ucarOrder.getStatus()+"___"+ucarOrder.getOrderId());
        ucarOrder.setStatus(ucarOrder.getStatus() == 0 ? 1 : 0);
        ucarOrder.setModifyTime(new Date());
        ucarOrderService.updateStatus(ucarOrder);
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
    /**
     * 删除
     */
    @RequestMapping("/createQRCode")
    @RequiresPermissions("ucar:order:QRCode")
    public R createQRCode(@RequestParam Map<String, Object> params,HttpServletRequest request, HttpServletResponse response){
        //SysUserEntity sysUserEntity = sysUserService.selectById(Long.parseLong((String)params.get("userId")));
        SysUserEntity sysUserEntity = sysUserService.selectById(Long.parseLong(request.getParameter("userId")));
        String mobile = sysUserEntity.getMobile();
        String content = "http://badme.net/scan.html?recommend="+ mobile;
        String destPath = System.getProperty("user.dir") + "/data/image/logo.png";
        String fileName = sysUserEntity.getChineseName()+".jpg";
        String agent = request.getHeader("User-Agent");
        try{
            BufferedImage image = QRCodeUtils.createImage(content,destPath,true);
            if (agent.contains("Foxfire")) {
                //火狐浏览器默认base64编码
                fileName= DownloadUtils.base64EncodeFileName(fileName);
            }else{
                fileName= URLEncoder.encode(fileName, "utf-8");
                //将编码后的文件名中的+换成空格
                fileName=fileName.replace("+", " ");
            }
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "jpg", os);
        }catch (Exception e){
            e.printStackTrace();
            return R.error("生成失败，请重试");
        }
        return R.ok();
    }

}
