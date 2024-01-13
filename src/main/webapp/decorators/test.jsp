<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bài test Listening IELTS</title>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<style>
	.paragraph {
		white-space: pre-wrap;
		word-break: break-word;
		text-align: justify;
		background: #f3f7fa;
		color: #222;
		font-size: 14px;
		font-style: 'Roboto';
	}
	
	#main {
		padding-top: 120px;
		overflow: hidden;
	}
	
	@media ( min-width : 767px) {
		#navigation {
			margin-top: 50px;
			position: fixed;
		}
	}
	
	.fix-scrolling {
		max-height: 450px;
		/*overflow-y: scroll;*/
	}
	
	.numberCircle {
		display: inline-block;
		width: 30px;
		height: 30px;
		border-radius: 50%;
		font-size: 15px;
		line-height: 25px;
		text-align: center;
		border: 2px solid #666;
		margin: 5px 5px 5px 15px;
	}
	
	#time {
		font-size: 25px;
		margin-left: 100px;
		color: green
	}
	
	#backhome {
		margin-left: 25px;
		text-decoration: none;
	}
	
	#btnSubmit {
		margin-bottom: 15px;
		margin-left: 15px;
	}
	
	#btnResult {
		margin-bottom: 15px;
		margin-left: 25px;
	}
	
	#btndoAgain {
		display: none;
		margin-bottom: 15px;
		margin-left: 40px;
	}
	
	.web-font {
		font-size: 15px;
		font-family: 'Arial';
	}
	</style>
	
</head>
<decorator:body></decorator:body>