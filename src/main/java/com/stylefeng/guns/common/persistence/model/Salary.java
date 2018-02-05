package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 工资表
 * @author nxj
 *
 */
@TableName("wq_salary")
public class Salary extends Model<Salary>{

    /**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//
    private int staffid;	//员工id
    private String prize;	//奖金
    private String drawp;	//提成
    private String baox;	//报销
    private int type;	//发放方式
    private String sui;	//扣税
    private String count;	//合计
    private String yingfa;	//应发工资
    private String shifa;	//实发工资
    private String other;	//其他
    private int delflag;	//删除状态
    private int status;	//状态
    private String createtime;	//创建时间
    private String updatetime;	//更新时间
    private String otherone;	//预留字段
    private String othertwo;	//预留字段
    private String otherthree;	//预留字段
    private String date;	//工资日期

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

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getDrawp() {
        return drawp;
    }

    public void setDrawp(String drawp) {
        this.drawp = drawp;
    }

    public String getBaox() {
        return baox;
    }

    public void setBaox(String baox) {
        this.baox = baox;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSui() {
        return sui;
    }

    public void setSui(String sui) {
        this.sui = sui;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getYingfa() {
        return yingfa;
    }

    public void setYingfa(String yingfa) {
        this.yingfa = yingfa;
    }

    public String getShifa() {
        return shifa;
    }

    public void setShifa(String shifa) {
        this.shifa = shifa;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", staffid=" + staffid + ", prize=" + prize + ", drawp=" + drawp + ", baox=" + baox
				+ ", type=" + type + ", sui=" + sui + ", count=" + count + ", yingfa=" + yingfa + ", shifa=" + shifa
				+ ", other=" + other + ", delflag=" + delflag + ", status=" + status + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", otherone=" + otherone + ", othertwo=" + othertwo + ", otherthree="
				+ otherthree + ", date=" + date + "]";
	}

}