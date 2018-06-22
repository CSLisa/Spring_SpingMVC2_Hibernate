package springmvc.action.impl;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller 
public class SpringMVCActionImpl {
	@Autowired  
	protected  HttpServletRequest request;
	@Autowired  
	protected  HttpSession session;
	@Autowired  
	protected  HttpServletResponse response;
 
	protected void setModuleActionName(){
	  	  String uri=request.getRequestURI();  
	  	  String[] array=uri.substring(uri.indexOf("/",1)+1,uri.indexOf(".")).split("/");
	  	  //保存到session中，以后使用
	  	   session.setAttribute("array", array);
	  	   //System.out.println(Arrays.deepToString(array));
	}
}
