package com.crm.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.annotation.JSONField;
import com.crm.biz.DeviceBiz;
import com.crm.biz.MonitorBiz;
import com.crm.info.Monitor;
import com.crm.tools.ResponseUtil;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class MonitorAction extends ActionSupport {
	
	private MonitorBiz monitorBiz;
	
	private Monitor monitor;
	
	//参数
	private String Only;
	private String beginDate;
	public void setOnly(String only) {
		Only = only;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public MonitorBiz getMonitorBiz() {
		return monitorBiz;
	}

	public void setMonitorBiz(MonitorBiz monitorBiz) {
		this.monitorBiz = monitorBiz;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	
	private File upload;//动作类上传的属性必须是file类型,upload为表单的name值 private String
	private String uploadFileName; //上传的文件名称,固定写法:name+FileName; private String
	private String uploadContentType; //上传文件的mime类型,固定写法: name+ContextType;
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
	//增加
	
	java.util.Date dat = new java.util.Date();
	SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
	String times = dateFormat.format(dat);
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ssSSS");//设置日期格式
	java.util.Date date = new java.util.Date();
	String now = df.format(date);// new Date()为获取当前系统时间
	String[] strNow = new SimpleDateFormat("yyyy-MM-dd-HH").format(date).toString().split("-");
	Integer yea = Integer.parseInt(strNow[0]);
	Integer mont = Integer.parseInt(strNow[1]);
	Integer da = Integer.parseInt(strNow[2]);
	Integer hou = Integer.parseInt(strNow[3]);
	String year = yea.toString();
	String month = mont.toString();
	String day = da.toString();
	String hour = hou.toString();
	
	public void addMonitor() throws ParseException, IOException {
		String Path=monitor.getM_Path();
		String Only=Path.substring(0, Path.indexOf("_"));
		String Time=Path.substring(Only.length()+1, Path.lastIndexOf("_"));
		//根目录
		
		String qq="C:/"+"CrmSystemFile/";
		String qq2="Monitor"+java.io.File.separator+Only+java.io.File.separator + year + java.io.File.separator + month + java.io.File.separator + day;
		String RootPath=qq+qq2;
		File file=new File(RootPath);
		file.mkdirs();
		//文件上传
		String realPath=RootPath+java.io.File.separator+uploadFileName;
		FileUtils.copyFile(upload, new File(realPath));
		//监控时间
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		format.setLenient(false);
		Timestamp ts = new Timestamp(format.parse(Time).getTime());
		//realPath.replaceAll("\\\\", "/")
		String ss="http://guanli.zigetech.com:8080/file/"+qq2+java.io.File.separator +uploadFileName;
		String LocalPath=RootPath+java.io.File.separator +uploadFileName;
		monitor.setM_Only(Only);
		monitor.setM_Time(ts);
		monitor.setM_LocalPath(LocalPath);
		monitor.setM_Path(ss.replaceAll("\\\\", "/"));
		String che=ss.replaceAll("\\\\", "/");
		monitorBiz.addMonitor(monitor);
		List<Monitor> ch=monitorBiz.findMonitor(che);
		Map<String, String> checking=new HashedMap();
		if(ch.size()<=0) {
			checking.put("state","存储失败");
		}else {
			checking.put("Success", "存储成功");
		}
		ObjectMapper mapper=new ObjectMapper();
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
	}
	//根据年月日查询相对应的监控录像
	@JSONField(format ="yyyy-MM-dd HH:mm:ss")
	public void backList() {
		String subString1=beginDate.substring(0, beginDate.lastIndexOf("-"));
		String subString2=beginDate.substring(subString1.length()+1,beginDate.length());
		beginDate=subString1+" "+subString2;
		List<Monitor> ch=monitorBiz.findMonitorList(Only, beginDate);
		System.out.println("ches:"+ch);
		Map<String, Object> map=new HashedMap();
		map.put("monitor",ch);
		ObjectMapper mapper=new ObjectMapper();
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
	
	
	
}
