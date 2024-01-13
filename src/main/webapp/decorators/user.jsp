<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>


<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-responsive.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script type="text/javascript src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript">   
</script>
</head>
<body>

	<!--Header
==========================-->

	<jsp:include page="/template/user/header.jsp"></jsp:include>

	<!--/End Headter-->

	
	<decorator:body></decorator:body>
	

	<!--Footer
==========================-->
	<jsp:include page="/template/user/footer.jsp"></jsp:include>
	<!--/.Footer-->


	<!-- Start Modal -->

	<div class="modal fade" id="openModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">DANH SÁCH LOẠT BÀI HƯỚNG DẪN</h4>
				</div>

				<div class="modal-body">

					<div class="media">
						<a class="pull-left"><img src="" id="image1" class="media-object"  /></a>
						<div class="media-body">
							<h3>
								<a href="" id="name1" name="name1"></a>
							</h3>
						</div>
					</div>

					<div class="media">
						<a class="pull-left"><img src="" id="image2" class="media-object"  /></a>
						<div class="media-body">
							<h3>
								<a href="" id="name2" name="name2"></a>
							</h3>
						</div>
					</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">Thoát</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->

</body>
</html>