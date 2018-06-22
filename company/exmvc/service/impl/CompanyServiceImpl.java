package exmvc.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.util.impl.Page;
import exmvc.dao.CompanyDao;
import exmvc.entity.impl.Company;
import exmvc.service.CompanyService; 
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
    private CompanyDao  companyDao ;
	@Override
	public List<Company> findAll(Company condition) throws Exception {
		 return companyDao.findAll(condition);
	} 
	@Override
	public Company findById(Company condition) throws Exception {
		 return companyDao.findById(condition);
	}

	@Override
	public List<Company> findByPaging(Page<Company> page, Company condition)
			throws Exception {
		 return companyDao.findByPaging(page, condition);
	}

	@Override
	public int add(Company condition) throws Exception {
		 
		return companyDao.add(condition);
	}

	@Override
	public int update(Company condition) throws Exception {
		 
		return companyDao.update(condition);
	}

	@Override
	public int delete(Company condition) throws Exception {
		 return companyDao.delete(condition);
	}
	public CompanyDao getCompanyDao() {
		return companyDao;
	}
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	} 
}
