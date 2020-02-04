package com.crm.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.Monitor;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class MonitorDao extends HibernateDao<Monitor, Integer> {
	
	//核对是否保存成功
	public List<Monitor> findMonitor(String Path){
		String hql=" from Monitor where M_Path='"+Path+"'";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	//根据年月日查询相对应的监控录像
	public List<Monitor> findMonitorList(String Only,String date){
		String hql=" FROM Monitor where M_Only='"+Only+"' and M_Time LIKE '"+date+"%'";
		Query query=getSession().createQuery(hql);
		List<Monitor> ss=query.list();
		return query.list();
	}
	//查询分店所用序列号
	public List<Object> findList(String uid,String pwd){
		String sql="SELECT b.Device_Only,b.Device_Name from hr_employee a,device b where a.BranchShop_Id=b.BranchShop_Id AND uid='"+uid+"' and pwd='"+pwd+"'";
		Query query=getSession().createSQLQuery(sql);
		return query.list();
	}
	
	//查询七天前的所有数据
	public List<Map<String, Object>> findDeleteList(String date){
		String sql="SELECT M_Id AS a,M_LocalPath AS b FROM Monitor where M_Time <=NOW() - INTERVAL 15 DAY ";
		Query query=getSession().createSQLQuery(sql).addScalar("a",Hibernate.INTEGER).addScalar("b", Hibernate.STRING).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	
	
}
