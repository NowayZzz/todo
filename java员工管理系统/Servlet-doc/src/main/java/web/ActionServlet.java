package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Fee;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 	 String uri=request.getRequestURI();
		 	 
		 	 String action=uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		 	 
		 	 if("/toLogin".equals(action)){
		 		 request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		 	 }
		 	 if("/login".equals(action)){
		 		 loginServlet login = new loginServlet();
		 		 login.service(request, response);
		 	 }
		 	 if("/index".equals(action)){
		 		 request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		 	 }
		 	 if("/fee".equals(action)){
		 		 FeeServlet fee=new FeeServlet();
		 		 fee.service(request, response);
		 	 }
		 	 if("/feeadd".equals(action)){
		 		 request.getRequestDispatcher("/WEB-INF/fee_add.jsp").forward(request, response);
		 	 }
		 	 if("/feeAdd".equals(action)){
		 		 FeeAddServlet feeadd=new FeeAddServlet();
		 		 feeadd.service(request, response);
		 	 }
		 	 if("/deletefee".equals(action)){
		 		 DeleteFeeServlet dele=new DeleteFeeServlet();
		 		 dele.service(request, response);
		 	 }
		 	 if("/fee_modi".equals(action)){
		 		String id=request.getParameter("id");
				Fee fee=new Fee();
				fee.setId( Integer.parseInt(id));
				request.setAttribute("fee", fee);
				request.getRequestDispatcher("/WEB-INF/fee_modi.jsp").forward(request, response);
		 	 }
		 	 if("/modifee".equals(action)){
		 		ModiFeeServlet modifee=new ModiFeeServlet();
		 		modifee.service(request, response);
		 	 }
	
	}



}
