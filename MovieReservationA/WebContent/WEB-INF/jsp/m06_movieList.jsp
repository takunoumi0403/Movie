<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.MovieListBeans" %>
<%@ page import="java.util.List" %>
<%@ page import="controller.HtmlUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/masterMovieInsertListStyle.css">
<title>映画一覧</title>
</head>
<body>

<%
List<MovieListBeans> movieList = (List<MovieListBeans>)session.getAttribute("movieList");
int ReleaseFlag=(int)request.getAttribute("ReleaseFlag");
%>
<!-- jspヘッダー場所 -->
<jsp:include page="./header/mastersHeader.jsp"/>

  
  <div class="container center">
  	<p>キーワード検索欄に映画名を入力すると該当する映画を表示します</p>
  
    <form action="movie_list_search" method="GET">
      <p>キーワード検索</p>
      <input type="text" name="keyword" >
      <input type="submit" value="検索"><br>
      <p>絞り込み</p>
      <p>
      	公開状況
      	<input type="radio" name="Release" value=0 <%if(ReleaseFlag==0){ %>checked="checked"<%} %>>全映画
        <input type="radio" name="Release" value=1 <%if(ReleaseFlag==1){ %>checked="checked"<%} %>>公開前
        <input type="radio" name="Release" value=2 <%if(ReleaseFlag==2){ %>checked="checked"<%} %>>公開中
        <input type="radio" name="Release" value=3 <%if(ReleaseFlag==3){ %>checked="checked"<%} %>>公開終了
      <p>
    </form>
    <table>
      <tr>
        <th>映画名</th><th>公開状況</th><th>更新</th><th>削除</th>
      </tr>
      <%for(int i=0;i<movieList.size();i++){ %>
      <%if(movieList.get(i).getShowFlag()){ %>
      <tr>
	 	<td><%=HtmlUtil.nl2be(movieList.get(i).getMovieName()) %></td><td><%=movieList.get(i).getShowStatus() %></td><td><a href="movie_ListUpdate?number=<%=i %>">更新</a></td><td><a href="movie_delete?number=<%=i %>" onclick="return deleteMovie();">削除</a></td>
      </tr>
      <%} }%>
    </table>
    <a href="masters_top">トップページに戻る</a>
  </div>
  <jsp:include page="./footer/mastersFooter.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script>


function deleteMovie(){
	if(window.confirm('選択した映画を削除しますがよろしいですか？')){
		if(window.confirm('本当によろしいですか？')){
			return true;
		}else{
			window.alert('キャンセルされました');
			return false;
		}
	}else{
		window.alert('キャンセルされました');
		return false;
	}
	
}
</script>
</body>
</html>