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
	List<UserReservationBeans> list = (List<UserReservationBeans>)request.getAttribute("list");
%>

<body>
<table border="1" style="text-align:center;">
	<tr>
		<td>上映時間</td>
		<td>予約コード</td>
		<td>予約詳細コード</td>
		<td>映画名</td>
		<td>座席</td>
		<td>金額</td>
	</tr>
<% for(UserReservationBeans beans : list) {%>
	<tr>
		<td><%=beans.getShowDate() %></td>
		<td><%=beans.getReservationCode() %></td>
		<td><%=beans.getReservationDetailsCode() %></td>
		<td><%=beans.getMovieName() %></td>
		<td><%int seatNum = Integer.parseInt(beans.getSeatNumber())+1; %><%=seatNum %></td>
		<td><%=beans.getFee() %></td>
		<td><a href="deleteUserReservation?reservationCode=<%=beans.getReservationCode() %>&reservationDetailsCode=<%=beans.getReservationDetailsCode() %>">削除する</a></td>
	</tr>
<% } %>
</table>


</body>
</html>
