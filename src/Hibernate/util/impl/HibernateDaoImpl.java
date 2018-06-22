package Hibernate.util.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class HibernateDaoImpl extends HibernateDaoSupport {

	@Resource
	protected SessionFactory sessionFactory;
	protected Session session;
	protected String sql;
	
	@Resource
	public void setSessionFactorys(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
		session=sessionFactory.openSession();
	}
}
