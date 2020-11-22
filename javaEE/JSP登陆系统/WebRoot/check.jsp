<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.*" %>
<%@ page import="vo.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
				<%-- 判断用户名和密码在数据库中是否存在 --%>
  </head>
  <body>
   		<%
   			request.setCharacterEncoding("UTF-8");
   			String userid = request.getParameter("userid");
   			String password = request.getParameter("password");
   			T_userDao  dao = new T_userDao();
   			T_user user= new T_user();
   			user.setUserid(userid);
   			user= dao.selectById(user);
   			
   			if(user==null){
   				%>
   				<jsp:forward page="Login.jsp">
   					<jsp:param value="用户不存在" name="errorinfo"/>
   				</jsp:forward>
   				<%
   			}else{
   				if(!user.getPassword().equals(password)){
   	   				%>
   	   				<jsp:forward page="Login.jsp">
   	   					<jsp:param value="密码错误" name="errorinfo"/>
   	   				</jsp:forward>
   	   				<%
   	   			}else{
   	   				%>
   	   				<jsp:forward page="welcome.jsp">
   	   					<jsp:param value="<%=user.getUsername() %>" name="username"/>
   	   					<jsp:param value="1" name="pn"/>
   	   				</jsp:forward>
   	   				<%
   	   			}
   	   	
   			}
   			%>
   			
  </body>
</html>
