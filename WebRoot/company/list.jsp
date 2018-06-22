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

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/base.css"/>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/css/borderHandler.css"/>
<script type="text/javascript" src="<%=basePath%>/js/jquery.js"></script>
<style type="text/css">
  table.kv-table tbody td .handle .detail{
	background:url(<%=basePath%>/images/handle-icon.gif) 0 -145px; /*第5个图*/
	}
</style>
<script type="text/javascript">
   function jumpHandling(dest){
      var currentPage=0;
      //currentPage赋值
      if(dest=="jump"){  //跳转命令处理:jump
         if(!isNaN($("#jump").val()))
            currentPage=$("#jump").val();
         else{
           alert("输入项不是数字");
           return false;
         } 
      }else{//跳转数字处理：首页/上一页/下一页/尾页
        currentPage=dest;
      }  
      //3>执行跳转
          window.location="<%=modulePath%>/findByPaging.st?currentPage="+currentPage;
   } 
   function operate(opName,id){
       var location="";
       //location赋值
       if(opName=="toAdd"){
           location="<%=modulePath%>/toAdd.st";
       }else if(opName=="findById"){
           location="<%=modulePath%>/findById.st?id="+id;
       }else if(opName=="toUpdate"){
           location="<%=modulePath%>/toUpdate.st?id="+id;
       }else if(opName=="delete"){
           location="<%=modulePath%>/delete.st?id="+id;
       } 
       //跳转
       window.location=location;
   }
</script>
</head>

<body>
<form id="form1" 
        <c:if test="${array[1]=='findAll' }">
            action="<%=modulePath%>/findAll.st"
        </c:if> 
        <c:if test="${array[1]=='findByPaging' }">
            action="<%=modulePath%>/findByPaging.st"
       </c:if> 
 method="post">
<div class="containner">
	<div id="inner-hd">
    	<div class="crumbs">
            <a href="javascript:;" class="crumbs-label">系统管理>>部门列表</a>
        </div>
    </div>
    <div id="inner-bd">
        <div class="button-group">
            <div class="button">
              <a href="<%=modulePath%>/toAdd.st"><img src="<%=basePath%>/images/add.gif"></a>
            </div>
            <div class="button">  
                            父项号:<input type="text" id="parentId" name="parentId" value="${condition.parentId}"/> 
              &nbsp;&nbsp;&nbsp;&nbsp;
                            编号:<input type="text" id="id" name="id" value="${condition.id}"/> 
              &nbsp;&nbsp;&nbsp;&nbsp;
                            名称:<input type="text" id="name" name="name" value="${condition.name}"/>          
              <a  href="javascript:$('#form1').submit();">
                 <img src="<%=basePath%>/images/search1.gif">
              </a>
            </div>
         </div>
         <table class="kv-table">
         	<thead>
            	 <tr>
            	    <td class="kv-num">父项号</td>
                    <td class="kv-num">部门编号</td>
                    <td class="kv-name">部门名称</td>
                    <td class="kv-handle">操作</td>
                </tr>
            </thead>
            <tbody>
               <c:forEach items="${page.dataList}" var="each" varStatus="status">
                  <!-- 隔行变色   -->
                   <tr 
                     <c:if test="${status.count%2==0}">
                             style="background-color:silver"
                     </c:if>
                   >
                     <td>${each.parentId}</td>
                     <td>${each.id}</td>
                     <td>${each.name}</td>
                     <td> 
					    <div class="handle"> 
					        <span class="handle-icon detail" title="查看明细" onclick="operate('findById','${each.id}');"></span>
					        <span class="handle-icon update" title="修改" onclick="operate('toUpdate','${each.id}');"></span>
                        	<span class="handle-icon del" title="删除" onclick="operate('delete','${each.id}');"></span> 
                        </div> 
                     </td>
                   </tr> 
               </c:forEach>
            </tbody>
        </table>
	</div>
</div>
<div>
  <c:if test="${array[1]=='findByPaging'}">
<p align="right">
		<font color="black">共</font><font color="black">${page.totalRecords}</font>
		<font color="black">项&nbsp;</font>
		<font color="black">每页</font><font color="black">${page.pageSize}</font><font color="black">项&nbsp;</font>
		<font color="black">当前第</font><font color="black">${page.currentPage}</font>
		<font color="black">页&nbsp;</font>
		<font color="black">共</font><font color="black">${page.totalPages}</font>
		<font color="black">页&nbsp; </font> 
	    <c:if test="${page.currentPage!=1}"> 
	       <a href="javascript:jumpHandling(1);">首  页</a>
           <a href="javascript:jumpHandling(${page.currentPage-1});">上一页</a>
        </c:if>
        <c:if test="${page.currentPage!=page.totalPages}" >
         <a href="javascript:jumpHandling(${page.currentPage+1});">下一页</a>
         <a href="javascript:jumpHandling(${page.totalPages});">尾  页</a>
        </c:if>  
           第<input id="jump" type="text" size="4">页<a  href="javascript:void(0);" onclick="javascript:jumpHandling('jump');"> 跳转</a>
   </p>
 </c:if>  	   
 </div>
</form>
</body>
</html>
