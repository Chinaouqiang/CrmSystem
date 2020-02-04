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
	
	
	//����
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
	
		
	//ɾ��
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
	//���ݷֵ�id
	public void delete(Integer bid) {
		shopCenterDao.deleteshop(bid);
	}
	//�����ܵ�id
	public void deleteHeadshop(Integer bid) {
		shopCenterDao.deleteHeadshop(bid);
	}
	//�����ܵ�ɾ�����зֵ�����
	public void deleteBranchshop(Integer bid) {
		shopCenterDao.deleteBranchshop(bid);
	}
}
