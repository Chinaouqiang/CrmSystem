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
	//����
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
	//�˶��Ƿ񱣴�ɹ�
	public List<Monitor> findMonitor(String Path){
		return monitorDao.findMonitor(Path);
	}
	//���������ղ�ѯ���Ӧ�ļ��¼��
	public List<Monitor> findMonitorList(String Only,String date){
		List<Monitor> monitor= monitorDao.findMonitorList(Only,date);
		return monitor;
	}
	//��ѯ�ֵ��������к�
	public List<Object> findList(String uid,String pwd){
		return monitorDao.findList(uid, pwd);
	}
	//��ѯ����ǰ����������
	
	public List<Map<String, Object>> findDeleteList() throws Exception{
		Date d = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String times = dateFormat.format(d);
		List<Map<String, Object>> ss=monitorDao.findDeleteList(times);
		for (Map<String, Object> map : ss) {
			/*
			 * System.out.println("����2"); //ɾ������ monitorDao.delete((Integer)map.get("a"));
			 * //ɾ���������ļ� File file=new File(map.get("b").toString()); file.delete();
			 * System.out.println("ɾ���ɹ�");
			 */
		}
		return ss;
	}
	
}
