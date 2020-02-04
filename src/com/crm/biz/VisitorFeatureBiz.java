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
	
	//调用文件上传Dao方法
	private VisitorFeatureDao visitorFeatureDao;
	
	public void setVisitorFeatureDao(VisitorFeatureDao visitorFeatureDao) {
		this.visitorFeatureDao = visitorFeatureDao;
	}
	//增加
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
	//时间
	public String Date() {
		String time = String.valueOf(System.currentTimeMillis());
		return time;
	}
	//查下所用访客
	public List<Visitorfeature>  Vistor() {
		List<Visitorfeature> vistor= visitorFeatureDao.getAll();
		return vistor;
	}
	//查询符合的访客记录
	public List<Visitorfeature> findList(Integer BranchId){
		List<Visitorfeature> visitor=visitorFeatureDao.findList(BranchId);
		return visitor;
	}
	//性别比例
	public List<Map<Object, Double>> SexRatio(Integer BranchId){
		return visitorFeatureDao.SexRatio(BranchId);
	}
	//当日访客量
	public List<Map<Object, Integer>> newDay(String date,Integer BranchId){
		return visitorFeatureDao.newDay(date,BranchId);
		
	}
	//查询前七天的访客数据
	public List<Map<String, Integer>> WeeklyData(Integer BranchId){
		return visitorFeatureDao.WeeklyData(BranchId);
	}
	
	//年龄比例图
	public List<Map<String, Double>> AgeRatio(Integer BranchId){
		return visitorFeatureDao.AgeRatio(BranchId);
	}
	
}
