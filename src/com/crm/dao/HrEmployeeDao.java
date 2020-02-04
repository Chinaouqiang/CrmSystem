package com.crm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.crm.info.BrancheShop;
import com.crm.info.HeadShop;
import com.crm.info.HrEmployee;
import com.haha.hibernate.HibernateDao;
/**
 * 员工表
 * @author 凯
 *
 */
@Repository("hrEmployeeDao")
public class HrEmployeeDao extends HibernateDao<HrEmployee, Integer> {
	
	public HrEmployee login(String name, String pwd) {
		return (HrEmployee) this.getSession().createCriteria(HrEmployee.class).add(Restrictions.eq("uid", name))
		.add(Restrictions.eq("pwd", pwd)).uniqueResult();
	}
	
	public List<HrEmployee> findEmpsByDepId(int depid){
		return this.getSession().createCriteria(HrEmployee.class).add(Restrictions.eq("hrDepartment.id", depid)).add(Restrictions.eq("isdelete", 1)).list();
	}

	public List<HrEmployee> findAll() {
		return this.getSession().createCriteria(HrEmployee.class).add(Restrictions.eq("isdelete", 1)).list();
	}
	
	public List<HrEmployee> findTrashAll(){
		return getSession().createCriteria(HrEmployee.class).add(Restrictions.eq("isdelete", 0)).list();
	}
	
	//根据序列号查询店铺对应的员工
	public List<Map<String, Object>> findList(String Only){
		String hql="select a from HrEmployee a,BrancheShop c,Device d where c.BranchShop_Id=a.BranchShop_Id and c.BranchShop_Id=d.BranchShop_Id and d.Device_Only='"+Only+"'";
		Query query=getSession().createQuery(hql);
		List<HrEmployee>  list=query.list();
		List<Map<String, Object>>  ObJect=new ArrayList<Map<String, Object>>();
		HashedMap map;
		for (HrEmployee hrEmployee : list) {
			map = new HashedMap();
			map.put("name", hrEmployee.getName());
			map.put("Portal", hrEmployee.getPortal());
			ObJect.add(map);
		}
		return ObJect ;
	}
	
	//根据序列号查询店铺对应的员工
	public Object findCount(String Only){
		String hql="select COUNT(*) from HrEmployee a,BrancheShop c,Device d where c.BranchShop_Id=a.BranchShop_Id and c.BranchShop_Id=d.BranchShop_Id and d.Device_Only='"+Only+"'";
		Query query=getSession().createQuery(hql);
		return query.uniqueResult();
	}
	
	
	public List<Map<String, Object>> findList2(String Name,String Path){
		String hql="select a from HrEmployee a WHERE name='"+Name+"' and portal='"+Path+"'";
		Query query=getSession().createQuery(hql);
		List<HrEmployee>  list=query.list();
		List<Map<String, Object>>  ObJect=new ArrayList<Map<String, Object>>();
		HashedMap map=null;
		for (HrEmployee hrEmployee : list) {
			map = new HashedMap();
			map.put("id", hrEmployee.getId());
			map.put("dep_id", hrEmployee.getHrDepartment().getId());
			map.put("BranchShop_Id", hrEmployee.getBranchShop_Id());
		}
		ObJect.add(map);
		return ObJect ;
	}
	
	
}
