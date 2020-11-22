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
    	
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
	window.onload =function(){
		var deleteas = document.getElementsByName("deleteas");
		for(var i=0;i<deleteas.length;i++){
			var a = deleteas[i];
			a.onclick=function(){
			var pname = this.getAttribute("pname");
			var f = confirm("确定删除"+pname+"吗?");
			return f;	
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
   String pn = request.getParameter("pn");
   if(username==null|username.equals("")|pn==null|pn.equals("")){
   %>
   <jsp:forward page="index.jsp">
   <jsp:param value="请登录" name="erro"/>
   </jsp:forward>
   <% 
   }
    %>
    <div align="center"><font color="red" size="50px">欢迎<%out.println(username); %> <a href="logout.jsp">退出</a></font> 	</div>
   
 	
  	<%
   	ProductDao  empDao = new ProductDao();
   	int pageNum = Integer.parseInt(pn);
   	int num = 5;
   	int count = 0;
   	int tota = 1;
   	count =empDao.getCount();
   	if(count%num==0){
   	tota = count/num;
   	}else{
   		tota = (count/num)+1;
   	}
   	if(pageNum<1){
   	pageNum = 1;
   	}else if(pageNum>tota){
   	pageNum = tota;
   	}
   	
   	List<Product> emps =null;
   	String keyValue = request.getParameter("keyValue");
   	String key = request.getParameter("key");
   	if(keyValue==null||keyValue.equals("")||keyValue.equals("null")){
	   	count = empDao.getCount();
	   	if(count%num==0){
	   	tota = count/num;
	   	}else{
	   		tota = (count/num)+1;
	   	}
	   	if(pageNum<1){
	   	pageNum = 1;
	   	}else if(pageNum>tota){
	   	pageNum = tota;
	   	}
   	 	emps=empDao.selectAll5(pageNum, num);
   	}else {
	   		if(key.equals("pname")){
	   		count =empDao.getPnameCount(keyValue);
		   	if(count%num==0){
		   	tota = count/num;
		   	}else{
		   		tota = (count/num)+1;
		   	}
		   	if(pageNum<1){
		   	pageNum = 1;
		   	}else if(pageNum>tota){
		   	pageNum = tota;
		   	}
	   	 	emps=empDao.selectPname(pageNum, num, keyValue);
	   		
   		}else if(key.equals("note")){
   		count =empDao.getNoteCount(keyValue);
		   	if(count%num==0){
		   	tota = count/num;
		   	}else{
		   		tota = (count/num)+1;
		   	}
		   	if(pageNum<1){
		   	pageNum = 1;
		   	}else if(pageNum>tota){
		   	pageNum = tota;
		   	}
	   	 	emps=empDao.selectNote(pageNum, num,  keyValue);
   		
   		}
   	
   	}
  
    %>
    <table border="1px" align="center">
    <tr>
    <td  colspan ="5"  align="center">
    <form action="welcome.jsp" method="POST">
    <input type="hidden" name ="username" value="<%=username%>"/>
        <input type="hidden" name ="pn" value="1"/>
    <select name="key">
    <option value="pname">按姓名模糊查询</option>
    <option value="note">按类型模糊查询</option>
    </select>
    <input type="text" name="keyValue"/>
     <input type="submit" value="查询"/>
    </form>
    </td>
    <td align="center"><a href="add.jsp?username=<%=username%>">增加</a></td>
    </tr>
		    <tr>
		    	<th>商品的编号</th>
		    	<th>商品的姓名</th>
		    	<th>商品的类型</th>
		    	<th>商品的价格</th>
		    	<th>商品的数量</th>
		    	<th>删除/修改</th>
		    </tr>
		    <%
		    if(emps==null||emps.size()==0||emps.equals("null")){
		    %>
		    <%="暂无数据" %>
		    <%}else{
		    for(int i=0;i<emps.size();i++){
		    Product e = emps.get(i);
		     %>
				<tr>
					<td align="center"><%=e.getPid() %></td>
					<td align="center"><%=e.getPname() %></td>
					<td align="center"><%=e.getNote() %></td>	
					<td align="center"><%=e.getPrice() %></td>
					<td align="center"><%=e.getAmount() %></td>
					<td><a href="delete.jsp?pid=<%=e.getPid() %>&username=<%=username %>" name="deleteas"  pname="<%=e.getPname()%>">删除</a><span>/</span><a href="update.jsp?pid=<%=e.getPid() %>&username=<%=username %>" >修改</a></td>	
				</tr>
		     <% }%> 
		    
    </table>
  
    <%    
    }
   	 %>
   	 <div  align="center">
   <a href="welcome.jsp?pn=1&username=<%=username%>&key=<%=key%>&keyValue=<%=keyValue%>"> 首页</a>
    <a href="welcome.jsp?pn=<%=pageNum-1%>&username=<%=username%>&key=<%=key%>&keyValue=<%=keyValue%>"> 上一页</a>
     <a href="welcome.jsp?pn=<%=pageNum+1%>&username=<%=username%>&key=<%=key%>&keyValue=<%=keyValue%>"> 下一页</a>
      <a href="welcome.jsp?pn=<%=tota%>&username=<%=username%>&key=<%=key%>&keyValue=<%=keyValue%>"> 尾页</a>
   	    </div>
  
  </body>
</html>
