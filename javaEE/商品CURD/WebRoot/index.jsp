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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	window.onload = function(){
		var userid = document.getElementById("userid");
		var password = document.getElementById("password");
		var button = document.getElementById("button");
		var sp1 = document.getElementById("sp1");
		var sp2 = document.getElementById("sp2");
		var sp3 = document.getElementById("sp3");

		var flag = true;
		
		button.onclick = function(){
			
			if(userid.value==""||userid.value==null){
				sp1.innerHTML="";
				sp2.innerHTML="";
				sp3.innerHTML="";
				sp1.innerHTML="<font color = 'red'>用户名不能为空</font>"
				return;
			}
			if(password.value==""||password.value==null){
				sp1.innerHTML="";
				sp2.innerHTML="";
				sp3.innerHTML="";
				sp2.innerHTML="<font color = 'red'>密码不能为空</font>"
			
				return;
			}
			//开始判断用户格式是否正确\
			var nameReg = /(^1[3,5]\d{9})|(^[a-zA-Z0-9]\w{3,4}@[a-zA-Z0-9]{2,7}(\.com|\.cn|\.net)$)/;
			if(userid.value.match(nameReg)==null){
				sp1.innerHTML="";
				sp2.innerHTML="";
				sp3.innerHTML="";
				sp1.innerHTML="<font color='red'>用户名格式不正确，应该为11位手机和或者邮箱</font>";
				
				return;
			}
			//开始判断密码格式是否正确
			var passwordReg = /\d{4,6}/;
			if(password.value.match(passwordReg)==null){
				sp1.innerHTML="";
				sp2.innerHTML="";
				sp3.innerHTML="";
				sp2.innerHTML="<font color='red'>密码格式不正确,应该为4-6位数字</font>";
				
				return;
			}else{
				document.forms[0].submit();//获取文档的全部form表单，第一个进行提交
			}
		}
		
		
	}
	</script>

  </head>

  <body>
	
    <% String errorinfo  = request.getParameter("errorinfo"); 
   	 if(errorinfo==null){
  		errorinfo="";
  		}    
 	  %>
 	  <%
 	 	//确定浏览器中cookie存的userid对应的密码并且和数据库中的密码匹配
		Cookie[] cookies = request.getCookies();
		String userid = "";
		String password = "";
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("userid")){
					userid = c.getValue();
				}
				if(c.getName().equals("password")){
					password = c.getValue();
				}
			}
			if(userid.trim()!=""&&password.trim()!=""){
				T_userDao userdao = new T_userDao();
				T_user user= new T_user();
				user.setUserid(userid);
				user = userdao.selectById(user);
				if(user!=null&&password.equals(user.getPassword())){
					session.setAttribute("userid", userid);
					%>
						<jsp:forward page="welcome.jsp">
							<jsp:param value="1" name="pn"/>
						</jsp:forward>
					<%
				}
			}
		}
	  %>
 	  
   <form action="check.jsp" method = "post">
   		用户名：<input type="text" id ="userid" name="userid"></input><span id="sp1"></span><span id="sp3"><%=errorinfo %></span><br/>
   		密码:<input type="password" id = "password" name="password"></input><span id="sp2"></span><br/>
   		记住密码<input type = "checkbox" name="remembername"></input>
   		<select name="remembertime">
   			<option value="1" >选择记住密码的时间</option>
   			<option value="2" id="op2">一分钟</option>
   			<option value="3" id="op3">五分钟</option>
   			<option value="4" id="op4">十分钟</option>
   		</select><br/>
   		<input type="button" id="button" value="提交"></input>
   	</form>
  

  </body>
</html>
