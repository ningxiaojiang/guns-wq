package com.stylefeng.guns.common.persistence.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
/**
 * 结算表
 * @author nxj
 *
 */
@TableName("wq_accounts")
public class Accounts extends Model<Accounts>{

    /**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	@TableId(value="id",type=IdType.AUTO)
	private int id;	//主键id
    private int clientid;	//客户id
    private int staffid;	//员工id
    private int salesid;	//销售表id
    private int dispatchingid;	//库存id
    private int productid;	//产品id
    private String grossp;	//毛利润
    private String netp;	//净利润
    private String purep;	//纯利润
    private String drawp;	//提成
    private Date createtime;	//创建时间
    private Date updatetime;	//更新时间
    private String delflag;	//删除状态
    private String remarks;	//备注
    private String otherone;	//预留字段
    private String othertwo;	//预留字段
    private String otherthree;	//预留字段

    @Override
	public String toString() {
		return "Accounts [id=" + id + ", clientid=" + clientid + ", staffid=" + staffid + ", salesid=" + salesid
				+ ", dispatchingid=" + dispatchingid + ", productid=" + productid + ", grossp=" + grossp + ", netp="
				+ netp + ", purep=" + purep + ", drawp=" + drawp + ", createtime=" + createtime + ", updatetime="
				+ updatetime + ", delflag=" + delflag + ", remarks=" + remarks + ", otherone=" + otherone
				+ ", othertwo=" + othertwo + ", otherthree=" + otherthree + "]";
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public int getSalesid() {
        return salesid;
    }

    public void setSalesid(int salesid) {
        this.salesid = salesid;
    }

    public int getDispatchingid() {
        return dispatchingid;
    }

    public void setDispatchingid(int dispatchingid) {
        this.dispatchingid = dispatchingid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getGrossp() {
        return grossp;
    }

    public void setGrossp(String grossp) {
        this.grossp = grossp;
    }

    public String getNetp() {
        return netp;
    }

    public void setNetp(String netp) {
        this.netp = netp;
    }

    public String getPurep() {
        return purep;
    }

    public void setPurep(String purep) {
        this.purep = purep;
    }

    public String getDrawp() {
        return drawp;
    }

    public void setDrawp(String drawp) {
        this.drawp = drawp;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
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
		return this.id;
	}

}