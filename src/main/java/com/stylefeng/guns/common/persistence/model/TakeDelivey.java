package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 收货表
 * @author nxj
 *
 */
@TableName("wq_take_delivey")
public class TakeDelivey extends Model<TakeDelivey>{

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
    private int staffid;	//员工id
    private String date;	//提货日期
    private String money;	//运费
    private int type;	//提货方式
    private String number;	//数量
    private int status;	//状态
    private String remarks;	//备注
    private int delflag;	//删除状态
    private String otherone;	//预留字段-货单号
    private String othertwo;	//预留字段
    private String otherthree;	//预留字段

    public int getId() {
        return id;
    }

    @Override
	public String toString() {
		return "TakeDelivey [id=" + id + ", staffid=" + staffid + ", date=" + date + ", money=" + money + ", type="
				+ type + ", number=" + number + ", status=" + status + ", remarks=" + remarks + ", delflag=" + delflag
				+ ", otherone=" + otherone + ", othertwo=" + othertwo + ", otherthree=" + otherthree + "]";
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


    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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