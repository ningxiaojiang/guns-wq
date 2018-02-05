package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 报销表
 * @author Administrator
 *
 */
@TableName("wq_wipeout")
public class Wipeout extends Model<Wipeout>{

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
    private String why;	//报销原因
    private String money;	//金额
    private String date;	//日期
    private int status;	//状态
    private String createtime;	//创建时间
    private String updatetime;	//更新时间
    private int delflag;	//删除状态
    private String remarks;	//备注
    private String otherone;	//预留字段-报销单号
    private String othertwo;	//预留字段
    private String otherthree;	//预留字段

    @Override
	public String toString() {
		return "Wipeout [id=" + id + ", staffid=" + staffid + ", why=" + why + ", money=" + money + ", date=" + date
				+ ", status=" + status + ", createtime=" + createtime + ", updatetime=" + updatetime + ", delflag="
				+ delflag + ", remarks=" + remarks + ", otherone=" + otherone + ", othertwo=" + othertwo
				+ ", otherthree=" + otherthree + "]";
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

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}