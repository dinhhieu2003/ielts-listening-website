<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>

<!-- Font awesome -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath}/resources/admin/css/style.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/resources/admin/js/main.js"></script>

<script type="text/javascript"> /* intro loading */
	document.onreadystatechange = function() {
		var state = document.readyState
		if (state == 'interactive') {
			document.getElementById('contents').style.display = "none";
		} else if (state == 'complete') {
			setTimeout(function() {
				document.getElementById('interactive');
				document.getElementById('load').style.display = "none";
				document.getElementById('contents').style.display = "block";
			}, 1000);
		}
	}
</script>

<script type="text/javascript">
	function ban_user(i) {
		var r = confirm("Bạn có chắc chắn muốn cấm người dùng này không?");
		if (r == true) {
			window.location = "AdminUserBan?username=" + i;
		}
	}
</script>

<script type="text/javascript">
function unban_user(i) {
	var r = confirm("Bạn có chắc chắn muốn cho phép người dùng này không?");
	if (r == true) {
		window.location = "AdminUserUnban?username="+i;
	}
}
</script>

<script type="text/javascript">
function delete_exam(i) {
	var r = confirm("Bạn có chắc chắn muốn xóa đề thi này không?");
	if (r == true) {
		window.location = "AdminDeleteExam?id="+i;
	}
}
</script>

<script type="text/javascript">
function delete_deThi(i) {
	var r = confirm("Bạn có chắc chắn muốn xóa đề thi này không?");
	if (r == true) {
		window.location = "AdminDeleteDeThi?id="+i;
	}
}
</script>

<script>
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>

</head>

<body style="background-color: rgb(231, 231, 231);">
	<div id="load"
		class="introLoading introLoader gifLoader theme-dark bubble">
		<div id="introLoaderSpinner" class="gifLoaderInner" style=""></div>
	</div>
	<div class="main-container" id="contents">
			<!--Header
			==========================-->

			<jsp:include page="/template/admin/header.jsp"></jsp:include>

			<!--/End Header-->

		<!-- Menu bên trái trang web -->
		
		<jsp:include page="/template/admin/menu.jsp"></jsp:include>

		<!-- Kết thúc Menu bên trái trang web -->
		<decorator:body></decorator:body>
	</div>

</body>

</html>