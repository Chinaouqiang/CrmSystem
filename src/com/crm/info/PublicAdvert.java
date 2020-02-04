package com.crm.info;

import java.io.Serializable;
import java.sql.Timestamp;

public class PublicAdvert implements Serializable {
	
	private Integer ad_Id;
	private Integer otherState;
	private String ad_Title;
	private String ad_Content;
	private String ad_Vido;
	private String ad_PicTure;
	private Integer ad_ScreenState;
	private Integer ad_State;
	private Timestamp create_Time;
	private String Device_only;
	
	
	public Integer getOtherState() {
		return otherState;
	}
	public void setOtherState(Integer otherState) {
		this.otherState = otherState;
	}
	public String getDevice_only() {
		return Device_only;
	}
	public void setDevice_only(String device_only) {
		Device_only = device_only;
	}
	public Integer getAd_Id() {
		return ad_Id;
	}
	public void setAd_Id(Integer ad_Id) {
		this.ad_Id = ad_Id;
	}
	public String getAd_Title() {
		return ad_Title;
	}
	public void setAd_Title(String ad_Title) {
		this.ad_Title = ad_Title;
	}
	public String getAd_Content() {
		return ad_Content;
	}
	public void setAd_Content(String ad_Content) {
		this.ad_Content = ad_Content;
	}
	public String getAd_Vido() {
		return ad_Vido;
	}
	public void setAd_Vido(String ad_Vido) {
		this.ad_Vido = ad_Vido;
	}
	public String getAd_PicTure() {
		return ad_PicTure;
	}
	public void setAd_PicTure(String ad_PicTure) {
		this.ad_PicTure = ad_PicTure;
	}
	public Integer getAd_ScreenState() {
		return ad_ScreenState;
	}
	public void setAd_ScreenState(Integer ad_ScreenState) {
		this.ad_ScreenState = ad_ScreenState;
	}
	public Integer getAd_State() {
		return ad_State;
	}
	public void setAd_State(Integer ad_State) {
		this.ad_State = ad_State;
	}
	public Timestamp getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(Timestamp create_Time) {
		this.create_Time = create_Time;
	}
	public PublicAdvert() {
		super();
	}
	public PublicAdvert(Integer ad_Id, Integer otherState, String ad_Title, String ad_Content, String ad_Vido,
			String ad_PicTure, Integer ad_ScreenState, Integer ad_State, Timestamp create_Time, String device_only) {
		super();
		this.ad_Id = ad_Id;
		this.otherState = otherState;
		this.ad_Title = ad_Title;
		this.ad_Content = ad_Content;
		this.ad_Vido = ad_Vido;
		this.ad_PicTure = ad_PicTure;
		this.ad_ScreenState = ad_ScreenState;
		this.ad_State = ad_State;
		this.create_Time = create_Time;
		Device_only = device_only;
	}
	@Override
	public String toString() {
		return "PublicAdvert [ad_Id=" + ad_Id + ", otherState=" + otherState + ", ad_Title=" + ad_Title
				+ ", ad_Content=" + ad_Content + ", ad_Vido=" + ad_Vido + ", ad_PicTure=" + ad_PicTure
				+ ", ad_ScreenState=" + ad_ScreenState + ", ad_State=" + ad_State + ", create_Time=" + create_Time
				+ ", Device_only=" + Device_only + "]";
	}
	
	
	
	
	
	

	
	
	

}
