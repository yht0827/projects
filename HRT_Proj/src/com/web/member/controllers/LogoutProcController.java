package com.web.member.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class LogoutProcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doDispacther(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/HRT_Proj/index.do");
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doDispacther(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispacther(request, response);
	}
}