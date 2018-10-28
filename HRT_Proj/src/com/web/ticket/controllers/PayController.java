package com.web.ticket.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ticket/Pay.do")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doDispatcher(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		HttpSession session = request.getSession();
		session.setAttribute("stime",stime);
		session.setAttribute("etime",etime);
		request.getRequestDispatcher("/ticket/pay.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}