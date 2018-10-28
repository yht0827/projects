package com.web.member.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/Mypage.do")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		 String path = request.getContextPath();
			if(mid == null){
				session.setAttribute("returnURL",path+"/member/Mypage.do");
				response.sendRedirect(path+"/member/login.do");
			}
			else{
			Calendar cal = new GregorianCalendar(Locale.KOREA);
			int nyear = cal.get(cal.YEAR);
			request.setAttribute("nyear",nyear);
			request.getRequestDispatcher("/member/MyPage.jsp").forward(request, response);
			}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doDispatcher(request, response);
	}
}