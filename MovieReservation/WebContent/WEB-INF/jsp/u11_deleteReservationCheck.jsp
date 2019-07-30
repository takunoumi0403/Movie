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
	UserReservationBeans beans = (UserReservationBeans) session.getAttribute("userReservationBeans");
	System.out.println(beans);
%>

<body>
	<jsp:include page="./header/userHeader.jsp" />
	<div class="w-75 mx-auto">
		<table class="table table-hover my-5">
			<thead>
				<tr>
					<td colspan="6" class="text-center text-danger"><h4>以下の予約を取り消します。</h4></td>
				</tr>
				<tr>
					<td>上映時間</td>
					<td>予約コード</td>
					<td>予約詳細コード</td>
					<td>映画名</td>
					<td>座席</td>
					<td>金額</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=beans.getShowDate()%></td>
					<td><%=beans.getReservationCode()%></td>
					<td><%=beans.getReservationDetailsCode()%></td>
					<td><%=beans.getMovieName()%></td>
					<td><%=beans.getSeatNumber()%></td>
					<td><%=beans.getFee()%></td>
				</tr>
			</tbody>
		</table>

		<form action="userReservationList">
			<button type="submit" class="btn btn-secondary w-25 mr-auto float-left">いいえ</button>
		</form>
		<form action="deleteUserReservationComplete">
			<button type="submit" class="btn btn-primary w-25 mr-auto float-right">はい</button>
		</form>
	</div>
</body>
</html>
