package com.crm.biz;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.BranchShopDao;
import com.crm.info.BrancheShop;
import com.crm.info.HeadShop;

@Transactional
@Repository
public class BranchShopBiz {
	private BranchShopDao branchShopDao;

	public void setBranchShopDao(BranchShopDao branchShopDao) {
		this.branchShopDao = branchShopDao;
	}
	
	//����
	public Boolean addBranchShop(BrancheShop brancheShop) {
		try {
			branchShopDao.save(brancheShop);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//ɾ��
	public Boolean deleteBranchShop(Integer id) {
		try {
			branchShopDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	//��ѯ����
	public List<BrancheShop> findList(Integer id){
		List<BrancheShop> shop=branchShopDao.findList(id);
		return shop;
	}
	
	//��ѯ�÷ֵ���ܵ�id
	public Integer findId(String name,String pwd) {
		Integer id=branchShopDao.findId(name, pwd);
		return id;
	}
	
	//��ѯ��������
		public BrancheShop findOne(Integer id) {
			return branchShopDao.get(id);
		}
		
		//�޸�
			public Boolean updateBrancheShop(BrancheShop BrancheShop) {
		try {
			branchShopDao.save(BrancheShop);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
