package com.listening_ielts.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listening_ielts.entity.CauHoi;
import com.listening_ielts.service.CauHoiServiceImpl;
import com.listening_ielts.service.ICauHoiService;

@WebServlet("/admin-detailDeThi")
public class DetailDeThiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICauHoiService cauHoiService = new CauHoiServiceImpl();
		int maDeThi = Integer.parseInt(request.getParameter("maDeThi"));
		int maBoDe = Integer.parseInt(request.getParameter("maBoDe"));
		List<CauHoi> listCauHoi = cauHoiService.findCauHoiByMaDeThi(maDeThi);
		request.setAttribute("listCauHoi", listCauHoi);
		request.setAttribute("maBoDe", maBoDe);
		request.getRequestDispatcher("/views/admin/detailDeThi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
