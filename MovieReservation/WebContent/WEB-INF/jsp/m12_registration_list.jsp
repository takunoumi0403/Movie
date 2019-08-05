<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者別予約一覧</title>
<link rel="stylesheet" href="css/mastersStyle.css">
</head>
<body>
<%
	String error = (String)request.getAttribute("error");
%>
<jsp:include page="./header/mastersHeader.jsp"/>

  <p>下の検索欄に予約番号と予約者の名前を入力してください</p>

  <article class="mRegistrationList">
    <form action="registration_resultList" method="GET" id="search_form">
	    <table style="border: 3px; background-color:#80D8FF;">
	      <tr><th>予約番号検索</th></tr>
	      <tr><td><input type="text" id="search_word" name="numbersearch" value=""></td></tr>
	      <tr><th>予約者名検索</th></tr>
	      <tr><td><input type="text" id="search_word" name="namesearch" value=""></td></tr>
	      <tr><td><input type="submit" value="検索"></td></tr>
	    </table>
	    <% if(false){ %>
	    <p>予約番号と予約者名に一致する映画予約はありません</p>
	    <% } %>

<!-- jquery読み込み -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>

	<script>
		$(function(){
		    // 1.フォーム要素の取得
		    var search_form = $("#search_form");
		    // 2.フォームのsubmitイベントを取得
		    search_form.submit(function(){
		        // 3.入力されているキーワードを取得し、正規表現により未入力かどうかを判別する
		        var keyword = $('input[id=search_word]').val();
		        if(keyword.match(/^[ \r\n\t]*$/)){
		            return false;
		        }
		    });
		});
	</script>

    </form>
  </article>

<jsp:include page="./footer/mastersFooter.jsp"/>
</body>
</html>