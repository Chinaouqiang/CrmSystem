package com.crm.biz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.MonitorDao;
import com.crm.info.Monitor;

@Transactional
@Service
public class MonitorBiz {
	
	private MonitorDao monitorDao;


	public void setMonitorDao(MonitorDao monitorDao) {
		this.monitorDao = monitorDao;
	}
	//增加
	public Boolean addMonitor(Monitor monitor) {
		try {
			monitorDao.save(monitor);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	//核对是否保存成功
	public List<Monitor> findMonitor(String Path){
		return monitorDao.findMonitor(Path);
	}
	//根据年月日查询相对应的监控录像
	public List<Monitor> findMonitorList(String Only,String date){
		List<Monitor> monitor= monitorDao.findMonitorList(Only,date);
		return monitor;
	}
	//查询分店所用序列号
	public List<Object> findList(String uid,String pwd){
		return monitorDao.findList(uid, pwd);
	}
	//查询七天前的所有数据
	
	public List<Map<String, Object>> findDeleteList() throws Exception{
		Date d = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = dateFormat.format(d);
		List<Map<String, Object>> ss=monitorDao.findDeleteList(times);
		for (Map<String, Object> map : ss) {
			/*
			 * System.out.println("进入2"); //删除数据 monitorDao.delete((Integer)map.get("a"));
			 * //删除服务器文件 File file=new File(map.get("b").toString()); file.delete();
			 * System.out.println("删除成功");
			 */
		}
		return ss;
	}
	
}
