<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="model.User" %>
<!DOCTYPE html>

<%
	String userName = "";
	String currentUrl = request.getRequestURL().toString();
	if (!currentUrl.contains("login")) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
	request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else {
	userName = user.getName();
		}
	}
%>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  		<link rel="stylesheet" href="css/bootstrap.css">
  		<link rel="stylesheet" href="css/jquery-ui.css">
	</head>
		<body>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark pt-2" style="background-color:#e3f2fd;">
			  <div class="collapse navbar-collapse" id="Navber">
			    <ul class="navbar-nav mr-auto">
			      <li class="nav-item active">
			      	<p class="nav-link">ログイン名:<%= userName %></p>
			      </li>
			      <li class="nav-item active">
			        <a class="nav-link" href="logout">ログアウト</a>
			      </li>
			       <li class="nav-item active">
			        <a class="nav-link" href="search">トップに戻る</a>
			      </li>
			    </ul>
			  </div><!-- /.navbar-collapse -->
			</nav>
			<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
  			<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
		</body>
</html>