package com.crm.dao;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.info.HrEmployee;


public class TeacherTest {
	private static SessionFactory sf = null;
	@BeforeClass
	public static void beforeClass(){
		// 读取配置文件
		Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
		// 得到session工厂
		sf = cfg.configure().buildSessionFactory();
	}
	@Test
	public void test() {
		
		

		// 得到session
		Session session = sf.openSession();
		// 开启事务
		session.beginTransaction();
		// session执行save
		HrEmployee s=(HrEmployee) session.load(HrEmployee.class, 1);
		System.out.println("萨达1："+s);
		HrEmployee ss=(HrEmployee) session.load(HrEmployee.class, 1);
		System.out.println("萨达2："+ss);
		// 事务提交
		session.getTransaction().commit();
		// 关闭session
		session.close();
	}
	@AfterClass
	public static void afterClass(){
		// 关闭session工厂
		sf.close();
	}
}

