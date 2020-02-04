package com.crm.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.CheckWork;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class CheckWorkDao extends HibernateDao<CheckWork, Integer> {
	
	//查询
	public List<CheckWork> findcheck(String time,String Name,Integer dep,Integer id){
		String hql=" from CheckWork where check_Time='"+time+"' and hr_Name='"+Name+"' and dep_id="+dep+" and hr_id="+id+"";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	
	//签到
	public Integer updateWork(String field,String workTime,Integer id) {
		String hql="UPDATE CheckWork SET "+field+"='"+workTime+"' where id="+id+"";
		Query query=getSession().createQuery(hql);
		return query.executeUpdate();
	}
	
	//签到
	public Integer updateWork2(String field,String workTime,String state,String con,Integer id) {
		String hql="UPDATE CheckWork SET "+field+"='"+workTime+"',"+state+"='"+con+"' ,iswork_State='异常' where id="+id+"";
		Query query=getSession().createQuery(hql);
		return query.executeUpdate();
	}
	
	//根据时间展示所有
	public List<CheckWork> findList(String Time,Integer id){
		String hql=" FROM CheckWork WHERE check_Time='"+Time+"' AND branch_id="+id+" ";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	
	//根据时间展示所有
		public List<CheckWork> findList2(String TimeHead,String Timelend){
			String hql=" FROM CheckWork WHERE check_Time between '"+TimeHead+"' AND '"+Timelend+"'";
			Query query=getSession().createQuery(hql);
			return query.list();
		}
}
