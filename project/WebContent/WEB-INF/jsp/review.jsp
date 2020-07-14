<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/hosi.css">
<meta charset="UTF-8">
<title>レビューする</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="container">

		<h2>レビュー:<c:out value="${name}"/></h2>

		<form action="review" method="post">
			<input type="hidden" name="shopId" value="<c:out value="${shopId}"/>" />
			<div class="evaluation">
				<input id="star2" type="radio" name="score" value="3" /> <label
					for="star2"><span class="text">うまい</span>★</label> <input
					id="star3" type="radio" name="score" value="2" /> <label
					for="star3"><span class="text">ふつう</span>★</label> <input
					id="star4" type="radio" name="score" value="1" checked /> <label
					for="star4"><span class="text">まずい</span>★</label>
			</div>

			<button class="btn btn-success" role="submit">レビューする</button>
		</form>

	</div>

</body>
</html>