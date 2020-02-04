package com.crm.action;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.crm.biz.CheckWorkBiz;
import com.crm.biz.DeviceBiz;
import com.crm.biz.HrEmployeeBiz;
import com.crm.info.CheckWork;
import com.crm.tools.ExcelUtils;
import com.crm.tools.ResponseUtil;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Transactional
@Controller
public class CheckWorkAction extends ActionSupport {
	private CheckWorkBiz checkWorkBiz;
	private HrEmployeeBiz hrEmployeeBiz;
	private CheckWork  checkWork;
	private DeviceBiz deviceBiz;

	
	public void setDeviceBiz(DeviceBiz deviceBiz) {
		this.deviceBiz = deviceBiz;
	}
	private List<CheckWork> ExcelCheckWork=new ArrayList<CheckWork>();
	public List<CheckWork> getExcelCheckWork() {
		return ExcelCheckWork;
	}
	public void setExcelCheckWork(List<CheckWork> excelCheckWork) {
		ExcelCheckWork = excelCheckWork;
	}
	private Integer idd;
	
	private List<CheckWork> Excel;
	
	public void setExcel(List<CheckWork> excel) {
		Excel = excel;
	}
	public void setIdd(Integer idd) {
		this.idd = idd;
	}
	public CheckWork getCheckWork() {
		return checkWork;
	}
	public void setCheckWork(CheckWork checkWork) {
		this.checkWork = checkWork;
	}
	public void setCheckWorkBiz(CheckWorkBiz checkWorkBiz) {
		this.checkWorkBiz = checkWorkBiz;
	}
	public void setHrEmployeeBiz(HrEmployeeBiz hrEmployeeBiz) {
		this.hrEmployeeBiz = hrEmployeeBiz;
	}

	private String Name,Path;
	
	public void setName(String name) {
		Name = name;
	}
	public void setPath(String path) {
		Path = path;
	}
	
	Date date=new Date();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
	String time=dateFormat.format(date);
	String year= time.substring(0, time.indexOf("/")).toString();
	//����
	public void addCheckWork() throws ParseException{
		Map<String, Object> Mixture=null;
		String Time=time.substring(year.length()+1,time.length()).toString();
		DateFormat formart = new SimpleDateFormat("HH:mm:ss");
		Date compare1=formart.parse(Time);
		Date M1=formart.parse("00:00:00");
		Date M2=formart.parse("05:59:59");
		if (compare1.compareTo(M1)>0&&compare1.compareTo(M2)<=0) {
			System.out.println("δ��ǩ��ʱ��");
		}
		else {
			checkWork=new CheckWork();
			Mixture=new HashedMap();
			Integer dep_id = null,BranchShop_Id = null,hr_id=null,check_id=null;
			String m_work= null,m_offwork= null,a_work = null,a_offwork= null,isLate=null;
			Map<String, Object> map2=new HashedMap();
			List<Map<String, Object>> hr=hrEmployeeBiz.findCheck(Name,Path);
			for (Map<String, Object> map : hr) {
				map2=map;
			}
			if (map2==null) {
				Mixture.put("Scan", "δɨ�赽���ˣ������³���");
			}else {
				for (Map<String, Object> map : hr) {
					hr_id=(Integer)map.get("id");
					dep_id=(Integer)map.get("dep_id");
					BranchShop_Id=(Integer)map.get("BranchShop_Id");
				}
				List<CheckWork> CheckWorkList=checkWorkBiz.findcheck(year, Name, dep_id, hr_id);
				//�ܽӴ򿨷�Χ
				
				//����򿨷�Χ
				Date MorningHead=formart.parse("06:00:00");
				Date Morninglend=formart.parse("09:00:59");
				//����򿨳ٵ���Χ
				Date MorningHeadHead=formart.parse("09:01:00");
				Date MorningLendLete=formart.parse("12:00:00");
				
				//��������˷�Χ
				Date AfternoonHead=formart.parse("13:00:00");
				Date Afternoonlend=formart.parse("17:59:59");
				
				//����򿨷�Χ
				Date AfternoonlendLete=formart.parse("18:00:00");
				Date AfternoonHeadLete=formart.parse("23:59:58");
				//����
				if (CheckWorkList.size()<=0) {
					System.out.println("������������");
					checkWork.setHr_id(hr_id);
					checkWork.setHr_Name(Name);
					checkWork.setBranch_id(BranchShop_Id);
					checkWork.setDep_id(dep_id);
					checkWork.setCheck_Time(year);
					checkWork.setIswork_State("����");
					checkWork.setIsLeave("δ���"); //Ĭ��Ϊ0(0 ��ʾ�ٵ���1��ʾΪ������2Ϊ����)
					checkWork.setCheck_remarks("");
					checkWorkBiz.addCheckWork(checkWork);
					List<CheckWork> CheckWorkList2=checkWorkBiz.findcheck(year, Name, dep_id, hr_id);
					for (CheckWork checkWork : CheckWorkList2) {
						check_id=checkWork.getId();
						a_work=checkWork.getA_work();
						a_offwork=checkWork.getA_offwork();
						m_work=checkWork.getM_work();
						m_offwork=checkWork.getM_offwork();
						System.out.println("����id:"+check_id);
					}
//					//�����ʱ��
					if(compare1.compareTo(MorningHead)>0&&compare1.compareTo(Morninglend)<=0) {
						if (a_work==null&&a_offwork==null&&m_work==null&&m_offwork==null) {
							checkWorkBiz.updateWork("m_work",Time,check_id);
							System.out.println("����ã�ǩ���ɹ�");
							Mixture.put("Scan", "����ã�ǩ���ɹ�");
						}
					}else if(compare1.compareTo(MorningHeadHead)>0&&compare1.compareTo(MorningLendLete)<=0) {
						if (a_work==null&&a_offwork==null&&m_work==null&&m_offwork==null) {
							checkWorkBiz.updateWork2("m_work", Time, "isLate", "�ٵ�", check_id);
							System.out.println("����ã����ٵ���");
							Mixture.put("Scan", "����ã����ٵ���");
						}
					}
					else if (compare1.compareTo(AfternoonHead)>0&&compare1.compareTo(Afternoonlend)<=0) {
						if (a_work==null&&a_offwork==null&&m_work==null&&m_offwork==null) {
							checkWorkBiz.updateWork2("a_work", Time, "isLate", "�ٵ�", check_id);
							System.out.println("����ã����ٵ���");
							Mixture.put("Scan", "����ã����ٵ���");
						}
					}
					else if (compare1.compareTo(AfternoonlendLete)>0&&compare1.compareTo(AfternoonHeadLete)<=0) {
						if (a_work==null&&a_offwork==null&&m_work==null&&m_offwork==null) {
							checkWorkBiz.updateWork2("a_offwork", Time, "isAbsenteeism", "����", check_id);
							System.out.println("����");
							Mixture.put("Scan", "����");
						}
					}
				}
				else {
					List<CheckWork> CheckWorkList2=checkWorkBiz.findcheck(year, Name, dep_id, hr_id);
					for (CheckWork checkWork : CheckWorkList2) {
						check_id=checkWork.getId();
						a_work=checkWork.getA_work();
						a_offwork=checkWork.getA_offwork();
						m_work=checkWork.getM_work();
						m_offwork=checkWork.getM_offwork();
						System.out.println("����id:"+check_id);
					}
					System.out.println("�޸Ŀ�������");
					if(compare1.compareTo(MorningHeadHead)>0&&compare1.compareTo(MorningLendLete)<=0) {
						if (m_work!="") {
							checkWorkBiz.updateWork2("m_offwork", Time, "isLateEarly", "����", check_id);
							System.out.println("����");
							Mixture.put("Scan", "����");
						}
						
					}
					else if (compare1.compareTo(AfternoonHead)>0&&compare1.compareTo(Afternoonlend)<=0) {
						if (a_work!=""||a_offwork!=""||a_work!="") {
							checkWorkBiz.updateWork2("a_offwork", Time, "isLateEarly", "����", check_id);
							System.out.println("����");
							Mixture.put("Scan", "����");
						}
					}
					else if (compare1.compareTo(AfternoonlendLete)>0&&compare1.compareTo(AfternoonHeadLete)<=0) {
						if (a_work!=""||a_offwork!=""||m_work!="") {
							checkWorkBiz.updateWork("a_offwork",Time,check_id);
							System.out.println("ǩ���ɹ�");
							Mixture.put("Scan", "ǩ���ɹ�");
						}
					}
				}
			}
			
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
		
	}	
	
	//ɾ��
	public String deleteCheck() {
		checkWorkBiz.deleteCheckWork(idd);
		int id=BrancheId();
		List<CheckWork> findList=checkWorkBiz.findList(year,id);
		Scopes.getRequestMap().put("findList", findList);
		return "Manage";
	}
	//�û��ֵ�id
	public Integer BrancheId() {
		String uid=(String) Scopes.getSessionMap().get("loginName");
		String pwd=(String) Scopes.getSessionMap().get("loginPwd");
		Integer ss=deviceBiz.BrancheId(uid, pwd);
		return ss;
	}
	
	//����ʱ��չʾ����
	public String findList() {
		int id=BrancheId();
		ExcelCheckWork=checkWorkBiz.findList(year,id);
		Scopes.getRequestMap().put("findList", ExcelCheckWork);
		Scopes.getSessionMap().put("Exce", ExcelCheckWork);
		return "Manage";
	}
	
	//����ʱ��չʾ����
		public String findList2() {
			String TimeHead=checkWork.getCheck_Time();
			String Timelend=checkWork.getIsLeave();
			ExcelCheckWork=checkWorkBiz.findList2(TimeHead,Timelend);
			Scopes.getRequestMap().put("findList", ExcelCheckWork);
			Scopes.getSessionMap().put("Exce", ExcelCheckWork);
			return "Manage";
		}
		
		
	
		 public void exportGWDataManageList(){
			 HttpServletResponse response=ServletActionContext.getResponse();
		        try{
		            List<CheckWork> voList = new ArrayList<CheckWork>();
		            CheckWork vo = new CheckWork();
		            List<CheckWork> checkWork =(List<CheckWork>) Scopes.getSessionMap().get("Exce");
		           // System.out.println(checkWork);
		            for (CheckWork checkWork2 : checkWork) {
						vo.setHr_id(checkWork2.getHr_id());
						vo.setHr_Name(checkWork2.getHr_Name());
						vo.setDep_id(checkWork2.getDep_id());
						vo.setCheck_Time(checkWork2.getCheck_Time());
						vo.setM_work(checkWork2.getM_work());
						vo.setM_offwork(checkWork2.getM_offwork());
						vo.setA_work(checkWork2.getA_work());
						vo.setA_offwork(checkWork2.getA_offwork());
						vo.setIswork_State(checkWork2.getIswork_State());
						vo.setIsLate(checkWork2.getIsLate());
						vo.setIsLateEarly(checkWork2.getIsLateEarly());
						vo.setIsAbsenteeism(checkWork2.getIsAbsenteeism());
						vo.setIsLeave(checkWork2.getIsLeave());
						vo.setCheck_remarks(checkWork2.getCheck_remarks());
						voList.add(vo);
					}
		            String[] headerName = { "Ա����","Ա������", "����", "����","�����ϰ�ʱ��","�����°�ʱ��", "�����ϰ�ʱ��", "�����ϰ�ʱ��","�ϰ�״��","�Ƿ�ٵ�","�Ƿ�����","�Ƿ����","�Ƿ����","��ע"};
		            String[] headerKey = { "hr_id","hr_Name", "dep_id", "check_Time","m_work","m_offwork","a_work", "a_offwork", "iswork_State","isLate","isLateEarly","isAbsenteeism","isLeave","Check_remarks"};
		            HSSFWorkbook wb = ExcelUtils.createExcel(headerName, headerKey, "�����ݹ���", voList);
		            if (wb == null) {
		                return;
		            }
		            response.setContentType("application/vnd.ms-excel");
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		            Date date = new Date();
		            String str = sdf.format(date);
		            String fileName = "���ڱ�" + str;
		            response.setHeader("Content-disposition",
		                    "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO-8859-1") + ".xls");
		            OutputStream ouputStream = response.getOutputStream();
		            ouputStream.flush();
		            wb.write(ouputStream);
		            ouputStream.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
}
	

