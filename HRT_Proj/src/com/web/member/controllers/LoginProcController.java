package com.web.member.controllers;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.MemberDAO;
import com.web.vo.Member;


@WebServlet("/member/LoginProc.do")
public class LoginProcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		String rememberID = request.getParameter("rememberID");
		System.out.println("mid= "+mid);
		System.out.println("pwd= "+pwd);
		MemberDAO dao= new MemberDAO();
		 Member m= dao.getMid(mid);
		 String path = request.getContextPath();
		if(m==null){
			System.out.println("아이디가 오류");
			response.sendRedirect(path+"/member/login.do?error=IDx");
		}else if(!m.getPwd().equals(pwd)){
			System.out.println("비번 오류");
			response.sendRedirect(path+"/member/login.do?error=PWDx");
		}else{
			System.out.println("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("mid",mid);
			session.setAttribute("name",m.getName());
			session.setAttribute("grade",m.getGrade());
			int money = dao.getMoney(mid);

			session.setAttribute("money",String.valueOf(money));
			session.setAttribute("money_ch",formatter.format(money));
			
			String returnURL = (String) session.getAttribute("returnURL");
			System.out.println("returnURL : "+ returnURL);
			request.getSession().removeAttribute("returnURL");
			if(returnURL != null && m.getGrade().equals("2")){
				response.sendRedirect(returnURL);
			}else{
					System.out.println(m.getName() + " 님 환영합니다.");
					System.out.println("session : "+ session.getId());
					if(rememberID!=null && !rememberID.equals("")){
						Cookie ckmid =new Cookie("mid",mid);
						ckmid.setMaxAge(60*60*24*7);//1주일 저장
						response.addCookie(ckmid);
						System.out.println("mid 쿠키저장");
					}else{
						Cookie ckmid =new Cookie("mid",null);
						ckmid.setMaxAge(0);
						response.addCookie(ckmid);
						System.out.println("mid 쿠키삭제");
					}
					response.sendRedirect(path+"/index.do");
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}