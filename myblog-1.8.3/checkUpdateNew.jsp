<%@page import="com.jdkcn.domain.SiteConfig"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%><%
response.setHeader("Pragma","No-Cache");
response.setHeader("Cache-Control","No-Cache");
response.setDateHeader("Expires",0);

String ver = request.getParameter("ver");
List<String> oldVers = new ArrayList<String>();
oldVers.add("Ver1.5.20070819qixi");
oldVers.add("Ver1.5.20070819qixi_P1");
oldVers.add("Ver1.6.20070925mid-autumn");
oldVers.add("Ver1.8.20071006-National-Day");
oldVers.add("Ver1.8.20071006-National-Day-Final");
oldVers.add("Ver1.8.20071011-National-Day-Final_Bachelor's-day-patch");
oldVers.add("Ver1.8.2.20090930-National-Day-Patch");
SiteConfig siteConfig = new SiteConfig();
if(ver==null||oldVers.contains(ver)||"".equals(ver)){
%>
<div class=message>
	<ul>
		<li>A new version[<%=siteConfig.getAppVersion() %>] available.recommend <a href="http://code.google.com/p/myblog/downloads/list">update.</a></li>
		<li>新版本[<%=siteConfig.getAppVersion() %>] 发布了。请您 <a href="http://code.google.com/p/myblog/downloads/list">更新</a> 到最新版本。</li>
	</ul>
</div>
<%}%>