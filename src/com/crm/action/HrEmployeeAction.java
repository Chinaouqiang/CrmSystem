package com.crm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.crm.biz.DeviceBiz;
import com.crm.biz.HrEmployeeBiz;
import com.crm.biz.MonitorBiz;
import com.crm.biz.SysAppBiz;
import com.crm.biz.SysLoginBiz;
import com.crm.biz.SysMenuBiz;
import com.crm.info.HrEmployee;
import com.crm.info.Monitor;
import com.crm.info.SysLogin;
import com.crm.info.Visitorfeature;
import com.crm.tools.Md5;
import com.crm.tools.ResponseUtil;
import com.crm.tools.Scopes;
import com.crm.tools.ValidateCode;
import com.crm.tools.WebTools;
import com.crm.tools.ajax;
import com.crm.vobj.SysMenuVobj;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("hrEmployeeAction")
public class HrEmployeeAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {
	HttpServletResponse response;
	HttpServletRequest request;
	
	private File upload;//动作类上传的属性必须是file类型,upload为表单的name值 private String
	private String uploadFileName; //上传的文件名称,固定写法:name+FileName; private String
	private String uploadContentType; //上传文件的mime类型,固定写法: name+ContextType;
	
	private MonitorBiz monitorBiz;
	
	public void setMonitorBiz(MonitorBiz monitorBiz) {
		this.monitorBiz = monitorBiz;
	}

	private DeviceBiz deviceBiz;
	
	
	public void setDeviceBiz(DeviceBiz deviceBiz) {
		this.deviceBiz = deviceBiz;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	private HrEmployeeBiz hrEmployeeBiz;

	private SysAppBiz sysAppBiz;
	private SysMenuBiz sysMenuBiz;
	private SysLoginBiz sysLoginBiz;

	public void setSysLoginBiz(SysLoginBiz sysLoginBiz) {
		this.sysLoginBiz = sysLoginBiz;
	}

	public void setSysMenuBiz(SysMenuBiz sysMenuBiz) {
		this.sysMenuBiz = sysMenuBiz;
	}

	public void setHrEmployeeBiz(HrEmployeeBiz hrEmployeeBiz) {
		this.hrEmployeeBiz = hrEmployeeBiz;
	}

	public void setSysAppBiz(SysAppBiz sysAppBiz) {
		this.sysAppBiz = sysAppBiz;
	}

	/**
	 * login.jsp页面的验证码生成
	 */
	public void ajaxValidateCode() {
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		ValidateCode randomValidateCode = new ValidateCode();
		try {
			ValidateCode.code = randomValidateCode.getRandcode(request,
					response);// 输出图片方法
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ajax2() {
		response.setContentType("image/jpeg");//设置相应的类型，告诉游览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		ajax s=new ajax();
		ajax.code = s.getRandcode(request, response);
	}
	
	private File headfile;
	public File getHeadfile() {
		return headfile;
	}
	public void setHeadfile(File headfile) {
		this.headfile = headfile;
	}
	private String headfileFileName,headfileContentType;
	public String getHeadfileFileName() {
		HrEmployee emp=((HrEmployee)Scopes.getSessionMap().get("emp"));
		return emp.getUid()+""+headfileFileName;
	}
	public void setHeadfileFileName(String headfileFileName) {
		this.headfileFileName = headfileFileName.substring(headfileFileName.lastIndexOf('.'));
	}
	public String getHeadfileContentType() {
		return headfileContentType;
	}
	public void setHeadfileContentType(String headfileContentType) {
		this.headfileContentType = headfileContentType;
	}

	public String uploadHead(){
		try{
			String path=ServletActionContext.getServletContext().getRealPath("/img/upfile");
			byte[] buff = new byte[1024];
			FileInputStream fis = new FileInputStream(getHeadfile());
			FileOutputStream fos = new FileOutputStream(path+"\\"+getHeadfileFileName());
			int length=fis.read(buff);
			while(length>0){
				fos.write(buff,0,length);
				length=fis.read(buff);
			}
			fis.close();
			fos.flush();
			fos.close();
			HrEmployee newemp = hrEmployeeBiz.updateHead(getHeadfileFileName());
			Scopes.getSessionMap().put("emp", newemp);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "uphead";
	}
	HrEmployee employee;
	public HrEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(HrEmployee employee) {
		this.employee = employee;
	}
	
	public String empUpdate(){
		HrEmployee loyee = hrEmployeeBiz.empUpdate(employee);
		Scopes.getSessionMap().put("emp", loyee);
		return "uphead";
	}
	private String newpwd;

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String empUpdatePwd(){
		HrEmployee loyee=hrEmployeeBiz.updatePwd(newpwd);
		Scopes.getSessionMap().put("emp", loyee);
		return "uphead";
	}
	public String ajaxValidatePwd(){
		HrEmployee emp=((HrEmployee)Scopes.getSessionMap().get("emp"));
		String data="";
		if (emp.getPwd().equals(pwd)) {
			data="1";
		}else{
			data="0";
		}
		Scopes.getRequestMap().put("data", data);
		return "ajax";
	}
	
	private String theme;
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String changeTheme(){
		HrEmployee loyee = hrEmployeeBiz.updateTheme(theme);
		Scopes.getSessionMap().put("emp", loyee);
		return "ajax";
	}

	private String name, pwd, inpcode,Only,Path;
	
	public void setPath(String path) {
		Path = path;
	}

	public void setOnly(String only) {
		Only = only;
	}

	// 登录名接收
	public void setName(String name) {
		this.name = name.trim();
	}

	// 登录密码接收
	public void setPwd(String pwd) {
		if (!pwd.trim().equals("")) {
			this.pwd = Md5.MD5(pwd.trim());
		} else {
			this.pwd = pwd.trim();
		}
	}

	// 登录验证码接收
	public void setInpcode(String inpcode) {
		this.inpcode = inpcode.trim();
	}

	/**
	 * 登录方法 登录成功的用户 Session 的key ='emp'
	 * 
	 * @return
	 */
	public String login() {
		 ObjectMapper mapper = new ObjectMapper();
		 Map<String, Object> Mixture=new HashedMap();
		if (inpcode.equalsIgnoreCase(ValidateCode.code)) {
			// 登录
			HrEmployee employee = hrEmployeeBiz.login(name, pwd);
			if (employee != null) {
				if (employee.getCanlogin() == 1) {
					Scopes.getSessionMap().put("emp", employee);
					List<SysMenuVobj> menuVobjs = sysMenuBiz.findShowMenusByRole(employee.getSysRole());
					Scopes.getSessionMap().put("menus", menuVobjs);
					sysLoginBiz.add(new SysLogin());
					int Branche=deviceBiz.BrancheId(name, pwd);
					Scopes.getSessionMap().put("BrancheId", Branche);
					Scopes.getSessionMap().put("loginName", name);
					Scopes.getSessionMap().put("loginPwd", pwd);
					List<Object> monitorOnly= monitorBiz.findList(name, pwd);
					return "login";
				} else {
					Scopes.getRequestMap().put("err", "您没有权限登录，请联系管理员");
					Mixture.put("err", "您没有权限登录，请联系管理员");
					// 您没有权限登录
					return "loginerr";
				}
			} else {
				Scopes.getRequestMap().put("err", "您输入账号或密码错误");
				// 账户密码错误
				return "loginerr";
			}
		} else {
			Scopes.getRequestMap().put("err", "您输入验证码错误");
			// 验证码错误
			return "loginerr";
		}
	}
	public String loginOut(){
		Scopes.getSessionMap().remove("emp");
		Scopes.getSessionMap().remove("menus");
		return "loginerr";
	}
	
	public String execute(){
		List<HrEmployee> employees = hrEmployeeBiz.findAllEmps();
		Scopes.getRequestMap().put("emps", employees);
		return "show";
	}
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public String findOne(){
		HrEmployee employee=hrEmployeeBiz.findOne(id);
		Scopes.getRequestMap().put("emp", employee);
		return "findone";
	}
	public String deleteById(){
		hrEmployeeBiz.deleteFlase(id);
		return "deletefalse";
	}
	private HrEmployee emp;
	public HrEmployee getEmp() {
		return emp;
	}

	public void setEmp(HrEmployee emp) {
		this.emp = emp;
	}

	public String update(){
		hrEmployeeBiz.update(emp);
		return "update";
	}
	
	public String add(){
		hrEmployeeBiz.add(emp);
		return "add";
	}

	private int depid;

	public void setDepid(int depid) {
		this.depid = depid;
	}
	
	public String ajaxGetEmpsByDepId() {
		List<HrEmployee> employees = hrEmployeeBiz.findEmpsByDepId(depid);
		WebTools.jsonClearEmps(employees);
		String data = WebTools.convertJson(employees);
		Scopes.getRequestMap().put("data", data);
		return "ajax";
	}
	public String ajaxGetEmps(){
		List<HrEmployee> employees = hrEmployeeBiz.findAllEmps();
		HrEmployee employee=(HrEmployee)Scopes.getSessionMap().get("emp");
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getId().equals(employee.getId())) {
				employees.remove(employees.get(i));
			}
		}
		System.out.println(employees.size());
		WebTools.jsonClearEmps(employees);
		String data = WebTools.convertJson(employees);
		Scopes.getRequestMap().put("data", data);
		return "ajax";
	}
	
	public String trashAll(){
		Scopes.getRequestMap().put("emps", hrEmployeeBiz.findTrashAll());
		return "trash";
	}
	
	public String trashDel(){
		hrEmployeeBiz.deleteById(id);
		return trashAll();
	}
	
	public String trashAdd(){
		hrEmployeeBiz.doTrashAdd(id);
		return trashAll();
	}
	
	//员工注册（注册部分数据）
	public void addlogon() throws IOException {
		String qq="C:/CrmSystemFile/";
		String qq2="upload" + java.io.File.separator + "Staff";
		String path=qq+qq2;
		File file=new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		String realPath=path+ java.io.File.separator +uploadFileName;
		FileUtils.copyFile(upload, new File(realPath));
		String ss="http://guanli.zigetech.com:8080/file"+java.io.File.separator+qq2+java.io.File.separator +uploadFileName ;
		emp.setIsdelete(1);
		emp.setPortal(ss.replaceAll("\\\\","/"));
		Boolean f=hrEmployeeBiz.Addlogon(emp);
		Map<String,Object> map=new HashMap<String,Object>();
		if(f) {
			map.put("tips",1);
		}else {
			map.put("tips",0);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(map);
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
	}
	
	public String loginCopy() {
		Map<String, Object> Mixture=new HashedMap();
		if (inpcode.equalsIgnoreCase(ValidateCode.code)) {
			// 登录
			HrEmployee employee = hrEmployeeBiz.login(name, pwd);
			if (employee != null) {
				if (employee.getCanlogin() == 1) {
					Scopes.getSessionMap().put("emp", employee);
					List<SysMenuVobj> menuVobjs = sysMenuBiz.findShowMenusByRole(employee.getSysRole());
					Scopes.getSessionMap().put("menus", menuVobjs);
					sysLoginBiz.add(new SysLogin());
					int Branche=deviceBiz.BrancheId(name, pwd);
					Scopes.getSessionMap().put("BrancheId", Branche);
					Scopes.getSessionMap().put("loginName", name);
					Scopes.getSessionMap().put("loginPwd", pwd);
					List<Object> monitorOnly= monitorBiz.findList(name, pwd);
					Mixture.put("Success", "成功");
					Mixture.put("monitorOnly", monitorOnly);
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = mapper.writeValueAsString(Mixture);
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
					return "login";
				} else {
					Mixture.put("err", "您没有权限登录，请联系管理员");
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = mapper.writeValueAsString(Mixture);
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
					// 您没有权限登录
					return "loginerr";
				}
			} else {
				Mixture.put("err", "您输入账号或密码错误");
				ObjectMapper mapper = new ObjectMapper();
				try {
					String json = mapper.writeValueAsString(Mixture);
					ResponseUtil.write(json);
					System.out.println(json);
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
				// 账户密码错误
				return "loginerr";
			}
		} else {
			Mixture.put("err", "您输入验证码错误");
			ObjectMapper mapper = new ObjectMapper();
			try {
				String json = mapper.writeValueAsString(Mixture);
				ResponseUtil.write(json);
				System.out.println(json);
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
			// 验证码错误
			return "loginerr";
		}
	}
	
	
	//根据序列号查询店铺对应的员工
		public void findList(){
			List<Map<String, Object>> findList=hrEmployeeBiz.findList(Only);
			Map map=new HashedMap();
			map.put("ss", findList);
			 ObjectMapper mapper = new ObjectMapper();
				try {
					String json = mapper.writeValueAsString(map);
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
		}
	//根据序列号查询店铺对应的员工人数
	public void findCount(){
		Object ss=hrEmployeeBiz.findCount(Only);
	}
	
}