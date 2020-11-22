package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet调用");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userid= request.getParameter("userid");
		String password = request.getParameter("password");
		String userid1 = "koala";
		String userid2 = "admin";		
		String passwords = "123456";
		ServletContext application =request.getSession().getServletContext();
		HttpSession session = request.getSession(false);
		
		//int onlineMember= (Integer)application.getAttribute("onlineMember");
		System.out.println("servlet中的session地址:"+session);
		if(userid!=null||userid.trim()!=""||password!=null||password.trim()!=""){		
				if((userid.equals(userid1)&&password.equals(passwords))||(userid.equals(userid2)&&password.equals(passwords))){
					
					if(application.getAttribute("onlineMember")==null){//说明时第一次登陆
						session.setAttribute("userid",userid);	//传递登录的正确用户
						System.out.println("servlet第一次跳转中的userid："+session.getAttribute("userid"));
						int onlineMember=1;
						application.setAttribute("onlineMember", onlineMember);
						response.sendRedirect("welcome.jsp");//使用客户端跳转刷新就不会重新提交表单，他因为服务器跳转URL不变，还是servlet的代码要执行
					}
					else{
						System.out.println("servlet跳转中的userid："+session.getAttribute("userid"));
						int onlineMember= (Integer)application.getAttribute("onlineMember");					
						onlineMember++;
						application.setAttribute("onlineMember", onlineMember);
						response.sendRedirect("welcome.jsp");
					}					
				}else{
					request.setAttribute("errorinfo", "密码有误");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			
			
		}else{
			//System.out.println("密码或者id输入有误");
			request.setAttribute("errorinfo", "密码或者id输入格式有误");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		
	}

}
