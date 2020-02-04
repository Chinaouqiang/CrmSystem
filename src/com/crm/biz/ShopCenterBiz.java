package com.crm.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.ShopCenterDao;
import com.crm.info.HeadShop;
import com.crm.info.ShopCenter;

@Transactional
@Service
public class ShopCenterBiz {
	private ShopCenterDao shopCenterDao;

	public void setShopCenterDao(ShopCenterDao shopCenterDao) {
		this.shopCenterDao = shopCenterDao;
	}
	
	
	//增加
	public Boolean addShopCenter(ShopCenter shopCenter) {
		try {
			shopCenterDao.save(shopCenter);
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
			shopCenterDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//根据分店id
	public void delete(Integer bid) {
		shopCenterDao.deleteshop(bid);
	}
	//根据总店id
	public void deleteHeadshop(Integer bid) {
		shopCenterDao.deleteHeadshop(bid);
	}
	//根据总店删除所有分店数据
	public void deleteBranchshop(Integer bid) {
		shopCenterDao.deleteBranchshop(bid);
	}
}
