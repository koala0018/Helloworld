<%@page import="Util.DBTools"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="Dao.*" %><%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
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
 	String username = (String)session.getAttribute("userid");
 	String pn = request.getParameter("pn");
 	%>
   
 		<div align="center">欢迎<%=username %></div>
   		<%//避免没登陆直接用网址登录

    	if(username==""||username==null||pn==""||pn==null){
    		%>
    		<jsp:forward page="index.jsp">
    			<jsp:param value="还没登录，请先登录" name="errorinfo"/>
    		</jsp:forward>
    		<%
    	}
    		int pageNumber = 1;//当前页数
       	   	int num = 4;//每页显示几个数据
        	int totalPage = 1;
    		pageNumber =Integer.parseInt(pn);
       		List<Product> list = new ArrayList<Product>();
			ProductDao dao = new ProductDao();       	
       	
			System.out.println("当前页数"+pageNumber);
       		//根据数据库总记录条数和一页显示几个确定总页数
       		int count = dao.Count();
       		//int totalPage = 1;//默认值
       		if(count%num==0){
       			totalPage = dao.Count()/num;
       		}else{
       			totalPage = dao.Count()/num+1;
       		}
       		if(pageNumber<1){
       			pageNumber=1;
       		}else if(pageNumber>totalPage){
       			pageNumber=totalPage;
       		}
       		list = dao.selectByPage(pageNumber, num);
       	  	%>
       	  	<div align="center">
       	  	<a href="add.jsp">增加商品</a>
       	  	<a href="Logout.jsp">退出</a>
       	  	</div>   		
       		<table align="center" border="1">
       			
       			<tr>
       				<th>产品的id</th>
       				<th>产品的名字</th>
       				<th>产品的Note</th>
       				<th>产品的价格</th>
       				<th>产品的数量</th>
       		       	<th>操作</th>

       			</tr>
       		<%
       			
				if(list==null){
       				%>
       				<%="暂无数据" %>
       				<%
       			}else{		
       	       		for(Product e:list){ 
       	       			int temppid = e.getPid();
       	       			%>
       	       	   		<tr>
       	       	   			<td><%=e.getPid() %></td>
       	       	   			<td><%=e.getPname()%></td>
       	       	   			<td><%=e.getNote()%></td>
       	       	   			<td><%=e.getPrice()%></td>
       	       	   			<td><%= e.getAmount()%></td>
        	       	   		<td><a href="delete.jsp?pid=<%=temppid%>">删除</a><span>/</span><a href="change.jsp?pid=<%=temppid%>">修改</a></td>      	       	 		
       	       	   		</tr>
       	       	   		<%
       	       		}
       	       		
       	       	%>
       	       		</table>
       	       	<% 
       	    	}
       		%>	
			<div align="center">
       		 	<a href="welcome.jsp?username=<%= username%>&pn=1">首页</a><%--在超链接跳回本页的时候，username和PN没传参数就会为空，跳会登录页 --%>
     	  		<a href="welcome.jsp?username=<%= username%>&pn=<%=pageNumber-1%>">上一页</a>
      	 		<a href="welcome.jsp?username=<%= username%>&pn=<%=pageNumber+1%>">下一页</a>
     			<a href="welcome.jsp?username=<%= username%>&pn=<%=totalPage%>">尾页</a>
       		</div>
  </body>
</html>
