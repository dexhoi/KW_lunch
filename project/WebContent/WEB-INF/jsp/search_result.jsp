<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jquery-ui.css">
</head>
<body>
	<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.bundle.js"></script>


	<div class="container">
		<div class="alert alert-primary text-center" role="alert">

			<h2>
				検索結果：
				<c:out value="${keyword}" />
			</h2>
		</div>
		<hr>

		<c:forEach var="shop" items="${items}" varStatus="status">
			<div class="row">
				<div class="col">
					<p>
						店名:
						<c:out value="${shop.name}" />
					</p>
				</div>

				<div class="col">
					<p>
						ジャンル:
						<c:out value="${shop.genreTxt}" />
					</p>
				</div>

				<div class="col">
					<p>
						料金:
						<c:out value="${shop.price}" />
					</p>
				</div>


				<div class="col">
					<p>
						提供時間:
						<c:out value="${shop.offer}" />
					</p>
				</div>

				<div class="col">
					<p>
						住所:
						<c:out value="${shop.address}" />
					</p>
				</div>

				<div class="col">
					<form action="" method="post">
						<button type="submit" class="btn btn-primary">レビュー画面へ</button>
					</form>
				</div>

				<hr>
			</div>
		</c:forEach>


	</div>


</body>
</html>