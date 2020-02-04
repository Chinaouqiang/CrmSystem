package com.crm.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.crm.biz.BackMonitorBiz;
import com.crm.biz.DeviceBiz;
import com.crm.biz.PublicAdvertBiz;
import com.crm.biz.VisitorFeatureBiz;
import com.crm.biz.VisitorTimeBiz;
import com.crm.info.BackMonitor;
import com.crm.info.Device;
import com.crm.info.PublicAdvert;
import com.crm.info.Visitorfeature;
import com.crm.tools.ResponseUtil;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class VisitorFeatureAction extends ActionSupport{
	

	private DeviceBiz deviceBiz;
	
	private PublicAdvertBiz publicAdvertBiz;
	
	private BackMonitorBiz backMonitorBiz;
	
	private VisitorTimeBiz visitorTimeBiz;

	public void setVisitorTimeBiz(VisitorTimeBiz visitorTimeBiz) {
		this.visitorTimeBiz = visitorTimeBiz;
	}
	
	public void setDeviceBiz(DeviceBiz deviceBiz) {
		this.deviceBiz = deviceBiz;
	}

	public void setPublicAdvertBiz(PublicAdvertBiz publicAdvertBiz) {
		this.publicAdvertBiz = publicAdvertBiz;
	}

	public void setBackMonitorBiz(BackMonitorBiz backMonitorBiz) {
		this.backMonitorBiz = backMonitorBiz;
	}

	//调用biz方法
	private VisitorFeatureBiz visitorFeatureBiz;
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private String serviceDir="/upload/facepic";
	
	private Visitorfeature visitorfeature=new Visitorfeature();
	
	public Visitorfeature getVisitorfeature() {
		return visitorfeature;
	}

	public void setVisitorfeature(Visitorfeature visitorfeature) {
		this.visitorfeature = visitorfeature;
	}
	
	



	public HttpServletRequest getRequest() {
		return request;
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}



	public HttpServletResponse getResponse() {
		return response;
	}



	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}



	public void setVisitorFeatureBiz(VisitorFeatureBiz visitorFeatureBiz) {
		this.visitorFeatureBiz = visitorFeatureBiz;
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
	public String add() {
		java.util.Date dat = new java.util.Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		String times = dateFormat.format(dat);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
		java.util.Date date = new java.util.Date();
		String now = df.format(date);// new Date()为获取当前系统时间
		String ssString=uploadFileName;
		String only=visitorfeature.getDevice_only();
		String fileNAME=now+ssString.substring(ssString.substring(0,ssString.lastIndexOf(".") ).length(), ssString.length());
		String[] strNow = new SimpleDateFormat("yyyy-MM-dd-HH").format(date).toString().split("-");
		Integer yea = Integer.parseInt(strNow[0]);
		Integer mont = Integer.parseInt(strNow[1]);
		Integer da = Integer.parseInt(strNow[2]);
		Integer hou = Integer.parseInt(strNow[3]);
		String year = yea.toString();
		String month = mont.toString();
		String day = da.toString();
		String hour = hou.toString();
		String qq="C:/"+"CrmSystemFile/";
		String qq2="upload" + java.io.File.separator + "facepic" + java.io.File.separator +only+ java.io.File.separator + year + java.io.File.separator + month + java.io.File.separator + day + java.io.File.separator + hour;
		String facepicpath =qq+qq2;
		File file=new File(facepicpath);
		file.mkdirs();
		String realPath=facepicpath+ java.io.File.separator +fileNAME;
		System.out.println(realPath);
		try {
			FileUtils.copyFile(upload, new File(realPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path="http://guanli.zigetech.com:8080/file"+java.io.File.separator+qq2+java.io.File.separator +fileNAME ;
		System.out.println("上传："+now);
		visitorfeature.setBuildtime(new Timestamp(new Date().getTime()));
		visitorfeature.setImg(path.replaceAll("\\\\", "/"));
		boolean f=visitorFeatureBiz.addVi(visitorfeature);
		Map<String, Object> Mixture=new HashedMap();
		if(f==true) {
			Mixture.put("state", 1);
		}else {
			Mixture.put("state", 0);
		}
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
		return null;
	}
	
	//访客记录
	
	public void  VistorList() {
		List<Visitorfeature> vistor = visitorFeatureBiz.findList((Integer)Scopes.getSessionMap().get("BrancheId"));
		for (Visitorfeature v : vistor) {
			if (v.getSex().equals("0")) {
				v.setSex("女");
			}
			else if(v.getSex().equals("1")) {
				v.setSex("男");
			}  
		}
		Scopes.getRequestMap().put("vistorList", vistor);
		//return SUCCESS;
	}
	//访客男女比例
	public void SexR() {
		Double total = null ;
		Double q = null;
		Double qq = null;
		DecimalFormat df = new DecimalFormat("#");
		List<Map<Object, Double>> SexRatio=visitorFeatureBiz.SexRatio((Integer)Scopes.getSessionMap().get("BrancheId"));
		for (Map<Object, Double> map : SexRatio) {
			total= map.get("a");
			q= map.get("b");
			qq= map.get("c");
		}
		String boy=df.format(q/total*100);
		String girl=df.format(qq/total*100);
		Map map=new HashedMap();
		map.put("boy",boy);
		map.put("girl", girl);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(map);
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
		
	}
	
	//当日访客量
		public void newDay(){
			Date date=new Date();
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
			String time=dateFormat.format(date);
			String year= time.substring(0, time.indexOf("/")).toString();
			List<Map<Object, Integer>> ss=visitorFeatureBiz.newDay(year,(Integer)Scopes.getSessionMap().get("BrancheId"));
			Map<Object, Integer> Chart=new HashedMap();
			for (Map<Object, Integer> map : ss) {
			  Chart.put("y",map.get("yl"));
			  Chart.put("e", map.get("el"));
			  Chart.put("sa", map.get("sal"));
			  Chart.put("si", map.get("sil"));
			  Chart.put("w", map.get("wl"));
			  Chart.put("l", map.get("ll"));
			  Chart.put("q", map.get("ql"));
			  Chart.put("b", map.get("bl"));
			  Chart.put("j", map.get("jl"));
			  Chart.put("n", map.get("nl"));
			  Chart.put("yy", map.get("yyl"));
			  Chart.put("ee", map.get("eel"));
			  Chart.put("saa", map.get("saal"));
			  Chart.put("sii", map.get("siil"));
			  Chart.put("ww", map.get("wwl"));
			  Chart.put("ll", map.get("lll"));
			  Chart.put("qq", map.get("qql"));
			  Chart.put("bb", map.get("bbl"));
			  Chart.put("jj", map.get("jjl"));
			  Chart.put("en", map.get("enl"));
			  Chart.put("ey", map.get("eyl"));
			  Chart.put("eee", map.get("eeel"));
			  Chart.put("esa", map.get("esal"));
			  Chart.put("esi", map.get("esil"));
			  
			  Chart.put("yn",map.get("yn"));
			  Chart.put("en", map.get("en"));
			  Chart.put("san", map.get("san"));
			  Chart.put("sin", map.get("sin"));
			  Chart.put("wn", map.get("wn"));
			  Chart.put("ln", map.get("ln"));
			  Chart.put("qn", map.get("qn"));
			  Chart.put("bn", map.get("bn"));
			  Chart.put("jn", map.get("jn"));
			  Chart.put("nn", map.get("nn"));
			  Chart.put("yyn", map.get("yyn"));
			  Chart.put("een", map.get("een"));
			  Chart.put("saan", map.get("saan"));
			  Chart.put("siin", map.get("siin"));
			  Chart.put("wwn", map.get("wwn"));
			  Chart.put("lln", map.get("lln"));
			  Chart.put("qqn", map.get("qqn"));
			  Chart.put("bbn", map.get("bbn"));
			  Chart.put("jjn", map.get("jjn"));
			  Chart.put("enn", map.get("enn"));
			  Chart.put("eyn", map.get("eyn"));
			  Chart.put("eeen", map.get("eeen"));
			  Chart.put("esan", map.get("esan"));
			  Chart.put("esin", map.get("esin"));
			  
			  
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				String json = mapper.writeValueAsString(Chart);
				ResponseUtil.write(json);
				System.out.println("时间段："+json);
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
	
		
		//跳转路径
		public String address() {
			return "address";
		}
		
		//查询前七天的访客数据
		public void WeeklyData() {
			List<Map<String, Integer>> ss=visitorFeatureBiz.WeeklyData((Integer)Scopes.getSessionMap().get("BrancheId"));
			Map<String, Integer> WeeklyData=new HashedMap();
			for (Map<String, Integer> map : ss) {
				WeeklyData.put("aa", map.get("aa"));
				WeeklyData.put("a", map.get("a"));
				WeeklyData.put("b", map.get("b"));
				WeeklyData.put("c", map.get("c"));
				WeeklyData.put("d", map.get("d"));
				WeeklyData.put("e", map.get("e"));
				WeeklyData.put("f", map.get("f"));
				WeeklyData.put("g", map.get("g"));
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				String json = mapper.writeValueAsString(WeeklyData);
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
		}
		
		//年龄比例图
		
		public void AgeRatio() {
			List<Map<String, Double>> ss=visitorFeatureBiz.AgeRatio((Integer)Scopes.getSessionMap().get("BrancheId"));
			Map<String, Object> AgeRatio=new HashedMap();
			DecimalFormat df = new DecimalFormat("#");
			for (Map<String, Double> map : ss) {
				//总数
				AgeRatio.put("aa", map.get("aa"));
				//人数
				AgeRatio.put("a", map.get("a"));
				AgeRatio.put("b", map.get("b"));
				AgeRatio.put("c", map.get("c"));
				AgeRatio.put("d", map.get("d"));
				AgeRatio.put("e", map.get("e"));
				//比例
				AgeRatio.put("ae", df.format(map.get("a")/map.get("aa")*100));
				AgeRatio.put("be", df.format(map.get("b")/map.get("aa")*100));
				AgeRatio.put("ce", df.format(map.get("c")/map.get("aa")*100));
				AgeRatio.put("de", df.format(map.get("d")/map.get("aa")*100));
				AgeRatio.put("ee", df.format(map.get("e")/map.get("aa")*100));
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				String json = mapper.writeValueAsString(AgeRatio);
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
		}
		
		
		public static void main(String[] args) {
			String path="C:/CrmSystemFile/1.png";
			File file=new File(path.replaceAll("\\\\", "/"));
			file.delete();//执行删除
			System.out.println("删除成功");
			
//			Date date=new Date();
//			SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			System.out.println(ss.format(date));
			
//			if(file.exists()) {
//				file.delete();
//				System.out.println("删除成功");
//			}
		}
}
