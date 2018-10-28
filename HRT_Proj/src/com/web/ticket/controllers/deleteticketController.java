package com.web.ticket.controllers;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.web.dao.MemberDAO;
import com.web.dao.SearchDAO;
import com.web.vo.reserve;

@WebServlet("/ticket/deleteticket.do")
public class deleteticketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String date = request.getParameter("date");
		DecimalFormat formatter = new DecimalFormat("###,###");
		String trainnum = request.getParameter("trainnum");
		String seatnum  = request.getParameter("seatnum");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String mid = (String) session.getAttribute("mid");
		String money = (String) session.getAttribute("money");
		
		reserve rs = new reserve();
		SearchDAO dao = new SearchDAO();
		MemberDAO dao1 = new MemberDAO();
		
		rs.setDate(date);
		rs.setTrainnum(trainnum);
		rs.setSeatnum(seatnum);
		rs.setStart(start);
		rs.setEnd(end);
		
		session.removeAttribute("money_ch");
		session.removeAttribute("money");
		int cnt = dao.deleteticket(rs);
		dao1.updateMoney(mid,10000);
		int cu_money = Integer.parseInt(money)+10000;
		session.setAttribute("money",String.valueOf(cu_money));
		session.setAttribute("money_ch",formatter.format(cu_money));
		Gson gson = new Gson();
		String cntgson = gson.toJson(cnt);
		response.getWriter().print(cntgson);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}
