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

@WebServlet("/member/join.do")
public class JoinController extends HttpServlet{
	
	public void doDispacther(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("mid")!=null){//로그인 시 못들어오게
			response.sendRedirect("/HRT_Proj/index.do");
		}
		else{
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		int nyear = cal.get(cal.YEAR);
		request.setAttribute("nyear",nyear);
		request.getRequestDispatcher("/member/Join.jsp").forward(request,response); 	
	}
	}
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doDispacther(request, response);
	 }
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doDispacther(request, response);
	 }
}
