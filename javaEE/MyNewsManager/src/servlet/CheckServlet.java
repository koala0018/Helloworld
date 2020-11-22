package servlet;

import java.io.IOException;

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		UserDao userdao = new UserDao();
		User user = new User();
		if(userid==null||password==null||userid.trim().equals("")||password.trim().equals("")){
			request.setAttribute("errorinfo", "请登录");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		user.setUserid(userid);
		user = userdao.selectById(user);
		if(user==null){
			request.setAttribute("errorInfo", "用户不存在");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		if(!user.getPassword().equals(password)){
			request.setAttribute("errorInfo", "密码错误");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userflag", user.getFlag());
			response.sendRedirect("news");
		}
		
		
	}

}
