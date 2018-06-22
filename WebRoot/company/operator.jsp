<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
String moduleName="company";
String modulePath=basePath+"/"+moduleName;
%> 
<!DOCTYPE HTML >
<html>
<head> 
<title>公司页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/check.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/borderHandler.css">
<script type="text/javascript"> 
    function checkItem(itemName){
         //1>非空检查
             if($.trim($("#"+itemName).val())==""){
                alert("编号不能为空");
                return false;
             } 
         //2>异步调用
             $.ajax({
                 url:"<%=modulePath%>/findById.st"
                ,data:"action=ajax&dataType=text&id="+$("#"+itemName).val() 
                ,dataType:"text" 
                ,success:function(data){ 
                   if(data.indexOf("成功")>=0){
                      $("#"+itemName+"Div").css("color","red");
                      $("#"+itemName+"Div").html("该名称已存在");
                   }else if(data.indexOf("失败")>=0){
                      $("#"+itemName+"Div").css("color","green");
                      $("#"+itemName+"Div").html("该名称可以使用");
                   }else{
                      $("#"+itemName+"Div").css("color","yellow");
                      $("#"+itemName+"Div").html("检查结果未知");
                   }
                 } 
             });
 
   }
   function submitCheck(){
       //非空检查
         if($.trim($("#id").val())==""){
                alert("编号不能为空");
                return false;
         } 
       //action动态设置并提交:判断toAdd/toUpdate/的泛doAdd/doUpdate目标实现
         var action="";
         if("${array[1]}"=="toAdd")
            action="<%=modulePath%>/doAdd.st";
         else if("${array[1]}"=="toUpdate")
            action="<%=modulePath%>/doUpdate.st";
         $("#form1").attr("action",action);
         $("#form1").submit(); 
   }
   function findItem(id){
      if(id=="parentId"){
          $.ajax({
                 url:"<%=basePath%>/dept/findByAll.st"
                ,data:"action=ajax&dataType=text"
                ,dataType:"json" 
                ,success:function(data){ 
                   //????
                 } 
          });
      } 
        
   }
</script>
</head>
<body>
	<span class="sys_list_yh">
	       系统管理&gt;&gt;公司管理&gt;&gt;
	     <c:if test="${array[1]=='toAdd'}">
			 添加公司信息 
		 </c:if>
		 <c:if test="${array[1]=='toUpdate'}">
			修改公司信息            
		 </c:if>    
		 <c:if test="${array[1]=='findById'}">
		        查看公司明细          
		 </c:if>     
	</span>
	<form id="form1" action="<%=modulePath%>/doAdd.st" method="post" onsubmit="return submitCheck();">
	   <table>
			<tr bgcolor="#F2F2F2">
				<td align="center">父项号：</td>
				<td>
				    <input id="parentId" name="parentId"  value="${entity.parentId}"/>
				       <!-- onfocus="findItem('deptId');" --> 
				</td>
			</tr> 
			<tr bgcolor="#F2F2F2">
				<td align="center">公司编号：</td>
				<td>
				    <input id="id" name="id"  value="${entity.id}"
				       <c:if test="${array[1]=='toAdd'}">
				          onblur="checkItem('id');"
				       </c:if>
				       <c:if test="${array[1]=='toUpdate'}">
				          readonly="readonly"
				       </c:if>
				       <c:if test="${array[1]=='findById'}">
				          readonly="readonly"
				          class="noBorderStyle";
				       </c:if>  
				    />
					<span id="idDiv" align="left"></span>
				</td>
			</tr>
			<tr bgcolor="#F2F2F2">
				<td align="center">公司名称：</td>
				<td>
				   <input id="name" name="name" value="${entity.name}"
				   	   <c:if test="${array[1]=='findById'}">
				          readonly="readonly"
				          class="noBorderStyle";
				       </c:if>  
				   /><span align="left" id="nameDiv"></span>
				</td>
			</tr> 
			<tr bgcolor="#F2F2F2">
				 <td colspan="2" style="text-align: center;"> 
				   	   <c:if test="${array[1]=='toAdd'}">
				          <button  onclick="submitCheck();">新增</button>
				       </c:if> 
				   	   <c:if test="${array[1]=='toUpdate'}">
				          <button  onclick="submitCheck();">修改</button>
				       </c:if> 
				    &nbsp;&nbsp; 
				    <input type="button" value="返回" onclick="history.back();" />
				 </td>
			</tr>
		</table>
		<br> 
	</form>
</body>
</html> 