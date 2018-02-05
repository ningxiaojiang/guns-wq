package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 产品类型表
 * @author nxj
 *
 */
@TableName("wq_product_type")
public class ProductType extends Model<ProductType>{

    /**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//
    private String name;	//名称
    private String remarks;	//备注
    private int delflag;	//删除状态
    private String createtime;	//创建时间
    private String updatetime;	//更新时间
    private String other;	//保留字段  

    public int getId() {
        return id;
    }

    @Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", remarks=" + remarks + ", delflag=" + delflag
				+ ", createtime=" + createtime + ", updatetime=" + updatetime + ", other=" + other + "]";
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

	public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}