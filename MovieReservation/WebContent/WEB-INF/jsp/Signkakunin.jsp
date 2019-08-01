<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.UserInfoBeans"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	UserInfoBeans bean = (UserInfoBeans) request.getAttribute("UserInfoBeans");
%>
<body>
	<form action="signUpComplete" method="post">
		<table>
			<tr>
				<td>メールアドレス</td>
				<td><%=bean.getAddress()%>> <input type="hidden" name="address"
					value="<%=bean.getAddress()%>"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="password" name="pass"
					value="<%=bean.getPass()%>"><input type="hidden"
					name="pass" value="<%=bean.getPass()%>"></td>
			</tr>

			<tr>
				<td>氏名</td>
				<td>性<input type="text" name="sei" value="<%=bean.getSei()%>"><input
					type="hidden" name="sei" value="<%=bean.getSei()%>"> 名<input
					type="text" name="mei" value="<%=bean.getMei()%>"><input
					type="hidden" name="mei" value="<%=bean.getMei()%>">
				</td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><%=bean.getUserPhone()%><input type="hidden"
					name="userphone" value="<%=bean.getUserPhone()%>"></td>
			</tr>

			<tr>
				<td>性別</td>
				<td><%=bean.getSex()%> <input type="hidden" name="sex"
					value="<%=bean.getSex()%>"></td>
			</tr>
			<tr>
				<td>生年月日</td>
				<td>西暦<%=bean.getYear()%> <input type="hidden" name="year"
					value=<%=
					bean.getYear()%>> 年<%=bean.getMonth()%><input
					type="hidden" name="month" value="<%=bean.getMonth()%>">月 <%=bean.getDay()%>
					<input type="hidden" name="day" value="<%=bean.getDay()%>">日

				</td>
			</tr>


		</table>
		<input type="button" value="戻る" onclick="history.back()"> <input
			type="submit" name="submit" value="登録する">
	</form>
</body>
</html>