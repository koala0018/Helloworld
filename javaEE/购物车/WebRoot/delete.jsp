<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.oracle.dao.ProductDao"%>
<%@page import="com.oracle.vo.Product"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   			<%
   			request.setCharacterEncoding("UTF-8");
   	 		response.setCharacterEncoding("UTF-8");
  		 	String username = (String)session.getAttribute("username");
  			if(username==null||username.equals("")){
   %>
   <jsp:forward page="index.jsp">
   <jsp:param value="请登录" name="erro"/>
   </jsp:forward>
   <% 
   }
   			String pidvalue = request.getParameter("pid");
   			Product emp = new Product();
   			emp.setPid(Integer.parseInt(pidvalue));
   			ProductDao dao = new ProductDao();
   			dao.delete(emp);
   			 %>
   			 <jsp:forward page="welcome.jsp">
				<jsp:param value="1" name="pn"/>
		   </jsp:forward>
		   		
		<% 
			
		
		
		%>
			
  </body>
</html>
