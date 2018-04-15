package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeeDao;

public class DeleteFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteFeeServlet的service方法");
		
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		System.out.println(id);
		FeeDao dao =new FeeDao();
		try {
			dao.delete(Integer.parseInt(id));
			response.sendRedirect("fee.do");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println(
					"系统繁忙，稍后重试");
		}
			
		}

}
