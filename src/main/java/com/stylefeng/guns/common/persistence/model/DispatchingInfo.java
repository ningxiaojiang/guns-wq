package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 配送清单
 * @author Administrator
 *
 */
@TableName("wq_dispatching_info")
public class DispatchingInfo extends Model<Dispatching>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
    private int id;	//
    private int productid;	//产品id
    private int counts;	//数量
    private String remarks;	//备注
    private int delflag;	//
    private String other;	//预留字段
    private int dispatchingid;	//配送表主表id

    @Override
	public String toString() {
		return "DispatchingInfo [id=" + id + ", productid=" + productid + ", counts=" + counts + ", remarks=" + remarks
				+ ", delflag=" + delflag + ", other=" + other + ", dispatchingid=" + dispatchingid + "]";
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public int getDispatchingid() {
        return dispatchingid;
    }

    public void setDispatchingid(int dispatchingid) {
        this.dispatchingid = dispatchingid;
    }

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}