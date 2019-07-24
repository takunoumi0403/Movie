<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.UserInfoBeans" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	UserInfoBeans userInfoBeans = (UserInfoBeans)session.getAttribute("userInfoBeans");
%>

<body>

トップ画面でーす

<%=userInfoBeans.getUserCode() %>
<%=userInfoBeans.getUserMail() %>
<%=userInfoBeans.getUserPhone() %>
<%=userInfoBeans.getUserName() %>

</body>
</html>