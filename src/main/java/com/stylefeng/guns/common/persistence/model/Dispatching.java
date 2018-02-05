package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 配送表
 * @author nxj
 *
 */
@TableName("wq_dispatching")
public class Dispatching extends Model<Dispatching>{

    /**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//主键id
    private int salesid;	//销售表id
    private int stockid;	//库存表id---改为配送人员
    private int number;	//数量
    private int status;	//状态
    private String money;	//金额
    private int type;	//配送方式
    private String createtime;	//创建时间
    private String updatetime;	//更新时间
    private int delflag;	//删除状态
    private String remarks;	//备注
    private String otherone;	//预留字段-配送单号
    private String othertwo;	//预留字段
    private String otherthree;	//预留字段

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalesid() {
        return salesid;
    }

    public void setSalesid(int salesid) {
        this.salesid = salesid;
    }

    public int getStockid() {
        return stockid;
    }

    public void setStockid(int stockid) {
        this.stockid = stockid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

	@Override
	public String toString() {
		return "Dispatching [id=" + id + ", salesid=" + salesid + ", stockid=" + stockid + ", number=" + number
				+ ", status=" + status + ", money=" + money + ", type=" + type + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", delflag=" + delflag + ", remarks=" + remarks + ", otherone="
				+ otherone + ", othertwo=" + othertwo + ", otherthree=" + otherthree + "]";
	}

}