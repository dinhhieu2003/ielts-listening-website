package com.listening_ielts.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listening_ielts.entity.CauHoi;
import com.listening_ielts.entity.DapAn;
import com.listening_ielts.service.CauHoiServiceImpl;
import com.listening_ielts.service.ChiTietBaiLamServiceImpl;
import com.listening_ielts.service.DapAnServiceImpl;
import com.listening_ielts.service.ICauHoiService;
import com.listening_ielts.service.IChiTietBaiLamService;
import com.listening_ielts.service.IDapAnService;

@MultipartConfig
@WebServlet(urlPatterns = {"/doExam"})
public class DoExamController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	ICauHoiService cauhoiService = new CauHoiServiceImpl();
	IDapAnService dapanService = new DapAnServiceImpl();
	IChiTietBaiLamService chitietbailamService = new ChiTietBaiLamServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("doExam"))
		{		
			findCauHoiVaDapAnByMaDeThi(req, resp);
		}
		
		req.getRequestDispatcher("/views/user/doExam.jsp").forward(req, resp);
	}


	private void findCauHoiVaDapAnByMaDeThi(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int madethi=1;
		if (req.getParameter("madethi") != null)
			madethi = Integer.parseInt(req.getParameter("madethi"));
		List<CauHoi> listCauHoi = cauhoiService.findCauHoiByMaDeThi(madethi);
		List<List<DapAn>> listDapAn = new ArrayList<List<DapAn>>();
		for (CauHoi cauhoi : listCauHoi) {
			List<DapAn> dsdapan = dapanService.findDapAnTheoMaCauHoi(cauhoi.getMaCauHoi());
			listDapAn.add(dsdapan);
		}
		req.setAttribute("listDapAn", listDapAn);
		req.setAttribute("listCauHoi", listCauHoi);
	}


}
