package com.crm.biz;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.PublicAdvertDao;
import com.crm.info.CrmContact;
import com.crm.info.PublicAdvert;

@Transactional
@Service
public class PublicAdvertBiz {
	
	private PublicAdvertDao publicAdvertDao;

	public void setPublicAdvertDao(PublicAdvertDao publicAdvertDao) {
		this.publicAdvertDao = publicAdvertDao;
	}
	
	//广告增加
	public Boolean addAdvert(PublicAdvert publicAdvert) {
		publicAdvert.setCreate_Time(new Timestamp(new Date().getTime()));
		try {
			publicAdvertDao.save(publicAdvert);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	//广告删除
	public boolean deleteAdvert(Integer AdvertId) {
		try {
			publicAdvertDao.delete(AdvertId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	//查找所以图片类型广告信息
		public List<PublicAdvert> findAllAdvertPic() {
			List<PublicAdvert> list=publicAdvertDao.AdverPic();
			new ParamCityBiz();
			return list;
		}
		
	//查找所以视频类型广告信息
			public List<PublicAdvert> findAllAdvertVido() {
				List<PublicAdvert> list=publicAdvertDao.AdverVido();
				new ParamCityBiz();
				return list;
			}
	
	//查找所以视频类型广告信息
	public List<PublicAdvert> findAllAdvert() {
		List<PublicAdvert> list=publicAdvertDao.getAll();
		new ParamCityBiz();
		return list;
	}
	//查找单个信息
	public PublicAdvert findOneAdvert(Integer id) {
		return publicAdvertDao.get(id);
	}
		
  
	//修改广告信息
	public boolean updateAdvert(PublicAdvert publicAdvert) {
		try {
			publicAdvertDao.save(publicAdvert);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
		
	//修改广告状态信息
	public void updatePublicAdvertSate(int Ad_State,int Ad_Id) {
		publicAdvertDao.updatePublicAdvertSate(Ad_State,Ad_Id);
	}
	
	//修改广告状态信息
		public Integer updatePublicAdvertSate2(String only,String field,String Context) {
			Integer num=publicAdvertDao.updatePublicAdvertSate2(only, field, Context);
			return num;
		}
		
   //通过序列号查找相对于的广告视频
	public List<PublicAdvert> findAllAdvertOnlyVido(String Only){
		List<PublicAdvert> Advert=publicAdvertDao.AdvertManageVido(Only);
		return Advert;
	}
	
	//通过序列号查找相对于的广告图文
	public List<PublicAdvert> findAllAdvertOnlyPic(String Only){
		List<PublicAdvert> Advert=publicAdvertDao.AdvertManagePic(Only);
		return Advert;
	}
	
	//通过序列号查找相对于所有可用广告
	public List<PublicAdvert> findAllAdvertOnly(String Only){
		List<PublicAdvert> Advert=publicAdvertDao.AdvertManage(Only);
		System.out.println("大广告:"+Advert);
		return Advert;
	}
	
	//通过序列号查找相对于所有可用广告(标题提示广告)
		public List<PublicAdvert> AdvertManageHead(String Only){
			List<PublicAdvert> Advert=publicAdvertDao.AdvertManageHead(Only);
			System.out.println("小广告:"+Advert);
			return Advert;
		}
		
		
	
}
