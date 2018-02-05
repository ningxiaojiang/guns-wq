package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 库存
 * @author nxj
 *
 */
@TableName("wq_stock")
public class Stock extends Model<Stock>{

    /**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//
    private int productid;	//产品id
    private int number;	//数量
    private String createtime;	//创建时间
    private String updatetime;	//更新时间
    private String takeid;	//收货单号
    private String remarks;
    public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTakeid() {
		return takeid;
	}

	public void setTakeid(String takeid) {
		this.takeid = takeid;
	}
	private int delflag;	//删除状态
    private String otherone;	//预留字段
    private String othertwo;	//预留字段
    private String otherthree;	//预留字段

    @Override
	public String toString() {
		return "Stock [id=" + id + ", productid=" + productid + ", number=" + number + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", takeid=" + takeid + ", delflag=" + delflag + ", otherone="
				+ otherone + ", othertwo=" + othertwo + ", otherthree=" + otherthree + "]";
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

}