<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.*"%>
<%@ page import="Dao.*"%>

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
		T_userDao userdao = new T_userDao();
		T_user user= new T_user();
		user.setUserid(userid);
		user = userdao.selectById(user);
		if(userid==null){
			%>
			<jsp:forward page="index.jsp">
				<jsp:param value="请登录" name="errorinfo"/>
			</jsp:forward>
			<%
		}
		//查传过来的user在不在数据库中
		System.out.println(user);
		if(user==null||user.getUserid()==""){
			%>
				<jsp:forward page="index.jsp">
					<jsp:param value="用户不存在" name="errorinfo"/>
				</jsp:forward>
			<% 
		}//jsp跳转时立即跳转，下面的不执行了
		if(password!=null&&password!=""&&password.equals(user.getPassword())){
			//将第一次登录时的正确用户密码存入cookie	
				System.out.println("密码正确");
			String remembername = request.getParameter("remembername");
			String remembertime = request.getParameter("remembertime");
			System.out.print("cookie值："+remembertime);
			System.out.println("remembername:"+remembername);
			if(remembername!=null){//勾上了记住密码，remembername的值就是on不然就是null
				if(remembertime!=null){
					int second = 0;
					if(remembertime.equals("2")){
						second=1*60;
					}else if(remembertime.equals("3")){
						second = 5*60;
						
					}else if(remembertime.equals("4")){
						second = 10*60;
					}
					Cookie useridcookie = new Cookie("userid",userid);
					Cookie passwordcookie = new Cookie("password",password);	
					useridcookie.setMaxAge(second);
					passwordcookie.setMaxAge(second);
					response.addCookie(useridcookie);
					response.addCookie(passwordcookie);					
				}				
			}
				session.setAttribute("userid", userid);//将正确的userid存入session
				%>
				<jsp:forward page="welcome.jsp">
					<jsp:param value="1" name="pn"/>
				</jsp:forward>
				
			<%
			
			
		}else{
			
		%>
			<jsp:forward page="index.jsp">
				<jsp:param value="密码不正确" name="errorinfo"/>
			</jsp:forward>

		<%
		}

	%>
  </body>
</html>
