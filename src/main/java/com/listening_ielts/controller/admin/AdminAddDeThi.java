package com.listening_ielts.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listening_ielts.entity.BoDe;
import com.listening_ielts.entity.DeThi;
import com.listening_ielts.service.BoDeServiceImpl;
import com.listening_ielts.service.DeThiServiceImpl;
import com.listening_ielts.service.IBoDeService;
import com.listening_ielts.service.IDeThiService;

@WebServlet("/AdminAddDeThi")
public class AdminAddDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maBoDe = (String)request.getParameter("maBoDe");
		request.setAttribute("maBoDe", maBoDe);
		request.getRequestDispatcher("/views/admin/addDeThi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maBoDe = Integer.parseInt((String) request.getParameter("maBoDe"));
		String tenDeThi = (String) request.getParameter("title");
		DeThi deThi = new DeThi();
		IBoDeService boDeService = new BoDeServiceImpl();
		BoDe boDe = boDeService.findBoDeTheoMaBoDe(maBoDe);
		deThi.setBoDe(boDe);
		deThi.setTenDeThi(tenDeThi);
		IDeThiService deThiService = new DeThiServiceImpl();
		if(deThiService.insertDeThi(deThi)) {
			request.setAttribute("messExam", "Thêm đề thi thành công");
		} else {
			request.setAttribute("messExamFail", "Thêm đề thi thất bại");
		}
		request.setAttribute("maBoDe", maBoDe);
		request.getRequestDispatcher("admin-UploadMultiFile").forward(request, response);
	}

}
