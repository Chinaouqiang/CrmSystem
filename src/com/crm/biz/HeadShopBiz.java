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
	
	
	//����
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
	
	//ɾ��
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
	
	
	//��ѯ����
	public List<HeadShop> findList(){
		List<HeadShop> shop=headShopDao.getAll();
		return shop;
	}
	
	//��ѯ��������
	public HeadShop findOne(Integer id) {
		return headShopDao.get(id);
	}
	
	//�޸�
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
