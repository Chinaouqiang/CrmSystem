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
	
	
	//增加（实体类Id为空）或修改（实体类Id不为空）
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
	
	//删除
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
	
	//查看所有设备
	
	public List<Device> findAll(Integer id){
		List<Device> DeviceList=deviceDao.findDevice(id);
		return DeviceList;
	}
	
	//查看单个设备
	public Device findOne(Integer id){
		Device OnlyDevice=deviceDao.get(id);
		return OnlyDevice;
	}
	
	
	//根据设备查询是否有现对应的设备
	
	public List<Device> checkingDevice(String OnlyId) {
		List<Device> checkingDevice=deviceDao.checkingDevice(OnlyId);
		return checkingDevice;
	}
	
	//修改设备信息
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
	
	//修改设备状态
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
	
	//分店设备序列号
	public List<Device> findDevice(Integer id){
		return deviceDao.findDevice(id);
	}
	

	public void ss() {
		deviceDao.ss();
	}
}
