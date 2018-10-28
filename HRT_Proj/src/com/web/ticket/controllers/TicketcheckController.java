package com.web.ticket.controllers;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.SearchDAO;
import com.web.vo.reserve;

@WebServlet("/ticket/ticketcheck.do")
public class TicketcheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		
		if(mid == null){
			session.setAttribute("returnURL","/HRT_Proj/ticket/ticketcheck.do");
			response.sendRedirect("/HRT_Proj/member/login.do");
		}else{
		String _pg=request.getParameter("pg");
		int pg;
		if(_pg !=null && !_pg.equals("")){
			pg=Integer.parseInt(_pg);
		}else{
			pg=1;
		}
		int sPage= pg - (pg-1)%5;
		SearchDAO dao =new SearchDAO();
		List<reserve> list=dao.getreserve(mid,pg);
		int seqCount=dao.getnocount(mid);
		int finalPage=seqCount/5 + (seqCount%5==0?0:1);//0 or 1;
				request.setAttribute("pg", pg);
				request.setAttribute("sPage", sPage);
				request.setAttribute("list", list);
				request.setAttribute("finalPage", finalPage);
				request.getRequestDispatcher("/ticket/ticketcheck.jsp").forward(request, response);
	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doDispatcher(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}