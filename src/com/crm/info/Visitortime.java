package com.crm.info;

import java.io.Serializable;
import java.sql.Timestamp;

public class Visitortime implements Serializable {
	private Integer Id;
	private Integer Visitorid;
	private Timestamp Cometime;
	private Timestamp Gotime;
	private String Visitortype;
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
	public Timestamp getCometime() {
		return Cometime;
	}
	public void setCometime(Timestamp cometime) {
		Cometime = cometime;
	}
	public Timestamp getGotime() {
		return Gotime;
	}
	public void setGotime(Timestamp gotime) {
		Gotime = gotime;
	}
	public String getVisitortype() {
		return Visitortype;
	}
	public void setVisitortype(String visitortype) {
		Visitortype = visitortype;
	}
	public Visitortime(Integer id, Integer visitorid, Timestamp cometime, Timestamp gotime, String visitortype) {
		super();
		Id = id;
		Visitorid = visitorid;
		Cometime = cometime;
		Gotime = gotime;
		Visitortype = visitortype;
	}
	public Visitortime() {
		super();
	}
	
	
}
