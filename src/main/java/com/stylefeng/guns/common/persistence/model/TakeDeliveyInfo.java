package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 提货清单
 * @author nxj
 *
 */
@TableName("wq_take_delivey_info")
public class TakeDeliveyInfo extends Model<TakeDeliveyInfo>{
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键id
	@TableField("productid")
	private Integer productId;//产品id
	private Integer number;//数量
	private Integer delflag;//删除状态
	private String remarks;//备注
	private String otherone;//预留字段
	private String othertwo;//预留字段
	@TableField("takedeliveyno")
	private String takeDeliveyNo;//货单号
	public String getTakeDeliveyNo() {
		return takeDeliveyNo;
	}

	public void setTakeDeliveyNo(String takeDeliveyNo) {
		this.takeDeliveyNo = takeDeliveyNo;
	}

	@Override
	public String toString() {
		return "TakeDeliveyInfo [id=" + id + ", productId=" + productId + ", number=" + number + ", delflag=" + delflag
				+ ", remarks=" + remarks + ", otherone=" + otherone + ", othertwo=" + othertwo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getDelflag() {
		return delflag;
	}

	public void setDelflag(Integer delflag) {
		this.delflag = delflag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOtherone() {
		return otherone;
	}

	public void setOtherone(String otherone) {
		this.otherone = otherone;
	}

	public String getOthertwo() {
		return othertwo;
	}

	public void setOthertwo(String othertwo) {
		this.othertwo = othertwo;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
