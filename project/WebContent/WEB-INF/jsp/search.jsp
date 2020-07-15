<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="status.LunchStatus, status.StatusTagFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP</title>
<%
	String msg = "";
	LunchStatus status = (LunchStatus)request.getAttribute("status");
	if(status != null){
		StatusTagFactory factory = StatusTagFactory.getInstance();
		msg = factory.build(status);
	}
%>

<style type="text/css">
img{
border-radius:30px;
}
</style>
</head>

<body style="background-color: #ffe4c4">
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>

	<%= msg %>

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
				<label class="form-check-label pr-3">ジャンル：</label>
					<input class="form-check-input" type="radio" name="genre" value="1" checked>
					<label class="form-check-label"><div style="font-size: 0;">
							<figure style="display: inline-block; position: relative;">
								<img src="img/udon3.jpeg" width="110px" height="110px">
								<figcaption
									style="position: absolute; top: 62px; left: 15px; font-size: 26px; color: #f0ffff;font-weight: bold;">うどん</figcaption>
							</figure>
						</div></label>
				</div>

				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="2">
					<label class="form-check-label"><div style="font-size: 0;">
							<figure style="display: inline-block; position: relative;">
								<img src="img/lamen.jpg" width="110px" height="110px">
									<figcaption
										style="position: absolute; top: 60px; left:2px; font-size: 26px; color: #f0ffff; font-weight: bold; ">ラーメン</figcaption>
							</figure>
						</div></label>
				</div>

				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="3">
					<label class="form-check-label"><div style="font-size: 0;">
					<figure style="display: inline-block; position: relative;">
							<img src="img/teishoku.jpg" width="110px" height="110px">
						<figcaption
									style="position: absolute; top: 62px; left:15px;font-size: 26px; color: #f0ffff; font-weight: bold;">和食</figcaption>
							</figure>
						</div></label>
				</div>

				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="4">
					<label class="form-check-label"><div style="font-size: 0;">
					<figure style="display: inline-block; position: relative;">
							<img src="img/chinese3.jpg" width="110px" height="110px">
						<figcaption
									style="position: absolute; top: 62px; left:28px;font-size: 26px; color:#f0ffff; font-weight: bold;">中華</figcaption>
							</figure>
						</div></label>
				</div>

				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="5">
					<label class="form-check-label"><div style="font-size: 0;">
					<figure style="display: inline-block; position: relative;">
							<img src="img/youshoku.jpeg" width="110px" height="110px">
							<figcaption
									style="position: absolute; top: 62px; left:28px;font-size: 26px; color: #f0ffff; font-weight: bold;">洋食</figcaption>
							</figure>
						</div></label>
				</div>

				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genre" value="6">
					<label class="form-check-label"><div style="font-size: 0;">
					<figure style="display: inline-block; position: relative;">
							<img src="img/carry2.jpg" width="110px" height="110px">
						<figcaption
									style="position: absolute; top: 62px; left:15px;font-size: 26px; color: #f0ffff; font-weight: bold;">カレー</figcaption>
							</figure>
						</div></label>
				</div>


				<div class="col">
					<button type="submit" class="btn btn-primary mb-2">検索</button>
				</div>

			</div>
		</form>
		<br> <br>

		<h4 class="pt-5">あなたのおすすめ瓦町ランチを教えてください！</h4>
		<br>

		<form action="registry_shop" method="get">
			<button class="btn btn-warning mb-2 text-white w-50" role="submit">教える</button>
		</form>


	</div>

</body>
</html>