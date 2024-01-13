package com.listening_ielts.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listening_ielts.entity.User;

/**
 * Servlet implementation class AdminHomeController
 */
@WebServlet("/admin-home")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null && session.getAttribute("account") != null ) {
			User account = (User)session.getAttribute("account");
			int isAdmin = account.getRole();
			if (isAdmin == 1) {
				request.getRequestDispatcher("/views/admin/home.jsp").forward(request, response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath()+ "/login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
