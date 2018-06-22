package exmvc.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import Hibernate.util.impl.HibernateDaoImpl;
import common.util.impl.Page;
import exmvc.dao.CompanyDao;
import exmvc.entity.impl.Company;
@Repository
public class CompanyDaoImpl extends HibernateDaoImpl implements CompanyDao {
	@Override
	public List<Company> findAll(Company condition) throws Exception {
		sql="select * from Company entity where 1=1";
		conditionHandling(condition);
		Query query=session.createSQLQuery(sql).addEntity("entity",Company.class);
		List<Company> list=query.list();
		return list;
	}

	@Override
	public Company findById(Company condition) throws Exception {
		 return session.get(Company.class,condition.getId());
	}

	@Override
	public int getRows(Company condition) throws Exception {
		sql="select count(1) rowCount from Company entity where 1=1";
		conditionHandling(condition);
		Query query=session.createSQLQuery(sql);
		int rows=((BigDecimal)query.uniqueResult()).intValue();
		return rows;  
	}

	@Override
	public List<Company> findByPaging(Page<Company> page, Company condition) throws Exception {
	   //获得总记录数
		  int rows=getRows(condition);
	    //设置Page<Company> page的值
		  page.setTotalRecords(rows);
		  page.setCurrentPage(page.getCurrentPage());
		//获得当前页记录明细
		sql="select * from Company entity  where 1=1";
		conditionHandling(condition);
		Query query=session.createSQLQuery(sql).addEntity("entity",Company.class);
		query=query.setFirstResult(page.getFrom()).setMaxResults(page.getPageSize());
		List<Company> list=query.list();
		page.setDataList(list);
		return list;
	}

	@Override
	public int add(Company condition) throws Exception {
		session.beginTransaction();
		Serializable objId=session.save(condition); //Serializable代替id的各种类型(强制类型转化实现)
		session.getTransaction().commit();
		if(objId!=null)
		    return 1;
		else 
			return 0;
	}

	@Override
	public int update(Company condition) throws Exception {
		try{
			session.beginTransaction();
			session.update(condition); //Serializable代替id的各种类型(强制类型转化实现)
			session.getTransaction().commit();
			return 1;	
		}catch(Exception e){
			return 0;	
		}
	}

	@Override
	public int delete(Company condition) throws Exception {
		try{
			session.beginTransaction();
			condition=findById(condition);
			session.delete(condition); //Serializable代替id的各种类型(强制类型转化实现)
			session.getTransaction().commit();
			return 1;	
		}catch(Exception e){
			return 0;	
		}
	}
   
	@Override
	public void conditionHandling(Company condition) throws Exception {
		if(condition.getId()!=null&&(!condition.getId().trim().equals(""))){
			sql+=" and id like "+"%"+condition.getId()+"%";
		}
		if(condition.getName()!=null&&(!condition.getName().trim().equals(""))){
			sql+=" and name like "+"%"+condition.getName()+"%";
		} 
	} 
}