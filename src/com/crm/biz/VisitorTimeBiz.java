package com.crm.biz;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.crm.dao.VisitorTimeDao;
import com.crm.info.Visitortime;

@Service
public class VisitorTimeBiz {
	
	private  VisitorTimeDao visitorTimeDao;
	private  Visitortime visitortime;
	public VisitorTimeDao getVisitorTimeDao() {
		return visitorTimeDao;
	}
	public void setVisitorTimeDao(VisitorTimeDao visitorTimeDao) {
		this.visitorTimeDao = visitorTimeDao;
	}
	public Visitortime getVisitortime() {
		return visitortime;
	}
	public void setVisitortime(Visitortime visitortime) {
		this.visitortime = visitortime;
	}
	
	
	public void add() throws Exception {
		visitortime=new Visitortime();
		  visitortime.setGotime(new Timestamp(new Date().getTime()));
		  visitortime.setCometime(new Timestamp(new Date().getTime()));
		  visitortime.setVisitortype("oqoqoq");
		  visitorTimeDao.save(visitortime);
	}

}
