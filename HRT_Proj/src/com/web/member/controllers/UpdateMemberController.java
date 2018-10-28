package com.web.member.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.web.dao.MemberDAO;
import com.web.vo.Member;

@WebServlet("/member/UpdateMember.do")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Calendar cal = Calendar.getInstance();
		String mid =(String) request.getSession().getAttribute("mid");
		String pwd = request.getParameter("Pwd");
		String name = request.getParameter("Name");
		String gender = request.getParameter("Gender");
		String year = request.getParameter("Year");
		String month = request.getParameter("Month");
		String day = request.getParameter("Day");
		String phone = request.getParameter("phone");
		String birthday = String.format("%s-%s-%s", year, month, day);
		 String path = request.getContextPath();
		int age = cal.get(cal.YEAR)-Integer.parseInt(year)+1;
		MemberDAO dao = new MemberDAO();
		Member m = dao.getMid(mid);

		m = new Member();
			m.setMid(mid);
			m.setPwd(pwd);
			m.setName(name);
			m.setGender(gender);
			m.setAge(age);
			m.setBirthday(birthday);
			m.setPhone(phone);
			
			int cr = dao.updateMember(m);
			if(cr==1){
				System.out.println("정보 수정 완료");
				response.sendRedirect(path+"/index.do?update=ok");
			}else{
				System.out.println("회원정보 수정 실패");
			}
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}