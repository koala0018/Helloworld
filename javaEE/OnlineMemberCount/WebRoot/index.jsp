<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
  	String errorinfo =  (String)request.getAttribute("errorinfo");
	if(errorinfo==null){
  		errorinfo="";
  	}
	//application.setAttribute("onlineMember", 0);
  %>
    <form action="loginServlet" method="post">
    	用户id<input type="text" name = "userid"></input><span><%=errorinfo %></span><br>
    	密码<input type="password" name = "password"></input>
    <input type="submit" value="提交"></input>
    </form>
    
  </body>
</html>
