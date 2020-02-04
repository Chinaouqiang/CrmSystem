package com.crm.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.HeadShopDao;
import com.crm.info.HeadShop;

@Transactional
@Service
public class HeadShopBiz {
	
	private HeadShopDao headShopDao;

	public void setHeadShopDao(HeadShopDao headShopDao) {
		this.headShopDao = headShopDao;
	}
	
	
	//增加
	public Boolean addHeadShop(HeadShop headShop) {
		try {
			headShopDao.save(headShop);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//删除
	public Boolean deleteHeadShop(Integer id) {
		try {
			headShopDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	//查询所有
	public List<HeadShop> findList(){
		List<HeadShop> shop=headShopDao.getAll();
		return shop;
	}
	
	//查询单个数据
	public HeadShop findOne(Integer id) {
		return headShopDao.get(id);
	}
	
	//修改
	public Boolean updateHeadShop(HeadShop headShop) {
		try {
			headShopDao.save(headShop);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
