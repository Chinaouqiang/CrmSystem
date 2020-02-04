package com.crm.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
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

import com.crm.biz.PublicAdvertBiz;
import com.crm.info.PublicAdvert;
import com.crm.tools.ResponseUtil;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class PublicAdvertAction extends ActionSupport {
	private static final long serialVersionUID = -6743567631108323096L;
	
	private PublicAdvertBiz publicAdvertBiz;
	
	private BaseAction baseAction;

	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private PublicAdvert publicAdvert;
	
	private String serviceDir="/upload/Advert";
  
	private Integer id;
	private String Path;
	
	public void setPath(String path) {
		Path = path;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setBaseAction(BaseAction baseAction) {
		this.baseAction = baseAction;
	}
	public void setPublicAdvert(PublicAdvert publicAdvert) {
		this.publicAdvert = publicAdvert;
	}
	public PublicAdvert getPublicAdvert() {
		return publicAdvert;
	}

	public void setPublicAdvertBiz(PublicAdvertBiz publicAdvertBiz) {
		this.publicAdvertBiz = publicAdvertBiz;
	}
		
	//struts2页面提交VO后台实体类要有set/get方法，否则提交的数据只有一个值
	
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
	
	//标题提示广告
	public String addHeadAdvert() {
		String Only=publicAdvert.getDevice_only();
		publicAdvert.setCreate_Time(new Timestamp(new Date().getTime()));
		publicAdvert.setAd_ScreenState(0);
		publicAdvert.setAd_State(-1);
		publicAdvertBiz.addAdvert(publicAdvert); 
	    List<PublicAdvert> findAllAdvertOnly= publicAdvertBiz.AdvertManageHead(Only);
	    Scopes.getRequestMap().put("AdvertManageHead", findAllAdvertOnly);
	    Scopes.getRequestMap().put("Only", Only);
	    return "AdvertManageHead";
	}
	//广告图片增加
	public String addPicAdvert() throws ServletException, IOException{
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
			String Only=publicAdvert.getDevice_only();
			String qq="C:/"+"CrmSystemFile/";
			String qq2="upload" + java.io.File.separator + "Advert"+java.io.File.separator+"Picture"+java.io.File.separator+Only+java.io.File.separator + year + "_" + month + "_" + day;
			String facepicpath =qq+qq2;
			File file=new File(facepicpath);
			file.mkdirs();
			String realPath=facepicpath+ java.io.File.separator +uploadFileName;
			try {
				FileUtils.copyFile(upload, new File(realPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String path="http://guanli.zigetech.com:8080/file"+java.io.File.separator+qq2+java.io.File.separator +uploadFileName ;
			publicAdvert.setOtherState(1);
			publicAdvert.setAd_ScreenState(0);
			publicAdvert.setAd_State(0);
			publicAdvert.setAd_PicTure(path.replaceAll("\\\\", "/"));
			publicAdvertBiz.addAdvert(publicAdvert); 
			 List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyPic(Only);
			 Scopes.getRequestMap().put("ListPic", findAllAdvertOnly);
			 Scopes.getRequestMap().put("Only", Only);
			return "AdvertManagePic";
	}
	
	
	//广告视频增加
		public String addVidoAdvert(){
			//文件上传
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
			String Only=publicAdvert.getDevice_only();
			String qq="C:/CrmSystemFile/";
			String qq2="upload" + java.io.File.separator + "Advert" +java.io.File.separator+"Vido"+ java.io.File.separator+Only+java.io.File.separator + year + "_" + month + "_" + day;
			String facepicpath =qq+qq2;
			File file=new File(facepicpath);
			file.mkdirs();
			String realPath=facepicpath+ java.io.File.separator +uploadFileName;
			try {
				FileUtils.copyFile(upload, new File(realPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String path="http://guanli.zigetech.com:8080/file"+java.io.File.separator+qq2+java.io.File.separator +uploadFileName ;
			
			publicAdvert.setOtherState(1);
			publicAdvert.setAd_Vido(path.replaceAll("\\\\", "/"));
			publicAdvert.setAd_ScreenState(0);
			publicAdvert.setAd_State(0);
			publicAdvertBiz.addAdvert(publicAdvert); 
			 List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyVido(Only);
			 Scopes.getRequestMap().put("AdvertManage", findAllAdvertOnly);
			 Scopes.getRequestMap().put("Only", Only);
			return "AdvertManage";
		}
		
		
		
		//竖屏广告增加
		public String addVidoAdvertvertical(){
			//文件上传
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
			String facepicpath ="C:/"+"CrmSystemFile"+ java.io.File.separator+ "upload" + java.io.File.separator + "Advert" +java.io.File.separator+"Vido"+ java.io.File.separator + year + "_" + month + "_" + day;
			File file=new File(facepicpath);
			file.mkdirs();
			String realPath=facepicpath+ java.io.File.separator +uploadFileName;
			try {
				FileUtils.copyFile(upload, new File(realPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String str1=realPath.substring(0, realPath.indexOf("CrmSystem"));
			String str2=realPath.substring(str1.length(),realPath.length());
			String path="http://47.103.61.124:8080"+java.io.File.separator+str2 ;
			publicAdvert.setAd_Vido(path.replaceAll("\\\\", "/"));
			publicAdvert.setAd_ScreenState(1);
			publicAdvert.setAd_State(0);
			publicAdvertBiz.addAdvert(publicAdvert); 
			return "addVido";
		}
	//广告图片类型删除
	public String deleteAdvertPic() {
		String Only=publicAdvert.getDevice_only();
		publicAdvertBiz.deleteAdvert(id); 
		List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyPic(Only);
		Scopes.getRequestMap().put("ListPic", findAllAdvertOnly);
		Scopes.getRequestMap().put("Only", Only);
		return "AdvertManagePic";
	}
	
	//广告视频类型删除
		public String deleteAdvertVido() {
			String Only=publicAdvert.getDevice_only();
			publicAdvertBiz.deleteAdvert(id); 
			List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyVido(Only);
			Scopes.getRequestMap().put("AdvertManage", findAllAdvertOnly);
			Scopes.getRequestMap().put("Only", Only);
			return "AdvertManage";
		}
		
		//广告视频类型删除
		public String deleteAdvertHead() {
			String Only=publicAdvert.getDevice_only();
			publicAdvertBiz.deleteAdvert(id); 
			List<PublicAdvert> findAllAdvertOnly= publicAdvertBiz.AdvertManageHead(Only);
			Scopes.getRequestMap().put("AdvertManageHead", findAllAdvertOnly);
			Scopes.getRequestMap().put("Only", Only);
			return "AdvertManageHead";
		}
	//查找所以后台广告信息
	  public String findAllAdvertVido() { 
		  	List<PublicAdvert> list=publicAdvertBiz.findAllAdvertVido();
			Scopes.getRequestMap().put("listdata", list);
		  return SUCCESS;
	  }
	  
	//查找所以后台广告信息
	  public String findAllAdvertPic() { 
		  	List<PublicAdvert> list=publicAdvertBiz.findAllAdvertPic();
			Scopes.getRequestMap().put("listdata", list);
		  return "pic";
	  }
	  
	//查找单个信息
	  public String findOneAdvertPic() {
		  PublicAdvert ad=publicAdvertBiz.findOneAdvert(id);
		  Scopes.getRequestMap().put("listOnead", ad);
		  return "updatePic";
	  }
	  
	//查找单个信息
	  public String findOneAdvertVido() {
		  PublicAdvert ad=publicAdvertBiz.findOneAdvert(id);
		  Scopes.getRequestMap().put("listOnead", ad);
		  return "updateVido";
	  }
	  
	//查找单个信息
	  public String findOneAdvertHead() {
		  PublicAdvert ad=publicAdvertBiz.findOneAdvert(id);
		  Scopes.getRequestMap().put("listOnead", ad);
		  return "updateHead";
	  }

   //修改广告图片信息
	  public String updateAdvertPic() {
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
			String Only=publicAdvert.getDevice_only();
			String qq="C:/"+"CrmSystemFile/";
			String qq2="upload" + java.io.File.separator + "Advert"+java.io.File.separator+"Picture"+java.io.File.separator+Only+java.io.File.separator + year + "_" + month + "_" + day;
			String facepicpath =qq+qq2;
			File file=new File(facepicpath);
			file.mkdirs();
			String realPath=facepicpath+ java.io.File.separator +uploadFileName;
			try {
				FileUtils.copyFile(upload, new File(realPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String path="http://guanli.zigetech.com:8080/file"+java.io.File.separator+qq2+java.io.File.separator +uploadFileName ;
			publicAdvert.setOtherState(1);
			publicAdvert.setAd_PicTure(path.replaceAll("\\\\", "/"));
			publicAdvertBiz.updateAdvert(publicAdvert);
			List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyPic(Only);
			Scopes.getRequestMap().put("ListPic", findAllAdvertOnly);
			Scopes.getRequestMap().put("Only", Only);
			return "AdvertManagePic";
	  }
	  
	  //修改广告视频信息
	  public String updateAdvertVido() {
		//文件上传
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
			String Only=publicAdvert.getDevice_only();
			String qq="C:/CrmSystemFile/";
			String qq2="upload" + java.io.File.separator + "Advert" +java.io.File.separator+"Vido"+ java.io.File.separator+Only+java.io.File.separator + year + "_" + month + "_" + day;
			String facepicpath =qq+qq2;
			File file=new File(facepicpath);
			file.mkdirs();
			String realPath=facepicpath+ java.io.File.separator +uploadFileName;
			try {
				FileUtils.copyFile(upload, new File(realPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String path="http://guanli.zigetech.com:8080/file"+java.io.File.separator+qq2+java.io.File.separator +uploadFileName ;
			publicAdvert.setOtherState(1);
			publicAdvert.setAd_Vido(path.replaceAll("\\\\", "/"));
			publicAdvertBiz.updateAdvert(publicAdvert);
			List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyVido(Only);
			Scopes.getRequestMap().put("AdvertManage", findAllAdvertOnly);
			Scopes.getRequestMap().put("Only", Only);
			return "AdvertManage";
	  }
	 
//	修改广告图片状态
	  public String updateAdvertPicState() {
		  int Ad_State=publicAdvert.getAd_State();
		  int Ad_Id=publicAdvert.getAd_Id();
		  String Only=publicAdvert.getDevice_only();
		  publicAdvertBiz.updatePublicAdvertSate(Ad_State, Ad_Id);
		  List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyPic(Only);
		  Scopes.getRequestMap().put("ListPic", findAllAdvertOnly);
		  Scopes.getRequestMap().put("Only", Only);
		  return "AdvertManagePic";
	  }
	  
	  public void updateAdvertPicState2() {
		  String Only=publicAdvert.getDevice_only();
		  String d=Path.substring(0, Path.lastIndexOf("."));
		  String p= Path.substring(d.length(), Path.length());
		  Map<String, Integer> checking=new HashedMap();
		  Integer ss;
		  if(p.equals(".bmp")||p.equals(".png")||p.equals(".gif")||p.equals(".jpg")||p.equals(".jpeg")){ 
			  ss= publicAdvertBiz.updatePublicAdvertSate2(Only,"Ad_PicTure",Path);
		  }else {
			  ss=publicAdvertBiz.updatePublicAdvertSate2(Only,"Ad_Vido",Path);
			}
		  checking.put("number", ss);
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
	  }
//	修改广告视频状态
	
	  public String updateAdvertVidoState() {
		  int Ad_State=publicAdvert.getAd_State();
		  int Ad_Id=publicAdvert.getAd_Id();
		  publicAdvertBiz.updatePublicAdvertSate(Ad_State, Ad_Id);
		  String Only=publicAdvert.getDevice_only();
		  List<PublicAdvert> findAllAdvertOnly=publicAdvertBiz.findAllAdvertOnlyVido(Only);
		  Scopes.getRequestMap().put("AdvertManage", findAllAdvertOnly);
		  Scopes.getRequestMap().put("Only", Only);
		  return "AdvertManage";
	  }
	
	  //根据序列号查找相对于的图文广告
	  public String findAllAdvertOnlyPic() {
		  String Only=publicAdvert.getDevice_only();
		  List<PublicAdvert> ListPic=publicAdvertBiz.findAllAdvertOnlyPic(Only);
		  Scopes.getRequestMap().put("ListPic", ListPic);
		  Scopes.getRequestMap().put("Only", Only);
		  return "AdvertManagePic";
	  }
	  
	  //跳转界面
	  public String jspPic() {
		  String Only=publicAdvert.getDevice_only();
		  Scopes.getRequestMap().put("OnlyPic", Only);
		  return "jspPic";
	  }
	  //跳转界面
	  public String jspVido() {
		  String Only=publicAdvert.getDevice_only();
		  Scopes.getRequestMap().put("OnlyVido", Only);
		  return "jspVido";
	  }
	  //跳转界面
	  public String jspHead() {
		  String Only=publicAdvert.getDevice_only();
		  Scopes.getRequestMap().put("OnlyHead", Only);
		  return "jspHead";
	  }
	  
	//通过序列号查找相对于所有可用广告(标题提示广告)
	  public String AdvertManageHead() {
		  String Only=publicAdvert.getDevice_only();
		  List<PublicAdvert> findAllAdvertOnly= publicAdvertBiz.AdvertManageHead(Only);
		  Scopes.getRequestMap().put("AdvertManageHead", findAllAdvertOnly);
		  Scopes.getRequestMap().put("Only", Only);
		  return "AdvertManageHead";
	  }
	  
	  //广告信息
	  public String updateAdvertHead() {
		  String Only=publicAdvert.getDevice_only();
		  publicAdvertBiz.updateAdvert(publicAdvert);
		  List<PublicAdvert> findAllAdvertOnly= publicAdvertBiz.AdvertManageHead(Only);
		  Scopes.getRequestMap().put("AdvertManageHead", findAllAdvertOnly);
		  Scopes.getRequestMap().put("Only", Only);
		  return "AdvertManageHead";
	  }
	  
	
}
