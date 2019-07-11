<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="beans.UserMovieListBeans" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>映画一覧</title>
</head>
<body>
<% 	List<UserMovieListBeans> list = (List<UserMovieListBeans>)request.getAttribute("list");%>

	<form action="movieResavation" method="GET">
		<table>
<%		if( list != null){
			for(UserMovieListBeans listBeans : list){
%>
				<tr>
					<td><a href="movieResavation?showCode=listBeans.getMovieName()"><%listBeans.getMovieName();%></a></td>
				</tr>
<%			}
		}
%>
		</table>
	</form>

</body>
</html>