<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List, dao.GenreDAO, status.*"%>

<%
	StatusTagFactory factory = StatusTagFactory.getInstance();
	String msg = "";
	LunchStatus status = (LunchStatus) request.getAttribute("status");
	msg = factory.build(status);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/hosi.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<%=msg%>

	<form action="registry_shop" method="post">
		<div class="container pt-3">
			<div id="img"></div>

			<div class="row" id="img_show">
			</div>
			<hr>

			<div class="row">
				<div class="col">
					<label>店名[必須]</label><input class="form-control w-50" type="text"
						name="name" required />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>ジャンル[必須]</label> <select class="form-control w-50" name="genre"
						required>
						<c:forEach var="genre" items="${genres}" varStatus="status">
							<option value="<c:out value="${status.index + 1}"/>">
								<c:out value="${genre}" />
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>料金[必須]</label><input class="form-control w-50" type="number"
						name="price" value="250" min="1" required />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>提供時間[必須]</label><input class="form-control w-50" type="time"
						name="time" min="00:01" max="00:60" value="00:10" step="00:01" required />
				</div>
			</div>

			<div class="row">
				<div class="col">
					<label>住所[必須]:</label> <input class="form-control w-50" type="text"
						name="address" required />
				</div>
			</div>

			<hr>

			<div class="row">
				<div class="form-inline">

					<label>定休日</label>

					<div class="col">
						<input class="form-control" type="checkbox" name="vac" value="1"><label>月曜日</label>
					</div>
					<div class="col">
						<input class="form-control" type="checkbox" name="vac" value="2"><label>火曜日</label>
					</div>
					<div class="col">
						<input class="form-control" type="checkbox" name="vac" value="3"><label>水曜日</label>
					</div>
					<div class="col">
						<input class="form-control" type="checkbox" name="vac" value="4"><label>木曜日</label>
					</div>
					<div class="col">
						<input class="form-control" type="checkbox" name="vac" value="5"><label>金曜日</label>
					</div>
					<div class="col">
						<input class="form-control" type="checkbox" name="vac" value="6"><label>土曜日</label>
					</div>
					<div class="col">
						<input class="form-control" type="checkbox" name="vac" value="7"><label>日曜日</label>
					</div>

				</div>
			</div>

			<hr>

			<div class="row">
				<div class="col-sm">
					<br> <br> <label>評価[必須]</label>
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

			<hr>

			<div class="row">
				<br> <br> <label>画像アップロード</label> <input type="file"
					class="form-control-file" name="file" id="customFile"
					accept="image/*" onchange="toBase64(this)">
			</div>

			<hr />

			<div class="row pb-5">
				<button type="submit" class="form-control btn btn-primary w-50">追加する</button>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		idx = 0;
		const MAX_IMG = 5;

		function toBase64(img) {
			if (!img.files.length){
				return;
			}

			if(idx > MAX_IMG){
				alert('画像の最大アップロード枚数は5枚までです');
				return;
			}

			var root = document.getElementById("img");

			var imgDataElm = document.createElement("input");
			imgDataElm.type = "hidden";
			imgDataElm.id = "imgData_" + idx;
			imgDataElm.name = "imgData";

			root.appendChild(imgDataElm);

			var reader = new FileReader();

			var img = img.files[0];

			reader.onload = function(evt) {
				imgDataElm.value = reader.result;

				var imgShowElm = document.getElementById("img_show");
				var colElm = document.createElement("div");
				colElm.className = "col";
				var imgElm = document.createElement("img");
				imgElm.src = reader.result;
				imgElm.setAttribute("width", 100);
				imgElm.setAttribute("height", 100);

				colElm.appendChild(imgElm);
				imgShowElm.appendChild(colElm);
			};
			reader.onerror = function(error) {
				console.log("Error:", error);
			};
			reader.readAsDataURL(img);

			idx++;
		}
	</script>
</body>
</html>