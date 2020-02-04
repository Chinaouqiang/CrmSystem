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
	
	//����biz����
	private VisitorFeatureBiz visitorFeatureBiz;
	
	
	private PublicAdvertBiz publicAdvertBiz;//���ù�淽��
	
	
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
	
	private Integer State;//״̬
	
	
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
	
	//����
	
	public String addDevice() {
		int ss=BrancheId();
		device.setBranchShop_Id(ss);
		device.setDevice_State(1);
		device.setDevice_Time(new Timestamp(new Date().getTime()));
		deviceBiz.CreateDevice(device);
		return "add";
	}
	
	//ɾ��
	
	public String deleteDevice() {
		deviceBiz.deleteDevice(id);
		return "add";
	}
	
	//�鿴�����豸
	public String findOne() {
		Device device=deviceBiz.findOne(id);
		Scopes.getRequestMap().put("deviceOne", device);
		return "findOne";
	}
	
	//��ѯ�����豸��Ϣ
	public String deviceList(){
		int branch=deviceBiz.BrancheId((String) Scopes.getSessionMap().get("loginName"),(String) Scopes.getSessionMap().get("loginPwd"));
		List<Device> list=deviceBiz.findAll(branch);
		Scopes.getRequestMap().put("DeviceList", list);
		return SUCCESS;
	}
	
	//�˶��豸��Ϣ
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
	
	//�޸��豸��Ϣ
	public String updateDevice() {
		device.setDevice_Time(new Timestamp(new Date().getTime()));
		deviceBiz.updateDevice(device);
		return "add";
	}
	
	//�޸��豸״̬
	public String updateDeviceState() {
		Integer state=device.Device_State;
		Integer Id=device.Device_Id;
		deviceBiz.updateDeviceState(state, Id);
		return "add";
	}
	
	
	//��ת��������ҳ��
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
		//�˶Ը��豸�ܷ��¼
		List<Device> ch=deviceBiz.checkingDevice(Only);
		System.out.println(ch);
		Map<String, Object> Mixture=new HashedMap();
		if(ch.size()>0 || "unknow".equals(Only)) {
			//��ǰʱ���
			String t=visitorFeatureBiz.Date();
			//С���
			List<PublicAdvert> listH=publicAdvertBiz.AdvertManageHead(Only);
			//����
			List<PublicAdvert> list=publicAdvertBiz.findAllAdvertOnly(Only);
			JsonUtil.toJson(list);
			//�����Ƶ����
			List<BackMonitor> backMonitor= backMonitorBiz.findBackMonitorOnly(Only);
			//�������кŲ�ѯ���̶�Ӧ��Ա������
			Object hrCount=hrEmployeeBiz.findCount(Only);
			//�������кŲ�ѯ���̶�Ӧ��Ա��
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
	
	//�û��ֵ�id
	public Integer BrancheId() {
		String uid=(String) Scopes.getSessionMap().get("loginName");
		String pwd=(String) Scopes.getSessionMap().get("loginPwd");
		Integer ss=deviceBiz.BrancheId(uid, pwd);
		return ss;
	}
	
	//�ֵ��豸���к�
	public void  findDevice(){
		int id=BrancheId();
		deviceBiz.findDevice(id);
	}
	
	public void sssss() {
		deviceBiz.ss();
	}
}
