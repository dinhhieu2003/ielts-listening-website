package com.listening_ielts.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listening_ielts.entity.User;
import com.listening_ielts.service.IUserService;
import com.listening_ielts.service.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			response.sendRedirect(request.getContextPath() + "/waiting");
			System.out.println(session.getId());
			return;
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					request.setAttribute("user", cookie.getValue());
					request.getRequestDispatcher("/views/common/login.jsp").forward(request, response);
					return;
				}
			}
		}
		String url = "/views/common/login.jsp";
//		if (request.getAttribute("message") != null) {
//			request.removeAttribute("message");
//		}
//		if (request.getAttribute("error") != null) {
//			request.removeAttribute("error");
//		}
//
//		String error = request.getParameter("error");
//		if (error != null && error.equals("admin-only")) {
//			error = new String("Vui lòng đăng nhập bằng account admin");
//		}
//		if (error != null && error.equals("manager-only")) {
//			error = new String("Vui lòng đăng nhập bằng account admin | employee");
//		}
//		if (error != null && error.equals("customer-only")) {
//			error = new String("Vui lòng đăng nhập bằng account khách hàng");
//		}
//		if (request.getAttribute("register_error") != null) {
//			request.removeAttribute("register_error");
//		}
//		request.setAttribute("error", error);

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("user");
		String password = request.getParameter("pass");

		boolean isRememberMe = false;
		if ("on".equals(request.getParameter("remember"))) {
			isRememberMe = true;
		}
		String message = "";
		if (username.isEmpty() || password.isEmpty()) {
			message = "Tài khoản, mật khẩu không để được để trống";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/views/common/login.jsp").forward(request, response);
			return;
		}

		IUserService userService = new UserServiceImpl();
		User account = userService.checkUser(username, password);
		if (account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			if (isRememberMe == true) {
				saveRememberMe(response, username);
			}
			int banned = account.getRole();
			if (banned == 5) {
				String error = "Tài khoản này đã bị cấm, vui lòng liên hệ admin";
				request.setAttribute("error", error);
				request.getRequestDispatcher("/views/common/login.jsp").forward(request, response);
				return;
			}
			response.sendRedirect(request.getContextPath() + "/waiting");
		} else {
			message = "Thông tin tài khoản hoặc mật khẩu không đúng";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/views/common/login.jsp").forward(request, response);
			return;
		}

	}

	private void saveRememberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}

}
