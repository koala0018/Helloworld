<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oracle.vo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showNews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		window.onload = function(){
			var deleteas = document.getElementsByName("deletea");
			for(var i=0;i<deleteas.length;i++){
				var deletea = deleteas[i];
				
				deletea.onclick = function(){
					
					var deleteTitle = this.getAttribute("title");
					var flag = confirm("确定要删除"+deleteTitle+"吗??");
					return flag;
				}
			}
			
		}
	</script>
	
	
  </head>
  
  <body>
   
     
     <table border="1" align="center">
     	<tr>
     		<td colspan="5"><a href="operator?operator=add">添加新闻</a></td>
     	</tr>
     	<tr>
     		<th>新闻的编号</th>
     		<th>新闻的标题</th>
     		<th>新闻的作者</th>
     		<th>新闻的发布时间</th>
     		<th>操作</th>
     	</tr>
     	<c:if test="${requestScope.news==null}">
     		<tr>
     			<td colspan="5"><%="暂无数据" %></td>
     		</tr>
     	</c:if>
     	<c:if test="${requestScope.news!=null}">
     		<c:forEach items="${requestScope.news}" var="n">
     			
     					<tr>
     						<td>${n.nid}</td>
     						<td><a href="operator?operator=select&nid=${n.nid }">${n.title}</a></td>
     						<td>${n.author }</td>
     						<td>${n.pubdate }</td>
     						<c:if test="${sessionScope.userflag==0}">
     							<c:if test="${n.lockflag==0}">
     								<c:if test="${n.author==sessionScope.username}">
     									<td><a href="operator?operator=update&nid=${n.nid}">修改</a>/<a href="operator?operator=delete&nid=${n.nid}" name="deletea" title="${n.title}">删除</a></td>
     								</c:if>
     								<c:if test="${n.author!=sessionScope.username}">
     									<td><a href="operator?operator=delete&nid=${n.nid }" name="deletea" title="${n.title }">删除</a></td>
     								</c:if>
     							</c:if>
     							<c:if test="${n.lockflag!=0}">
     								<c:if test="${n.author==sessionScope.username}">
     									<td><a href="operator?operator=update&nid=${n.nid}">修改</a>/<a href="operator?operator=delete&nid=${n.nid}" name="deletea" title="${n.title }">删除</a></td>
     								</c:if>
     								<c:if test="${n.author!=sessionScope.username}">
     									<td><a href="operator?operator=pass&nid=${n.nid }">通过</a>/<a href="operator?operator=delete&nid=${n.nid}" name="deletea" title="${n.title }">删除</a></td>
     								</c:if>
     							</c:if>
     						</c:if>
     						
     						<c:if test="${sessionScope.userflag==1}">
     							<c:if test="${n.author==sessionScope.username}">
     									<td><a href="operator?operator=update&nid=${n.nid }">修改</a>/<a href="operator?operator=delete&nid=${n.nid }" name="deletea" title="${n.title }">删除</a></td>
     								</c:if>
     								<c:if test="${n.author!=sessionScope.username}">
     										<td>"-"</td>
     								</c:if>
     									
     						
     						</c:if>
     						
     						
     					</tr>
     					
     				
     		</c:forEach>
     	
     		
     			<tr align="center">
     						<td colspan="5">
     							<a href="selectServlet?pn=1">首页</a>
     							<a href="selectServlet?pn=${requestScope.pageNum-1}">上一页</a>
     							<a href="selectServlet?pn=${requestScope.pageNum+1}">下一页</a>
     							<a href="selectServlet?pn=${requestScope.totalPage}">尾页</a>
     						</td>
     			</tr>
     			
     	
     	</c:if>
     	
     </table>
  </body>
</html>
