package com.crm.info;

import java.io.Serializable;

public class Enter implements Serializable {
	
	private Integer Id;
	private String Name;
	private String Password;
	private String Permissioncode;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPermissioncode() {
		return Permissioncode;
	}
	public void setPermissioncode(String permissioncode) {
		Permissioncode = permissioncode;
	}
	public Enter(Integer id, String name, String password, String permissioncode) {
		super();
		Id = id;
		Name = name;
		Password = password;
		Permissioncode = permissioncode;
	}
	public Enter() {
		super();
	}
	
	
	
	
	
}
