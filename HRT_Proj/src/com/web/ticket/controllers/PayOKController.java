package com.web.ticket.controllers;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.MemberDAO;
import com.web.dao.SearchDAO;
import com.web.vo.reserve;

@WebServlet("/ticket/PayOK.do")
public class PayOKController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		DecimalFormat formatter = new DecimalFormat("###,###");
		String money = (String) session.getAttribute("money");
		String seatcode = (String) session.getAttribute("seatcode");
		String date = (String) session.getAttribute("date");
		String start = (String) session.getAttribute("start");
		String end = (String) session.getAttribute("end");
		String stime = (String) session.getAttribute("stime");
		String etime = (String) session.getAttribute("etime");
		String tname = (String) session.getAttribute("tname");
		String sname = (String) session.getAttribute("startname");
		String ename = (String) session.getAttribute("endname");
		System.out.println("money : " + money);
		
		reserve r = new reserve();
		r.setDate(date);
		r.setEnd(end);
		r.setStart(start);
		r.setStime(stime);
		r.setEtime(etime);
		r.setTrainnum(tname);
		r.setMid(mid);
		r.setSeatnum(seatcode);
		r.setEname(ename);
		r.setSname(sname);
		
		session.removeAttribute("money");
		session.removeAttribute("money_ch");
		MemberDAO m = new MemberDAO();
		SearchDAO s = new SearchDAO();
		m.updateMoney(mid,-10000);
		int cu_money = Integer.parseInt(money)-10000;
		session.setAttribute("money",String.valueOf(cu_money));
		session.setAttribute("money_ch",formatter.format(cu_money));
		s.insertticket(r);
		
		request.getRequestDispatcher("/ticket/payOK.jsp").forward(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doDispatcher(request, response);
	}
}
