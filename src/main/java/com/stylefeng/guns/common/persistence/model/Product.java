package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 产品表
 * @author nxj
 *
 */
@TableName("wq_product")
public class Product extends Model<Product>{

    /**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//
    private String name;	//名称
    private String price;	//单价
    private String packagetype;	//包装方式
    private int packagenumber;	//包装数量
    private String createtime;	//创建时间
    private String updatetime;	//更新时间
    private int delflag;	//删除状态
    private int typeid;	//产品类型id
    private String remarks;	//备注
    private String otherone;	//预留字段
    private String othertwo;	//预留字段
    private String otherthree;	//预留字段

    public int getId() {
        return id;
    }

    @Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", packagetype=" + packagetype
				+ ", packagenumber=" + packagenumber + ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", delflag=" + delflag + ", typeid=" + typeid + ", remarks=" + remarks + ", otherone=" + otherone
				+ ", othertwo=" + othertwo + ", otherthree=" + otherthree + "]";
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPackagetype() {
        return packagetype;
    }

    public void setPackagetype(String packagetype) {
        this.packagetype = packagetype;
    }

    public int getPackagenumber() {
        return packagenumber;
    }

    public void setPackagenumber(int packagenumber) {
        this.packagenumber = packagenumber;
    }


    public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
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

    public String getOtherthree() {
        return otherthree;
    }

    public void setOtherthree(String otherthree) {
        this.otherthree = otherthree;
    }

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}