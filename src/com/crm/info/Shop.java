package com.crm.info;

import java.io.Serializable;

public class Shop implements Serializable{
	
	private Integer Id;
	private Integer Enterid;
	private String Shopname;
	private String Shopadress;
	private String Contact;
	private String Phone;
	private Integer Population;
	private Integer Belongid;
	private String Shoplevel;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getEnterid() {
		return Enterid;
	}
	public void setEnterid(Integer enterid) {
		Enterid = enterid;
	}
	public String getShopname() {
		return Shopname;
	}
	public void setShopname(String shopname) {
		Shopname = shopname;
	}
	public String getShopadress() {
		return Shopadress;
	}
	public void setShopadress(String shopadress) {
		Shopadress = shopadress;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Integer getPopulation() {
		return Population;
	}
	public void setPopulation(Integer population) {
		Population = population;
	}
	public Integer getBelongid() {
		return Belongid;
	}
	public void setBelongid(Integer belongid) {
		Belongid = belongid;
	}
	public String getShoplevel() {
		return Shoplevel;
	}
	public void setShoplevel(String shoplevel) {
		Shoplevel = shoplevel;
	}
	public Shop(Integer id, Integer enterid, String shopname, String shopadress, String contact, String phone,
			Integer population, Integer belongid, String shoplevel) {
		super();
		Id = id;
		Enterid = enterid;
		Shopname = shopname;
		Shopadress = shopadress;
		Contact = contact;
		Phone = phone;
		Population = population;
		Belongid = belongid;
		Shoplevel = shoplevel;
	}
	public Shop() {
		super();
	}
	
	
}
