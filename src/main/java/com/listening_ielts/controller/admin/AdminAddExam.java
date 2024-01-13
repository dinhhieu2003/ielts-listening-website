package com.listening_ielts.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listening_ielts.entity.BoDe;
import com.listening_ielts.service.BoDeServiceImpl;
import com.listening_ielts.service.IBoDeService;

@WebServlet("/AdminAddExam")
public class AdminAddExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/addExam.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenBoDe = (String) request.getParameter("title");
		BoDe boDe = new BoDe();
		boDe.setTenBoDe(tenBoDe);
		IBoDeService boDeService = new BoDeServiceImpl();
		if(boDeService.insertBoDe(boDe)) {
			request.setAttribute("messExam", "Thêm thành công");
		} else {
			request.setAttribute("messExamFail", "Thêm thất bại");
		}
		request.getRequestDispatcher("admin-allExam").forward(request, response);
	}

}
