<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="container" style="max-width:1400px;">
		<div class="alert alert-primary text-center" role="alert">

			<h2>
				検索結果：
				<c:out value="${keyword}"/> <c:out value="${size}"/>件
			</h2>
		</div>
		<hr>

		<c:forEach var="shop" items="${shops}" varStatus="status">
			<div class="row">
				<div class="col-sm">
					<p>
						店名:
						<c:out value="${shop.name}" />
					</p>
				</div>

				<div class="col-sm">
					<p>
						ジャンル:
						<c:out value="${shop.genreTxt}" />
					</p>
				</div>

				<div class="col-sm">
					<p>
						料金:
						<c:out value="${shop.price}" />
					</p>
				</div>


				<div class="col-sm">
					<p>
						提供時間:
						<c:out value="${shop.offer}" />
					</p>
				</div>

				<div class="col-sm">
					<p>
						住所:
						<c:out value="${shop.address}" />
					</p>
				</div>

				<div class="col-sm">
					<p>
						登録者:
						<c:out value="${shop.userName}"/>
					</p>
				</div>

				<div class="col-sm">
					<p>
						レビュー:
						<fmt:formatNumber value="${shop.scoreAVG}" maxFractionDigits="2" />
					</p>
				</div>

				<div class="col-sm">
					<form action="review" method="get">
						<input type="hidden" name="shopId" value= "<c:out value="${shop.id}"/>">
						<button type="submit" class="btn btn-success">レビューする</button>
					</form>
				</div>
			</div>
			<hr/>
		</c:forEach>
	</div>

</body>
</html>