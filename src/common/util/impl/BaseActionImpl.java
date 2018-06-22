package common.util.impl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
/*
 CommonServlet中doPost(HttpServletRequest request, response HttpServletResponse)获得request, response
 JobActionImpl jobActionImpl=new JobActionImpl();
 jobActionImpl.getResource(request, response);
 */
public class BaseActionImpl extends HttpServlet {
	protected HttpServletRequest request;
	protected HttpSession session;
	protected HttpServletResponse response;
 
	public void getResource(HttpServletRequest request,HttpServletResponse response){
		this.request=request;
		this.session=request.getSession();
		this.response=response;
	}
}
