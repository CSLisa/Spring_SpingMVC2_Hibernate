package exmvc.concept;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import exmvc.entity.impl.Company;

public class HibernateAnnotationTest {

/*public static void main(String[] args) {
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	System.out.println(tx);
	Company company = new Company("3","001","中国联通");
	Serializable idObj = session.save(company);
	session.getTransaction().commit();
	//为什么只显示id字段的值？？？
	System.out.println(idObj);
	Serializable idObj2 = session.get(Company.class, "1");
	System.out.println(idObj2);
	
	}*/
	
}
