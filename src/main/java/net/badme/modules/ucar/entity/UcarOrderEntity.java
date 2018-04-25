package net.badme.modules.ucar.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单信息
 * 
 * @author Jayce
 * @email qinxune@gmail.com
 * @date 2018-04-23 21:41:25
 */
@TableName("ucar_order")
public class UcarOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long orderId;
	/**
	 * 订单名
	 */
	private String orderName;

	@Override
	public String toString() {
		return "UcarOrderEntity{" +
				"orderId=" + orderId +
				", orderName='" + orderName + '\'' +
				", recommendMobile='" + recommendMobile + '\'' +
				", applyMobile='" + applyMobile + '\'' +
				", status=" + status +
				", desc='" + desc + '\'' +
				", origin='" + origin + '\'' +
				", remark='" + remark + '\'' +
				", createTime=" + createTime +
				", modifyTime=" + modifyTime +
				'}';
	}

	/**
	 * 推荐人号码
	 */
	private String recommendMobile;
	/**
	 * 申请人号码
	 */
	private String applyMobile;
	/**
	 * 状态  0：无效   1：有效
	 */
	private Integer status;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 来源
	 */
	private String origin;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 下单时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 设置：
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单名
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	/**
	 * 获取：订单名
	 */
	public String getOrderName() {
		return orderName;
	}
	/**
	 * 设置：推荐人号码
	 */
	public void setRecommendMobile(String recommendMobile) {
		this.recommendMobile = recommendMobile;
	}
	/**
	 * 获取：推荐人号码
	 */
	public String getRecommendMobile() {
		return recommendMobile;
	}
	/**
	 * 设置：申请人号码
	 */
	public void setApplyMobile(String applyMobile) {
		this.applyMobile = applyMobile;
	}
	/**
	 * 获取：申请人号码
	 */
	public String getApplyMobile() {
		return applyMobile;
	}
	/**
	 * 设置：状态  0：无效   1：有效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态  0：无效   1：有效
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：来源
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * 获取：来源
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：下单时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：下单时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
}
