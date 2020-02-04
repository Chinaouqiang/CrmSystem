package com.crm.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.CheckWorkDao;
import com.crm.info.CheckWork;

@Transactional
@Service
public class CheckWorkBiz {

	private CheckWorkDao checkWorkDao;

	public void setCheckWorkDao(CheckWorkDao checkWorkDao) {
		this.checkWorkDao = checkWorkDao;
	}
	
	
	//增加
	public Boolean addCheckWork(CheckWork checkWork) {
		try {
			checkWorkDao.save(checkWork);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	//删除
	public Boolean deleteCheckWork(Integer id) {
		try {
			checkWorkDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	//查询
	public List<CheckWork> findcheck(String time,String Name,Integer dep,Integer id){
		List<CheckWork> ss=checkWorkDao.findcheck(time, Name, dep, id);
		return ss;
	}
	
	//修改
	public Integer updateWork(String field,String workTime,Integer id){
		Integer num=checkWorkDao.updateWork(field, workTime, id);
		return num;
	}
	
	//修改
		public Integer updateWork2(String field,String workTime,String state,String con,Integer id){
			Integer num=checkWorkDao.updateWork2(field, workTime, state, con, id);
			return num;
		}
	
	//根据时间展示所有
	public List<CheckWork> findList(String Time,Integer id){
		List<CheckWork> findList=checkWorkDao.findList(Time,id);
		return findList;
	}
	
	//根据时间展示所有
		public List<CheckWork> findList2(String TimeHead,String Timelend){
			List<CheckWork> findList=checkWorkDao.findList2(TimeHead,Timelend);
			return findList;
		}
	
	public List<CheckWork> findAll(){
		List<CheckWork> ss=checkWorkDao.getAll();
		return ss;
	}
	
}
