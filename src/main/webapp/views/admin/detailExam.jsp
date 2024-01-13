<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<div class="pagebody">
	<div class="page-body-container">
		<div class="page-body-header">
			<p>
				<i class="fa fa-arrow-left" style="font-size: 20px; color: white"></i>
				<a href="admin-allExam" style="color: white">back</a>
				<i class="fa fa-th-list" style="font-size: 20px"></i> Tất Cả Đề Thi
			</p>
		</div>
		<div class="">
			<div class="error"
				style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messExamFail}</div>
			<div class="success"
				style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messExam}</div>
			<table class="tb-mana-exam">
				<thead>
					<tr>
						<th>Mã đề thi</th>
						<th>Tên đề thi</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${listDeThi}" var="deThi" varStatus="Exam_info">
						<tr>
							<td class="center">${deThi.maDeThi}</td>
							<td class="center">
								<a href="admin-detailDeThi?maDeThi=${deThi.maDeThi}&maBoDe=${deThi.boDe.maBoDe}">
									${deThi.tenDeThi}
								</a>
							</td>
							<td class="center"><a class="red"
								onclick="delete_deThi(${deThi.maDeThi})" style="cursor: pointer;">
									<i class="fa fa-trash-o" style="font-size: 24px; color: red"></i>
							</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>