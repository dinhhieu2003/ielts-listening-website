<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<div class="pagebody">
	<div class="page-body-container">
		<div class="page-body-header">
			<p>
				<i class="fa fa-arrow-left" style="font-size: 20px; color: white"></i>
				<a href="admin-home" style="color: white">back</a>
				<i class="fa fa-th-list" style="font-size: 20px"></i> Tất cả bộ đề
			</p>
		</div>
		<div class="">
			<div class="error"
				style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messExamFail}</div>
			<div class="error"
					style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messUploadFail}</div>
			<div class="success"
				style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messExam}</div>
			<div class="success"
					style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messUpload}</div>
			<table class="tb-mana-exam">
			
				<thead>
					<tr>
						<th>Mã bộ đề</th>
						<th>Tên bộ đề</th>
						<th>Xóa</th>
						<th>Thêm đề thi</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listBoDe}" var="boDe" varStatus="Exam_info">
						<tr>
							<td class="center">${boDe.maBoDe}</td>
							<td class="center"><a href="admin-detailExam?maBoDe=${boDe.maBoDe}">${boDe.tenBoDe}</a></td>

							<td class="center"><a class="red"
								onclick="delete_exam(${boDe.maBoDe})" style="cursor: pointer;">
									<i class="fa fa-trash-o" style="font-size: 24px; color: red"></i>
							</a></td>
							
							<td class="center"><a href="AdminAddDeThi?maBoDe=${boDe.maBoDe}" style="cursor: pointer;">
									<i class="fa fa-plus" style="font-size: 24px; color: green"></i>
							</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>