<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Part" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.MovieRegistBeans" %>
<%@ page import="controller.HtmlUtil" %>
<%@ page import="beans.MovieTheaterRegistBeans" %>
<%@ page import="model.Date_Change" %>
<%@ page import="controller.HtmlUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/masterMovieInsertListStyle.css">
<title>映画登録確認画面</title>
</head>
<body>
<%
MovieRegistBeans MRBeans=(MovieRegistBeans)session.getAttribute("MRBeans");
List<MovieTheaterRegistBeans> MTRBeansList=(List<MovieTheaterRegistBeans>)session.getAttribute("MTRBeansList");
Date_Change DSC=new Date_Change();

%>
<jsp:include page="./header/mastersHeader.jsp"/>
<div class="container center">
<table border="1">
<tr><th>映画の名前</th><td>
<%=HtmlUtil.nl2be(MRBeans.getMovieName()) %>
</td></tr>
<tr>
<th>映画説明文</th><td>
<%=HtmlUtil.nl2be(MRBeans.getMovieDescription()) %>
</td></tr>
<tr>
<th>映画上映分</th><td>
<%=MRBeans.getMovieTime() %>
</td></tr>
<tr><th>映画上映開始日</th><td>
<%=DSC.StringChange(MRBeans.getStartDate()) %>
</td></tr>
<tr><th>映画上映終了日</th><td>
<%=DSC.StringChange(MRBeans.getEndDate()) %>
</td></tr>
<tr><th>シアター番号毎 上映開始時間</th><td>
<%for(int i=0;i<MTRBeansList.size();i++){ %>

<%=MTRBeansList.get(i).getTheaterNumber() %>
シアター  <br>
<%	for(int n=0;n<MTRBeansList.get(i).getTheaterStartHour().size();n++){ %>

<%=MTRBeansList.get(i).getTheaterStartHour().get(n)%>
時
<%=MTRBeansList.get(i).getTheaterStartMinute().get(n) %>
分<br>
<%	}%>
<br>
<%} %>
</td></tr>

<tr><th>HPアドレス</th><td>
<%=MRBeans.getMovieAddress() %>
</td></tr>
<tr><th>サムネイル名</th><td>
<%=MRBeans.getThumbnail() %>
</td></tr>

</table>

これでよろしいですか？<br>
<button onclick="history.back()">戻る</button><form action="regist_complete" method="POST"><input type="submit" value="登録"></form>
<!-- jQuery読み込み -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- サムネイル画像表示スクリプト -->
</div>
<jsp:include page="./footer/mastersFooter.jsp"/>
</body>
</html>