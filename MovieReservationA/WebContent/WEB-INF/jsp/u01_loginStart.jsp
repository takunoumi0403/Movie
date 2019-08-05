<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="beans.UserInfoBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./header/userHeader.jsp"/>
	<div class="w-75 mx-auto ">
		<%
			String erro = (String) request.getParameter("erro");
		%>

		<div id="main" class="w-75 mx-auto my-5 table_border_radius">
			<form action="uauth" method="post">
				<table class="w-100 mx-auto bg-light">
					<tr>
						<td>
							<%if (erro != null) {%>
								<div class="text-danger">IDかパスワードが間違っています</div>
							<%}%>
						</td>
					</tr>
					<tr>
						<td>ID</td>
					</tr>
					<tr>
						<td><input class="w-100 my-2" type="text" name="mail"></td>
					</tr>
					<tr>
						<td>パスワード</td>
					</tr>
					<tr>
						<td><input class="w-100 my-2" type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><Button class="my-2 btn btn-primary w-50" type="submit">ログイン</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="signUp" class="btn btn-secondary w-50">会員登録</a></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="mastersLogin" class="w-25">管理者ログイン</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>