package com.crm.info;

import java.io.Serializable;

public class Powers implements Serializable {
	
	private Integer Id;
	private String Permissioncode;
	private String Permissionname;
	private Integer Menuid;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getPermissioncode() {
		return Permissioncode;
	}
	public void setPermissioncode(String permissioncode) {
		Permissioncode = permissioncode;
	}
	public String getPermissionname() {
		return Permissionname;
	}
	public void setPermissionname(String permissionname) {
		Permissionname = permissionname;
	}
	public Integer getMenuid() {
		return Menuid;
	}
	public void setMenuid(Integer menuid) {
		Menuid = menuid;
	}
	public Powers() {
		super();
	}
	public Powers(Integer id, String permissioncode, String permissionname, Integer menuid) {
		super();
		Id = id;
		Permissioncode = permissioncode;
		Permissionname = permissionname;
		Menuid = menuid;
	}
	
	
	
	
}
