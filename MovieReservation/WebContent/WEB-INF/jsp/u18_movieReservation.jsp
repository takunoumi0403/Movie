<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
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
	}

	String showCode = (String)request.getAttribute("showCode");

%>

<body>
<h1>座席表</h1>
<form action="movieReservationCheck?showCode=<%=showCode %>" method="post">
	<table border="1">
		<tr><td height="100px" colspan="20">スクリーン</td></tr>
		<%try{ %>
			<% for(int i =0; i < (maxSeatSpace/20)+1; i++){ %>
			<tr>
				<%for(int j = 0; j < 20; j++){ %>
					<% if(seat[(i*20)+j] != 1){ %>
						<td width="50px" height="100" style="background-color:skyblue;">
							<input type="checkbox" name="vacantSeat" value="<%=(i*20)+j+1%>" id="seat"><%=(i*20)+j+1 %>
						</td>
					<% }else{ %>
						<td style="background-color:silver;">
							<h6>予約済</h6>
						</td>
					<% } %>
				<%} %>
			</tr>
			<% } %>
		<%}catch(Exception e){ } %>
		<tr>
			<td style="text-align:left;"colspan="10"><input type="submit" style="width:100px; height:100px;" value="戻る"></td>
			<td style="text-align:right;" colspan="10"><input type="submit" style="width:100px; height:100px;" type="submit" value="決定"></td>
		</tr>
	</table>
</form>

</body>
</html>
