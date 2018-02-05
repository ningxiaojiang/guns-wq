package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 销售表
 * @author nxj
 *
 */
@TableName("wq_sales")
public class Sales extends Model<Sales>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String salesno;	//销售单
	  /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
    private int id;	//主键id
    private int staffid;	//员工id
    private int clientid;	//客户id
    private int productid;	//产品id
    private String price;	//价格
    private int number;	//数量
    private int delflag;	//删除状态
    private String dispatchingtime;	//配送时间
    private int dispatchingtype;	//配送方式
    private String preferential;	//优惠
    private int status;	//状态
    private String createtime;	//创建时间
    private String updatetime;	//更新时间
    private String remarks;	//备注
    private int otherone;	//预留字段-是否开发票:
    private String othertwo;	//预留字段-发票金额
    private String otherthree;	//预留字段-额外税点

    @Override
	public String toString() {
		return "Sales [salesno=" + salesno + ", id=" + id + ", staffid=" + staffid + ", clientid=" + clientid
				+ ", productid=" + productid + ", price=" + price + ", number=" + number + ", delflag=" + delflag
				+ ", dispatchingtime=" + dispatchingtime + ", dispatchingtype=" + dispatchingtype + ", preferential="
				+ preferential + ", status=" + status + ", createtime=" + createtime + ", updatetime=" + updatetime
				+ ", remarks=" + remarks + ", otherone=" + otherone + ", othertwo=" + othertwo + ", otherthree="
				+ otherthree + "]";
	}

	public String getSalesno() {
        return salesno;
    }

    public void setSalesno(String salesno) {
        this.salesno = salesno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }


    public String getDispatchingtime() {
		return dispatchingtime;
	}

	public void setDispatchingtime(String dispatchingtime) {
		this.dispatchingtime = dispatchingtime;
	}

	public int getDispatchingtype() {
        return dispatchingtype;
    }

    public void setDispatchingtype(int dispatchingtype) {
        this.dispatchingtype = dispatchingtype;
    }

    public String getPreferential() {
        return preferential;
    }

    public void setPreferential(String preferential) {
        this.preferential = preferential;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

	public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public int getOtherone() {
		return otherone;
	}

	public void setOtherone(int otherone) {
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