package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.NewsDao;
import com.oracle.vo.News;

public class OperatorServlet extends HttpServlet {

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

		//接收请求参数
		String operator = request.getParameter("operator");
		//创建NewsDao对象
		NewsDao newsDao = new NewsDao();
		//判断请求参数是否为空
		if(operator==null||operator.trim().equals("")){
			//如果请求参数为空则跳转会查询的Servlet重新查询重新显示
			response.sendRedirect("selectServlet");
			return;
		}else{
			//如果operator不为空
			//判断operator是否是添加
			if(operator.equals("add")){
				//如果是operator是添加，则跳转到添加页面
				request.setAttribute("operator", operator);
				request.getRequestDispatcher("addOrUpdate.jsp").forward(request, response);
				return;
			}else if(operator.equals("update")){
				//如果operator是修改
				//获取传递的nid
				String id = request.getParameter("nid");
				System.out.println("update:"+id);
				//判断nid是否为空
				if(id==null||!id.matches("\\d+")){
					//如果id为空或者id不满足需要的格式，跳转到查询页面重新查询
					response.sendRedirect("selectServlet");
					return;
				}
				//将参数id转化为nid
				int nid = Integer.parseInt(id);
				//创建新闻对象
				News news = new News();
				//设置nid
				news.setNid(nid);
				//查询新闻
				news = newsDao.selectById(news);
				//判断查询到的新闻是否存在
				if(news==null){
					//如果新闻不存在，跳转到查询页面重新查询
					response.sendRedirect("selectServlet");
					return;
				}
				//向request中添加参数
				request.setAttribute("operator", operator);
				request.setAttribute("news", news);
				request.getRequestDispatcher("addOrUpdate.jsp").forward(request, response);
				return;
				
			}else if(operator.equals("addNews")){
				//接收请求参数
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String lf = request.getParameter("lockflag");
				String content = request.getParameter("content");
				News n = new News(0, title, author, new Date(), content, Integer.parseInt(lf));
				newsDao.insert(n);
				response.sendRedirect("selectServlet");
				return;
			}else if(operator.equals("updateNews")){
				//接收请求参数
				String id = request.getParameter("nid");
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String lf = request.getParameter("lockflag");
				String content = request.getParameter("content");
				News n = new News(Integer.parseInt(id), title, author, new Date(), content, Integer.parseInt(lf));
				newsDao.update(n);
				response.sendRedirect("selectServlet");
				return;
				
			}else if(operator.equals("select")){
				//获取传递的nid
				String id = request.getParameter("nid");
				//判断nid是否为空
				if(id==null||!id.matches("\\d+")){
					//如果id为空或者id不满足需要的格式，跳转到查询页面重新查询
					response.sendRedirect("selectServlet");
					return;
				}
				//将参数id转化为nid
				int nid = Integer.parseInt(id);
				//创建新闻对象
				News news = new News();
				//设置nid
				news.setNid(nid);
				//查询新闻
				news = newsDao.selectById(news);
				//判断查询到的新闻是否存在
				if(news==null){
					//如果新闻不存在，跳转到查询页面重新查询
					response.sendRedirect("selectServlet");
					return;
				}
				//向request中添加参数
				request.setAttribute("operator", operator);
				request.setAttribute("news", news);
				request.getRequestDispatcher("addOrUpdate.jsp").forward(request, response);
				return;
				
				
				
			}else if(operator.equals("delete")){
				//获取传递的nid
				String id = request.getParameter("nid");
				//判断nid是否为空
				if(id==null||!id.matches("\\d+")){
					//如果id为空或者id不满足需要的格式，跳转到查询页面重新查询
					response.sendRedirect("selectServlet");
					return;
				}
				//将参数id转化为nid
				int nid = Integer.parseInt(id);
				//创建新闻对象
				News news = new News();
				//设置nid
				news.setNid(nid);
				newsDao.delete(news);
				response.sendRedirect("selectServlet");
				return;
				
			}else if(operator.equals("pass")){
				//获取传递的nid
				String id = request.getParameter("nid");
				//判断nid是否为空
				if(id==null||!id.matches("\\d+")){
					//如果id为空或者id不满足需要的格式，跳转到查询页面重新查询
					response.sendRedirect("selectServlet");
					return;
				}
				//将参数id转化为nid
				int nid = Integer.parseInt(id);
				//创建新闻对象
				News news = new News();
				//设置nid
				news.setNid(nid);
				news = newsDao.selectById(news);
				if(news==null){
					response.sendRedirect("selectServlet");
					return;
				}
				news.setLockflag(0);
				newsDao.update(news);
				response.sendRedirect("selectServlet");
				return;
			}
		}
	}

}
