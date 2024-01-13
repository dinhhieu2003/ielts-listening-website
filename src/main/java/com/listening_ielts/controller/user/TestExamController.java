package com.listening_ielts.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listening_ielts.entity.BoDe;
import com.listening_ielts.entity.DeThi;
import com.listening_ielts.service.BoDeServiceImpl;
import com.listening_ielts.service.DeThiServiceImpl;
import com.listening_ielts.service.IBoDeService;
import com.listening_ielts.service.IDeThiService;


@WebServlet(urlPatterns = {"/test-exam", "/test-exam/findAllDeThi"})
public class TestExamController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	IBoDeService bodeService = new BoDeServiceImpl();
	IDeThiService dethiService = new DeThiServiceImpl();
	int numBoDeOfPage = (int)Math.ceil(bodeService.findAllBoDe().size()/5.0);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		req.setAttribute("numBoDeOfPage", numBoDeOfPage);
		if (req.getParameter("page") != null)
			findBoDeTheoTrang(req, resp);
		else
			findAllBoDe(req, resp);
		if (url.contains("findAllDeThi"))
		{
			int maBoDe = Integer.parseInt(req.getParameter("mabode"));
			List<DeThi> listDeThi = dethiService.findDeThiTheoMaBoDe(maBoDe);
			req.setAttribute("listDeThi", listDeThi);
			req.getRequestDispatcher("/views/user/findAllDeThiTheoMaBoDe.jsp").forward(req, resp);
		}
		
		req.getRequestDispatcher("/views/user/findAllBoDe.jsp").forward(req, resp);
			
	}

	protected void findAllBoDe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {		
			List<BoDe> listBoDe = bodeService.findBoDeTheoTrang(0, 5);			
			request.setAttribute("listBoDe", listBoDe);
					
		} catch (Exception e) {		
			e.printStackTrace();		
		}
	
	}
	
	protected void findBoDeTheoTrang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {		
			String page = request.getParameter("page");
			List<BoDe> listBoDe = bodeService.findBoDeTheoTrang(Integer.parseInt(page) - 1, 5);			
			// thông báo	
			request.setAttribute("listBoDe", listBoDe);
					
		} catch (Exception e) {		
			e.printStackTrace();		
		}
	
	}
}
