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
	
	//����
	public String addBranchShop(){
		shopCenter=new ShopCenter();
		//�ֵ�
		branchShopBiz.addBranchShop(brancheShop);
		//�м��
		shopCenter.setBranchShop_Id(brancheShop.getBranchShop_Id());
		shopCenter.setShop_Id((Integer)findId());
		shopCenterBiz.addShopCenter(shopCenter);
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	
	//ɾ��
	public String deleteBranchShop(){
		//ɾ���ֵ�����
		branchShopBiz.deleteBranchShop(brancheShop.getBranchShop_Id());
		//ɾ���Žӱ�����
		shopCenterBiz.delete(brancheShop.getBranchShop_Id());
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	//��ѯ����
	public String findList() {
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	
	//��ȡ������Ϣ
	public String update() {
		BrancheShop brancheShopp=branchShopBiz.findOne(brancheShop.getBranchShop_Id());
		System.out.println(brancheShopp);
		Scopes.getRequestMap().put("Shopp", brancheShopp);
		return "update";
	}
	
	//�޸�
	public String updateBrancheShop() {
		branchShopBiz.updateBrancheShop(brancheShop);
		List<BrancheShop> BranchShop=branchShopBiz.findList((Integer)findId());
		Scopes.getRequestMap().put("BranchShop", BranchShop);
		return SUCCESS;
	}
	
	//��ѯ�ܵ�id
	public Integer findId() {
		Integer ss=branchShopBiz.findId((String)Scopes.getSessionMap().get("loginName"),(String) Scopes.getSessionMap().get("loginPwd"));
		return ss;
	}
	
}
