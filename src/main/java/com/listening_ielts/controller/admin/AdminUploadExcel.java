package com.listening_ielts.controller.admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.listening_ielts.constant.PathConstant;
import com.listening_ielts.entity.CauHoi;
import com.listening_ielts.entity.DeThi;
import com.listening_ielts.entity.LoaiCauHoi;
import com.listening_ielts.entity.Part;
import com.listening_ielts.entity.User;
import com.listening_ielts.service.CauHoiServiceImpl;
import com.listening_ielts.service.DeThiServiceImpl;
import com.listening_ielts.service.ICauHoiService;
import com.listening_ielts.service.IDeThiService;
import com.listening_ielts.service.IPartService;
import com.listening_ielts.service.PartService;
import com.listening_ielts.util.UploadUtil;

@WebServlet("/AdminUploadExcel")
public class AdminUploadExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null && session.getAttribute("account") != null ) {
			User account = (User)session.getAttribute("account");
			int isAdmin = account.getRole();
			if (isAdmin == 1) {
				request.getRequestDispatcher("/views/admin/uploadExcel.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("Foward_404").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDeThiService deThiService = new DeThiServiceImpl();
		DeThi deThi = deThiService.getLastDeThi();
		int maDeThi = deThi.getMaDeThi();
		String filename = UploadUtil.UploadFile(request, response, PathConstant.pathToExcelExam);
		if (!filename.equals("failed")) {
			if(ImportExcel(request, response, filename)) {
				request.setAttribute("messUpload", "Nhập đề thi thành công");
			} else {
				System.out.println("Nhập excel lỗi");
				try {
					if(deThiService.deleteDeThi(maDeThi)) {
						System.out.println("Xóa được file");
					} else {
						System.out.println("Không xóa được file");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("messUploadFail", "Nhập đề thi thất bại");
			}
		} else {
			System.out.println("Không thấy file");
			request.setAttribute("messUploadFail", "Nhập đề thi thất bại");
		}
		request.getRequestDispatcher("admin-allExam").forward(request, response);
	}

	public static boolean ImportExcel(HttpServletRequest request, HttpServletResponse response, String filename)
			throws ServletException, IOException {
		System.out.println("File name: " + filename);
		InputStream inp;
		int check=0;
		List<CauHoi> list = new ArrayList<CauHoi>();
		IDeThiService deThiService = new DeThiServiceImpl();
		DeThi deThi = deThiService.getLastDeThi();
		int maDeThi = deThi.getMaDeThi();
		IPartService partService = new PartService();
		try {
			inp = new FileInputStream(PathConstant.pathToResource + PathConstant.pathToExcelExam + filename);
			XSSFWorkbook wb = new XSSFWorkbook(inp);
			Sheet sheet = wb.getSheetAt(0);

			for (int i = 1; i <= 41; i++) {
				String image = "";
				String noiDungCauHoi = "";
				String giaiThich = "";
				int partNum = -1;
				int maLoaiCauHoi = -1;
				Row row = sheet.getRow(i);
				
				if (row.getCell(0) != null) {
					image = row.getCell(0).getStringCellValue().toString();
				}

				if (row.getCell(1) != null) {
					noiDungCauHoi = row.getCell(1).getStringCellValue().toString();;
				}

				if (row.getCell(2) != null) {
					maLoaiCauHoi = (int) row.getCell(2).getNumericCellValue();
				}

				if (row.getCell(3) != null) {
					partNum = (int) row.getCell(3).getNumericCellValue();
				} else {
					continue;
				}
				
				if (row.getCell(5) != null) {
					giaiThich = row.getCell(5).getStringCellValue().toString();
				}
				
				LoaiCauHoi loaiCauHoi = new LoaiCauHoi();
				loaiCauHoi.setMaLoai(maLoaiCauHoi);
				Part part = partService.findMaPart(maDeThi, partNum);
				CauHoi cauHoi = new CauHoi();
				cauHoi.setAnhCauHoi(image);
				cauHoi.setNoiDungCauHoi(noiDungCauHoi);
				cauHoi.setLoaiCauHoi(loaiCauHoi);
				cauHoi.setPart(part);
				cauHoi.setDeThi(deThi);
				cauHoi.setGiaiThich(giaiThich);
				list.add(cauHoi);
				++check;
				
			}
			if(check==40) {
				System.out.println("Check đủ 40");
				ICauHoiService cauHoiService = new CauHoiServiceImpl();
				for (CauHoi c: list) {
					cauHoiService.insertCauHoi(c);
				}
				return true;
			}else {
				System.out.println("Không đủ 40");
				for (int i=0; i<40; i++) {
					System.out.println("-----------------------------");
				}
				return false;
			}
			

		} catch (FileNotFoundException e) {
			System.out.println("new");
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			return false;
		}

	}
}