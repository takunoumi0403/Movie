<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.UserInfoBeans" %>
<%--
<%@ page import="MovieReservation.beans.LoginInfoBeans" %>
<% LoginInfoBeans login = (LoginInfoBeans)session.getAttribute("loginInfo"); %>
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="header/css"></style>

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<%
UserInfoBeans loginInfo=(UserInfoBeans)session.getAttribute("loginInfo");%>
<div class="mheader">
	<ul>
		<li><a href="masters_top"><img src="img/logo.png" alt="サイトロゴ" width="58" height="38"></a></li>
		<li>～映画予約管理システム～</li>
		<li>株式会社 West Field ようこそ<%=loginInfo.getName() %>さん</li>

		<li><a href="logout">ログアウト</a></li>
	</ul>
</div>