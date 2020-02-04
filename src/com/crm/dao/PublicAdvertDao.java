package com.crm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.CrmContact;
import com.crm.info.Device;
import com.crm.info.PublicAdvert;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class PublicAdvertDao extends HibernateDao<PublicAdvert, Integer>{
	

	public List<PublicAdvert> findAllAdvert(){
		return getSession().createCriteria(PublicAdvert.class).list();
	}
	
	
	//图片
	public List<PublicAdvert> AdverPic(){
		String hql=" FROM PublicAdvert WHERE AD_PICTURE!=''";
		Query query=getSession().createQuery(hql);
		List results=query.list();
		return results;
	}
	
	//视频
	public List<PublicAdvert> AdverVido(){
		String hql=" FROM PublicAdvert WHERE AD_VIDO!=''";
		Query query=getSession().createQuery(hql);
		List results=query.list();
		return results;
	}
	
	//修改广告状态
	public void updatePublicAdvertSate(int Ad_State,int Ad_Id) {
		String hql=" UPDATE PublicAdvert SET ad_State="+Ad_State+" WHERE ad_Id="+Ad_Id+" ";
		Query query=getSession().createQuery(hql);
		query.executeUpdate();
	}
	
	//通过序列号查找相对于的广告
	public List<PublicAdvert> AdvertManageVido(String Only){
		String hql="FROM PublicAdvert WHERE Device_Only='"+Only+"' and Ad_Vido!=''";
		Query query=getSession().createQuery(hql);
		List results=query.list();
		return results;
	}
	
	//通过序列号查找相对于的广告
	public List<PublicAdvert> AdvertManagePic(String Only){
		String hql="FROM PublicAdvert WHERE Device_Only='"+Only+"' and Ad_PicTure!=''";
		Query query=getSession().createQuery(hql);
		List results=query.list();
		return results;
	}

	
	//通过序列号查找相对于所有可用广告
	public List<PublicAdvert> AdvertManage(String Only){
		String hql="FROM PublicAdvert WHERE Device_Only='"+Only+"' and Ad_State=0";
		Query query=getSession().createQuery(hql);
		List results=query.list();
		return results;
	}
	
	//通过序列号查找相对于所有可用广告
		public List<PublicAdvert> AdvertManageHead(String Only){
			String hql="FROM PublicAdvert WHERE Device_Only='"+Only+"' and Ad_State=-1";
			Query query=getSession().createQuery(hql);
			List results=query.list();
			return results;
		}
		
	//修改
		public Integer updatePublicAdvertSate2(String only,String field,String Context) {
			String hql=" UPDATE PublicAdvert SET otherState=0 WHERE Device_Only='"+only+"' and "+field+"='"+Context+"' ";
			Query query=getSession().createQuery(hql);
			return query.executeUpdate();
		}
		
}
