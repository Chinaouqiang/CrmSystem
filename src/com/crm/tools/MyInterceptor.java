package com.crm.tools;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.crm.info.HrEmployee;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@Component //让Spring可以扫描到并初始化
public class MyInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map session=invocation.getInvocationContext().getSession();
		HrEmployee employee=(HrEmployee) session.get("emp");
		if (employee==null) {
			return Action.ERROR;
		}
		return invocation.invoke();
	}
	

}
