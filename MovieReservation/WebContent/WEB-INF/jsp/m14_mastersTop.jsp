<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者のトップページ</title>
<link rel="stylesheet" href="css/MastersStyle.css">
</head>
<body>
<jsp:include page="./header/mastersHeader.jsp"/>

  <article class="mastersTop">
    <p>操作を選んでください</p>
    <div">
    	<button style="background-color:#FFE0B2;" type="button" onclick="location.href='registration_list'">利用者予約確認</button>
    </div>
    <div>
    	<button style="background-color:#ffcdd2;" type="button" onclick="location.href='movie_regist'">映画登録</button></div>
    <div>
    	<button style="background-color:#BBDEFB;" type="button" onclick="location.href='movie_list'">映画一覧更新削除</button></div>
  </article>
  
<jsp:include page="./footer/mastersFooter.jsp"/>
</body>
</html>