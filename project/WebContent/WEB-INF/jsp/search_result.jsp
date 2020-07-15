<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.ImageDAO, model.Shop, java.util.List, java.io.File" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="container" style="max-width: 1400px;">
		<div class="alert alert-primary text-center" role="alert">

			<h2>
				検索結果：
				<c:out value="${keyword}" />
				<c:out value="${size}" />
				件
			</h2>
		</div>
		<hr>

		<c:forEach var="shop" items="${shops}" varStatus="status">

			<div class="row">

				<div class="col-sm">

					<div id="carouselOption1" class="carousel slide mx-auto" data-ride="carousel">
						<!-- スライドさせる画像の設定 -->
						<div class="carousel-inner">
							<%
								ImageDAO imgDAO = new ImageDAO();
								Shop shop = (Shop)pageContext.findAttribute("shop");
								File temp = (File)request.getServletContext().getAttribute("javax.servlet.context.tempdir");
								List<String> imgs = imgDAO.getImgDataByShopId(shop.getId(), temp);

								boolean flag = true;
								for(String img : imgs){

									if(flag){
										flag = false;
										out.println("<div class='carousel-item active'>");
									}else{
										out.println("<div class='carousel-item'>");
									}

									String imgElm = String.format("<img width='200' height='200' src=%s>", img);
									out.println(imgElm);
									out.println("</div>");
								}
							%>
						</div>


						<!-- スライドコントロールの設定 -->
						<!--
						<a class="carousel-control-prev" href="#carouselOption1" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						 <span class="sr-only">前へ</span>
						</a>
						<a class="carousel-control-next" href="#carouselOption1" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">次へ</span>
						</a>
						 -->
					</div>


				</div>

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
						<c:out value="${shop.userName}" />
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
						<input type="hidden" name="shopId"
							value="<c:out value="${shop.id}"/>">
						<button type="submit" class="btn btn-success">レビュー</button>
					</form>
				</div>
			</div>
			<hr />
		</c:forEach>
	</div>

</body>
</html>