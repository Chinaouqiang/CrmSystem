package com.crm.info;

import java.io.Serializable;

public class BackMonitor implements Serializable {
	private Integer B_Id;  //Id
	private Integer BranchShop_Id;
	private String Device_Only;  //设备序列号
	private String B_Only;    //摄像头序列号
	private String B_CheckCode;  //验证码
	private String B_Pass;  //通道号
	private String Device_Name;//自定义字段
	public Integer getB_Id() {
		return B_Id;
	}
	public void setB_Id(Integer b_Id) {
		B_Id = b_Id;
	}
	public Integer getBranchShop_Id() {
		return BranchShop_Id;
	}
	public void setBranchShop_Id(Integer branchShop_Id) {
		BranchShop_Id = branchShop_Id;
	}
	public String getDevice_Only() {
		return Device_Only;
	}
	public void setDevice_Only(String device_Only) {
		Device_Only = device_Only;
	}
	public String getB_Only() {
		return B_Only;
	}
	public void setB_Only(String b_Only) {
		B_Only = b_Only;
	}
	public String getB_CheckCode() {
		return B_CheckCode;
	}
	public void setB_CheckCode(String b_CheckCode) {
		B_CheckCode = b_CheckCode;
	}
	public String getB_Pass() {
		return B_Pass;
	}
	public void setB_Pass(String b_Pass) {
		B_Pass = b_Pass;
	}
	public String getDevice_Name() {
		return Device_Name;
	}
	public void setDevice_Name(String device_Name) {
		Device_Name = device_Name;
	}
	public BackMonitor() {
		super();
	}
	public BackMonitor(String b_CheckCode, String device_Name) {
		super();
		B_CheckCode = b_CheckCode;
		Device_Name = device_Name;
	}
	public BackMonitor(Integer b_Id, Integer branchShop_Id, String device_Only, String b_Only, String b_CheckCode,
			String b_Pass, String device_Name) {
		super();
		B_Id = b_Id;
		BranchShop_Id = branchShop_Id;
		Device_Only = device_Only;
		B_Only = b_Only;
		B_CheckCode = b_CheckCode;
		B_Pass = b_Pass;
		Device_Name = device_Name;
	}
	@Override
	public String toString() {
		return "BackMonitor [B_Id=" + B_Id + ", BranchShop_Id=" + BranchShop_Id + ", Device_Only=" + Device_Only
				+ ", B_Only=" + B_Only + ", B_CheckCode=" + B_CheckCode + ", B_Pass=" + B_Pass + ", Device_Name="
				+ Device_Name + "]";
	}
	

	
	
	
	
	
	
	
}
