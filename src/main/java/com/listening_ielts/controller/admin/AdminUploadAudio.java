package com.listening_ielts.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listening_ielts.constant.PathConstant;
import com.listening_ielts.entity.DeThi;
import com.listening_ielts.entity.Part;
import com.listening_ielts.entity.User;
import com.listening_ielts.service.DeThiServiceImpl;
import com.listening_ielts.service.IDeThiService;
import com.listening_ielts.service.IPartService;
import com.listening_ielts.service.PartService;
import com.listening_ielts.util.UploadUtil;

@WebServlet("/AdminUploadAudio")
public class AdminUploadAudio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User account = (User) session.getAttribute("account");
			int isAdmin = account.getRole();
			if (isAdmin == 1) {
				request.getRequestDispatcher("/views/admin/uploadAudio.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int action = Integer.parseInt((String) request.getParameter("action"));

		if (action != 0) {
			String filename = UploadUtil.UploadFile(request, response, PathConstant.pathToAudioExam);

			System.out.println("Part: " + action);
			System.out.println(filename);
			int partNum = action;
			if (!filename.equals("failed")) {
				IDeThiService deThiService = new DeThiServiceImpl();
				DeThi deThi = deThiService.getLastDeThi();
				IPartService partService = new PartService();
				Part newPart = new Part();
				newPart.setSoHieuPart(partNum);
				newPart.setSoCauHoi(10);
				newPart.setAudio(filename);
				newPart.setDeThi(deThi);
				if(partService.insertPart(newPart)) {
					request.setAttribute("messUpload", "Tải audio thành công");
				} else {
					request.setAttribute("messUploadFail", "Tải audio thất bại");
				}
			} else {
				request.setAttribute("messUploadFail", "Tải audio thất bại");
			}

			request.getRequestDispatcher("/views/admin/uploadAudio.jsp").forward(request, response);
		} 

		else if(action == 0){
			response.sendRedirect(request.getContextPath()+ "/AdminUploadExcel");
		}
	}
}
