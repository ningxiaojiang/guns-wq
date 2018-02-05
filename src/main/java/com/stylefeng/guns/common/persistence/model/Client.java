package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 客户表
 * @author Administrator
 *
 */
@TableName("wq_client")
public class Client extends Model<Client>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//主键id
    private String name;	//客户姓名
    private int age;	//年龄
    private int sex;	//性别
    private String dt;	//公司
    private String address;	//地址
    private String nativplace;	//籍贯
    private String tel;	//电话
    private String phone;	//手机
    private String brithday;	//生日
    private String remearks;	//备注
    private String createtime;	//创建时间
    private int delflag;	//删除状态1正常0删除
    private String updatatime;	//更新时间
    private String otherone;	//预留字段-住址
    private String othertwo;	//预留字段-职位
    private String otherthree;	//预留字段

    public int getId() {
        return id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNativplace() {
        return nativplace;
    }

    public void setNativplace(String nativplace) {
        this.nativplace = nativplace;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public String getRemearks() {
		return remearks;
	}

	public void setRemearks(String remearks) {
		this.remearks = remearks;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

	public String getUpdatatime() {
		return updatatime;
	}

	public void setUpdatatime(String updatatime) {
		this.updatatime = updatatime;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", dt=" + dt + ", address="
				+ address + ", nativplace=" + nativplace + ", tel=" + tel + ", phone=" + phone + ", brithday="
				+ brithday + ", remearks=" + remearks + ", createtime=" + createtime + ", delflag=" + delflag
				+ ", updatatime=" + updatatime + ", otherone=" + otherone + ", othertwo=" + othertwo + ", otherthree="
				+ otherthree + "]";
	}

}