package com.crm.info;

import java.io.Serializable;

public class HeadShop implements Serializable {
	private Integer Shop_Id;
	private String  Shop_Name;
	private String Shop_Adress;
	public Integer getShop_Id() {
		return Shop_Id;
	}
	public void setShop_Id(Integer shop_Id) {
		Shop_Id = shop_Id;
	}
	public String getShop_Name() {
		return Shop_Name;
	}
	public void setShop_Name(String shop_Name) {
		Shop_Name = shop_Name;
	}
	public String getShop_Adress() {
		return Shop_Adress;
	}
	public void setShop_Adress(String shop_Adress) {
		Shop_Adress = shop_Adress;
	}
	public HeadShop(Integer shop_Id, String shop_Name, String shop_Adress) {
		super();
		Shop_Id = shop_Id;
		Shop_Name = shop_Name;
		Shop_Adress = shop_Adress;
	}
	public HeadShop() {
		super();
	}
	@Override
	public String toString() {
		return "HeadShop [Shop_Id=" + Shop_Id + ", Shop_Name=" + Shop_Name + ", Shop_Adress=" + Shop_Adress + "]";
	}
	
	
	
}
