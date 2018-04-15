<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工管理系统</title>
<link type="text/css" rel="stylesheet" media="all"
	href="" />
<link type="text/css" rel="stylesheet" media="all"
	href="" />
</head>
<body class="index">
	<form action="login" method="post" id="search_form">
		<div class="login_box">
			<table>
				<tr>
					<td class="login_info">账号：</td>
					<td colspan="2"><input name="uname" type="text"
						class="width150" /></td>
					<td class="login_error_info"><span class="required"></span></td>
				</tr>
				<tr>
					<td class="login_info">密码：</td>
					<td colspan="2"><input name="pwd" type="password"
						class="width150" /></td>
					<td><span class="required"> <%
          String msg = 
          (String)request.getAttribute(
              "login_failed");
        %> <%=msg == null ? "" : msg%></span></td>

				</tr>
				<tr>
					<td class="login_info">验证码：</td>
					<td class="width70"><input name="number" type="text"
						class="width70" /> <% String msg2=(String)request.getAttribute("number_error"); %>
						</td>
					<td><img src="checkcode"
						onclick="this.src='checkcode?'+Math.random()" alt="验证码"
						title="点击更换" /></td>
					<td><span style="color: red; font-size: 18px;"> <%=msg2==null ? "" :msg2 %>
					</span></td>
				</tr>
				<tr>
					<td></td>
					<td class="login_button" colspan="2"><a
						href="javascript:document:search_form.submit();"><img
							src="" /></a></td>
					<td><span class="required"></span></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
