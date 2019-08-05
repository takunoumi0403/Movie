<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.MovieRegistBeans" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.MovieTheaterRegistBeans" %>
<%@ page import="controller.HtmlUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/masterMovieInsertListStyle.css">
<title>映画登録完了</title>
</head>
<body>
<%

String name=(String)request.getAttribute("name");
String description=(String)request.getAttribute("description");
int time=(int)request.getAttribute("time");
String start=(String)request.getAttribute("start");
String end=(String)request.getAttribute("end");
List<MovieTheaterRegistBeans> MTRBeansList=(List<MovieTheaterRegistBeans>)request.getAttribute("MTRBeansList");

int errorFlag=(int)session.getAttribute("errorFlag");
if(errorFlag==0){
%>
<jsp:include page="./header/mastersHeader.jsp"/>
<div class="container center">
登録完了しました！<br>
<table border="1">
<tr>
<th>映画の名前</th>
<td>
<%=HtmlUtil.nl2be(name) %>
</td></tr>
<tr>
<th>映画の説明文</th>
<td>
<%=HtmlUtil.nl2be(description) %>
</td></tr>
<tr><th>映画上映時間</th><td>
<%=time %>
</td></tr>
<tr>
<th>映画上映開始日</th>
<td>
<%=start %>
</td></tr>
<tr>
<th>映画上映終了日</th>
<td>
<%=end%>
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
</table>
5秒後に戻ります、戻らなければ<a href="masters_top">こちら</a><br>
<%}else{%>
登録できませんでした、DBの接続に問題があると考えられます<br>
5秒後に戻ります、戻らなければ<a href="masters_top">こちら</a>
<%} %>
</div>
</body>
<script>
setTimeout(function(){
  window.location.href = 'masters_top';
}, 5*1000);
</script>
</html>