<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String erro = (String) request.getParameter("erro");
	%>
	<%
		if (erro != null) {
	%>
	<p class="ems">IDかパスワードが間違っています</p>
	<%
		}
	%>
	<div id="main">
		<form action="auth" method="post">
			<table class="" tabletable-bordered">
				<tr>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="ログイン"></td>
				</tr>

			</table>


		</form>

	</div>
</body>
</html>