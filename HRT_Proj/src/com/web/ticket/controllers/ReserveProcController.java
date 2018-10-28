package com.web.ticket.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.SearchDAO;
import com.web.vo.Search;

@WebServlet("/ticket/ReserveOk.do")
public class ReserveProcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("seatcode");
		String seatcode = request.getParameter("seatcode");
		session.setAttribute("seatcode",seatcode);
		request.getRequestDispatcher("/ticket/reserveOK.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}
