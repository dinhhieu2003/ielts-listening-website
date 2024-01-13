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
            <h5>Thêm hình ảnh cần thiết cho bài thi:</h5>
            <form action="AdminUploadImage" method="post" enctype="multipart/form-data" id="uploadForm">
                <input type="file" name="image" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,image/*,.xls,audio/*" class="form-control" style="height: 100px" multiple="multiple">
                <input type="button" value="Xác nhận" class="btn-readmore" style="margin-top: 100px" onclick="submitForm('confirm')"/>
            	<input type="submit" value="Tiếp" class="btn-readmore" style="margin-top: 100px" style="display:inline" onclick="submitForm('next')"/>
                
            </form>
        </div>
    </div>
</div>
 
<script>
    function submitForm(actionType) {
        var form = document.getElementById('uploadForm');

        if (actionType === 'confirm') {
            form.action = 'AdminUploadImage?action=1'; // Thay 'URL_XAC_NHAN' bằng đường dẫn muốn post đến khi xác nhận
        } else if (actionType === 'next') {
            form.action = 'AdminUploadImage?action=0'; // Thay 'URL_TIEP_THEO' bằng đường dẫn muốn post đến khi tiếp tục
        }

        // Submit form
        form.submit();
    }
</script>

	</div>
</div>