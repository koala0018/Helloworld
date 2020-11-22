<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.oracle.vo.User"%>
<%@page import="com.oracle.dao.UserDao"%>
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
    
    <title>My JSP 'check.jsp' starting page</title>
    
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
			String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			String remPass=request.getParameter("remPass");
			String remTime=request.getParameter("remTime");
			User user = new User();
			user.setUserid(userid);
			UserDao dao = new UserDao();
			user = dao.selectById(user);
			if(user==null){
			%>
			<jsp:forward page="index.jsp">
			<jsp:param value="用户id不存在" name = "erro"/>
			
			</jsp:forward>
			<%
			}else{ 
			if(password.equals(user.getPassword())){
			session.setAttribute("username", user.getUsername());
			if(remPass!=null){
			int second=0;
			if(remTime.equals("0")){
			second=0;
				}
			else if(remTime.equals("1")){
			second=60;
				}
			else if(remTime.equals("2")){
			second=60;
				}
			else if(remTime.equals("3")){
			second=5*60;
				}
			else if(remTime.equals("4")){
			second=30*60;
				}
				Cookie useridCookie=new Cookie("userid",userid);
				useridCookie.setMaxAge(second);
				Cookie passwordCookie=new Cookie("password",password);
				passwordCookie.setMaxAge(second);
				response.addCookie(useridCookie);
				response.addCookie(passwordCookie);
			}
			%>
			<jsp:forward page="welcome.jsp">
			<jsp:param value="1" name = "pn"/>
			</jsp:forward>

			<%
			}else{
			%>
			<jsp:forward page="index.jsp">
			<jsp:param value="密码不匹配" name = "erro"/>
			</jsp:forward>
			<%}
			} %>
			
		
  </body>
</html>
