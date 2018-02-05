package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
/**
 * 员工表
 * @author nxj
 * Mapper方法默认寻找的表为staff,so需要指定表名,或者实体类名和表名一致
 */
@TableName("wq_staff")
public class Staff extends Model<Staff>{

    @Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", cardId=" + cardId
				+ ", cardAddress=" + cardAddress + ", nation=" + nation + ", origin=" + origin + ", address=" + address
				+ ", deptId=" + deptId + ", pay=" + pay + ", entrytime=" + entrytime + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", delFlag=" + delFlag + ", post=" + post + ", otherOne=" + otherOne
				+ ", otherTwo=" + otherTwo + ", otherThree=" + otherThree + ", otherFore=" + otherFore + "]";
	}

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	private int id;	//主键id
    private String name;	//员工姓名
    private int age;	//年龄
    private int sex;	//1-男,2-女
    private String cardId;	//身份证号
    private String cardAddress;	//身份证地址
    private String nation;	//民族
    private String origin;	//籍贯
    private String address;	//住址
    private int deptId;	//部门id
    private String pay;	//薪资
    private String entrytime;	//入职时间
    private String createtime;	//
    private String updatetime;	//
    private int delFlag;	//1正常-0删除
    private String post;	//职位
    private String otherOne;	//电话
    private String otherTwo;	//状态 : 在职,离职,兼职
    private String otherThree;	//
    private String otherFore;	//

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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }


    public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
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

	public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getOtherOne() {
        return otherOne;
    }

    public void setOtherOne(String otherOne) {
        this.otherOne = otherOne;
    }

    public String getOtherTwo() {
        return otherTwo;
    }

    public void setOtherTwo(String otherTwo) {
        this.otherTwo = otherTwo;
    }

    public String getOtherThree() {
        return otherThree;
    }

    public void setOtherThree(String otherThree) {
        this.otherThree = otherThree;
    }

    public String getOtherFore() {
        return otherFore;
    }

    public void setOtherFore(String otherFore) {
        this.otherFore = otherFore;
    }

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}