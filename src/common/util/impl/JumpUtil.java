package common.util.impl;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class JumpUtil {
	/*
	   1.前台
             $.ajax({
                 url:"<%=modulePath%>/findById.do"
                ,data:"action=ajax&dataType=text&id="+$("#"+itemName).val() 
                ,dataType:"text" 
                ,success:function(data){
                   alert(data);
                   if(data.indexOf("成功")>=0){
                      $("#"+itemName+"Div").css("color","red");
                      $("#"+itemName+"Div").html("该用户名已存在");
                   }else if(data.indexOf("失败")>=0){
                      $("#"+itemName+"Div").css("color","green");
                      $("#"+itemName+"Div").html("该用户名可以使用");
                   }else{
                      $("#"+itemName+"Div").css("color","yellow");
                      $("#"+itemName+"Div").html("检查结果未知");
                   }
                 } 
             });
	 */
	public static void jsJump(String dataType,HttpServletRequest request,HttpServletResponse response,String result,String dest) throws Exception{
        /*
         //1>初始化 
         //2>生成content--ajaxDataType类型处理实现
         //3>输出content到out并flush()/close()
         */
		//1>初始化  
 	       response.setContentType("text/html;UTF-8");
	       response.setCharacterEncoding("UTF-8");
	       PrintWriter out=response.getWriter();
	       String content="";
	       String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		//2>生成content--ajaxDataType类型处理实现
	     if(dataType.equals("jump")){
	    	 content=""
	    		   +"<script type=\"text/javascript\">" 
	               +"alert(\""+result+"\");" 
	               +"location.href=\""+basePath+"/"+dest+"\";" 
	               +"</script>";
	     }
	     else if(dataType.equals("text")){
			    content=result;
	    }else if(dataType.equals("json")){
	    	    content=result;
	    }else if(dataType.equals("script")){ 
  	            content="" 
  	                   +"alert(\""+result+"\");" 
  	                   +"location.href=\""+basePath+"/"+dest+"\";"
  	                   ; 
       } 
		//3>输出content到out并flush()/close() 
  	    out.println(content); 
  		out.flush();
  		out.close(); 
	}
	 
}
