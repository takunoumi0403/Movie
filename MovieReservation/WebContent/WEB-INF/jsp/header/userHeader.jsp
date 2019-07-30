<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="beans.UserInfoBeans" %>
<%
////////////////////////////////////////
//セッションからログイン情報を取得
	UserInfoBeans userInfoBeans = (UserInfoBeans)session.getAttribute("userInfoBeans");
%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<nav class="navbar navbar-dark bg-dark mb-3">
	<a class="navbar-brand" href="uauth">ＭＯＶＩＥ</a>

	<div class="text-light">
		<span><a href="movieList" class="text-light">上映一覧</a>　　</span>
		<span>
<%			if(userInfoBeans == null){ %>
				<a href="login" class="text-light">ログイン／会員登録　　</a>
<%			} else{%>
				<a href="myPage" class="text-light"><%=userInfoBeans.getUserName() %>さんのマイページ　　</a>
<%			} %>
		</span>
		<span><a href="logout" class="text-light">ログアウト</a></span>
	</div>
</nav>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>