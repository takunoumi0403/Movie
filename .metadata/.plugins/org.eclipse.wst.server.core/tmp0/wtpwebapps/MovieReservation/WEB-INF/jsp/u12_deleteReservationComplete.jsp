<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="beans.UserReservationBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%

%>

<body>
	<jsp:include page="./header/userHeader.jsp" />
	<div class="w-50 mx-auto text-center my-5">
		<h3><u>取り消し作業が完了しました。</u></h3>
		予約の取り消しが完了しました。
		<form action="uauth">
			<button type="submit" class="btn btn-primary  mt-4 mb-1">トップ画面へ戻る</button>
		</form>
		<form action="userReservationList">
			<button type="submit" class="btn btn-secondary my-1">予約一覧に戻る</button>
		</form>
	</div>
</html>
