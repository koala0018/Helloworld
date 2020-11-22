package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.NewsDao;
import com.oracle.vo.News;

public class SelectServlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//获取用户的身份
		int userflag = (Integer)session.getAttribute("userflag");
		//接收请求参数
		String pn = request.getParameter("pn");
		if(pn==null||pn.trim().equals("")){
			pn="1";
		}else if(!pn.matches("\\d+")){
			pn="1";
		}
		//定义一个变量代表当前页数
		int pageNum = Integer.parseInt(pn);
		//定义一个变量代表每一页查询的数量
		int num=5;
		//定义NewsDao对象
		NewsDao newsDao = new NewsDao();
		//定义一个变量代表查询到的总数量
		int count = newsDao.getCountAdmin(userflag);
		//定义一个变量代表总页数
		int totalPage = 1;
		//判断总数量对num取值是否能除尽
		if(count%num==0){
			totalPage=count/num;
		}else{
			totalPage=(count/num)+1;
		}
		//判断总页数是否小于0
		if(totalPage<1){
			totalPage=1;
		}
		//判断当前也是是否小于1或者大于总页数
		if(pageNum<1){
			pageNum=1;
		}else if(pageNum>totalPage){
			pageNum=totalPage;
		}
		//查询新闻
		List<News> news = newsDao.selectNewsByPageAdmin(userflag,pageNum, num);
		//将数据存储到request属性范围
		request.setAttribute("news", news);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("showNews.jsp").forward(request, response);
	}

}
