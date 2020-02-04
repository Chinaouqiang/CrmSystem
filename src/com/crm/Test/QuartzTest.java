package com.crm.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.crm.biz.MonitorBiz;
import com.crm.dao.MonitorDao;

@Service
public class QuartzTest {
		
		private MonitorBiz monitorBiz;
		
	 	public void setMonitorBiz(MonitorBiz monitorBiz) {
			this.monitorBiz = monitorBiz;
		}
	 	
	 	
		@Scheduled(cron = "0 0/1 * * * ? ")
	    public void run() throws Exception {
			System.out.println("Quartz");
	    }
		
	public static void main(String[] args) {
		int[] a= {1,2,3,4,2,4,22,23,34,5,1,2,3,41,5,6,3,1,3};
		Set sets=new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			sets.add(a[i]);
		}
		System.out.println(sets);
	}
		
		
}
