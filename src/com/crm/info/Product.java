package com.crm.info;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {
	
	private Integer Id;
	private BigDecimal Price;
	private String Mainfunction;
	private String Subfunction;
	private String Proname;
	private String Introduction;
	private String Mainpic;
	private String Functionpic;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	public String getMainfunction() {
		return Mainfunction;
	}
	public void setMainfunction(String mainfunction) {
		Mainfunction = mainfunction;
	}
	public String getSubfunction() {
		return Subfunction;
	}
	public void setSubfunction(String subfunction) {
		Subfunction = subfunction;
	}
	public String getProname() {
		return Proname;
	}
	public void setProname(String proname) {
		Proname = proname;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public String getMainpic() {
		return Mainpic;
	}
	public void setMainpic(String mainpic) {
		Mainpic = mainpic;
	}
	public String getFunctionpic() {
		return Functionpic;
	}
	public void setFunctionpic(String functionpic) {
		Functionpic = functionpic;
	}
	public Product(Integer id, BigDecimal price, String mainfunction, String subfunction, String proname,
			String introduction, String mainpic, String functionpic) {
		super();
		Id = id;
		Price = price;
		Mainfunction = mainfunction;
		Subfunction = subfunction;
		Proname = proname;
		Introduction = introduction;
		Mainpic = mainpic;
		Functionpic = functionpic;
	}
	public Product() {
		super();
	}
	
	
	
}
