<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="checkboxB">
<%for(int i = 0; i < 20; i++){ %>
	<input type="checkbox" value="<%=i %>" name="checkbox">
<%} %>
<input type="submit" value="送信">
</form>

</body>
</html>