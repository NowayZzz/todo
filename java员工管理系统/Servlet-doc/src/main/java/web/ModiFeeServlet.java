package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeeDao;
import entity.Fee;

public class ModiFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");;
			response.setContentType("text/html;charset=utf-8");
			String name=request.getParameter("name");
		    String radFeeType=request.getParameter("radFeeType");
		    String base_duration=request.getParameter("base_duration");
		    String base_cost=request.getParameter("base_cost");
		    String unit_cost=request.getParameter("unit_cost");
		    String descr=request.getParameter("descr");
		    String id=request.getParameter("id");
		    
		    try {
				FeeDao dao =new FeeDao();
				Fee fee=new Fee();
				fee.setName(name);
		    	if(!base_duration.equals("0")){
		    		fee.setBase_duration(Integer.valueOf(base_duration));
		    	}
		    	if(!Double.valueOf(base_cost).equals("0")){
		    		fee.setBase_cost(Double.valueOf(base_cost));
		    	}
		    	if(!unit_cost.equals("0")){
		    		fee.setUnit_cost(Double.valueOf(unit_cost));
		    	}
		    	fee.setDescr(descr);
		    	fee.setCost_type(radFeeType);
		    	fee.setId(Integer.parseInt(id));
		    	dao.update(fee);
		    	
		    	response.sendRedirect("fee.do");
		    	System.out.println("重定向成功");
				
			} catch (Exception e) {
				
				//记日志(保留现场)
				e.printStackTrace();
				/*
				 * 看异常能否恢复，如果不能够恢复
				 * (比如数据库服务停止，这样的异常，
				 * 我们称之为系统异常)，则提示用户
				 * 稍后重试。如果能够恢复，则立即恢复。
				 */
				response.getWriter().println(
						"修改错误");
			}
	}

}
