package com.crm.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.crm.biz.BackMonitorBiz;
import com.crm.biz.DeviceBiz;
import com.crm.biz.HrEmployeeBiz;
import com.crm.biz.PublicAdvertBiz;
import com.crm.biz.VisitorFeatureBiz;
import com.crm.info.BackMonitor;
import com.crm.info.Device;
import com.crm.info.PublicAdvert;
import com.crm.tools.JsonUtil;
import com.crm.tools.ResponseUtil;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class DeviceAction extends ActionSupport {
	
	private HrEmployeeBiz hrEmployeeBiz;
	
	private DeviceBiz deviceBiz;
	
	private BackMonitorBiz backMonitorBiz;
	
	//调用biz方法
	private VisitorFeatureBiz visitorFeatureBiz;
	
	
	private PublicAdvertBiz publicAdvertBiz;//调用广告方法
	
	
	public void setBackMonitorBiz(BackMonitorBiz backMonitorBiz) {
		this.backMonitorBiz = backMonitorBiz;
	}

	public void setVisitorFeatureBiz(VisitorFeatureBiz visitorFeatureBiz) {
		this.visitorFeatureBiz = visitorFeatureBiz;
	}

	public void setPublicAdvertBiz(PublicAdvertBiz publicAdvertBiz) {
		this.publicAdvertBiz = publicAdvertBiz;
	}

	public void setHrEmployeeBiz(HrEmployeeBiz hrEmployeeBiz) {
		this.hrEmployeeBiz = hrEmployeeBiz;
	}


	private Device device;
	
	private Integer id;
	
	private Integer State;//状态
	
	
	public Integer getState() {
		return State;
	}

	public void setState(Integer state) {
		State = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public void setDeviceBiz(DeviceBiz deviceBiz) {
		this.deviceBiz = deviceBiz;
	}
	
	//增加
	
	public String addDevice() {
		int ss=BrancheId();
		device.setBranchShop_Id(ss);
		device.setDevice_State(1);
		device.setDevice_Time(new Timestamp(new Date().getTime()));
		deviceBiz.CreateDevice(device);
		return "add";
	}
	
	//删除
	
	public String deleteDevice() {
		deviceBiz.deleteDevice(id);
		return "add";
	}
	
	//查看单个设备
	public String findOne() {
		Device device=deviceBiz.findOne(id);
		Scopes.getRequestMap().put("deviceOne", device);
		return "findOne";
	}
	
	//查询所有设备信息
	public String deviceList(){
		int branch=deviceBiz.BrancheId((String) Scopes.getSessionMap().get("loginName"),(String) Scopes.getSessionMap().get("loginPwd"));
		List<Device> list=deviceBiz.findAll(branch);
		Scopes.getRequestMap().put("DeviceList", list);
		return SUCCESS;
	}
	
	//核对设备信息
	public String checking() {
		String OnlyId=device.getDevice_Only();
		List<Device> ch=deviceBiz.checkingDevice(OnlyId);
		Map<String, Integer> checking=new HashedMap();
		if(ch.size()>0) {
			checking.put("DeviceChecking",1);
		}else {
			checking.put("DeviceChecking",0);
		}
	    ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(checking);
			ResponseUtil.write(json);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//修改设备信息
	public String updateDevice() {
		device.setDevice_Time(new Timestamp(new Date().getTime()));
		deviceBiz.updateDevice(device);
		return "add";
	}
	
	//修改设备状态
	public String updateDeviceState() {
		Integer state=device.Device_State;
		Integer Id=device.Device_Id;
		deviceBiz.updateDeviceState(state, Id);
		return "add";
	}
	
	
	//跳转到广告管理页面
	public String AdvertManage() {
		String Only=device.getDevice_Only();
		 List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyVido(Only);
		 Scopes.getRequestMap().put("AdvertManage", findAllAdvertOnly);
		 Scopes.getRequestMap().put("Only", Only);
		return "AdvertManage";
	}
	
	
	//
	public String Mixture() {
		String Only=device.getDevice_Only();
		//核对该设备能否登录
		List<Device> ch=deviceBiz.checkingDevice(Only);
		System.out.println(ch);
		Map<String, Object> Mixture=new HashedMap();
		if(ch.size()>0 || "unknow".equals(Only)) {
			//当前时间戳
			String t=visitorFeatureBiz.Date();
			//小广告
			List<PublicAdvert> listH=publicAdvertBiz.AdvertManageHead(Only);
			//大广告
			List<PublicAdvert> list=publicAdvertBiz.findAllAdvertOnly(Only);
			JsonUtil.toJson(list);
			//监控视频数据
			List<BackMonitor> backMonitor= backMonitorBiz.findBackMonitorOnly(Only);
			//根据序列号查询店铺对应的员工人数
			Object hrCount=hrEmployeeBiz.findCount(Only);
			//根据序列号查询店铺对应的员工
			List<Map<String, Object>> findList=hrEmployeeBiz.findList(Only);
			System.out.println(findList);
			Mixture.put("hrCount", hrCount);
			Mixture.put("backMonitor", backMonitor);
			Mixture.put("hrCount", hrCount);
			Mixture.put("backMonitor", backMonitor);
			Mixture.put("publicAdvert", list);
			Mixture.put("publicAdvertHead", listH);
			Mixture.put("time",t);
			Mixture.put("DeviceChecking",1);
			Mixture.put("number", findList);
		}else {
			Mixture.put("DeviceChecking",0);
		}
		 ObjectMapper mapper = new ObjectMapper();
			try {
				String json = mapper.writeValueAsString(Mixture);
				JsonUtil.format(json);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return null;
	}
	
	//用户分店id
	public Integer BrancheId() {
		String uid=(String) Scopes.getSessionMap().get("loginName");
		String pwd=(String) Scopes.getSessionMap().get("loginPwd");
		Integer ss=deviceBiz.BrancheId(uid, pwd);
		return ss;
	}
	
	//分店设备序列号
	public void  findDevice(){
		int id=BrancheId();
		deviceBiz.findDevice(id);
	}
	
	public void sssss() {
		deviceBiz.ss();
	}
}
