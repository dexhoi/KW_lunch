<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="container">
		<h3 class="text-center" style="background-color: #b0e0e6">新規ユーザー登録</h3>
		<h5 class="text-center">新規登録を行ってください</h5>
		<form action="registry_user" method="post">
			<div class="form-group">
				<label for="name">NAME：</label> <input type="text"
					class="form-control w-50 " name="name" placeholder="ニックネーム">
			</div>
			<div class="form=group">
				<label for="pass" class=>PASSWORD：</label> <input type="password"
					class="form-control w-50" name="pass" placeholder="パスワード">
			</div>
			<br> <br>
			<button type="submit" class="btn btn-info mb-2  text-center">登録</button>

		</form>

	</div>

	<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.bundle.js"></script>
</body>
</html>