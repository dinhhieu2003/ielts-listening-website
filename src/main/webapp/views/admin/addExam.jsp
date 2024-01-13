<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="pagebody">
	<div class="page-body-container">
		<div class="page-body-header">
			<p>
				<i class="fa fa-arrow-left" style="font-size: 20px; color: white"></i>
				<a href="admin-home" style="color: white">back</a>
				<i class="fa fa-plus-circle" style="font-size: 20px"></i> 
				Thêm bộ đề
			</p>
		</div>

		<div class="row">
			<div class="container">
				<div class="col-sm-8">
					<form action="AdminAddExam" method="POST"
						enctype="application/x-www-form-urlencoded">
						<div class="error">${messExamFail}</div>
						<div class="add-post-body">
							<div class="add-content">
								<h5>Tên bộ đề:</h5>
								<input class="form-control" type="text" name="title" id="title"
									placeholder="Tên bộ đề" required maxlength="200">
							</div>

							<div class="add-button">
								<input type="submit" value="Xác nhận" class="btn-readmore" style="" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>