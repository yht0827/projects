package com.web.member.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.dao.MemberDAO;

@WebServlet("/member/DelMember.do")
public class delMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private void doDispatcher(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
	
		String mid =(String) request.getSession().getAttribute("mid");
		MemberDAO dao = new MemberDAO();
		System.out.println("mid : "+ mid);
		String path = request.getContextPath();
		
		int cr = dao.deleteMember(mid);
		
		if(cr==1){
			System.out.println("È¸¿ø Å»Åð ¼º°ø");
			response.sendRedirect(path+"/index.do?update=del");
		}else{
			System.out.println("È¸¿ø Å»Åð ½ÇÆÐ");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}

}
