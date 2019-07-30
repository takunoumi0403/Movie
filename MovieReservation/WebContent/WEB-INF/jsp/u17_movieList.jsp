<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="beans.UserMovieListBeans" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>映画一覧</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/u17.css">
</head>
<body>
	<jsp:include page="./header/userHeader.jsp"/>

<% 	List<List<UserMovieListBeans>> oList = (List<List<UserMovieListBeans>>)request.getAttribute("oList");
	String[] dList = (String[])request.getAttribute("dList");%>
<%	String name = "";
	String theater = "";
	int index = 1;%>
<div class="container">
	<h2 class="mt-3 mb-3">上映一覧</h2>
	<form action="movieResavation" method="GET">

<%		if( oList != null){%>
			<ul class="nav nav-pills ml-5">
				  <li class="nav-item">
				    <a href="#tab1" class="nav-link active" data-toggle="tab"><%=dList[0]%></a>
				  </li>
				  <li class="nav-item">
				    <a href="#tab2" class="nav-link" data-toggle="tab"><%=dList[1]%></a>
				  </li>
				  <li class="nav-item">
				    <a href="#tab3" class="nav-link" data-toggle="tab"><%=dList[2]%></a>
				  </li>
			</ul>
			<div class="tab-content">

<%			for(List<UserMovieListBeans> iList : oList){%>
				<div id="tab<%=index %>" class="tab-pane<%if(index==1){%> active<%}%> ml-5">
				<h5 class="mt-3"><%=(iList.get(0)).getMovieName() %></h5>
<%				name = (iList.get(0)).getMovieName();
				theater = (iList.get(0)).getTheaterCode();%>

				<ul class="list-group list-group-horizontal">
					<li class="list-group-item text-center mr-2 mb-1">シアター<br><%=(iList.get(0)).getTheaterCode() %></li>
<%				if( iList != null){
					for(UserMovieListBeans beans : iList){%>

<% 						if(!(beans.getMovieName().equals(name))){%>
							</ul>
								<h5 class="mt-3"><%= beans.getMovieName() %></h5>
							<ul class="list-group list-group-horizontal">
								<li class="list-group-item text-center mr-2 mb-1">シアター<br><%=beans.getTheaterCode() %></li>
<% 						}else if(!(beans.getTheaterCode().equals(theater))){%>
							</ul>
							<ul class="list-group list-group-horizontal">
								<li class="list-group-item text-center mr-2 mb-1">シアター<br><%=beans.getTheaterCode() %></li>
<%						} %>

						<li class="list-group-item text-center mr-2 mb-1">

<%							if(beans.getSeatSpace() == 0){ %>
								<span class="text-danger h4">×</span>
								<br><%=beans.getShowTime()%>
<%							} else{%>
								<a href="movieReservation?showCode=<%=beans.getShowCode() %>">
<%								if(beans.getSeatSpace() < 20){%>
									<span class="text-warning h4">△</span>
<%								}else{ %>
									<span class="text-info h4">○</span>
<%								} %>
								<br><%=beans.getShowTime()%></a>
<%							} %>

<%						name = beans.getMovieName();
						theater = beans.getTheaterCode();
					}
				}%>
				</ul>
				</div>
				<%index++; %>
<%			}%>
			</div>
<%		}%>

	</form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>