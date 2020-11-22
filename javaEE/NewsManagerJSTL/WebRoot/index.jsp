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
	<script>
		function $(id){
			return document.getElementById(id);
		}
		//当页面加载完毕
		window.onload = function(){
			//获取页面的组件
			var userid = $("userid");
			var password = $("password");
			var sp1 = $("sp1");
			var sp2 = $("sp2");
			var btn_login = $("btn_login");
			//对按钮设置点击事件
			btn_login.onclick = function(){
				//定义一个变量代表表单是否可以提交
				var flag = true;
				//获取userid的value
				var useridValue = userid.value;
				//获取密码的value
				var passwordValue = password.value;
				//判断userid是否为空
				if(useridValue==null||useridValue==""){
					flag=false;
					sp1.innerHTML = "<font color='red'>userid不能为空</font>";
					return;
				}else{
					flag=true;
					sp1.innerHTML = "";
				}
				//判断password是否为空
				if(passwordValue==null||passwordValue==""){
					flag=false;
					sp2.innerHTML = "<font color='red'>password不能为空</font>";
					return;
				}else{
					flag=true;
					sp2.innerHTML = "";
				}
				//定义userid的正则表达式
				var useridReg = /(^1[3-9]\d{9}$)|(^\w[a-zA-Z0-9]{5,7}@[0-9a-zA-Z]{2,7}(\.com\|\.cn\|\.net)$)/;
				//判断userid是否满足格式
				if(useridValue.match(useridReg)==null){
					flag=false;
					sp1.innerHTML= "<font color='red'>userid的格式不正确</font>";
					return;
				}else{
					flag=true;
					sp1.innerHTML = "";
				}
				
				//定义password的正则表达式
				var passwordReg = /\d{6,16}/;
				//判断userid是否满足格式
				if(passwordValue.match(passwordReg)==null){
					flag=false;
					sp2.innerHTML= "<font color='red'>password的格式不正确</font>";
					return;
				}else{
					flag=true;
					sp2.innerHTML = "";
				}
				//判断是否能提交
				if(flag==true){
					document.forms[0].submit();
				}
			}
		}
	</script>
  </head>
  
  <body>
   <form action="check" method="POST">
   	userid:<input type="text" name="userid" id="userid"/><span id="sp1">${requestScope.errorInfo}</span><br/>
   	password:<input type="password" name="password" id="password"/><span id="sp2"></span><br/>
   	<input type="button" value="登录" id="btn_login"/><input type="reset" value="重置"/>
   </form>
  </body>
</html>
