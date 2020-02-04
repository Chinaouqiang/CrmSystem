package com.crm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.BackMonitor;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class BackMonitorDao extends HibernateDao<BackMonitor, Integer> {
	///�������кŲ�������
	public List<BackMonitor> findBackMonitorOnly(String Only){
		String hql=" from BackMonitor where Device_Only='"+Only+"'";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	
	//�����û����Ӧ������
	public List<BackMonitor> findList(Integer id){
		String hql=" from BackMonitor where BranchShop_Id="+id+"";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
}
