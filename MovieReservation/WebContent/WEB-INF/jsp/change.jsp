<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.UserInfoBeans"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員情報変更</title>
<%
	UserInfoBeans bean = (UserInfoBeans) session.getAttribute("userInfoBeans");
	String test = bean.getAddress();
%>
</head>
<body>
	<h1>メールアドレス/パスワード</h1>
	<form action="userInfoChange">

		<table>
			<tr>
				<td>メールアドレス</td>
				<td><input type="text" name="address"
					value="<%=bean.getUserMail()%>"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="text" name="pass"
					value="<%=bean.getPass()%>"></td>
			</tr>
			<h2>お客様情報</h2>
			<tr>
				<td>ユーザー名</td>
				<td><input type="text" name="uname"
					value="<%=bean.getUserName()%>"></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><input type="text" name="userphone"
					value="<%=bean.getUserPhone()%>"></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><%=bean.getGenderCode()%></td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td><%=bean.getYear() + "/" + bean.getMonth() + "/" + bean.getDay()%></td>

			</tr>
		</table>
		<button type="submit">更新</button>
	</form>
</body>
</html>