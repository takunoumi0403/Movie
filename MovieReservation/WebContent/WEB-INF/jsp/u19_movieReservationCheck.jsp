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
	<jsp:include page="./header/userHeader.jsp"/>
	<div class="w-75 mx-auto text-center">
		<table class="table table-bordered table-hover mt-5" id="ReservationList">
			<thead>
				<tr><td colspan="4"><h3>以下の情報で予約しますか？</h3></td></tr>
				<tr>
					<td>映画名</td>
					<td>上映時間</td>
					<td>シアターコード</td>
					<td>座席</td>
				</tr>
			</thead>
			<tbody>
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
			</tbody>
		</table>

<form action="movieReservationComplete"><button type="submit" class="btn btn-primary float-right">はい</button></form>
<form action="movieList"><button type="submit" class="btn btn-secondary float-left">キャンセル</button></form>

	</div>
<script>
    $(document).ready( function () {
        $('#ReservationList').bdt();
    });
</script>
</body>
</html>
