<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.UserInfoBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<%
	UserInfoBeans userInfoBeans = (UserInfoBeans) session.getAttribute("userInfoBeans");
%>

<body>
	<jsp:include page="./header/userHeader.jsp" />
	<div id="carousel-1" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="#carousel-1" data-slide-to="0" class="active"></li>
			<li data-target="#carousel-1" data-slide-to="1"></li>
			<li data-target="#carousel-1" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<a href="https://meitantei-pikachu.jp/">
					<img class="d-block w-50 mx-auto" src="https://i.ytimg.com/vi/DGEme-q3D78/maxresdefault.jpg" alt="First slide">
				</a>
			</div>
			<div class="carousel-item">
				<a href="https://www.disney.co.jp/movie/aladdin.html">
					<img class="d-block w-50 mx-auto" src="https://i.ytimg.com/vi/U8pIQ4lJZ1c/maxresdefault.jpg" alt="Second slide">
				</a>
			</div>
			<div class="carousel-item">
				<a href="http://shin-godzilla.jp/">
					<img class="d-block w-50 mx-auto" src="https://moviework-orenchi.com/wp-content/uploads/2019/05/godzilla-1280x720.jpg" alt="Third slide">
				</a>
			</div>
		</div>
		<a class="carousel-control-prev w-25 mx-auto" href="#carousel-1" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next w-25 mx-auto" href="#carousel-1" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<div class="news w-50 my-5 mx-auto">
		<h4>新着情報</h4>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">
				<div class="news-date">7月14日</div>
				<div class="news-subject">　名探偵ピカチュウ上映中！</div>
			</li>
			<li class="list-group-item">
					<div class="news-date ">7月13日</div>
					<div class="news-category">　日本語字幕付き上映のご案内</div>
			</li>
		</ul>
	</div>




</body>
</html>