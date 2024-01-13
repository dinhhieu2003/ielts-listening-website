<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta charset="utf-8">
<title></title>
</head>

<body style="background-color: rgb(231, 231, 231);">
	<div class="left-sidebar">
		<div class="side-bar">
			<ul class="side-bar-menu">
				<li><a href="#homeSubmenu1" data-toggle="collapse"
					aria-expanded="false" class="dropdown-toggle"><i
						class="fa fa-question-circle" style="font-size: 20px;"></i> Đề Thi</a>
					<ul class="collapse list-unstyled" id="homeSubmenu1">
						<li><a href="admin-allExam" id="125"><i class="fa fa-th-list"></i>
								Tất cả đề thi</a></li>
						<li><a href="AdminAddExam" id="125"><i class="fa fa-plus-circle"></i>
								Thêm bộ đề</a></li>
					</ul></li>
				<li><a href="#homeSubmenu2" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"><i
							class="fa fa-users" style="font-size: 20px;"></i> Người dùng</a>
						<ul class="collapse list-unstyled" id="homeSubmenu2">
							<li><a href="admin-usermanagement?pageid=1" id="125"><i
									class="fa fa-th-list"></i> Tất cả người dùng</a></li>
							<li><a href="admin-usermanagement_ban?pageid=1" id="125"><i
									class="fa fa-ban"></i> Danh sách cấm</a></li>
						</ul></li>

			</ul>
		</div>
	</div>

</body>
