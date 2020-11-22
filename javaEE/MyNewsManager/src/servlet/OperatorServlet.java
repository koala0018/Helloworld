package servlet;

import java.io.IOException;

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

		int nid = Integer.parseInt(request.getParameter("nid"));
		String operator = request.getParameter("operator");
		NewsDao dao = new NewsDao();
		News news = new News();
		if(operator==null||operator.trim().equals("")){
			response.sendRedirect("news");
			return;
		}
		if(operator.equals("select")){
		//	System.out.println("进入select,nid:"+nid);
			news.setNid(nid);
			news = dao.selectById(news);
			String context = news.getContent();
			request.setAttribute("nid", nid);
			request.setAttribute("context", context);
			request.getRequestDispatcher("newsDetail.jsp").forward(request, response);;
			return;//待定
		}
		if(operator.equals("delete")){
			
		}
		if(operator.equals("update")){}
	}

}
