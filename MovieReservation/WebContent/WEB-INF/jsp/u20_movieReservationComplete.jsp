<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="beans.UserReservationBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
%>

<body>
	<jsp:include page="./header/userHeader.jsp"/>
	<div class="w-75 mx-auto text-center">
		<h3 class="mt-5"><u>予約が完了しました</u></h3>

		<form action="movieList"><button class="btn btn-primary mt-3 mb-1">上映一覧に戻る</button></form>
		<form action="uauth"><button class="btn btn-secondary my-1">トップ画面に戻る</button></form>
	</div>

</body>
</html>
