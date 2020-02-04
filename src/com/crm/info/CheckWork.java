package com.crm.info;

import java.io.Serializable;
import java.sql.Timestamp;

public class CheckWork implements Serializable {
	private Integer id;
	private Integer hr_id;
	private String hr_Name;
	private Integer dep_id;
	private String check_Time;
	private String m_work;
	private String m_offwork;
	private String a_work;
	private String a_offwork;
	private String iswork_State;
	private String isLate;
	private String isLateEarly;
	private String isAbsenteeism;
	private String isLeave;
	private Integer branch_id;
	private String check_remarks;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getHr_id() {
		return hr_id;
	}
	public void setHr_id(Integer hr_id) {
		this.hr_id = hr_id;
	}
	public String getHr_Name() {
		return hr_Name;
	}
	public void setHr_Name(String hr_Name) {
		this.hr_Name = hr_Name;
	}
	public Integer getDep_id() {
		return dep_id;
	}
	public void setDep_id(Integer dep_id) {
		this.dep_id = dep_id;
	}
	public String getCheck_Time() {
		return check_Time;
	}
	public void setCheck_Time(String check_Time) {
		this.check_Time = check_Time;
	}
	public String getM_work() {
		return m_work;
	}
	public void setM_work(String m_work) {
		this.m_work = m_work;
	}
	public String getM_offwork() {
		return m_offwork;
	}
	public void setM_offwork(String m_offwork) {
		this.m_offwork = m_offwork;
	}
	public String getA_work() {
		return a_work;
	}
	public void setA_work(String a_work) {
		this.a_work = a_work;
	}
	public String getA_offwork() {
		return a_offwork;
	}
	public void setA_offwork(String a_offwork) {
		this.a_offwork = a_offwork;
	}
	public String getIswork_State() {
		return iswork_State;
	}
	public void setIswork_State(String iswork_State) {
		this.iswork_State = iswork_State;
	}
	public String getIsLate() {
		return isLate;
	}
	public void setIsLate(String isLate) {
		this.isLate = isLate;
	}
	public String getIsLateEarly() {
		return isLateEarly;
	}
	public void setIsLateEarly(String isLateEarly) {
		this.isLateEarly = isLateEarly;
	}
	public String getIsAbsenteeism() {
		return isAbsenteeism;
	}
	public void setIsAbsenteeism(String isAbsenteeism) {
		this.isAbsenteeism = isAbsenteeism;
	}
	public String getIsLeave() {
		return isLeave;
	}
	public void setIsLeave(String isLeave) {
		this.isLeave = isLeave;
	}
	public Integer getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(Integer branch_id) {
		this.branch_id = branch_id;
	}
	public String getCheck_remarks() {
		return check_remarks;
	}
	public void setCheck_remarks(String check_remarks) {
		this.check_remarks = check_remarks;
	}
	public CheckWork() {
		super();
	}
	public CheckWork(Integer id, Integer hr_id, String hr_Name, Integer dep_id, String check_Time, String m_work,
			String m_offwork, String a_work, String a_offwork, String iswork_State, String isLate, String isLateEarly,
			String isAbsenteeism, String isLeave, Integer branch_id, String check_remarks) {
		super();
		this.id = id;
		this.hr_id = hr_id;
		this.hr_Name = hr_Name;
		this.dep_id = dep_id;
		this.check_Time = check_Time;
		this.m_work = m_work;
		this.m_offwork = m_offwork;
		this.a_work = a_work;
		this.a_offwork = a_offwork;
		this.iswork_State = iswork_State;
		this.isLate = isLate;
		this.isLateEarly = isLateEarly;
		this.isAbsenteeism = isAbsenteeism;
		this.isLeave = isLeave;
		this.branch_id = branch_id;
		this.check_remarks = check_remarks;
	}
	@Override
	public String toString() {
		return "CheckWork [id=" + id + ", hr_id=" + hr_id + ", hr_Name=" + hr_Name + ", dep_id=" + dep_id
				+ ", check_Time=" + check_Time + ", m_work=" + m_work + ", m_offwork=" + m_offwork + ", a_work="
				+ a_work + ", a_offwork=" + a_offwork + ", iswork_State=" + iswork_State + ", isLate=" + isLate
				+ ", isLateEarly=" + isLateEarly + ", isAbsenteeism=" + isAbsenteeism + ", isLeave=" + isLeave
				+ ", branch_id=" + branch_id + ", check_remarks=" + check_remarks + "]";
	}
	
	
}
