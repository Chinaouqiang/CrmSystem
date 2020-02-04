package com.crm.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.BackMonitorDao;
import com.crm.info.BackMonitor;

@Transactional
@Service
public class BackMonitorBiz {
	private BackMonitorDao backMonitorDao;
	
	public void setBackMonitorDao(BackMonitorDao backMonitorDao) {
		this.backMonitorDao = backMonitorDao;
	}
	
	
	
	//增加监控摄像头数据
	public Boolean addBackMonitor(BackMonitor backMonitor) {
		try {
			backMonitorDao.save(backMonitor);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	//删除监控摄像头数据
	public Boolean deleteBackMonitor(Integer id) {
		try {
			backMonitorDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//修改监控摄像头数据
	public void updateBackMonitor(BackMonitor backMonitor) {
		try {
			backMonitorDao.save(backMonitor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//根据id查找数据
	public BackMonitor  findOne(Integer id) {
		return backMonitorDao.get(id);
	}
	
	//查找用户相对应的数据
	public List<BackMonitor> findBackMonitorList(Integer id){
		List<BackMonitor> backMonitors=backMonitorDao.findList(id);
		return backMonitors;
	}
	
	//根据序列号查找数据
	public List<BackMonitor> findBackMonitorOnly(String id){
		List<BackMonitor> backMonitorsOnly=backMonitorDao.findBackMonitorOnly(id);
		System.out.println("backMonitor:"+backMonitorsOnly);
		return backMonitorsOnly;
	}
	
	
	
}
