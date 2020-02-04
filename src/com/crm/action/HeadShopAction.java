package com.crm.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.crm.biz.BranchShopBiz;
import com.crm.biz.HeadShopBiz;
import com.crm.biz.ShopCenterBiz;
import com.crm.info.BrancheShop;
import com.crm.info.HeadShop;
import com.crm.info.ShopCenter;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class HeadShopAction extends ActionSupport {
	
	private HeadShop headShop; //总店实体类
	private HeadShopBiz headShopBiz; //总店Service层
	private BrancheShop brancheShop;//分店实体类
	private BranchShopBiz branchShopBiz;//分店Service层
	private ShopCenter shopCenter;//店铺中间表实体类
	private ShopCenterBiz shopCenterBiz;//店铺中间表Service层
	public HeadShop getHeadShop() {
		return headShop;
	}
	public void setHeadShop(HeadShop headShop) {
		this.headShop = headShop;
	}
	public void setHeadShopBiz(HeadShopBiz headShopBiz) {
		this.headShopBiz = headShopBiz;
	}
	public void setBranchShopBiz(BranchShopBiz branchShopBiz) {
		this.branchShopBiz = branchShopBiz;
	}
	public void setShopCenterBiz(ShopCenterBiz shopCenterBiz) {
		this.shopCenterBiz = shopCenterBiz;
	}
	//增加
	public String addHeadShop() {
		brancheShop=new BrancheShop(); //实例化分店对象
		shopCenter=new ShopCenter();
		brancheShop.setBranchShop_Name(headShop.getShop_Name());
		brancheShop.setBranchShop_Adress(headShop.getShop_Adress());
		//增加总店表
		headShopBiz.addHeadShop(headShop);
		//增加分店表
		branchShopBiz.addBranchShop(brancheShop);
		//增加店铺中间表
		shopCenter.setShop_Id(headShop.getShop_Id());
		shopCenter.setBranchShop_Id(brancheShop.getBranchShop_Id());
		shopCenterBiz.addShopCenter(shopCenter);
		//返回主界面同时刷新数据
		List<HeadShop> findList=headShopBiz.findList();
		Scopes.getRequestMap().put("findList", findList);
		return SUCCESS;
	}
	//删除
		public String deleteHeadShop() {
			//删除总店表
			headShopBiz.deleteHeadShop(headShop.getShop_Id());
			//删除桥接表
			shopCenterBiz.deleteHeadshop(headShop.getShop_Id());
			//删除分店表
			shopCenterBiz.deleteBranchshop(headShop.getShop_Id());
			List<HeadShop> findList=headShopBiz.findList();
			Scopes.getRequestMap().put("findList", findList);
			return SUCCESS;
		}
		
	//获取单个信息
		public String update() {
		HeadShop headShopp=	headShopBiz.findOne(headShop.getShop_Id());
		Scopes.getRequestMap().put("headShopp", headShopp);
			return "update";
		}
		
	//修改
		public String updateHeadShop() {
			headShopBiz.updateHeadShop(headShop);
			List<HeadShop> findList=headShopBiz.findList();
			Scopes.getRequestMap().put("findList", findList);
			return SUCCESS;
		}
	
   //查询所有
	public String findList() {
		List<HeadShop> findList=headShopBiz.findList();
		Scopes.getRequestMap().put("findList", findList);
		return SUCCESS;
	}
		
		
		
}
