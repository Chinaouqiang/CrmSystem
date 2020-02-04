package com.crm.biz;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.crm.dao.VisitorFeatureDao;
import com.crm.info.Visitorfeature;

@Transactional
@Service
public class VisitorFeatureBiz {
	
	//�����ļ��ϴ�Dao����
	private VisitorFeatureDao visitorFeatureDao;
	
	public void setVisitorFeatureDao(VisitorFeatureDao visitorFeatureDao) {
		this.visitorFeatureDao = visitorFeatureDao;
	}
	//����
	public boolean addVi(Visitorfeature visitorfeature) {
		try {
			visitorFeatureDao.save(visitorfeature);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//ʱ��
	public String Date() {
		String time = String.valueOf(System.currentTimeMillis());
		return time;
	}
	//�������÷ÿ�
	public List<Visitorfeature>  Vistor() {
		List<Visitorfeature> vistor= visitorFeatureDao.getAll();
		return vistor;
	}
	//��ѯ���ϵķÿͼ�¼
	public List<Visitorfeature> findList(Integer BranchId){
		List<Visitorfeature> visitor=visitorFeatureDao.findList(BranchId);
		return visitor;
	}
	//�Ա����
	public List<Map<Object, Double>> SexRatio(Integer BranchId){
		return visitorFeatureDao.SexRatio(BranchId);
	}
	//���շÿ���
	public List<Map<Object, Integer>> newDay(String date,Integer BranchId){
		return visitorFeatureDao.newDay(date,BranchId);
		
	}
	//��ѯǰ����ķÿ�����
	public List<Map<String, Integer>> WeeklyData(Integer BranchId){
		return visitorFeatureDao.WeeklyData(BranchId);
	}
	
	//�������ͼ
	public List<Map<String, Double>> AgeRatio(Integer BranchId){
		return visitorFeatureDao.AgeRatio(BranchId);
	}
	
}
