package com.crm.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.BrancheShop;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class BranchShopDao extends HibernateDao<BrancheShop, Integer> {
	
	//查询分店
	public List<BrancheShop> findList(Integer id){
		String sql="select*from branchshop where BranchShop_Id in(SELECT b.BranchShop_id from headshop a,branchshop b,shopcenter c where a.Shop_id=c.Shop_id and c.BranchShop_id=b.BranchShop_id and a.shop_Id="+id+")";
		Query query=getSession().createSQLQuery(sql).addEntity(BrancheShop.class);
		return query.list();
	}
	
	//查询该分店的总店id
	public Integer findId(String name,String pwd) {
		String sql="SELECT Shop_Id from branchshop a,shopcenter b where a.BranchShop_id=b.BranchShop_id and a.BranchShop_id=(select BranchShop_Id from hr_employee  where uid='"+name+"' and pwd='"+pwd+"')";
		Query query=getSession().createSQLQuery(sql);
		return (Integer) query.uniqueResult();
	}
	
}
