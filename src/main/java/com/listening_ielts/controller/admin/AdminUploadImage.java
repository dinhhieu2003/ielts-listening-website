package com.listening_ielts.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listening_ielts.constant.PathConstant;
import com.listening_ielts.entity.User;
import com.listening_ielts.util.UploadUtil;

@WebServlet("/AdminUploadImage")
public class AdminUploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null && session.getAttribute("account") != null ) {
			User account = (User)session.getAttribute("account");
			int isAdmin = account.getRole();
			if (isAdmin == 1) {
				request.getRequestDispatcher("/views/admin/uploadImage.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int action = Integer.parseInt((String) request.getParameter("action"));
		if (action == 1) {
			if (!UploadUtil.UploadImage(request, response).equals("failed")) {
				request.setAttribute("messUpload", "Tải ảnh thành công");
			} else {
				request.setAttribute("messUploadFail", "Tải ảnh thất bại");
			}
			request.getRequestDispatcher("/views/admin/uploadImage.jsp").forward(request, response);
		} else if(action == 0){
			//request.getRequestDispatcher("AdminUploadAudio").forward(request, response);
			response.sendRedirect(request.getContextPath()+ "/AdminUploadAudio");
		}
		
	}
	
}
