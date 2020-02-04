package com.crm.info;

import java.io.Serializable;

public class BrancheShop implements Serializable{
	private Integer BranchShop_Id;
	private String BranchShop_Name;
	private String BranchShop_Adress;
	public Integer getBranchShop_Id() {
		return BranchShop_Id;
	}
	public void setBranchShop_Id(Integer branchShop_Id) {
		BranchShop_Id = branchShop_Id;
	}
	public String getBranchShop_Name() {
		return BranchShop_Name;
	}
	public void setBranchShop_Name(String branchShop_Name) {
		BranchShop_Name = branchShop_Name;
	}
	public String getBranchShop_Adress() {
		return BranchShop_Adress;
	}
	public void setBranchShop_Adress(String branchShop_Adress) {
		BranchShop_Adress = branchShop_Adress;
	}
	public BrancheShop() {
		super();
	}
	public BrancheShop(Integer branchShop_Id, String branchShop_Name, String branchShop_Adress) {
		super();
		BranchShop_Id = branchShop_Id;
		BranchShop_Name = branchShop_Name;
		BranchShop_Adress = branchShop_Adress;
	}
	@Override
	public String toString() {
		return "BrancheShop [BranchShop_Id=" + BranchShop_Id + ", BranchShop_Name=" + BranchShop_Name
				+ ", BranchShop_Adress=" + BranchShop_Adress + "]";
	}
	
	
}	
