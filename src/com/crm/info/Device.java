package com.crm.info;

import java.io.Serializable;
import java.sql.Timestamp;


public class Device implements Serializable {
	
	public Integer Device_Id;
	public Integer BranchShop_Id;
	public String Device_Name;
	public String Device_Address;
	public String Device_Only;
	public Integer Device_State;
	public Timestamp Device_Time;
	
	public Integer getDevice_State() {
		return Device_State;
	}
	public void setDevice_State(Integer device_State) {
		Device_State = device_State;
	}
	public Integer getDevice_Id() {
		return Device_Id;
	}
	public void setDevice_Id(Integer device_Id) {
		Device_Id = device_Id;
	}
	public String getDevice_Name() {
		return Device_Name;
	}
	public void setDevice_Name(String device_Name) {
		Device_Name = device_Name;
	}
	public String getDevice_Address() {
		return Device_Address;
	}
	public void setDevice_Address(String device_Address) {
		Device_Address = device_Address;
	}
	public String getDevice_Only() {
		return Device_Only;
	}
	public void setDevice_Only(String device_Only) {
		Device_Only = device_Only;
	}
	public Timestamp getDevice_Time() {
		return Device_Time;
	}
	public void setDevice_Time(Timestamp device_Time) {
		Device_Time = device_Time;
	}
	
	public Integer getBranchShop_Id() {
		return BranchShop_Id;
	}
	public void setBranchShop_Id(Integer branchShop_Id) {
		BranchShop_Id = branchShop_Id;
	}
	
	public Device() {
		super();
	}
	public Device(Integer device_Id, Integer branchShop_Id, String device_Name, String device_Address,
			String device_Only, Integer device_State, Timestamp device_Time) {
		super();
		Device_Id = device_Id;
		BranchShop_Id = branchShop_Id;
		Device_Name = device_Name;
		Device_Address = device_Address;
		Device_Only = device_Only;
		Device_State = device_State;
		Device_Time = device_Time;
	}
	@Override
	public String toString() {
		return "Device [Device_Id=" + Device_Id + ", BranchShop_Id=" + BranchShop_Id + ", Device_Name=" + Device_Name
				+ ", Device_Address=" + Device_Address + ", Device_Only=" + Device_Only + ", Device_State="
				+ Device_State + ", Device_Time=" + Device_Time + "]";
	}
	
	
	
	

}
