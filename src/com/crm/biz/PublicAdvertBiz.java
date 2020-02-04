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
	
	//�������
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
	
	//���ɾ��
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
	

	//��������ͼƬ���͹����Ϣ
		public List<PublicAdvert> findAllAdvertPic() {
			List<PublicAdvert> list=publicAdvertDao.AdverPic();
			new ParamCityBiz();
			return list;
		}
		
	//����������Ƶ���͹����Ϣ
			public List<PublicAdvert> findAllAdvertVido() {
				List<PublicAdvert> list=publicAdvertDao.AdverVido();
				new ParamCityBiz();
				return list;
			}
	
	//����������Ƶ���͹����Ϣ
	public List<PublicAdvert> findAllAdvert() {
		List<PublicAdvert> list=publicAdvertDao.getAll();
		new ParamCityBiz();
		return list;
	}
	//���ҵ�����Ϣ
	public PublicAdvert findOneAdvert(Integer id) {
		return publicAdvertDao.get(id);
	}
		
  
	//�޸Ĺ����Ϣ
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
		
	//�޸Ĺ��״̬��Ϣ
	public void updatePublicAdvertSate(int Ad_State,int Ad_Id) {
		publicAdvertDao.updatePublicAdvertSate(Ad_State,Ad_Id);
	}
	
	//�޸Ĺ��״̬��Ϣ
		public Integer updatePublicAdvertSate2(String only,String field,String Context) {
			Integer num=publicAdvertDao.updatePublicAdvertSate2(only, field, Context);
			return num;
		}
		
   //ͨ�����кŲ�������ڵĹ����Ƶ
	public List<PublicAdvert> findAllAdvertOnlyVido(String Only){
		List<PublicAdvert> Advert=publicAdvertDao.AdvertManageVido(Only);
		return Advert;
	}
	
	//ͨ�����кŲ�������ڵĹ��ͼ��
	public List<PublicAdvert> findAllAdvertOnlyPic(String Only){
		List<PublicAdvert> Advert=publicAdvertDao.AdvertManagePic(Only);
		return Advert;
	}
	
	//ͨ�����кŲ�����������п��ù��
	public List<PublicAdvert> findAllAdvertOnly(String Only){
		List<PublicAdvert> Advert=publicAdvertDao.AdvertManage(Only);
		System.out.println("����:"+Advert);
		return Advert;
	}
	
	//ͨ�����кŲ�����������п��ù��(������ʾ���)
		public List<PublicAdvert> AdvertManageHead(String Only){
			List<PublicAdvert> Advert=publicAdvertDao.AdvertManageHead(Only);
			System.out.println("С���:"+Advert);
			return Advert;
		}
		
		
	
}
