<%@page import="com.oracle.vo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function $(id){
			return document.getElementById(id);
		}
		window.onload = function(){
			var title = $("title");
			var content = $("content");
			var sp1 = $("sp1");
			var btn_ok=$("btn_ok");
			var btn_cancel = $("btn_cancel");
			//对提交按钮设置点击事件
			if(btn_ok!=null&&btn_ok!=undefined){
				btn_ok.onclick = function(){
				//定义一个变量代表是否提交
				var flag=true;
				//获取title和content的value
				var titleValue = title.value;
				var contentValue = content.value;
				//判断值是否为空
				if(titleValue==null||titleValue==""){
					sp1.innerHTML="<font color='red'>title不能为空</font>"
					flag=false;
					return;
				}else{
					sp1.innerHTML=""
					flag=true;
				}
				if(contentValue==null||contentValue==""){
					sp1.innerHTML="<font color='red'>content不能为空</font>"
					flag=false;
					return;
				}else{
					sp1.innerHTML=""
					flag=true;
				}
				//判断是否能够提交
				if(flag==true){
					var f1 = $("f1");
					f1.submit();
				}
			}
			}
			
			//对取消按钮设置点击事件
			btn_cancel.onclick = function(){
				var f2 = $("f2");
				f2.submit();
			}
			
		}
	</script>
  </head>
  
  
  <body>
 
   <c:if test="${requestScope.operator==null }"><%--判断请求参数是否为空 --%>
   	<c:redirect url="selectServlet"></c:redirect><%--如果operator为空,跳转会查询的Servlet重新查询 --%>
   </c:if>
   <c:if test="${requestScope.operator!='add'&&requestScope.news==null }">
   	<c:redirect url="selectServlet"></c:redirect><%--如果operator为空,跳转会查询的Servlet重新查询--%>
   </c:if>
   
   <form action="operator" method="POST" id="f1">
   		<c:if test="${requestScope.operator=='update'}">
   			<input type="hidden" name="author" value="${sessionScope.username}"/>
   			<input type="hidden" name="lockflag" value="${sessionScope.userflag}"/>
   			<input type="hidden" name="operator" value="updateNews"/>
   			<input type="hidden" name="nid" value="${requestScope.news.nid}"/>
   			title:<input type="text" name="title" id="title" value="${requestScope.news.title}"/><span id="sp1"></span><br/>
   			content:<textarea rows="10" cols="30" id="content" name="content">${requestScope.news.content}</textarea><br/>
   			<input type="button" value="更新" id="btn_ok"/><input type="button" value="取消" id="btn_cancel"/>
   					
   		</c:if>
   		
   		<c:if test="${requestScope.operator=='add'}">
   			<input type="hidden" name="author" value="${sessionScope.username}"/>
   			<input type="hidden" name="lockflag" value="${sessionScope.userflag}"/>
   			<input type="hidden" name="operator" value="addNews"/>
   			title:<input type="text" name="title" id="title"/><span id="sp1"></span><br/>
   			content:<textarea rows="10" cols="30" id="content" name="content"></textarea><br/>
   			<input type="button" value="添加" id="btn_ok"/><input type="button" value="取消" id="btn_cancel"/>
   		</c:if>
   		
   		<c:if test="${requestScope.operator=='select'}">
   			title:<input type="text" name="title" id="title" value="${requestScope.news.title}" readonly="readonly"/><span id="sp1"></span><br/>
   			content:<textarea rows="10" cols="30" id="content" name="content" readonly="readonly">${requestScope.news.content}</textarea><br/>
   			<input type="button" value="返回" id="btn_cancel"/>
   		</c:if>
   </form>
   <form action="selectServlet" method="POST" id="f2">
   	
   </form>
  </body>
</html>
