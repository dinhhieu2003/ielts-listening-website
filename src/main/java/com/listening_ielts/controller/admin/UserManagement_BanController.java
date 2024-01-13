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
import com.listening_ielts.service.IUserService;
import com.listening_ielts.service.UserServiceImpl;

/**
 * Servlet implementation class UserManagement_Ban
 */
@WebServlet("/admin-usermanagement_ban")
public class UserManagement_BanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session != null && session.getAttribute("account") != null) {
			User account = (User)session.getAttribute("account");
			int isAdmin = account.getRole();
			if (isAdmin == 1) {
				int start_index = Integer.parseInt(request.getParameter("pageid"));
				int count = 10;
				if(start_index!=1) {
					start_index = start_index - 1;
					start_index = start_index * count +1;
				}
				
				IUserService userService = new UserServiceImpl();
				int maxpageid;
				int CountPage = userService.countUser();
				if((CountPage%count)==0 && CountPage>=10) {
					maxpageid = (CountPage/ count);
				}else {
					maxpageid = CountPage/ count +1;
				}
				request.setAttribute("maxpageid", maxpageid);
				request.setAttribute("numberpage", Integer.parseInt(request.getParameter("pageid")));
				List<User> listUser = userService.getListUser_ban(start_index, count);
				request.setAttribute("listMem", listUser);
				request.getRequestDispatcher("/views/admin/userManager_ban.jsp").forward(request, response);
			}
			
		}else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		};
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
