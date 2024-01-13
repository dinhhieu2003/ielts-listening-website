<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="pagebody">
	<div class="page-body-container">
		<div class="page-body-header">
			<p>
				<i class="fa fa-arrow-left" style="font-size: 20px; color: white"></i>
				<a href="admin-allExam" style="color: white">back</a> <i
					class="fa fa-plus-circle" style="font-size: 20px"></i> Import file
			</p>
		</div>
		<div class="row">
			<div class="container">
				<div class="error"
					style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messUploadFail}</div>
				<div class="success"
					style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messUpload}</div>
				<div class="col-sm-8">
					<h5>Nhập file excel có nội dung đề thi</h5>
					<form action="AdminUploadExcel" method="post"
						enctype="multipart/form-data" id="uploadForm">
						<input type="file" name="image"
							accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,image/*,.xls,audio/*"
							class="form-control" style="height: 100px" multiple="multiple">
						<input type="submit" value="Xác nhận" class="btn-readmore"
							style="margin-top: 100px" />
					</form>
				</div>
			</div>
		</div>

	</div>
</div>