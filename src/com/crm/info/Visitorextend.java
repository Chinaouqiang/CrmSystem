package com.crm.info;

import java.io.Serializable;

public class Visitorextend implements Serializable{
	
	private Integer Id;
	private Integer Visitorid;
	private String Glasses;
	private String Hat;
	private String clothing;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getVisitorid() {
		return Visitorid;
	}

	public void setVisitorid(Integer visitorid) {
		Visitorid = visitorid;
	}

	public String getGlasses() {
		return Glasses;
	}

	public void setGlasses(String glasses) {
		Glasses = glasses;
	}

	public String getHat() {
		return Hat;
	}

	public void setHat(String hat) {
		Hat = hat;
	}

	public String getClothing() {
		return clothing;
	}

	public void setClothing(String clothing) {
		this.clothing = clothing;
	}

	
	public Visitorextend(Integer id, Integer visitorid, String glasses, String hat, String clothing) {
		super();
		Id = id;
		Visitorid = visitorid;
		Glasses = glasses;
		Hat = hat;
		this.clothing = clothing;
	}

	public Visitorextend() {
		super();
	}
	
	
}
