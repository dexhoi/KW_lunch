<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="status.LunchStatus, status.StatusTagFactory" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<%
	String msg = "";
	LunchStatus status = (LunchStatus)request.getAttribute("status");
	if(status != null){
		StatusTagFactory factory = StatusTagFactory.getInstance();
		msg = factory.build(status);
	}
%>

</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<%= msg %>


	<div class="container">
		<h3 class="text-center " style="background-color: #b0e0e6">ユーザーログイン</h3>
		<h5 class="text-center">名前とパスワードを入力してください</h5>
		<form action="login" method="post">
			<div class="form-group">
				<label for="id">Name</label> <input type="text"
					class="form-control w-50 " name="name" placeholder="名前">
			</div>
			<div class="form=group">
				<label for="pass" class=>Password</label> <input type="password"
					class="form-control w-50" name="pass" placeholder="パスワード">
			</div>
			<br> <br>
			<button type="submit" class="btn btn-info mb-2  center-block">ログイン</button>
			<br> <br>
		</form>

		<hr>

		<form class="text-right" action="registry_user" method="get">
			<button class="btn btn-success" role="submit">新規登録</button>
		</form>

	</div>

</body>
</html>