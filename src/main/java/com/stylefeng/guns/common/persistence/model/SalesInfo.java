package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 销售清单
 * @author nxj
 *
 */
@TableName("wq_sales_info")
public class SalesInfo extends Model<SalesInfo>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//
    private String salesid;	//销售主表id
    private int productid;	//产品表id
    private String price;	//单价
    private int counts;	//数量
    private String remarks;	//备注
    private String otherone;	//
    private int delflag; //删除状态
    public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "SalesInfo [id=" + id + ", salesid=" + salesid + ", productid=" + productid + ", price=" + price
				+ ", counts=" + counts + ", remarks=" + remarks + ", otherone=" + otherone + "]";
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSalesid() {
		return salesid;
	}

	public void setSalesid(String salesid) {
		this.salesid = salesid;
	}

	public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getOtherone() {
        return otherone;
    }

    public void setOtherone(String otherone) {
        this.otherone = otherone;
    }

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}