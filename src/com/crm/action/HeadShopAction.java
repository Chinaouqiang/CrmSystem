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
	
	private HeadShop headShop; //�ܵ�ʵ����
	private HeadShopBiz headShopBiz; //�ܵ�Service��
	private BrancheShop brancheShop;//�ֵ�ʵ����
	private BranchShopBiz branchShopBiz;//�ֵ�Service��
	private ShopCenter shopCenter;//�����м��ʵ����
	private ShopCenterBiz shopCenterBiz;//�����м��Service��
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
	//����
	public String addHeadShop() {
		brancheShop=new BrancheShop(); //ʵ�����ֵ����
		shopCenter=new ShopCenter();
		brancheShop.setBranchShop_Name(headShop.getShop_Name());
		brancheShop.setBranchShop_Adress(headShop.getShop_Adress());
		//�����ܵ��
		headShopBiz.addHeadShop(headShop);
		//���ӷֵ��
		branchShopBiz.addBranchShop(brancheShop);
		//���ӵ����м��
		shopCenter.setShop_Id(headShop.getShop_Id());
		shopCenter.setBranchShop_Id(brancheShop.getBranchShop_Id());
		shopCenterBiz.addShopCenter(shopCenter);
		//����������ͬʱˢ������
		List<HeadShop> findList=headShopBiz.findList();
		Scopes.getRequestMap().put("findList", findList);
		return SUCCESS;
	}
	//ɾ��
		public String deleteHeadShop() {
			//ɾ���ܵ��
			headShopBiz.deleteHeadShop(headShop.getShop_Id());
			//ɾ���Žӱ�
			shopCenterBiz.deleteHeadshop(headShop.getShop_Id());
			//ɾ���ֵ��
			shopCenterBiz.deleteBranchshop(headShop.getShop_Id());
			List<HeadShop> findList=headShopBiz.findList();
			Scopes.getRequestMap().put("findList", findList);
			return SUCCESS;
		}
		
	//��ȡ������Ϣ
		public String update() {
		HeadShop headShopp=	headShopBiz.findOne(headShop.getShop_Id());
		Scopes.getRequestMap().put("headShopp", headShopp);
			return "update";
		}
		
	//�޸�
		public String updateHeadShop() {
			headShopBiz.updateHeadShop(headShop);
			List<HeadShop> findList=headShopBiz.findList();
			Scopes.getRequestMap().put("findList", findList);
			return SUCCESS;
		}
	
   //��ѯ����
	public String findList() {
		List<HeadShop> findList=headShopBiz.findList();
		Scopes.getRequestMap().put("findList", findList);
		return SUCCESS;
	}
		
		
		
}
