<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者ログイン</title>
</head>
<body>
<%
	String errflg = request.getParameter("errflg");
	String loginId = (String)session.getAttribute("loginId");
%>

	<h1>管理者ログイン</h1>
<% 			if(errflg != null){%>

				<p>IDあるいはパスワードが間違っています</p>
<%			} %>

	<form action="auth" method="post">
		<p><input type="text" name="id" placeholder="ID" size="40"></p>
		<p><input type="password" name="pass" placeholder="パスワード" size="40"></p>
		<p><input type="submit" value="ログイン"></p>
	</form>

</body>
</html>