package com.listening_ielts.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listening_ielts.entity.User;
import com.listening_ielts.service.BoDeServiceImpl;
import com.listening_ielts.service.IBoDeService;
@MultipartConfig
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IBoDeService bodeService = new BoDeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
	}

}
