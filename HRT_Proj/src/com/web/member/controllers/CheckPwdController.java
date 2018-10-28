package com.web.member.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.web.dao.MemberDAO;

@WebServlet("/member/CheckPwd.do")
public class CheckPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pwd = (String) request.getParameter("pwd");
		String mid = (String) request.getSession().getAttribute("mid");
		
		System.out.println("mid °ª : " + mid);
		System.out.println("pwd °ª : " + pwd);
		
		int cnt = 0;
		
		MemberDAO dao = new MemberDAO();
		cnt = dao.getPwd(pwd,mid);
		Gson gson = new Gson();
		String cntgson = gson.toJson(cnt);
		response.getWriter().print(cntgson);
	}
}