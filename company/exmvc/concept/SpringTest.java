package exmvc.concept;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exmvc.dao.CompanyDao;
import exmvc.dao.impl.CompanyDaoImpl;
import exmvc.entity.impl.Company;
import exmvc.service.CompanyService;
import exmvc.service.impl.CompanyServiceImpl;

public class SpringTest {
	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=new  ClassPathXmlApplicationContext("applicationContext10_Company.xml");
		//Entity
/*		Company company=applicationContext.getBean("company",Company.class);
		company.setParentId("888");
		company.setId("888");
		company.setName("中软亚新");
		System.out.println(company);*/
		//Dao
		/*CompanyDao companyDao=applicationContext.getBean("companyDao",CompanyDaoImpl.class);
		List<Company> list=companyDao.findAll(null);
		System.out.println(list);*/
		//Service
		CompanyService companyService=applicationContext.getBean("companyService",CompanyServiceImpl.class);
		List<Company> list=companyService.findAll(null);
		System.out.println(list);
		
		
	}
}
