<%@page import="java.text.SimpleDateFormat"%>
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
    	String username = request.getParameter("username");
    	String pn = request.getParameter("pn");
    	
    %>
   		<div align="center">欢迎<%=username %></div>
   		<%//避免没登陆直接用网址登录
    	if(username==""||username==null||pn==""||pn==null){
    		%>
    		<jsp:forward page="Login.jsp">
    			<jsp:param value="还没登录，请先登录" name="errorinfo"/>
    		</jsp:forward>
    		<%
    	}else{
    		int pageNumber = 1;//当前页数
       	   	int num = 2;//每页显示几个数据
        	 int totalPage = 1;
    		pageNumber =Integer.parseInt(pn);
       		List<Emp> list = new ArrayList<Emp>();
       		EmpDao dao = new EmpDao();
       	
       		%>
				<%= pageNumber%>
			<%
       		
       		int count = dao.getCount();
       		//int totalPage = 1;//默认值
       		if(count%num==0){
       			totalPage = dao.getCount()/num;
       		}else{
       			totalPage = dao.getCount()/num+1;
       		}
       		if(pageNumber<1){
       			pageNumber=1;
       		}else if(pageNumber>totalPage){
       			pageNumber=totalPage;
       		}
       		list = dao.selectByPage(pageNumber, num);
       	  	%>
       		<table align="center" border="1">
       			<tr>
       				<th>雇员的id</th>
       				<th>雇员的名字</th>
       				<th>雇员的职位</th>
       				<th>雇员的工资</th>
       				<th>雇员的入职时间</th>
       			</tr>
       		<%
       			
				if(list==null){
       				%>
       				<%="暂无数据" %>
       				<%
       			}else{		

       	       		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       	       		for(Emp e:list){
       	       			String date = time.format(e.getHiredate());
       	       			%>
       	       	   		<tr>
       	       	   			<td><%=e.getEmpid() %></td>
       	       	   			<td><%=e.getEname()%></td>
       	       	   			<td><%=e.getJob() %></td>
       	       	   			<td><%=e.getSal() %></td>
       	       	   			<td><%= date%></td>
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
       		
       		<% 
       		}
   		%>
       		
      
    	

 
  </body>
</html>
