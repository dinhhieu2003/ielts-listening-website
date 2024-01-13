<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!-- Search -->
<div class="container">

	<div class="row">

		<br>
		<div class="span12">
			<div class="navbar  pull-right">
				<div id="size">
					<form name="myform">						
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End search -->

<div class="container" id="resultsearch">
<input style="display:none;" id ="nameUser" value=""/>
<input style="display:none;" id="baseUrl" value="${pageContext.request.contextPath}">
	<!--Carousel
 ==================================================-->
	<!-- slide 1 là để cứng. 2 slide còn lại dùng for each. load từ database lên -->
	<div id="myCarousel" class="carousel slide">
		<div class="carousel-inner">

			<div class="active item">
				<div class="container">
					<div class="row">

						<div class="span6">
							<div class="carousel-caption">
								<h1>Đào tạo chất lượng</h1>
								<p class="lead">Chúng tôi cung cấp cho các bạn những kiến
									thức tốt nhất.</p>
									<a class="btn btn-large btn-primary" href="#"
										 id="modal1">Tham gia ngay</a>
							</div>
						</div>

						<div class="span6">
							<img
								src="${pageContext.request.contextPath}/resources/file/images/slide/aaa.jpg"
								alt="img not found aab" />
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- Carousel nav -->
		<a class="carousel-control left " href="#myCarousel"
			data-slide="prev"><i class="icon-chevron-left"></i></a> <a
			class="carousel-control right" href="#myCarousel" data-slide="next"><i
			class="icon-chevron-right"></i></a>
		<!-- /.Carousel nav -->

	</div>
	<!-- /Carousel -->

	<!-- Feature 
 ==============================================-->


	<div class="row feature-box">
		<div class="span12 cnt-title">
			<h1>Cung cấp các giao diện học và thi thân thiện</h1>
		</div>

		<div class="span4">
			<img
				src="${pageContext.request.contextPath}/resources/file/images/feature-vocabulary1.jpg">
			<p>Các bài hướng dẫn đơn giản, dễ hiểu.</p>

		</div>

		<div class="span4">
			<img
				src="${pageContext.request.contextPath}/resources/file/images/feature-listenandread.jpg">
			<p>Sử dụng các dạng bài tập thường xuyên xuất hiện.</p>
		</div>

		<div class="span4">
			<img
				src="${pageContext.request.contextPath}/resources/file/images/feature-lamdethithu.jpg"
				height="170px" width="270px">
			<p>Cập nhật, đổi mới liên tục, sát với đề thi thật nhất.</p>

		</div>
	</div>


	<!-- /.Feature -->

	<div class="hr-divider"></div>

	<!-- Row View -->


	<div class="row">
		<div class="span8">
			<img
				src="${pageContext.request.contextPath}/resources/file/images/background3.png">
		</div>

		<div class="span4">
			<!--   <img class="hidden-phone" src="Template/Frontend/img/icon4.png" alt="img not found"> -->
			<h1 align="center">Tin cậy - uy tín</h1>
			<p align="justify">Mỗi năm, có hàng nghìn lượt học viên đã tham
				gia thi tiếng Anh tại web và đạt kết quả như ý muốn. Do đó,
				chúng tôi tự hào là một trong những website ngoại ngữ hàng đầu,
				là địa chỉ tin cậy của bạn. Đừng ngần ngại liên hệ với chúng tôi
				nếu có những đánh giá nào khác.</p>

		</div>
	</div>


</div>
