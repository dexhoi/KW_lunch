<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List, dao.GenreDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/hosi.css">
</head>
<body>
	<form action="/registry_shop" method="post">
		<div class="container pt-3">
			<!-- 2分割列の設定 -->
			<div class="row">
				<div class="col">
					<label>店名</label><input class="form-control w-50" type="text"
						name="name" required />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>ジャンル</label>
					<select class="form-control" name="genre">
						<c:forEach var ="genre" items="${genres}" varStatus="status">
							<option value="<c:out value="${status.index}"/>">
								<c:out value="${genre}"/>
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>料金</label><input class="form-control w-50" type="number"
						name="price" value="1" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>提供時間</label><input class="form-control w-50" type="time"
						name="time" />
				</div>
			</div>
			<div class="row">
				<div class="form-inline">

					<label>定休日</label>

					<div class="col"><input class="form-control" type="checkbox" name="vac" value="1"><label>月曜日</label></div>
					<div class="col"><input class="form-control" type="checkbox" name="vac" value="2"><label>火曜日</label></div>
					<div class="col"><input class="form-control" type="checkbox" name="vac" value="3"><label>水曜日</label></div>
					<div class="col"><input class="form-control" type="checkbox" name="vac" value="4"><label>木曜日</label></div>
					<div class="col"><input class="form-control" type="checkbox" name="vac" value="5"><label>金曜日</label></div>
					<div class="col"><input class="form-control" type="checkbox" name="vac" value="6"><label>土曜日</label></div>
					<div class="col"><input class="form-control" type="checkbox" name="vac" value="7"><label>日曜日</label></div>

				</div>
			</div>
			<div class="row">
				<div class="col-sm">
					<br><br><label>評価</label>
				</div>
			</div>
			<div class="evaluation">

				<input id="star2" type="radio" name="score" value="3" /> <label
					for="star2"><span class="text">うまい</span>★</label> <input
					id="star3" type="radio" name="score" value="2" /> <label
					for="star3"><span class="text">ふつう</span>★</label> <input
					id="star4" type="radio" name="score" value="1" checked /> <label
					for="star4"><span class="text">まずい</span>★</label>

			</div>
			<button type="submit" class="btn btn-primary">追加</button>
		</div>
	</form>
</body>
</html>