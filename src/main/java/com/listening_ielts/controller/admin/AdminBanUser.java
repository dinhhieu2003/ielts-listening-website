package com.listening_ielts.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listening_ielts.entity.User;
import com.listening_ielts.service.IUserService;
import com.listening_ielts.service.UserServiceImpl;

@WebServlet("/AdminUserBan")
public class AdminBanUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null && session.getAttribute("account") != null ) {
			User account = (User)session.getAttribute("account");
			int isAdmin = account.getRole();
			if (isAdmin == 1) {
				String username = request.getParameter("username");
				IUserService userSerivce = new UserServiceImpl();
				if(userSerivce.banUser(username)) {
					request.setAttribute("messBan", "Cấm người dùng thành công");
					request.getRequestDispatcher("admin-usermanagement?pageid=1").forward(request, response);
				}else {
					request.setAttribute("messFailBan", "Cấm người dùng thất bại");
					request.getRequestDispatcher("admin-usermanagement?pageid=1").forward(request, response);
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
