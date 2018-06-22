package common.filter.impl; 
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
public class EncodingFilter implements Filter {
	private String encoding;
	private FilterConfig filterConfig;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig=filterConfig;
		encoding=filterConfig.getInitParameter("encoding"); 
	} 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		//编码过滤
		if(encoding!=null){
			 ((HttpServletRequest)request).setCharacterEncoding(encoding);
			 ((HttpServletResponse)response).setCharacterEncoding(encoding);
		}
		//运行状态过滤    
		String runStatus=filterConfig.getInitParameter("runStatus");
		if(runStatus!=null)
			((HttpServletRequest)request).getSession().setAttribute("runStatus", runStatus);
	    //下一个过滤器或目标
		chain.doFilter(request, response); 
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
