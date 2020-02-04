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
	
	
	
	//���Ӽ������ͷ����
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
	
	
	//ɾ���������ͷ����
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
	
	//�޸ļ������ͷ����
	public void updateBackMonitor(BackMonitor backMonitor) {
		try {
			backMonitorDao.save(backMonitor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����id��������
	public BackMonitor  findOne(Integer id) {
		return backMonitorDao.get(id);
	}
	
	//�����û����Ӧ������
	public List<BackMonitor> findBackMonitorList(Integer id){
		List<BackMonitor> backMonitors=backMonitorDao.findList(id);
		return backMonitors;
	}
	
	//�������кŲ�������
	public List<BackMonitor> findBackMonitorOnly(String id){
		List<BackMonitor> backMonitorsOnly=backMonitorDao.findBackMonitorOnly(id);
		System.out.println("backMonitor:"+backMonitorsOnly);
		return backMonitorsOnly;
	}
	
	
	
}
