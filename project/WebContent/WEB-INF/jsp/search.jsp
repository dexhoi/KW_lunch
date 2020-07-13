<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP</title>
</head>
<body style="background-color: #ffe4c4">
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<div class="container pt-5 text-center">
		<h1 class="text-center">今日の瓦町ごはん</h1>

		<form action="search" class="form-inline" method="post">
			<div class="row">


				<a class="pt-5 ">キーワード：</a>
				<div class="col pt-5">
					<label class="sr-only" for="inlineFormInput">名前</label> <input
						name="keyword" type="text" class="form-control" placeholder="店名"
						required> <label class="sr-only"
						for="inlineFormInputGroup">ユーザー名</label>

				</div>

				<div class="col pt-5">
					<button type="submit" class="btn btn-primary mb-2">検索</button>
				</div>
			</div>
		</form>

		<hr>

		<form action="search" method="post" class="form-inline">
			<div class="row">

				<div class="form-check form-check-inline">
					<label class="form-check-label pr-3">ジャンル：</label> <input
						class="form-check-input" type="radio" name="genre" value="1">
						 <label class="form-check-label">ラーメン</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="2">
					<label class="form-check-label">うどん</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="3">
					<label class="form-check-label">ごはん</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="4">
					<label class="form-check-label">カレー</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="5">
					<label class="form-check-label">中華</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="6">
					<label class="form-check-label">洋食</label>
				</div>
				<div class="col">
					<button type="submit" class="btn btn-primary mb-2">検索</button>
				</div>

			</div>
		</form>
		<br> <br>

		<h4 class="pt-5">あなたのおすすめ瓦町ランチを教えてください！</h4>
		<br>

		<button class="btn btn-warning mb-2 text-white w-50"><a class="text-white" href="registry_shop">教える</a></button>

	</div>

</body>
</html>