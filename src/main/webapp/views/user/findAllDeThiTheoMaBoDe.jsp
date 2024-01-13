<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Danh sách đề thi</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/paging.css">
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-1.js"></script>
		
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">  
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
				<h4 style="font-weight: bold;">DANH SÁCH ĐỀ THI</h4>
			</div>
		</div>

		<!-- /. PAGE TITLE-->
		<div class="row">

			<div class="span9">
				<c:if test="${fn:length(listDeThi) == 0 }">
					<h3>Không tìm thấy dữ liệu</h3>
				</c:if>

				<c:forEach items="${listDeThi}" var="dethi" varStatus="loop">

					<div class="span9">
						<div class="span3">
							<c:if test="${dethi.maDeThi % 2 == 0}">
								<img class="imageExam" src="${pageContext.request.contextPath}/resources/file/images/exam/${dethi.maDeThi % 2 + 2}.examtest.jpeg" />
							</c:if>
							
							<c:if test="${dethi.maDeThi % 2 == 1}">
								<img class="imageExam" src="${pageContext.request.contextPath}/resources/file/images/exam/${dethi.maDeThi % 2}.minitest.png" />
							</c:if>
							
						</div>
						<div class="span1"></div>
						<div class="span5">
							<h4 class="content-heading" id="namebaithithu">${dethi.tenDeThi}</h4>
							<br>
							<button type="button" class="btn btn-primary btnHuongDanThi" value="${dethi.maDeThi}" data-madethi="${dethi.maDeThi}" data-toggle="modal" data-target="#examModal" >Hướng dẫn làm bài thi</button>
						</div>


					</div>

				</c:forEach>

				<br>
			</div>
			
			


			<div class="span3">
				<div class="side-bar">

					<h3>DANH MỤC</h3>
					<ul class="nav nav-list">
						<li><a href="/listening-ielts/test-exam">XEM TẤT CẢ BỘ ĐỀ</a></li>
					</ul>

				</div>
			</div>
		</div>
		<br>
		<br>
	</div>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- Modal -->
	<div class="modal fade" id="examModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content -->

			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">HƯỚNG DẪN LÀM BÀI THI</h4>
				</div>
				<div class="modal-body">
					<input class="hidden" id="idExamModal">
					<p>Bài thi gồm 4 part (40 câu hỏi - 40 phút) với 3 loại câu hỏi</p>
					<img style="float: left"
						src="https://img.icons8.com/nolan/64/000000/reading.png"> <br>
					<p>Loại 1: Multiple choice</p>
					<br> <img style="float: left"
						src="https://img.icons8.com/nolan/64/000000/reading.png"> <br>
					<p>Loại 2: Note/form completion</p>
					<br> <img style="float: left"
						src="https://img.icons8.com/nolan/64/000000/reading.png"> <br>
					<p>Loại 3: Matching and map</p>

					<br>
					<p>Bài thi được thực hiện sau khi xác nhận làm bài thi</p>

				</div>
			</div>


			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="btnLamBaiThi">Làm bài thi</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<script>
			    	$(document)
					.ready(function() {		
								
								var madethi;
								$('.btnHuongDanThi').click(function() {
							        madethi = $(this).val();
							    });
								
								$('#btnLamBaiThi').click(function() {
									if (madethi == undefined || madethi == null) {
										madethi = $('.btnHuongDanThi').val();
									}
									window.location.href = "/listening-ielts/doExam?madethi=" + madethi;

								});

							});
				</script>
			</div>

		</div>
	</div>

</body>
</html>

