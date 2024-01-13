<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div class="pagebody">
	<div class="page-body-container">
		<div class="page-body-header">
			<p>
				<i class="fa fa-arrow-left" style="font-size: 20px; color: white"></i>
				<a href="admin-detailExam?maBoDe=${maBoDe}" style="color: white">back</a> <i
					class="fa fa-plus-circle" style="font-size: 20px"></i> Import file
			</p>
		</div>
		<div class="row">
			<div class="container">
				<div class="col-sm-8">
					<h5>Thêm hình ảnh và file Excel câu hỏi cho bài thi:</h5>
					<form action="AdminUploadFile?id=${id}" method="post"
						enctype="multipart/form-data">
						<div class="custom-file">
							<input type="file" name="image"
								accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,image/*,.xls,audio/*"
								class="form-control" style="height: 100px" multiple="multiple">
						</div>
						<input type="submit" value="Đăng đề thi" class="btn-readmore"
							style="margin-top: 100px" />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>