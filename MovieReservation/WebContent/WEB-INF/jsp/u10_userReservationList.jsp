<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="beans.UserReservationBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約一覧</title>
</head>
<%
	List<UserReservationBeans> list = (List<UserReservationBeans>)request.getAttribute("list");
%>

<body>
	<jsp:include page="./header/userHeader.jsp"/>
	<div class="w-75 mx-auto">
		<table class="table table-hover" id="ReservationList">
			<thead>
				<tr>
					<td colspan="7" class="bg-secondary text-white">予約一覧</td>
				</tr>
				<tr>
					<td>上映時間</td>
					<td>予約コード</td>
					<td>予約詳細コード</td>
					<td>映画名</td>
					<td>座席</td>
					<td>金額</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<% for(UserReservationBeans beans : list) {%>
					<tr>
						<%session.setAttribute("userReservationBeans",beans); %>
						<td><%=beans.getShowDate() %></td>
						<td><%=beans.getReservationCode() %></td>
						<td><%=beans.getReservationDetailsCode() %></td>
						<td><%=beans.getMovieName() %></td>
						<td><%int seatNum = Integer.parseInt(beans.getSeatNumber())+1; %><%=seatNum %></td>
						<td><%=beans.getFee() %></td>
						<td><a href="deleteUserReservationCheck">削除する</a></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	</div>

<script>
    $(document).ready( function () {
        $('#ReservationList').bdt();
    });
</script>
</body>

</html>
