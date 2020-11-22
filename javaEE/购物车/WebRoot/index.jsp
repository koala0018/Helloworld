<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import=" org.apache.tomcat.util.http.Cookies"%>
<%@page import="com.oracle.vo.User"%>
<%@page import="com.oracle.dao.UserDao"%>


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
	<script>
  	function $(id){
  	return document.getElementById(id);
  	}
  	window.onload = function(){
  	var flag = true;
  	var userid = $("userid");
  	var password = $("password");
  	var btn_login = $("btn_login");
  	var sp1 = $("sp1");
  	var sp2 = $("sp2");
  	btn_login.onclick = function(){
  	var useridValue = userid.value;
  	var passwordValue = password.value;
  	if(useridValue==null||useridValue==""){
  	 	sp1.innerHTML="<font color='red'>账号不能为空</font>";
  	 	flag = false;
  	 	return;
  	}
  	else{
  	sp1.innerHTML="";
  	flag = true;
  	}
  	if(passwordValue==null||passwordValue==""){
		sp2.innerHTML="<font color='red'>密码不能为空</font>";
		flag = false;
  	 	return;
  	}
  	else{
  	sp2.innerHTML="";
  	flag = true;
  	}
  	var useridReg=/(^1[3-9]\d{9}$)|(^[a-zA-Z0-9]\w{3-4}@[a-z0-9A-Z]{2,6}(\.com|\.net|\.cn)$)/;
  	if(useridValue.match(useridReg)==null){
  	sp1.innerHTML="<font color='red'>账号格式不对</font>";
  	flag = false;
  	return;
  	}else{
  	sp1.innerHTML="";
  	}
  	var passReg=/\d{4,16}$/;
  	if(passwordValue.match(passReg)==null){
  	sp2.innerHTML = "<font color='red'>密码格式不对</font>";
  	flag = false;
  	return;
  	}else{
  	sp2.innerHTML="";
  	}
  	if(flag==true){
  	document.forms[0].submit();
  	}
  	}
  }
  </script>
  </head>

  <body>
  <%
  request.setCharacterEncoding("UTF-8");
  response.setCharacterEncoding("UTF-8");
  	String erro =request.getParameter("erro");
  	if(erro==null){
  	erro="";
  	}
  	Cookie[] cookies=request.getCookies();
  	String userid="";
  	String password="";
  	if(cookies!=null){
  		for(Cookie c:cookies){
	  		if(c.getName().equals("userid")){
	  		userid=c.getValue();
	  		}
	  		if(c.getName().equals("password")){
	  		password=c.getValue();
	  		}
  		}
  	}
  	if(!userid.equals("")&&!password.equals("")){
  	UserDao userDao=new UserDao();
  	User user=new User();
  	user.setUserid(userid);
  	user=userDao.selectById(user);
  	if(user!=null&&password.equals(user.getPassword())){
  	session.setAttribute("username", user.getUsername());
  		%>
			<jsp:forward page="welcome.jsp">
			<jsp:param value="1" name = "pn"/>
			</jsp:forward>
	<%
  		}
  	}
  	
   %>
  <form action="check.jsp" method="POST">
  	 账号<input type="text" name="userid" id="userid"/><span id="sp1"></span><br/>
  	 密码<input type="password" name="password" id="password"/><span id="sp2"></span><br/>
  	 <input type="button" value="提交" id="btn_login"/>
  	  <input type="checkbox" name="remPass"/>记住密码
  	 	<select name="remTime">
				<option value="0">选择记住密码的时间</option>
				<option value="1">1分钟</option>
				<option value="2">5分钟</option>
				<option value="3">10分钟</option>
				<option value="4">30分</option>
			</select>
  	 </form>
  </body> 
</html>
