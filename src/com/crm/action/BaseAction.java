package com.crm.action;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

public class BaseAction implements Serializable,ServletRequestAware, ServletResponseAware{


	private static final long serialVersionUID = -7110462505161900879L;

	
	/**
	 * 为了传值使用
	 */
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected HttpSession session;
	protected ServletContext application;
	
	/**
	 * 为了配置跳转页面所用
	 */
	protected final static String SUCCESS="success";
	protected final static String FAIL="fail";
	protected final static String LIST="list";
	protected final static String ADD="add";
	protected final static String EDIT="edit";
	protected final static String DETALL="detail";
	protected final static String Img="img";
	
	
	/**
	 * 具体传值字段 	后端向jsp页面传值所用字段
	 */
	
	protected Object result;
	protected Object msg;
	protected int code;
	
	public Object getResult() {
		return result;
	}
	public Object getMsg() {
		return msg;
	}
	public int getCode() {
		return code;
	}
	
	
	
	
	public ServletContext getApplication() {
		return application;
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
		this.session=arg0.getSession();
		/* this.application=arg0.getServletContext(); */
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
	


}