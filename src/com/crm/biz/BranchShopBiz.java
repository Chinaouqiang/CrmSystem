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
	
	//增加
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
	
	//删除
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
	
	//查询所有
	public List<BrancheShop> findList(Integer id){
		List<BrancheShop> shop=branchShopDao.findList(id);
		return shop;
	}
	
	//查询该分店的总店id
	public Integer findId(String name,String pwd) {
		Integer id=branchShopDao.findId(name, pwd);
		return id;
	}
	
	//查询单个数据
		public BrancheShop findOne(Integer id) {
			return branchShopDao.get(id);
		}
		
		//修改
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
