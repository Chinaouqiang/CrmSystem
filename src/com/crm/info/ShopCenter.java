package com.crm.info;

import java.io.Serializable;

public class ShopCenter implements Serializable {
	
	private Integer Center_Id; //中间表id
	private Integer Shop_Id;  //总店ID
	private Integer BranchShop_Id; //分店id
	public Integer getCenter_Id() {
		return Center_Id;
	}
	public void setCenter_Id(Integer center_Id) {
		Center_Id = center_Id;
	}
	public Integer getShop_Id() {
		return Shop_Id;
	}
	public void setShop_Id(Integer shop_Id) {
		Shop_Id = shop_Id;
	}
	public Integer getBranchShop_Id() {
		return BranchShop_Id;
	}
	public void setBranchShop_Id(Integer branchShop_Id) {
		BranchShop_Id = branchShop_Id;
	}
	public ShopCenter() {
		super();
	}
	public ShopCenter(Integer center_Id, Integer shop_Id, Integer branchShop_Id) {
		super();
		Center_Id = center_Id;
		Shop_Id = shop_Id;
		BranchShop_Id = branchShop_Id;
	}
	@Override
	public String toString() {
		return "ShopCenter [Center_Id=" + Center_Id + ", Shop_Id=" + Shop_Id + ", BranchShop_Id=" + BranchShop_Id + "]";
	}
	
	
}
