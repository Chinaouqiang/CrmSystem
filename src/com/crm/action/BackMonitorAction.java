package com.crm.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.crm.biz.BackMonitorBiz;
import com.crm.biz.DeviceBiz;
import com.crm.info.BackMonitor;
import com.crm.info.Device;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class BackMonitorAction extends ActionSupport {
	
	private BackMonitorBiz backMonitorBiz;
	
	private BackMonitor backMonitor;
	
	private DeviceBiz deviceBiz;
	

	public void setDeviceBiz(DeviceBiz deviceBiz) {
		this.deviceBiz = deviceBiz;
	}


	public void setBackMonitorBiz(BackMonitorBiz backMonitorBiz) {
		this.backMonitorBiz = backMonitorBiz;
	}
	
	
	public BackMonitor getBackMonitor() {
		return backMonitor;
	}


	public void setBackMonitor(BackMonitor backMonitor) {
		this.backMonitor = backMonitor;
	}


	//���Ӽ������ͷ����
	public String addBackMonitor() {
		String uid=(String) Scopes.getSessionMap().get("loginName");
		String pwd=(String) Scopes.getSessionMap().get("loginPwd");
		int branch=deviceBiz.BrancheId(uid, pwd);
		backMonitor.setBranchShop_Id(branch);
		backMonitorBiz.addBackMonitor(backMonitor);
		return findBackMonitorList();
	}
	//ɾ���������ͷ����
	public String deleteBackMonitor() {
		Integer id=backMonitor.getB_Id();
		backMonitorBiz.deleteBackMonitor(id);
		return findBackMonitorList();
	}
	//�޸ļ������ͷ����
	public String updateBackMonitor() {
		backMonitorBiz.updateBackMonitor(backMonitor);
		return findBackMonitorList();
	}
	//����id������Ӧ������
	public String findOne() {
		Integer id=backMonitor.getB_Id();
		BackMonitor one=backMonitorBiz.findOne(id);
		int branch=deviceBiz.BrancheId((String) Scopes.getSessionMap().get("loginName"),(String) Scopes.getSessionMap().get("loginPwd"));
		List<Device> findDevice= deviceBiz.findDevice(branch);
		System.out.println(findDevice);
		Scopes.getRequestMap().put("findDevice", findDevice);
		Scopes.getRequestMap().put("ListOne", one);
		return "list";
	}
	//�����û����Ӧ������
	public String findBackMonitorList() {
		int branch=deviceBiz.BrancheId((String) Scopes.getSessionMap().get("loginName"),(String) Scopes.getSessionMap().get("loginPwd"));
		List<BackMonitor> BackMonitorList=backMonitorBiz.findBackMonitorList(branch);
		System.out.println(BackMonitorList);
		Scopes.getRequestMap().put("BackMonitorList", BackMonitorList);
		return SUCCESS;
	}
	
	//�ֵ��豸���к�
	public String findDevice() {
		int branch=deviceBiz.BrancheId((String) Scopes.getSessionMap().get("loginName"),(String) Scopes.getSessionMap().get("loginPwd"));
		List<Device> findDevice= deviceBiz.findDevice(branch);
		Scopes.getRequestMap().put("findDevice", findDevice);
		return "add";
	}
	
	
	
	
}
