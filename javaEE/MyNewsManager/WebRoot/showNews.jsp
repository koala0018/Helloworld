<%@page import="com.oracle.dao.UserDao"%>
<%@page import="com.oracle.vo.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oracle.vo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showNews.jsp.jsp' starting page</title>
    
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
    	int totalPage = (Integer)request.getAttribute("totalPage");
   		 int pageNum = (Integer)request.getAttribute("pageNum");
   		int userflag = (Integer)session.getAttribute("userflag");
		List<News> news = (List<News>)request.getAttribute("news");
		String username = (String)session.getAttribute("username");
		SimpleDateFormat time = null;
    %>
    <div align="center">欢迎：<%=username %></div>
    <table border="1" align="center">
    	<tr>
    		<th>新闻的id</th>
    		<th>新闻的标题</th>
    		<th>新闻的作者</th>
    		<th>新闻的发布日期</th>
    		<th>操作</th>    		
    	</tr>
    	<%
    	if(news==null){
    		%>
    		<tr >
    			<td colspan="5">暂无数据</td>
    		</tr>
    		<%
    	}else{
    		for(News n:news){
    			time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    			String date = time.format(n.getPubdate());
        		%>
        		<tr>
        			<td><%=n.getNid() %></td>
        			<td><a href="operator?operator=select&nid=<%=n.getNid() %>"><%=n.getTitle() %></a></td>
        			<td><%=n.getAuthor() %></td>
        			<td><%=date%></td>
        			<%
     							//判断是否是admin
     							if(userflag==0){
     								//判断是否是通过的新闻
     								if(n.getLockflag()==0){
     									//判断是否是管理员自己发布的
     									if(n.getAuthor().equals(username)){
     											%>
     												<td><a href="operator?operator=update&nid=<%=n.getNid()%>">修改</a>/<a href="operator?operator=delete&nid=<%=n.getNid()%>" name="deletea" title="<%=n.getTitle()%>">删除</a></td>
     											<% 	
     									}else{
     											%>
     												<td><a href="operator?operator=delete&nid=<%=n.getNid()%>" name="deletea" title="<%=n.getTitle()%>">删除</a></td>
     											<% 	
     									}
     								}else{
     									//判断是否是管理员自己发布的
     									if(n.getAuthor().equals(username)){
     											%>
     												<td><a href="operator?operator=update&nid=<%=n.getNid()%>">修改</a>/<a href="operator?operator=delete&nid=<%=n.getNid()%>" name="deletea" title="<%=n.getTitle()%>">删除</a></td>
     											<% 	
     									}else{
     											%>
     												<td><a href="operator?operator=pass&nid=<%=n.getNid()%>">通过</a>/<a href="operator?operator=delete&nid=<%=n.getNid()%>" name="deletea" title="<%=n.getTitle()%>">删除</a></td>
     											<% 	
     									}
     								}
     							}else{//如果是普通用户
     									//判断是否是自己发布的
     									if(n.getAuthor().equals(username)){
     											%>
     												<td><a href="operator?operator=update&nid=<%=n.getNid()%>">修改</a>/<a href="operator?operator=delete&nid=<%=n.getNid()%>" name="deletea" title="<%=n.getTitle()%>">删除</a></td>
     											<% 	
     									}else{
     											%>
     												<td><%="-" %></td>
     											<% 	
     									}
     							}
     						 
        	}
        	
    	}
    	%>
    	
    </table>
    <div align="center">
    	<a href="news?pn=1">首页</a>
    	<a href="news?pn=<%= pageNum-1%>">上一页</a>
    	<a href="news?pn=<%= pageNum+1%>">下一页</a>
    	<a href="news?pn=<%= totalPage%>">尾页</a>
    </div>
  </body>
</html>
