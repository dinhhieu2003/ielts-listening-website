package com.listening_ielts.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listening_ielts.entity.DeThi;
import com.listening_ielts.service.DeThiServiceImpl;
import com.listening_ielts.service.IDeThiService;

@WebServlet("/admin-detailExam")
public class DetailExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		IDeThiService deThiService = new DeThiServiceImpl();
		int maBoDe = Integer.parseInt(req.getParameter("maBoDe"));
		List<DeThi> listDeThi = deThiService.findDeThiTheoMaBoDe(maBoDe);
		req.setAttribute("listDeThi", listDeThi);
		req.getRequestDispatcher("/views/admin/detailExam.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
