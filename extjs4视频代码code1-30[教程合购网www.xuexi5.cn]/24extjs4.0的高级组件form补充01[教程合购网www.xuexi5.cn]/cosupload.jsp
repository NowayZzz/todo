<%@ page language="java" contentType="text/html; charset=GBk"
    pageEncoding="GBK"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.hd.util.RandomFileRenamePolicy" %>
<%@page import="com.oreilly.servlet.*"%>
<%
	//----------------------------------------
	//----------------------------------------
	String root = request.getSession().getServletContext().getRealPath("/");
	String savePath = root + "file-library\\";
	int maxPostSize = 3 * 5 * 1024 * 1024;
	RandomFileRenamePolicy frp = new RandomFileRenamePolicy();
	MultipartRequest multi = new MultipartRequest(request, savePath, maxPostSize, "utf-8",frp);
	String fieldIds = "";
	//取得所有已上传文件的名字，返回枚举类型。
	Enumeration filesName = multi.getFileNames();
	//遍历返回的枚举类型，COS可以上传多个文件，当表单中有多个文本域标签时，使用while关键字遍历.
	long l = 0L;
	String fileType = null;
	String fileName = null;
	while(filesName.hasMoreElements()){
		//当发现枚举类型中包含文件对象，获取文件对象在枚举中的名字
		String fname = (String)filesName.nextElement();
		//通过名字获取文件，返回java文件对象
		File file = multi.getFile(fname);
		//判断是否获得到文件
		if(file != null){
			//获取文件的真实名字(以便能存储到数据库中)
			fileName = multi.getFilesystemName(fname);
			fileType = fileName.substring(fileName.lastIndexOf(".")+1);
			RandomAccessFile raFile = new RandomAccessFile(new File(savePath+fileType+"\\"+fileName),"r"); 
			l = raFile.length(); 
			fieldIds = fieldIds + fileName+",";
		}
	}
	fieldIds = fieldIds.substring(0,fieldIds.length()-1);
	response.setContentType("text/html;charset=GBK");
	response.getWriter().print("{'address':'"+RandomFileRenamePolicy.fp+"','docName':'"+RandomFileRenamePolicy.fn+"','fileType':'"+fileType+"','docCode':'"+fileName+"','size':'"+l+"','success':true,'message':'上传成功','ids':'"+fieldIds+"'}");
%>

















