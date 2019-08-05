<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.HtmlUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/masterMovieInsertListStyle.css">
<title>映画更新完了</title>
</head>
<%
String name=(String)request.getAttribute("name");
String description=(String)request.getAttribute("description");
String hpaddress=(String)request.getAttribute("hpaddress");
int errorFlag=(int)session.getAttribute("errorFlag");
if(errorFlag==0){
%>

<body>
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
<tr>
<th>HPアドレス</th>
<td>
<%=hpaddress %>
</td></tr>
</table>
5秒後に戻ります、戻らなければ<a href="masters_top">こちら</a><br>
<%}else{%>
登録できませんでした、DBの接続に問題があると考えられます<br>
5秒後に戻ります、戻らなければ<a href="masters_top">こちら</a>
<%} %>
</div>
  
<jsp:include page="./footer/mastersFooter.jsp"/>
</body>
<script>
setTimeout(function(){
  window.location.href = 'masters_top';
}, 5*1000);
</script>
</html>