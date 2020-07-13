<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="container">
		<h3 class="text-center " style="background-color: #b0e0e6">ユーザーログイン</h3>
		<h5 class="text-center">IDとPASSWORDを入力してください</h5>
		<form action="login" method="post">
			<div class="form-group">
				<label for="id">ID</label> <input type="text"
					class="form-control w-50 " name="name" placeholder="ID">
			</div>
			<div class="form=group">
				<label for="pass" class=>パスワード</label> <input type="password"
					class="form-control w-50" name="pass" placeholder="パスワード">
			</div>
			<br> <br>
			<button type="submit" class="btn btn-info mb-2  center-block">ログイン</button>
			<br> <br>
		</form>

		<p class="text-center">
				<button class="btn btn-primary"><a class="text-white" href="registry_user">新規登録</a></button>
		</p>
	</div>

</body>
</html>