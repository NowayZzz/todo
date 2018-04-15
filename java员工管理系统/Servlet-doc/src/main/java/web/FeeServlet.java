package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FeeDao;
import entity.Fee;

public class FeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();
	
	HttpSession session=request.getSession();
	Object obj=session.getAttribute("user");
	if(obj==null){
		//没有登录
		response.sendRedirect("toLogin.do");
		return;
	}
	//查询所有信息
	FeeDao dao =new FeeDao();
	try {
		List<Fee> users=dao.findAllS();
		
		request.setAttribute("users", users);
		
		RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/fee_list.jsp");
		
		rd.forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
		out.println("系统繁忙，稍后再试");
	}
	
	}

}
