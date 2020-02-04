package com.crm.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.Device;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class DeviceDao extends HibernateDao<Device, Integer> {
	
	public List<Device> checkingDevice(String OnlyId) {
		String hql=" FROM Device WHERE DEVICE_ONLY='"+OnlyId+"' AND Device_State=1";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	
	//修改设备状态
	public void updateState(Integer state,Integer Id) {
		String hql="UPDATE Device SET Device_State="+state+" WHERE Device_Id="+Id+"";
		Query query=getSession().createQuery(hql);
		query.executeUpdate();
	}
	
	//分店id
	public Integer BrancheId(String uid,String pwd) {
		String sql="SELECT BranchShop_Id FROM hr_employee where uid='"+uid+"' and pwd='"+pwd+"'";
		Query query=getSession().createSQLQuery(sql);
		return (Integer) query.uniqueResult();
	}
	
	//分店设备
	public List<Device> findDevice(Integer id){
		String hql=" FROM Device where BranchShop_Id="+id+"";
		Query query=getSession().createQuery(hql);
		return query.list();
	}
	
	
	public void ss() {
		String hql=" FROM Device";
		Query query=getSession().createQuery(hql);
		query.setCacheable(true);
		System.out.println("设置："+query.list());
		
	}
	
}
