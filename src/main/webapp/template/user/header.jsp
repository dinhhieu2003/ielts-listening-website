<%@page import="com.listening_ielts.entity.User"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">


<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'  />" />

<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap-responsive.min.css'  />" />
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'  />" />
<script src="http://code.jquery.com/jquery.js"></script>
<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<script src="${pageContext.request.contextPath}/resources/js/client/home.js"></script>
<script type="text/javascript"> 
 function openModal(){
 	$('#myModal').modal();
 }    
</script>
<style>
.radio-inline {
	display: inline-flex;
	padding-left: 35px;
}

input[type=radio] {
	margin-right: 5px;
}

h3 {
	margin: 0;
}
</style>
</head>

<body>
	<%
		if(session != null && session.getAttribute("account") != null ) {
			User account = (User)session.getAttribute("account");
			String username = account.getUsername();
			request.setAttribute("username", username);
		} 
	%>
	<!--HEADER ROW-->
	<div id="header-row">
		<div class="container">
			<div class="row">
				<!--LOGO-->
				<div class="span3">
					<a class="brand" href="/listening-ielts/home"><img src="${pageContext.request.contextPath}/resources/file/images/logo-web.jpg" alt="logo-web"/>GROUP 3</a>
					
				</div>
				<!-- /LOGO -->

				<!-- MAIN NAVIGATION -->
				<div class="span9">
					<div class="navbar  pull-right">
						<div class="navbar-inner">
							<a data-target=".navbar-responsive-collapse" data-toggle="collapse"
								class="btn btn-navbar"><span class="icon-bar"></span><span
								class="icon-bar"></span><span class="icon-bar"></span></a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<c:if test="${empty username}">
										<li class="active"><a href="/listening-ielts/home">Trang chủ</a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown">Luyện Tập <b class="caret"></b></a>
											<ul class="dropdown-menu">
												<li><a href="/listening-ielts/login" class="doExam" id="doExam">Luyện đề thi</a></li>
											</ul></li>
										<c:if test="${empty username}">
											<li><a href="<%=request.getContextPath()%>/login">Đăng nhập</a></li>
										</c:if>
										
									</c:if>


									<c:if test="${not empty username}">
										<li class="active"><a href="/listening-ielts/home">Trang chủ</a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown">Luyện Tập <b class="caret"></b></a>
											<ul class="dropdown-menu">
												<li><a href="/listening-ielts/test-exam">Luyện đề thi</a></li>
											</ul></li>

										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown">${username}<b class="caret"></b></a>
											<ul class="dropdown-menu">
												<li><a href="<%=request.getContextPath()%>/logout">Đăng xuất</a></li>
											</ul></li>
									</c:if>
								</ul>
							</div>

						</div>
					</div>
				</div>
				<!-- MAIN NAVIGATION -->
			</div>
		</div>
	</div>