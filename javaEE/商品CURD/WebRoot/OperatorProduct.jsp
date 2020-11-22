<%@page import="Util.DBTools"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="Dao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OperatorProduct.jsp' starting page</title>
    
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
 		String username = (String)session.getAttribute("userid");
    	if(username==""||username==null){
    		%>
    		<jsp:forward page="index.jsp">
    			<jsp:param value="还没登录，请先登录" name="errorinfo"/>
    		</jsp:forward>
    		<%
    	}
    	int pid = Integer.parseInt(request.getParameter("pid"));
    	String pname = request.getParameter("pname");
    	String note = request.getParameter("note");
    	double price = Double.parseDouble(request.getParameter("price"));
    	int amount =  Integer.parseInt(request.getParameter("amount"));
    	ProductDao dao = new ProductDao();
    	Product pro = new Product(pid,pname,note,price,amount);
    	dao.insert(pro); 
    	%>
   
			<jsp:forward page="welcome.jsp">
				<jsp:param value="1" name="pn"/>
			</jsp:forward>
					
  </body>
</html>
