<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'change.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
		window.onload=function(){
			var pname = document.getElementById("pname");
			var price = document.getElementById("price");
			var note = document.getElementById("note");
			var amount = document.getElementById("amount");
			var button = document.getElementById("button");
			var sp1 = document.getElementById("sp1");
			var sp2 = document.getElementById("sp2");
			var sp3 = document.getElementById("sp3");
			var sp4 = document.getElementById("sp4");
			var flag = true;
			button.onclick=function(){								
				if(pname.value==null||pname.value==""){
					sp1.innerHTML="<font color = 'red'>名字不能为空</font>"		
					flag = false;
					return;
				}else{
					sp1.innerHTML="";
					flag = true;
				}
				if(note.value==null||note.value==""){
					sp2.innerHTML="<font color = 'red'>描述不能为空</font>";
					flag = false;
					return;
				}else{
					sp2.innerHTML="";
					flag = true;
				}
				if(price.value==null||price.value==""){
					sp3.innerHTML="<font color = 'red'>价格不能为空</font>";
					flag = false;
					return;
				}else{
					sp3.innerHTML="";
					flag = true;
				}
				//判断格式
				var priceReg = /^\d{1,9}\.{0,1}\d{0,2}$/;
				if(price.value.match(priceReg)==null){
					
					sp3.innerHTML="<font color = 'red'>价格格式错误，只能是一亿以内，且小数点最多后两位</font>";
					flag = false;
					return;
				}else{
					sp3.innerHTML="";
					flag = true;
				}
				if(amount.value==null||amount.value==""){
					sp4.innerHTML="<font color = 'red'>数量不能为空</font>";
					flag = false;
					return;
				}else{
					flag = true;
					sp4.innerHTML="";
					document.forms[0].submit();
				}
				
				
			}
		}
	</script>
  </head>
  
  <body>
   <%request.setCharacterEncoding("UTF-8");
   		int pid  = Integer.parseInt(request.getParameter("pid"));//接收welcome页面传的参数,用隐藏域传入最终页面
 		String username = (String)session.getAttribute("userid");
    	if(username==""||username==null){
    		%>
    		<jsp:forward page="index.jsp">
    			<jsp:param value="还没登录，请先登录" name="errorinfo"/>
    		</jsp:forward>
    		<%
    	}
    	//int pid = Integer.parseInt(request.getParameter("pid"));//根据传来的id去修改
    	%>

   <div align="center">
   <span>输入你需要的修改信息</span>
   	<form action="changeProduct.jsp" >
   			<input type="hidden" name="pid" value="<%=pid %>"></input>
   		产品的名字<input type="text" id="pname" name="pname"></input><span id="sp1"></span>
   		产品的Note<input type="text" id="note" name="note"></input><span id="sp2"></span>
   		产品的价格<input type="text" id="price" name="price"></input><span id="sp3"></span>
   		产品的数量<input type="text" id="amount" name="amount"></input><span id="sp4"></span>
   		<input type="button" id="button" value="提交"></input>
   </form>
   </div>  
  </body>
 
</html>
