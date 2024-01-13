<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


<body style="background-color: rgb(231, 231, 231);">
	<div class="pagebody">
		<div class="page-body-container">
			<div class="page-body-header">
				<p>
					<i class="fa fa-users" style="font-size: 20px"></i> Tất cả người
					dùng
				</p>
			</div>
			<div class="">
				<div class="success"
					style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messBan}</div>
				<div class="error"
					style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messFailBan}</div>
				<table class="tb-mana-post">
					<thead>
						<tr>
							<th>Username</th>
							<th>Email</th>
							<th>Ban</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${listMem}" var="mem" varStatus="Member">
							<tr>
								<td class="center">${mem.getUsername()}</td>
								<td class="center">${mem.getEmail()}</td>
								<td class="center"><a class="red"
									onclick="ban_user('${mem.getUsername()}')"
									style="cursor: pointer;"> <i class="fa fa-ban"
										style="font-size: 24px; color: red"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pagination">
					<ul>
						<c:if test="${numberpage == 1 && numberpage == maxpageid}">
							<li class="page-item disabled"><a class="page-link"
								href="AdminUserManager?pageid=${numberpage-1}">Trước</a></li>

							<li class="page-item disabled"><a class="page-link"
								href="AdminUserManager?pageid=${numberpage+1}">Sau</a></li>
						</c:if>
						<c:if test="${numberpage == 1 && numberpage != maxpageid}">
							<li class="page-item disabled"><a class="page-link"
								href="AdminUserManager?pageid=${numberpage+1}">Trước</a></li>

							<li class="page-item"><a class="page-link"
								href="AdminUserManager?pageid=${numberpage+1}">Sau</a></li>
						</c:if>
						<c:if test="${numberpage == maxpageid && numberpage!=1}">
							<li class="page-item"><a class="page-link"
								href="AdminUserManager?pageid=${numberpage-1}">Trước</a></li>

							<li class="page-item disabled"><a class="page-link" href="#">Sau</a></li>
						</c:if>

						<c:if test="${numberpage > 1 && numberpage < maxpageid}">
							<li class="page-item"><a class="page-link"
								href="AdminUserManager?pageid=${numberpage-1}">Trước</a></li>

							<li class="page-item"><a class="page-link"
								href="AdminUserManager?pageid=${numberpage+1}">Sau</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>


</body>
