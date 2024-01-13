<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
	<div style="height: 50px"></div>
	<div class="testReading" id="testReading">
		<div class="navbar navbar-default navbar-fixed-top">
			<br>
			<div style="display: block;">
					<a href="admin-detailExam?maBoDe=${maBoDe}" id="backhome">&larr; Back</a>
			</div>

		</div>

		<div id="content" class="container-fluid fill">
			<form id="submitForm" name="submitForm">
				<div class="row">
					<div class="col-md-3 ">
						<!-- Placeholder - keep empty -->
					</div>				
					<div id="main" class="col-md-8 web-font">
						<c:forEach items="${listCauHoi}" var="cauhoi">
							<c:if test="${cauhoi.maCauHoi % 10 == 1}">
								<c:if test="${(cauhoi.maCauHoi + 41) % 41 != 1}"> <!-- audio xuống hàng trừ dòng đầu-->
									<br>
								</c:if>										
								<audio controls> 
									<source src="${pageContext.request.contextPath}/resources/file/audio/exam/${cauhoi.getPart().getAudio()}" type="audio/wav">
								</audio>	
							</c:if>
							<h4>${cauhoi.noiDungCauHoi}</h4>
							<div>
								<c:if test="${cauhoi.anhCauHoi != null}">
									<img alt="lỗi" src="${pageContext.request.contextPath}/resources/file/images/exam/${cauhoi.anhCauHoi}.png">
								</c:if>							 
							</div>
							<div>
								${((cauhoi.maCauHoi- 1) % 40) + 1}. <input type="text" id="${((cauhoi.maCauHoi- 1) % 40) + 1}" name="question${((cauhoi.maCauHoi- 1) % 40) + 1}" onclick="markColor(this.id)">
								<c:if test="${cauhoi.maCauHoi % 10 == 1}">	
								</c:if>
							</div>
						</c:forEach>					
						<br><br>
						<div id="answers">
							<h2 style="color: orange; font-weight: bold; margin-left: 42%;">ĐÁP ÁN</h2>
							<c:forEach items="${listCauHoi}" var="cauhoi">
								<span style="font-weight: bold;">${cauhoi.maCauHoi}. </span>
									<c:forEach items="${cauhoi.getListDapAn()}" var="dapan">						
										<h4 style="font-weight: bold; padding-left: 40px;"> ${dapan.noiDungDapAn} </h4>	
									</c:forEach>
							</c:forEach>
							
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="row" style="margin-left: 42%;">
			<h1 style="color: blue;">KẾT THÚC BÀI THI</h1>
		</div>
	</div>
</body>
</html>