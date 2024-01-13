package com.listening_ielts.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listening_ielts.entity.User;
import com.listening_ielts.service.BoDeServiceImpl;
import com.listening_ielts.service.IBoDeService;

@WebServlet("/AdminDeleteExam")
public class AdminDeleteExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null && session.getAttribute("account") != null ) {
			User account = (User)session.getAttribute("account");
			int isAdmin = account.getRole();
			if (isAdmin == 1) {
				IBoDeService boDeService = new BoDeServiceImpl();
				int id = Integer.parseInt(request.getParameter("id")) ;
				try {
					if(boDeService.deleteBoDe(id)) {
						request.setAttribute("messExam", "Xóa thành công");
						request.getRequestDispatcher("admin-allExam").forward(request, response);
					}else {
						request.setAttribute("messExamFail", "Xóa thất bại");
						request.getRequestDispatcher("admin-allExam").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
