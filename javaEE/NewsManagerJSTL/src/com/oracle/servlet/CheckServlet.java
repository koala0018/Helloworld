package com.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.UserDao;
import com.oracle.vo.User;

public class CheckServlet extends HttpServlet {

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
		//获取提交的请求参数
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		//判断请求参数是否为空
		if(userid==null||userid.trim().equals("")||password==null||password.trim().equals("")){
			request.setAttribute("errorInfo", "请登录");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}else{
			//创建UserDao对象
			UserDao userDao = new UserDao();
			//创建User对象
			User user = new User();
			//对user对象设置userid为用户输入的userid
			user.setUserid(userid);
			//查询数据库是否存在此用户
			user = userDao.selectById(user);
			//判断如果查询的结果为空则证明用户不存在
			if(user==null){
				request.setAttribute("errorInfo", "userid不存在");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}else{
				//判断用户输入的密码与查询到的用户的密码是否一致
				if(password.equals(user.getPassword())){
					//获取HttpSession对象
					HttpSession session = request.getSession();
					//向session方位存储用户名和用户的角色
					session.setAttribute("username", user.getUsername());
					session.setAttribute("userflag", user.getFlag());
					//将请求跳转到查询新闻的Servlet
					response.sendRedirect("selectServlet");
				}else{
					request.setAttribute("errorInfo", "密码不正确");
					request.getRequestDispatcher("index.jsp").forward(request, response);
					return;
				}
				
			}
			
		}
		
	}

}
