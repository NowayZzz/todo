<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%	
	String id = request.getParameter("id");
	if("01".equals(id)){
		response.getWriter().write("[{id:'01',name:'uspcat.com','age':26,email:'yunfengcheng2008@126.com'}]");
	}
%>