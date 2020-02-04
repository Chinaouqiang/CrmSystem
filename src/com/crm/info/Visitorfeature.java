package com.crm.info;

import java.io.Serializable;
import java.sql.Timestamp;


public class Visitorfeature implements Serializable {
	private Integer Id;
	private String device_only;
	private String Ufaceid;
	private String Img;
	private String Sex;
	private String Age;
	private String Beauty;
	private Integer Facevalue;
	private String Isalive;
	private String Asym;
	private String Blur;
	private String Glass;
	private String Hat;
	private String LeftEye;
	private String RightEye;
	private String Light;
	private String Mask;
	private String Race;
	private Timestamp Buildtime;
	
	public String getDevice_only() {
		return device_only;
	}
	public void setDevice_only(String device_only) {
		this.device_only = device_only;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getUfaceid() {
		return Ufaceid;
	}
	public void setUfaceid(String ufaceid) {
		Ufaceid = ufaceid;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getBeauty() {
		return Beauty;
	}
	public void setBeauty(String beauty) {
		Beauty = beauty;
	}
	public Integer getFacevalue() {
		return Facevalue;
	}
	public void setFacevalue(Integer facevalue) {
		Facevalue = facevalue;
	}
	public String getIsalive() {
		return Isalive;
	}
	public void setIsalive(String isalive) {
		Isalive = isalive;
	}
	public String getAsym() {
		return Asym;
	}
	public void setAsym(String asym) {
		Asym = asym;
	}
	public String getBlur() {
		return Blur;
	}
	public void setBlur(String blur) {
		Blur = blur;
	}
	public String getGlass() {
		return Glass;
	}
	public void setGlass(String glass) {
		Glass = glass;
	}
	public String getHat() {
		return Hat;
	}
	public void setHat(String hat) {
		Hat = hat;
	}
	public String getLeftEye() {
		return LeftEye;
	}
	public void setLeftEye(String leftEye) {
		LeftEye = leftEye;
	}
	public String getRightEye() {
		return RightEye;
	}
	public void setRightEye(String rightEye) {
		RightEye = rightEye;
	}
	public String getLight() {
		return Light;
	}
	public void setLight(String light) {
		Light = light;
	}
	public String getMask() {
		return Mask;
	}
	public void setMask(String mask) {
		Mask = mask;
	}
	public String getRace() {
		return Race;
	}
	public void setRace(String race) {
		Race = race;
	}
	public Timestamp getBuildtime() {
		return Buildtime;
	}
	public void setBuildtime(Timestamp buildtime) {
		Buildtime = buildtime;
	}
	public Visitorfeature() {
		super();
	}
	public Visitorfeature(Integer id, String device_only, String ufaceid, String img, String sex, String age,
			String beauty, Integer facevalue, String isalive, String asym, String blur, String glass, String hat,
			String leftEye, String rightEye, String light, String mask, String race, Timestamp buildtime) {
		super();
		Id = id;
		this.device_only = device_only;
		Ufaceid = ufaceid;
		Img = img;
		Sex = sex;
		Age = age;
		Beauty = beauty;
		Facevalue = facevalue;
		Isalive = isalive;
		Asym = asym;
		Blur = blur;
		Glass = glass;
		Hat = hat;
		LeftEye = leftEye;
		RightEye = rightEye;
		Light = light;
		Mask = mask;
		Race = race;
		Buildtime = buildtime;
	}
	@Override
	public String toString() {
		return "Visitorfeature [Id=" + Id + ", device_only=" + device_only + ", Ufaceid=" + Ufaceid + ", Img=" + Img
				+ ", Sex=" + Sex + ", Age=" + Age + ", Beauty=" + Beauty + ", Facevalue=" + Facevalue + ", Isalive="
				+ Isalive + ", Asym=" + Asym + ", Blur=" + Blur + ", Glass=" + Glass + ", Hat=" + Hat + ", LeftEye="
				+ LeftEye + ", RightEye=" + RightEye + ", Light=" + Light + ", Mask=" + Mask + ", Race=" + Race
				+ ", Buildtime=" + Buildtime + "]";
	}
	
	
	
	
	
}
