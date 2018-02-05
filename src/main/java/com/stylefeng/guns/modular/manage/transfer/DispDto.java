package com.stylefeng.guns.modular.manage.transfer;
/**
 * 配送传输bean
 * @author nxj
 *
 */
public class DispDto {
	private String salesNo;
	private String disoatchingNo;
	private Integer disStaffId;
	private String dispTime;
	private String productes;
	
	public String getDisoatchingNo() {
		return disoatchingNo;
	}
	public void setDisoatchingNo(String disoatchingNo) {
		this.disoatchingNo = disoatchingNo;
	}
	public String getSalesNo() {
		return salesNo;
	}
	public void setSalesNo(String salesNo) {
		this.salesNo = salesNo;
	}
	public Integer getDisStaffId() {
		return disStaffId;
	}
	public void setDisStaffId(Integer disStaffId) {
		this.disStaffId = disStaffId;
	}
	public String getDispTime() {
		return dispTime;
	}
	public void setDispTime(String dispTime) {
		this.dispTime = dispTime;
	}
	public String getProductes() {
		return productes;
	}
	public void setProductes(String productes) {
		this.productes = productes;
	}
	@Override
	public String toString() {
		return "DispDto [salesNo=" + salesNo + ", disoatchingNo=" + disoatchingNo + ", disStaffId=" + disStaffId
				+ ", dispTime=" + dispTime + ", productes=" + productes + "]";
	}
}
