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
	List<UserReservationBeans> list = (List<UserReservationBeans>)session.getAttribute("list");
	UserReservationBeans beans = null;
	int seatNum;
	int size = list.size();
%>

<body>
<table border="1" style="text-align:center;">
	<tr>
		<td>映画名</td>
		<td>上映時間</td>
		<td>シアターコード</td>
		<td>座席</td>
	</tr>
	<%beans = list.get(0); %>
	<tr>
		<td rowspan="<%=list.size()+1%>">
			<%= beans.getMovieName()%>
		</td>

		<td rowspan="<%=list.size()+1%>">
			<%= beans.getShowDate()%>
		</td>

		<td rowspan="<%=list.size()+1%>">
			<%= beans.getTheaterCode()%>
		</td>
	</tr>
<% for(UserReservationBeans beans1 : list) {%>
	<tr>
		<td>
			<%=beans1.getSeatNumber() %>
		</td>
	</tr>
<% } %>
</table>


以上の<%=size %>席を予約します <a href="movieReservationComplete">はい</a>　<a href="">いいえ</a>

</body>
</html>
