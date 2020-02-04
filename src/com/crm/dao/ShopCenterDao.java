package com.crm.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.ShopCenter;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class ShopCenterDao extends HibernateDao<ShopCenter, Integer> {
	
	//根据分店id
	public void deleteshop(Integer bid) {
		String hql="delete from ShopCenter where BranchShop_Id ="+bid+"";
		Query query=getSession().createQuery(hql);
		query.executeUpdate();
	}
	
	//根据总店id
	public void deleteHeadshop(Integer bid) {
		String hql="delete from ShopCenter where Shop_Id ="+bid+"";
		Query query=getSession().createQuery(hql);
		query.executeUpdate();
	}
	
	//根据总店删除所有分店数据
	@Transactional
	public void deleteBranchshop(Integer bid) {
		String sql="delete from branchshop where BranchShop_Id in(select b.Branchshop_Id from headshop a,shopcenter b where a.Shop_Id=b.Shop_Id and a.Shop_Id="+bid+")";
		Query query=getSession().createSQLQuery(sql);
		query.executeUpdate();
		System.out.println("删除所有分店数据结果:"+query.executeUpdate());
	}
	

}
