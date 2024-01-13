package com.listening_ielts.util;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.listening_ielts.constant.PathConstant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UploadUtil {

	public static String UploadImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String test = "failed";
		response.setContentType("text/html; charset=UTF-8");
		String realPath = PathConstant.pathToResource;
		String relativePath = PathConstant.pathToImageExam;
		String address = realPath + relativePath;
		System.out.println(address);
		final int MaxMemorySize = 1024 * 1024 * 5; // 3MB
		final int MaxRequestSize = 1024 * 1024 * 50; // 50 MB

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
			test = "failed";
			return test;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(MaxMemorySize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);

		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (!item.isFormField()) {
					String fileName = item.getName();
					System.out.println("File name: "  + fileName);
					test = fileName;
					// pathFile: vị trí mà chúng ta muốn upload file vào
					// gửi cho server

					String pathFile = address + File.separator + fileName;

					File uploadedFile = new File(pathFile);

					boolean kt = uploadedFile.exists();

					try {

						if (kt == true) {

							test = "failed";
						} else {
							item.write(uploadedFile);
							test = fileName;
						}

					} catch (Exception e) {

						test = e.getMessage();
					}
				} else {
					test = "failed";
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
			test = "failed";
			return test;
		}

		return test;
	}
	
	public static String UploadFile(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		String test = "failed";
		ServletContext context = request.getServletContext();
		response.setContentType("text/html; charset=UTF-8");

		final String Address = PathConstant.pathToResource + path;
		System.out.println(Address);
		final int MaxMemorySize = 1024 * 1024 * 5; // 3MB final int MaxRequestSize = 1024 * 1024 * 50; // 50 MB

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {

			request.setAttribute("mess", "Chua nhap file!");

		}
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(1024 * 1024 * 5);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024 * 50);

		try {
			List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> iter = items.iterator();
			System.out.println("bar");
			while (iter.hasNext()) {
				System.out.println("foo");
				FileItem item = iter.next();

				if (!item.isFormField()) {
					String filename = item.getName();
					String pathfile = Address + File.separator + filename;
					File uploadFile = new File(pathfile);
					item.write(uploadFile);
					test = filename;
				} else {
					request.setAttribute("mess1", "Sorry this Servlet only handles file upload request");
					return test;
				}

			}

		} catch (FileUploadException e) {
			request.setAttribute("mess1", e.getMessage());
			return test;
		} catch (Exception e) {
			request.setAttribute("mess1", e.getMessage());
			return test;
		}
		return test;
	}

}