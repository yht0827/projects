package com.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doDispacther(HttpServletRequest request, HttpServletResponse response)
									throws ServletException, IOException {
		String update = request.getParameter("update");
		request.setAttribute("update",update);
		System.out.println("update : " + update);
		if(update != null){
		 request.getSession().invalidate();
		}
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispacther(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispacther(request, response);
	}
}