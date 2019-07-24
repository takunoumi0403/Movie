<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="beans.UserInfoBeans" %>
<%
////////////////////////////////////////
//セッションからログイン情報を取得
	UserInfoBeans userInfoBeans = (UserInfoBeans)session.getAttribute("userInfoBeans");
%>

<nav class="navbar navbar-dark bg-dark mb-3">
	<a class="navbar-brand" href="movieList">ＭＯＶＩＥ</a>

	<div class="text-light">
		<span><a href="movieList" class="text-light">上映一覧</a>　　</span>
		<span>
<%			if(userInfoBeans == null){ %>
				<a href="login" class="text-light">ログイン／会員登録</a>
<%			} else{%>
				<a href="userMyPage" class="text-light"><%=userInfoBeans.getUserName() %>さんのマイページ</a>
<%			} %>
		</span>
	</div>
</nav>