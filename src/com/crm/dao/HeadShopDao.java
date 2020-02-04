package com.crm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.HeadShop;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class HeadShopDao extends HibernateDao<HeadShop, Integer> {
	

}
