<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Danh sách bộ đề</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/paging.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.js"></script>
	
	<style type="text/css">
	.hidden {
		display: none;
	}
	
	.error-message {
		color: red;
	}
	
	.anchor {
		display: block;
		height: 115px; /*same height as header*/
		margin-top: -115px; /*same height as header*/
		visibility: hidden;
	}
	
	.imageExam {
		float: left;
		height: 150px;
		width: 250px;
		margin-bottom: 25px;
	}
	</style>

</head>
<body>
	<input id="baseUrl" value="${pageContext.request.contextPath}" style="display:none;"/>
	<div class="container">
		<!--PAGE TITLE-->
		<div class="span9" style="text-align: center">
			<div class="page-header">
				<h4 style="font-weight: bold;">DANH SÁCH BỘ ĐỀ</h4>
			</div>
		</div>

		<!-- /. PAGE TITLE-->
		<div class="row">

			<div class="span9">
				<c:if test="${fn:length(listBoDe) == 0 }">
					<h3>Không tìm thấy dữ liệu</h3>
				</c:if>

				<c:forEach items="${listBoDe}" var="bode">

					<div class="span9">
						<div class="span3">
							<c:if test="${bode.maBoDe % 2 == 0}">
								<img class="imageExam" src="${pageContext.request.contextPath}/resources/file/images/exam/${bode.maBoDe % 2 + 2}.examtest.jpeg" />
							</c:if>
							
							<c:if test="${bode.maBoDe % 2 == 1}">
								<img class="imageExam" src="${pageContext.request.contextPath}/resources/file/images/exam/${bode.maBoDe % 2}.minitest.png" />
							</c:if>
							
						</div>
						<div class="span1">
						</div>
						<div class="span5">
							<h4 class="content-heading"> ${bode.tenBoDe}</h4>
							
							<h3><a href="${pageContext.request.contextPath}/test-exam/findAllDeThi?mabode=${bode.maBoDe}">Xem các đề thi</a></h3>

						</div>


					</div>

				</c:forEach>

				<br>
				
			</div>
			
			<div class="span3">
				<div class="side-bar">

					<h3>DANH MỤC</h3>
					<ul class="nav nav-list">
						<li><a href="/listening-ielts/test-exam">LUYỆN ĐỀ NGHE</a></li>
					</ul>

				</div>
			</div>
		</div>
		<br>
		<br>
		<div class="row" style="padding: 0 30%">
			<span>page:</span>
	       <c:forEach begin="1" end="${numBoDeOfPage}" var="i">
	           <a style="color: #444342; text-decoration:underline; margin-left: 10px" href="${pageContext.request.contextPath}/test-exam?page=${i}">${i}</a>
	       </c:forEach>
		</div>
	</div>


	
</body>

</html>