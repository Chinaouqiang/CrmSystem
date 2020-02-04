package com.crm.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.DeviceDao;
import com.crm.info.Device;
import com.crm.info.PublicAdvert;

@Transactional
@Service
public class DeviceBiz {
	
	private DeviceDao deviceDao;

	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}
	
	
	//���ӣ�ʵ����IdΪ�գ����޸ģ�ʵ����Id��Ϊ�գ�
	public Boolean CreateDevice(Device device) {
		try {
			deviceDao.save(device);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//ɾ��
	public boolean deleteDevice(Integer id) {
		try {
			deviceDao.delete(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//�鿴�����豸
	
	public List<Device> findAll(Integer id){
		List<Device> DeviceList=deviceDao.findDevice(id);
		return DeviceList;
	}
	
	//�鿴�����豸
	public Device findOne(Integer id){
		Device OnlyDevice=deviceDao.get(id);
		return OnlyDevice;
	}
	
	
	//�����豸��ѯ�Ƿ����ֶ�Ӧ���豸
	
	public List<Device> checkingDevice(String OnlyId) {
		List<Device> checkingDevice=deviceDao.checkingDevice(OnlyId);
		return checkingDevice;
	}
	
	//�޸��豸��Ϣ
	public boolean updateDevice(Device device) {
		try {
			deviceDao.save(device);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	//�޸��豸״̬
	public boolean updateDeviceState(Integer state,Integer Id) {
		try {
			deviceDao.updateState(state, Id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}	
	
	public Integer BrancheId(String uid,String pwd) {
		return deviceDao.BrancheId(uid,pwd);
	}
	
	//�ֵ��豸���к�
	public List<Device> findDevice(Integer id){
		return deviceDao.findDevice(id);
	}
	

	public void ss() {
		deviceDao.ss();
	}
}
