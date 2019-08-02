<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者別予約一覧</title>
</head>
<body>
  <p>下の検索欄に予約番号または予約者の名前を入力してください</p>

  <article>
    <form>
      <p>予約番号検索</p><br>
      <input type="text" name="numbersearch" value="">
      <p>予約者名検索</p><br>
      <input type="text" name="namesearch" value="">
      <input type="submit" value="検索">
    </form>
  </article>
  
  <p>
    <% if( "" != null){ %>
      <font color="red">予約番号または予約者名に一致する映画予約はありません</font>
	<% }else{ %>
	  予約番号または予約者名に一致する映画予約が見つかりました
	<% } %>
  </p>
  
  <table>
    <tr><th>予約番号</th><th>名前</th><th>映画名</th><th>シアター</th><th>上映開始時刻</th><th>券種</th></tr>
    <tr><td><%= %></td><td><%= %></td><td><%= %></td><td><%= %></td><td><%= %></td><td><%= %></td></tr>
  </table>
</body>
</html>