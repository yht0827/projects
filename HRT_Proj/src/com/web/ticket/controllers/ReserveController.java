package com.web.ticket.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ticket/reserve.do")
public class ReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		 String path = request.getContextPath();
			if(mid == null){
				session.setAttribute("returnURL",path+"/ticket/reserve.do");
				response.sendRedirect(path+"/member/login.do");
			}else{
				SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy/MM/dd");
				Date currentTime = new Date ();
		  String[] weekDay = {"일","월", "화", "수", "목", "금", "토"};     
				   Calendar cal = Calendar.getInstance(); 
				      int num = cal.get(Calendar.DAY_OF_WEEK)-1; 
				      String mTime = mSimpleDateFormat.format ( currentTime );
				      mTime +="("+weekDay[num]+")";
				     
				      System.out.println(mTime);
				      
		    request.setAttribute("c_date",mTime);
			request.getRequestDispatcher("/ticket/reserve.jsp").forward(request, response);
	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}
