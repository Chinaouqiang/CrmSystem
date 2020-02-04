package com.crm.info;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * SysRole entity. @author MyEclipse Persistence Tools
 */

public class SysRole implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private HrEmployee hrEmployeeByCreateid;
	private HrEmployee hrEmployeeByUpdateid;
	private String rolename;
	private String roledscript;
	private String childmenus;
	private String rolesort;
	private Timestamp createdate;
	private Timestamp updatedate;
	private Set hrEmployees = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysRole() {
	}

	/** full constructor */
	public SysRole(HrEmployee hrEmployeeByCreateid,
			HrEmployee hrEmployeeByUpdateid, String rolename,
			String roledscript, String childmenus, String rolesort,
			Timestamp createdate, Timestamp updatedate, Set hrEmployees) {
		this.hrEmployeeByCreateid = hrEmployeeByCreateid;
		this.hrEmployeeByUpdateid = hrEmployeeByUpdateid;
		this.rolename = rolename;
		this.roledscript = roledscript;
		this.childmenus = childmenus;
		this.rolesort = rolesort;
		this.createdate = createdate;
		this.updatedate = updatedate;
		this.hrEmployees = hrEmployees;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public HrEmployee getHrEmployeeByCreateid() {
		return this.hrEmployeeByCreateid;
	}

	public void setHrEmployeeByCreateid(HrEmployee hrEmployeeByCreateid) {
		this.hrEmployeeByCreateid = hrEmployeeByCreateid;
	}

	public HrEmployee getHrEmployeeByUpdateid() {
		return this.hrEmployeeByUpdateid;
	}

	public void setHrEmployeeByUpdateid(HrEmployee hrEmployeeByUpdateid) {
		this.hrEmployeeByUpdateid = hrEmployeeByUpdateid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledscript() {
		return this.roledscript;
	}

	public void setRoledscript(String roledscript) {
		this.roledscript = roledscript;
	}

	public String getChildmenus() {
		return this.childmenus;
	}

	public void setChildmenus(String childmenus) {
		this.childmenus = childmenus;
	}

	public String getRolesort() {
		return this.rolesort;
	}

	public void setRolesort(String rolesort) {
		this.rolesort = rolesort;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getUpdatedate() {
		return this.updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public Set getHrEmployees() {
		return this.hrEmployees;
	}

	public void setHrEmployees(Set hrEmployees) {
		this.hrEmployees = hrEmployees;
	}

}