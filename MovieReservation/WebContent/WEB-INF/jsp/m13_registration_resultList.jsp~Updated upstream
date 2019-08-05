<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.ReservationListBeans" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>利用者別予約一覧</title>
<link rel="stylesheet" href="css/mastersStyle.css">
</head>
<body id="registration_resultList">
<jsp:include page="./header/mastersHeader.jsp"/>
<%
	List<ReservationListBeans> list = (List<ReservationListBeans>)session.getAttribute("reservationList");
%>

  <p>下の検索欄に予約番号と予約者の名前を入力してください</p>

  <article class="RegistrationList">
    <form action="registration_resultList" method="GET" id="search_form">
      <p>予約番号検索</p>
      <input type="text" id="search_word" name="numbersearch" value="">
      <p>予約者名検索</p>
      <input type="text" id="search_word" name="namesearch" value="">
      <input type="submit" value="検索">

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


  <p>
    <% if( list == null){ %>
      <font color="red">予約番号と予約者名に一致する映画予約はありません</font>
	<% }else{ %>
	  予約番号と予約者名に一致する映画予約が見つかりました
	<% } %>
  </p>

<%--
  <form action="" method="post" class="js-post_include" target="#jsChangeContents">
	  <input type="text" name="keyword" value="" size="15" />
	  <input type="hidden" name="tpl" value="include/searchResultSample.html" />
	  <input type="hidden" name="bid" value="%{BID}" />
	  <input type="submit" name="ACMS_POST_2GET" value="検索" />
  </form>
 --%>

<div id="jsChangeContents">

  
  <table>
    <tr>
    	<th>予約番号</th>
    	<th>予約詳細番号</th>
    	<th>名前</th>
    	<th>映画名</th>
    	<th>シアター</th>
    	<th>上映開始時刻</th>
    	<th>券種</th>
    </tr>
    
<% for(ReservationListBeans reservation : list){ %>
    <tr>
    	<td><%=reservation.getReservation_code() %></td>
    	<td><%=reservation.getDetail_number() %></td>
    	<td><%=reservation.getName() %></td>
    	<td><%=reservation.getMovieName() %></td>
    	<td><%=reservation.getTheater() %></td>
    	<td><%=reservation.getShowDate() %></td>
    	<td><%=reservation.getFeeType() %></td>
    </tr>
  </table>
<% } %>
</div>

<jsp:include page="./footer/mastersFooter.jsp"/>
</body>
</html>