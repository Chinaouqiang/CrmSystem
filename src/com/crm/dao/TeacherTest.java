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
		// ��ȡ�����ļ�
		Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
		// �õ�session����
		sf = cfg.configure().buildSessionFactory();
	}
	@Test
	public void test() {
		
		

		// �õ�session
		Session session = sf.openSession();
		// ��������
		session.beginTransaction();
		// sessionִ��save
		HrEmployee s=(HrEmployee) session.load(HrEmployee.class, 1);
		System.out.println("����1��"+s);
		HrEmployee ss=(HrEmployee) session.load(HrEmployee.class, 1);
		System.out.println("����2��"+ss);
		// �����ύ
		session.getTransaction().commit();
		// �ر�session
		session.close();
	}
	@AfterClass
	public static void afterClass(){
		// �ر�session����
		sf.close();
	}
}

