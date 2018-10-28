package com.web.member.controllers;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.MemberDAO;
import com.web.vo.Member;

@WebServlet("/member/joinProc.do")
public class JoinProcController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
		
		Calendar cal = Calendar.getInstance();
		String mid = request.getParameter("Mid");
		String pwd = request.getParameter("Pwd");
		String name = request.getParameter("Name");
		String gender = request.getParameter("Gender");
		String year = request.getParameter("Year");
		String month = request.getParameter("Month");
		String day = request.getParameter("Day");
		String phone = request.getParameter("phone");
		String birthday = String.format("%s-%s-%s", year, month, day);
		int age = cal.get(cal.YEAR)-Integer.parseInt(year)+1;
		
		System.out.println("mid : " + mid);
		System.out.println("pwd : " + pwd);
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("birthday : " + birthday);
		System.out.println("age: " + age);
		System.out.println("phone : " + phone);
		
		Member m = new Member();
		MemberDAO dao = new MemberDAO();
		
		m.setMid(mid);
		m.setPwd(pwd);
		m.setName(name);
		m.setGender(gender);
		m.setPhone(phone);
		m.setBirthday(birthday);
		m.setAge(age);
		
		int cr = dao.addMember(m);
		if(cr == 1){
			System.out.println("계정 등록 성공!!");
			response.sendRedirect("/HRT_Proj/member/Joinok.do");
		}
	}
}