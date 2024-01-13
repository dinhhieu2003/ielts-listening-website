package com.listening_ielts.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listening_ielts.entity.User;
import com.listening_ielts.service.IUserService;
import com.listening_ielts.service.UserServiceImpl;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();

//    Kiểm tra để đảm bảo username, email là unique
        IUserService userService = new UserServiceImpl();
        String errorMessage = "";
        System.out.println("name: " + username + email);
        if (userService.isExistUserName(username)) {
        	errorMessage = "Tên người dùng được đã đăng ký trước đó. Vui lòng nhập tên khác";
        }
        if (userService.isExistEmail(email)) {
            errorMessage = "Địa chỉ Email được đã đăng ký trước đó. Vui lòng nhập email mới";
        }
        System.out.println("Error Message: " + errorMessage);

        if (errorMessage == "") {
            //Nếu email và username hợp lệ thì tiến hành đăng ký thành viên
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(0);

            try {
                userService.insertUser(user);
                System.out.println("Thêm User thành công");
                request.setAttribute("message", "Đăng ký tài khoản thành công");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println("Thêm User không thành công");
                e.printStackTrace();
            }
        }
        request.setAttribute("error", errorMessage);
        request.setAttribute("action", "signup");
        request.getRequestDispatcher("/views/common/signup.jsp").forward(request, response);
	}

}
