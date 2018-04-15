package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeeDao;
import entity.Fee;

public class FeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("name");
	    String radFeeType=request.getParameter("radFeeType");
	    System.out.println("radFeeType"+radFeeType);
	    String base_duration=request.getParameter("base_duration");
	    String base_cost=request.getParameter("base_cost");
	    String unit_cost=request.getParameter("unit_cost");
	    String descr=request.getParameter("descr");
	    
	    try {
	    	FeeDao dao=new FeeDao();
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
	    	dao.save(fee);
	    	
	    	response.sendRedirect("fee.do");
	    	System.out.println("�ض���ɹ�");
		} catch (Exception e) {
			//����־(�����ֳ�)
			e.printStackTrace();
			/*
			 * ���쳣�ܷ�ָ���������ܹ��ָ�
			 * (�������ݿ����ֹͣ���������쳣��
			 * ���ǳ�֮Ϊϵͳ�쳣)������ʾ�û�
			 * �Ժ����ԡ�����ܹ��ָ����������ָ���
			 */
			response.getWriter().println(
					"��Ӵ������ƴ���");
		}

	}

}
