package com.crm.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.info.Visitorfeature;
import com.haha.hibernate.HibernateDao;

@Transactional
@Repository
public class VisitorFeatureDao extends HibernateDao<Visitorfeature, Integer> {

	private static final List Object = null;

	//查询符合的访客记录
	public List<Visitorfeature> findList(Integer BranchId){
		String sql="SELECT *from visitorfeature where device_only in(SELECT b.Device_Only FROM hr_employee a,device b where a.BranchShop_Id=b.BranchShop_Id and a.BranchShop_Id='"+BranchId+"')";
		List<Visitorfeature> visitor=getSession().createSQLQuery(sql).addEntity(Visitorfeature.class).list();
		return visitor;
	}
	
	//访客男女比例
	public List<Map<Object, Double>> SexRatio(Integer BranchId){
		String sql="SELECT count(*) as a ,sum(case when sex=1 then 1 else 0 end ) as b ,sum(case when sex=0 then 1 else 0 end ) as c from visitorfeature where device_only in(SELECT b.Device_Only FROM hr_employee a,device b where a.BranchShop_Id=b.BranchShop_Id  and a.BranchShop_Id='"+BranchId+"')";
		Query query =getSession().createSQLQuery(sql).addScalar( "a" , Hibernate.DOUBLE).addScalar( "b" , Hibernate.DOUBLE).addScalar("c", Hibernate.DOUBLE).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<Object, Double>> ss=query.list();
		return ss;
	}
	
	//时间段访客量
	public List<Map<Object, Integer>> newDay(String date,Integer BranchId){
		String sql="SELECT  SUM(case when buildtime LIKE '% 01%' and sex=0  then 1 else 0 end) as yl, SUM(case when buildtime LIKE '% 01%' and sex=1  then 1 else 0 end) as yn,SUM(case when buildtime LIKE '% 02%' and sex=0  then 1 else 0 end) as el,SUM(case when buildtime LIKE '% 03%' and sex=0 then 1 else 0 end) as sal, SUM(case when buildtime LIKE '% 04%' and sex=0 then 1 else 0 end) as sil, SUM(case when buildtime LIKE '% 05%' and sex=0 then 1 else 0 end) as wl, SUM(case when buildtime LIKE '% 06%' and sex=0 then 1 else 0 end) as ll,SUM(case when buildtime LIKE '% 07%' and sex=0 then 1 else 0 end) as ql,SUM(case when buildtime LIKE '% 08%' and sex=0 then 1 else 0 end) as bl,SUM(case when buildtime LIKE '% 09%' and sex=0 then 1 else 0 end) as jl, SUM(case when buildtime LIKE '% 10%' and sex=0 then 1 else 0 end) as nl, SUM(case when buildtime LIKE '% 11%' and sex=0 then 1 else 0 end) as yyl, SUM(case when buildtime LIKE '% 12%' and sex=0 then 1 else 0 end) as eel,SUM(case when buildtime LIKE '% 13%' and sex=0 then 1 else 0 end) as saal, SUM(case when buildtime LIKE '% 14%' and sex=0 then 1 else 0 end) as siil, SUM(case when buildtime LIKE '% 15%' and sex=0 then 1 else 0 end) as wwl, SUM(case when buildtime LIKE '% 16%' and sex=0 then 1 else 0 end) as lll, SUM(case when buildtime LIKE '% 17%' and sex=0 then 1 else 0 end) as qql,SUM(case when buildtime LIKE '% 18%' and sex=0 then 1 else 0 end) as bbl, SUM(case when buildtime LIKE '% 19%' and sex=0 then 1 else 0 end) as jjl, SUM(case when buildtime LIKE '% 20%' and sex=0 then 1 else 0 end) as enl,SUM(case when buildtime LIKE '% 21%' and sex=0 then 1 else 0 end) as eyl, SUM(case when buildtime LIKE '% 22%' and sex=0 then 1 else 0 end) as eeel, SUM(case when buildtime LIKE '% 23%' and sex=0 then 1 else 0 end) as esal,SUM(case when buildtime LIKE '% 00%' and sex=0 then 1 else 0 end) as esil, SUM(case when buildtime LIKE '% 02%' and sex=1  then 1 else 0 end) as en,SUM(case when buildtime LIKE '% 03%' and sex=1 then 1 else 0 end) as san, SUM(case when buildtime LIKE '% 04%' and sex=1 then 1 else 0 end) as sin,SUM(case when buildtime LIKE '% 05%' and sex=1 then 1 else 0 end) as wn, SUM(case when buildtime LIKE '% 06%' and sex=1 then 1 else 0 end) as ln, SUM(case when buildtime LIKE '% 07%' and sex=1 then 1 else 0 end) as qn,SUM(case when buildtime LIKE '% 08%' and sex=1 then 1 else 0 end) as bn, SUM(case when buildtime LIKE '% 09%' and sex=1 then 1 else 0 end) as jn, SUM(case when buildtime LIKE '% 10%' and sex=1 then 1 else 0 end) as nn, SUM(case when buildtime LIKE '% 11%' and sex=1 then 1 else 0 end) as yyn, SUM(case when buildtime LIKE '% 12%' and sex=1 then 1 else 0 end) as een, SUM(case when buildtime LIKE '% 13%' and sex=1 then 1 else 0 end) as saan, SUM(case when buildtime LIKE '% 14%' and sex=1 then 1 else 0 end) as siin, SUM(case when buildtime LIKE '% 15%' and sex=1 then 1 else 0 end) as wwn,SUM(case when buildtime LIKE '% 16%' and sex=1 then 1 else 0 end) as lln, SUM(case when buildtime LIKE '% 17%' and sex=1 then 1 else 0 end) as qqn, SUM(case when buildtime LIKE '% 18%' and sex=1 then 1 else 0 end) as bbn, SUM(case when buildtime LIKE '% 19%' and sex=1 then 1 else 0 end) as jjn, SUM(case when buildtime LIKE '% 20%' and sex=1 then 1 else 0 end) as enn, SUM(case when buildtime LIKE '% 21%' and sex=1 then 1 else 0 end) as eyn, SUM(case when buildtime LIKE '% 22%' and sex=1 then 1 else 0 end) as eeen, SUM(case when buildtime LIKE '% 23%' and sex=1 then 1 else 0 end) as esan, SUM(case when buildtime LIKE '% 00%' and sex=1 then 1 else 0 end) as esin FROM visitorfeature WHERE buildtime LIKE '"+date+"%' and device_only in(SELECT b.Device_Only FROM hr_employee a,device b where a.BranchShop_Id=b.BranchShop_Id and a.BranchShop_Id='"+BranchId+"')";
		Query query=getSession().createSQLQuery(sql).addScalar("yl", Hibernate.INTEGER).addScalar("el", Hibernate.INTEGER).addScalar("esil", Hibernate.INTEGER).addScalar("sal", Hibernate.INTEGER).addScalar("sil", Hibernate.INTEGER).addScalar("wl", Hibernate.INTEGER).addScalar("ll", Hibernate.INTEGER).addScalar("ql", Hibernate.INTEGER).addScalar("bl", Hibernate.INTEGER).addScalar("jl", Hibernate.INTEGER).addScalar("nl", Hibernate.INTEGER).addScalar("yyl", Hibernate.INTEGER).addScalar("eel", Hibernate.INTEGER).addScalar("saal", Hibernate.INTEGER).addScalar("siil", Hibernate.INTEGER).addScalar("wwl", Hibernate.INTEGER).addScalar("lll", Hibernate.INTEGER).addScalar("qql", Hibernate.INTEGER).addScalar("bbl", Hibernate.INTEGER).addScalar("jjl", Hibernate.INTEGER).addScalar("enl", Hibernate.INTEGER).addScalar("eyl", Hibernate.INTEGER).addScalar("eeel", Hibernate.INTEGER).addScalar("esil", Hibernate.INTEGER).addScalar("esal", Hibernate.INTEGER).addScalar("yn", Hibernate.INTEGER).addScalar("en", Hibernate.INTEGER).addScalar("esin", Hibernate.INTEGER).addScalar("san", Hibernate.INTEGER).addScalar("sin", Hibernate.INTEGER).addScalar("wn", Hibernate.INTEGER).addScalar("ln", Hibernate.INTEGER).addScalar("qn", Hibernate.INTEGER).addScalar("bn", Hibernate.INTEGER).addScalar("jn", Hibernate.INTEGER).addScalar("nn", Hibernate.INTEGER).addScalar("yyn", Hibernate.INTEGER).addScalar("een", Hibernate.INTEGER).addScalar("saan", Hibernate.INTEGER).addScalar("siin", Hibernate.INTEGER).addScalar("wwn", Hibernate.INTEGER).addScalar("lln", Hibernate.INTEGER).addScalar("qqn", Hibernate.INTEGER).addScalar("bbn", Hibernate.INTEGER).addScalar("jjn", Hibernate.INTEGER).addScalar("enn", Hibernate.INTEGER).addScalar("eyn", Hibernate.INTEGER).addScalar("eeen", Hibernate.INTEGER).addScalar("esin", Hibernate.INTEGER).addScalar("esan", Hibernate.INTEGER)  ;
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<Object, Integer>> newDay=query.list();
		return newDay;
	}
	
	//查询前七天的访客数据
	public List<Map<String, Integer>> WeeklyData(Integer BranchId){
		String sql="select COUNT(1) as aa, SUM(TO_DAYS( NOW( ) ) - TO_DAYS(buildtime ) = 7) as a,SUM(TO_DAYS( NOW( ) ) - TO_DAYS(buildtime ) = 6) as b,SUM(TO_DAYS( NOW( ) ) - TO_DAYS(buildtime ) = 5) as c,SUM(TO_DAYS( NOW( ) ) - TO_DAYS(buildtime ) = 4) as d,SUM(TO_DAYS( NOW( ) ) - TO_DAYS(buildtime ) = 3) as e,SUM(TO_DAYS( NOW( ) ) - TO_DAYS(buildtime ) = 2) as f,SUM(TO_DAYS( NOW( ) ) - TO_DAYS(buildtime ) = 1) as g from visitorfeature where device_only in(SELECT b.Device_Only FROM hr_employee a,device b where a.BranchShop_Id=b.BranchShop_Id  and a.BranchShop_Id="+BranchId+")";
		Query query=getSession().createSQLQuery(sql).addScalar("aa", Hibernate.INTEGER).addScalar("a", Hibernate.INTEGER).addScalar("b", Hibernate.INTEGER).addScalar("c", Hibernate.INTEGER).addScalar("d", Hibernate.INTEGER).addScalar("e", Hibernate.INTEGER).addScalar("f", Hibernate.INTEGER).addScalar("g", Hibernate.INTEGER);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Integer>> WeeklyData=query.list();
		return WeeklyData;
	}
	
	//年龄比例图
	public List<Map<String, Double>> AgeRatio(Integer BranchId){
		String sql="SELECT COUNT(1) as aa, SUM(CASE WHEN age BETWEEN 0 and 17 THEN 1 ELSE 0 END) a,SUM(CASE WHEN age BETWEEN 18 and 30 THEN 1 ELSE 0 END) b,SUM(CASE WHEN age BETWEEN 31 and 50 THEN 1 ELSE 0 END) c,SUM(CASE WHEN age BETWEEN 51 and 70 THEN 1 ELSE 0 END) d,SUM(CASE WHEN age BETWEEN 71 and 150 THEN 1 ELSE 0 END) e from visitorfeature where device_only in(SELECT b.Device_Only FROM hr_employee a,device b where a.BranchShop_Id=b.BranchShop_Id  and a.BranchShop_Id="+BranchId+")";
		Query query=getSession().createSQLQuery(sql).addScalar("aa", Hibernate.DOUBLE).addScalar("a", Hibernate.DOUBLE).addScalar("b", Hibernate.DOUBLE).addScalar("c", Hibernate.DOUBLE).addScalar("d", Hibernate.DOUBLE).addScalar("e", Hibernate.DOUBLE);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
		
	}
	

}
