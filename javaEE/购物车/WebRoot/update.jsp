
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
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
		window.onload=function(){
			var btn_update =$("btn_update");
			var pname =$("pname");
			var note =$("note");
			var price =$("price");
			var amount =$("amount");
			var sp1 =$("sp1");
			var sp2 =$("sp2");
			var sp3 =$("sp3");
			var sp4 =$("sp4");
		
			btn_update.onclick=function(){
			var pnameValue = pname.value;
			var noteValue = note.value;
			var priceValue = price.value;
			var amountValue = amount.value;
			var flag=true;
			if(pnameValue==null||pnameValue==""){
				flag =false;
				sp1.innerHTML ="<font color='red'>商品名字不能为空</font>";
				return;
			}else{
				flag=true;
				sp1.innerHTML="";
			}
			if(noteValue==null||noteValue==""){
				flag =false;
				sp2.innerHTML ="<font color='red'>商品类型不能为空</font>";
				return;
			}else{
				flag=true;
				sp2.innerHTML="";
			}
			if(priceValue==null||priceValue==""){
				flag =false;
				sp3.innerHTML ="<font color='red'>商品价格不能为空</font>";
				return;
			}else{
				var priceReg =/^\d\d{0,}\.{0,1}\d{0,2}$/;
				if(priceValue.match(priceReg)==null){
					flag = false;
					sp3.innerHTML ="<font color='red'>商品价格格式不对</font>";
					return;
				}else{
				flag=true;
				sp3.innerHTML="";

				}
			}
			if(amountValue==null||amountValue==""){
				flag =false;
				sp4.innerHTML ="<font color='red'>商品价格不能为空</font>";
				return;
			}else{
				var amountReg =/^\d\d{0,}\d$/;
				if(amountValue.match(amountReg)==null){
					flag = false;
					sp4.innerHTML ="<font color='red'>商品数量格式不对</font>";
					return;
				}else{
				flag=true;
				sp4.innerHTML="";

				}
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
  		String username = (String)session.getAttribute("username");
  	if(username==null||username.equals("")){
   %>
   <jsp:forward page="index.jsp">
   <jsp:param value="请登录" name="erro"/>
   </jsp:forward>
   <% 
   }
  		String pid = request.getParameter("pid");
  		ProductDao dao =new ProductDao();
  		Product emp = new Product();
  		emp.setPid(Integer.parseInt(pid));
  		emp = dao.selectById(emp);
  		if(emp!=null){
  			%>
  			<form action="updateemp.jsp" method="POST">
  			<input type="hidden" name="pid" value="<%=emp.getPid() %>"/>
  			名称<input type="text" name="pname" id="pname" value="<%=emp.getPname()%>"/><span id="sp1"></span><br/>
    		类型<input type="text" name="note"id="note"/ value="<%=emp.getNote()%>"><span id="sp2"></span><br/>
    		价格<input type="text" name="price" id="price" value="<%=emp.getPrice()%>"/><span id="sp3"></span><br/>
    		数量<input type="text" name="amount" id="amount" value="<%=emp.getAmount()%>"/><span id="sp4"></span><br/>
  			<input type="button" value="修改" id="btn_update"/> <input type="reset" value="重置"/>
  			</form>
  			
  			
  			<% 
  			
  			
		}else{
		%>
		<jsp:forward page="welcome.jsp">
				<jsp:param value="1" name="pn"/>
		</jsp:forward>
		<% 	} %>
	
  		
  		
  </body>
</html>
