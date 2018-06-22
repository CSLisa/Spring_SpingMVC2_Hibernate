package exmvc.action.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.util.impl.JumpUtil;
import common.util.impl.Page;
import common.util.impl.RequestUtil;
import exmvc.action.CompanyAction;
import exmvc.entity.impl.Company;
import exmvc.service.CompanyService;
import springmvc.action.impl.SpringMVCActionImpl;
/*
 http://localhost:8080/q0301FiveFrameworkTotalFrameWork/company/findAll.st
 */
@Controller
@RequestMapping("/company")
public class CompanyActionImpl extends SpringMVCActionImpl implements CompanyAction  {
    @Autowired
	private CompanyService companyService;
    
	@SuppressWarnings("unchecked")
	@RequestMapping("/findAll")
	public String findAll() throws Exception {
		//VariableDeclaring
		  Company condition=RequestUtil.requestToBean(request,Company.class);
		  Page<Company> page=RequestUtil.requestToBean(request, Page.class); 
		//InputChecking
		//InitAssign  设置模块活动名称，必要的，否则无法跳转
		  setModuleActionName();
		//业务逻辑实现:执行findAll
		  List<Company> list=companyService.findAll(condition);
		  page.setDataList(list);
		//保存list到request转发
		  request.setAttribute("condition", condition);		  
		  request.setAttribute("page", page);
		  //request.getRequestDispatcher("/company/list.jsp").forward(request, response);
		//返回
		  return "company/list";
	}
	@RequestMapping("/findByPaging")
	public String findByPaging() throws Exception {
		//VariableDeclaring
		Company condition=RequestUtil.requestToBean(request,Company.class);
		  Page<Company> page=RequestUtil.requestToBean(request, Page.class);
		//InputChecking
		//InitAssign 
		  setModuleActionName();
		//业务逻辑实现:执行findByPaging
		  List<Company> list=companyService.findByPaging(page,condition);
		  page.setDataList(list);
		//保存list到request转发
		  request.setAttribute("condition", condition);		  
		  request.setAttribute("page", page);
		  //request.getRequestDispatcher("/company/list.jsp").forward(request, response);
		//返回
		  return "company/list";
	}
	@RequestMapping("/findById")
	public String findById() throws Exception {
		Company company = RequestUtil.requestToBean(request, Company.class);
		company=companyService.findById(company);
		request.setAttribute("company", company);
		//request.getRequestDispatcher("/company/operator.jsp").forward(request, response);
		return "company/operator";
	}
	@RequestMapping("/toAdd")
	public String toAdd() throws Exception {
		//VariableDeclaring
		//InputChecking
		//InitAssign 
		  setModuleActionName();
		//业务逻辑实现(无) 
		//返回
		return "company/operator";
	}
	@RequestMapping("/doAdd")
	public String doAdd() throws Exception {
		//VariableDeclaring
		  Company condition=RequestUtil.requestToBean(request,Company.class);
		//InputChecking
		//InitAssign 
		//业务逻辑实现(无) 
		  int rows=companyService.add(condition);
		  if(rows>0){
			  JumpUtil.jsJump("jump", request, response, "新增成功", "company/findByPaging.st");
		  }else{
			  //用户输入回显
			  session.setAttribute("entity",condition);
			  JumpUtil.jsJump("jump", request, response, "新增失败", "company/findByPaging.st");
		  }
		//返回
		  return "company/list";
	}
	@RequestMapping("/toUpdate")
	public String toUpdate() throws Exception {
		Company company=RequestUtil.requestToBean(request, Company.class);
		company=companyService.findById(company);
		request.setAttribute("company", company);
		//request.getRequestDispatcher("/company/operator.jsp").forward(request, response);
		
		return "company/operator";
	}
	@RequestMapping("/doUpdate")
	public String doUpdate() throws Exception {
		Company company=RequestUtil.requestToBean(request, Company.class);
		companyService.update(company);
		//response.sendRedirect(request.getContextPath()+"/company/operator.jsp");
		return "company/operator";
	}
	@RequestMapping("/delete")
	public String delete() throws Exception {
		Company condition=RequestUtil.requestToBean(request, Company.class);
		companyService.delete(condition);
		//response.sendRedirect("/Spring_SpingMVC2_Hibernate/company/findAll.do");
		 int rows=companyService.delete(condition);
		  if(rows>0){
			  JumpUtil.jsJump("jump", request, response, "删除成功", "company/findByAll.st");
		  }else{
			  //用户输入回显
			  session.setAttribute("entity",condition);
			  JumpUtil.jsJump("jump", request, response, "删除失败", "company/findByAll.st");
		  }
		return "company/list";
	}
	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}   
}
