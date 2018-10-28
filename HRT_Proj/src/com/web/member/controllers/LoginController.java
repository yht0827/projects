package com.web.member.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.util.CookieManager;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	String error = request.getParameter("error");
	String errorMsg = "";
	Cookie[] coos = request.getCookies();
	String cookieMid=CookieManager.getCookie(coos,"mid");
	String cookiePwd=CookieManager.getCookie(coos,"pwd");
	System.out.println("cookieMid= "+cookieMid);
	System.out.println("cookiePwd= "+cookiePwd);
	
	if(error !=null && !error.equals("")){
		if(error.equals("IDx")){
			errorMsg="아이디가 없습니다.";
		}else if(error.equals("PWDx")){
			errorMsg="비밀번호가 틀렸습니다.";
		}
	}
		request.setAttribute("errorMsg", errorMsg);
		request.getRequestDispatcher("/member/Login.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doDispatcher(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}