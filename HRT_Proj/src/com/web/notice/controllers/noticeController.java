package com.web.notice.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice/notice.do")
public class noticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doDispatcher(HttpServletRequest request, 
					HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/notice/notice.jsp").forward(request, response);
		
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}
