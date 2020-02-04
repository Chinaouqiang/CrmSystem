package com.crm.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.crm.biz.BranchShopBiz;
import com.crm.biz.ShopCenterBiz;
import com.crm.info.BrancheShop;
import com.crm.info.HeadShop;
import com.crm.info.ShopCenter;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class BranchShopAction extends ActionSupport {
	
	private BranchShopBiz branchShopBiz;
	private BrancheShop brancheShop;
	private ShopCenter shopCenter;
	private ShopCenterBiz shopCenterBiz;
	
	public ShopCenter getShopCenter() {
		return shopCenter;
	}
	public void setShopCenter(ShopCenter shopCenter) {
		this.shopCenter = shopCenter;
	}
	public void setShopCenterBiz(ShopCenterBiz shopCenterBiz) {
		this.shopCenterBiz = shopCenterBiz;
	}
	public BrancheShop getBrancheShop() {
		return brancheShop;
	}
	public void setBrancheShop(BrancheShop brancheShop) {
		this.brancheShop = brancheShop;
	}
	public void setBranchShopBiz(BranchShopBiz branchShopBiz) {
		this.branchShopBiz = branchShopBiz;
	}
	
	//增加
	public String addBranchShop(){
		shopCenter=new ShopCenter();
		//分店
		branchShopBiz.addBranchShop(brancheShop);
		//中间表
		shopCenter.setBranchShop_Id(brancheShop.getBranchShop_Id());
		shopCenter.setShop_Id((Integer)findId());
		shopCenterBiz.addShopCenter(shopCenter);
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	
	//删除
	public String deleteBranchShop(){
		//删除分店数据
		branchShopBiz.deleteBranchShop(brancheShop.getBranchShop_Id());
		//删除桥接表数据
		shopCenterBiz.delete(brancheShop.getBranchShop_Id());
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	//查询所有
	public String findList() {
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	
	//获取单个信息
	public String update() {
		BrancheShop brancheShopp=branchShopBiz.findOne(brancheShop.getBranchShop_Id());
		System.out.println(brancheShopp);
		Scopes.getRequestMap().put("Shopp", brancheShopp);
		return "update";
	}
	
	//修改
	public String updateBrancheShop() {
		branchShopBiz.updateBrancheShop(brancheShop);
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	
	//查询总店id
	public Integer findId() {
		Integer ss=branchShopBiz.findId((String)Scopes.getSessionMap().get("loginName"),(String) Scopes.getSessionMap().get("loginPwd"));
		return ss;
	}
	
}
