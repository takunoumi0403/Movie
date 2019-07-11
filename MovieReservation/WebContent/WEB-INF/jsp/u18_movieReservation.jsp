<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%/*
	//座席の最大値を受け取る
	int maxSeatSpace = (int)request.getAttribute("maxSeatSpace");

	//全て空席状態の配列を作る
	int seat[] = new int[maxSeatSpace];
	for(int i = 0; i < seat.length; i++){
		seat[i] = 0;
	}

	//埋まっている座席を取得して、seat[]に反映する
	List<Integer> reservedSeatList = (List<Integer>)request.getAttribute("reservedSeatList");
	for(int reservedSeatNum : reservedSeatList){
		//空席を予約席に変更する。
		seat[reservedSeatNum] = 1;
	} */

	int maxSeatSpace = 62;

	int seat[] = new int[maxSeatSpace];
	for(int i = 0; i < seat.length; i++){
		seat[i] = 0;
	}

	int reservedSeat[] = {15,20,25,30,35};

	for(int a : reservedSeat){
		//空席を予約席に変更する。
		seat[a] = 1;
	}
%>

<body>
<form action="movieReservationCheck">
<center>
<h1>座席表</h1>
<form action="movieReservationCheck" method="get">
	<table border="1">
		<tr><td height="100px" colspan="20"><center>スクリーン</center></td></tr>
		<%try{ %>
			<% for(int i =0; i < (maxSeatSpace/20)+1; i++){ %>
			<%System.out.println(i); %>
			<tr>
				<%for(int j = 0; j < 20; j++){ %>
				<%System.out.println((i*20)+j); %>
					<% if(seat[(i*20)+j] != 1){ %>
						<td width="50px" height="100" style="background-color:skyblue;">
							<input type="checkbox" name="vacantSeat" value="<%=(i*20)+j%>" id="seat"><%=(i*20)+j+1 %>
						</td>
					<% }else{ %>
						<td style="background-color:silver;">
							<center><h6>予約済</h6></center>
						</td>
					<% } %>
				<%} %>
			</tr>
			<% } %>
		<%}catch(Exception e){ } %>
		<tr>
			<td style="text-align:left;"colspan="10"><input type="submit" style="width:100px; height:100px;" value="戻る"></form></td>
			<td style="text-align:right;" colspan="10"><input type="submit" style="width:100px; height:100px;" type="submit" value="決定"></form></td>
		</tr>
	</table>
</form>
</center>

</body>
</html>
