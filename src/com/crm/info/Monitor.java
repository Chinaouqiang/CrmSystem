package com.crm.info;

import java.io.Serializable;
import java.sql.Timestamp;
import com.alibaba.fastjson.annotation.JSONField;

public class Monitor implements Serializable {
	
	private Integer M_Id;
	private String M_Path;
	private String M_LocalPath;
	private String M_Only;
	private Timestamp M_Time;
	public Integer getM_Id() {
		return M_Id;
	}
	public void setM_Id(Integer m_Id) {
		M_Id = m_Id;
	}
	public String getM_Path() {
		return M_Path;
	}
	public void setM_Path(String m_Path) {
		M_Path = m_Path;
	}
	public String getM_LocalPath() {
		return M_LocalPath;
	}
	public void setM_LocalPath(String m_LocalPath) {
		M_LocalPath = m_LocalPath;
	}
	public String getM_Only() {
		return M_Only;
	}
	public void setM_Only(String m_Only) {
		M_Only = m_Only;
	}
	public Timestamp getM_Time() {
		return M_Time;
	}
	public void setM_Time(Timestamp m_Time) {
		M_Time = m_Time;
	}
	public Monitor(Integer m_Id, String m_Path, String m_LocalPath, String m_Only, Timestamp m_Time) {
		super();
		M_Id = m_Id;
		M_Path = m_Path;
		M_LocalPath = m_LocalPath;
		M_Only = m_Only;
		M_Time = m_Time;
	}
	public Monitor() {
		super();
	}
	@Override
	public String toString() {
		return "Monitor [M_Id=" + M_Id + ", M_Path=" + M_Path + ", M_LocalPath=" + M_LocalPath + ", M_Only=" + M_Only
				+ ", M_Time=" + M_Time + "]";
	}
	
	
	
	
	
}
