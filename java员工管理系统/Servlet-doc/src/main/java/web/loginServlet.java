package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.UEncoder;

import dao.UserDAO;
import entity.User;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	request.setCharacterEncoding("UTF-8");
	String uname=request.getParameter("uname");
	String pwd=request.getParameter("pwd");
	//查看数据库
	UserDAO dao =new UserDAO();
	User user=dao.find(uname);
	String number1=request.getParameter("number");
	String number2=(String) session.getAttribute("number");
	System.out.println(number1);
	System.out.println(number2);
	if(!number1.equals(number2)){
		request.setAttribute("number_error", "验证码错误");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		return;
	}
	
	if(user!=null&&user.getPassword().equals(pwd)){
		//登录成功
		response.sendRedirect("index.jsp");
		
		session.setAttribute("user", user);
	}else{
		request.setAttribute("login_failed", "用户名或密码错误");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	}

}
