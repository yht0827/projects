package com.web.ticket.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.web.dao.SearchDAO;
import com.web.vo.Search;
import com.web.vo.codes;
import com.web.vo.peoplecount;

@WebServlet("/ticket/search.do")
public class searchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("updown");
		session.removeAttribute("start");
		session.removeAttribute("end");
		session.removeAttribute("date");
		session.removeAttribute("startname");
		session.removeAttribute("endname");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		session.setAttribute("startname",start);
		session.setAttribute("endname",end);
		date = date.substring(0,10);
		System.out.println(date);
		System.out.println("time : "+time);
		SearchDAO dao = new SearchDAO();
		String code[] = new String[2];
		String code_start="";
		String code_end="";
		List<codes> cList=null;
		cList = dao.getName();
		
		for(int i=0;i<cList.size();i++){
			if(cList.get(i).getSt_name().equals(start))
			{
				code_start = cList.get(i).getCode_name();
			}else if(cList.get(i).getSt_name().equals(end)){
				code_end = cList.get(i).getCode_name();
			}
		}
		session.setAttribute("start",code_start);
		session.setAttribute("end",code_end);
		session.setAttribute("date",date);
		String updown="";
		//
		if(Integer.parseInt(code_start.substring(1,3)) > Integer.parseInt(code_end.substring(1,3)) ){
			updown= "UP_TIME1";
			session.setAttribute("updown",updown);
		}else{
			updown="DOWN_TIME1";
			session.setAttribute("updown",updown);
		}
		
		List<Search> searchList=null;
		searchList = dao.getSearch(code_start, code_end,date,time,updown);

		List<peoplecount> peoplelist=null;
		peoplelist = dao.getCount(code_start,code_end,date);
		
		for(int i=0;i<searchList.size();i++){
			if(searchList.get(i).getLeadtime().equals(":")){
				searchList.remove(i);
				i--;
			}
		}
		for(int i=0;i<searchList.size();i++){
			for(int j=0;j<peoplelist.size();j++){
				if(searchList.get(i).getTrainnum().equals(peoplelist.get(j).getTraincode()))
				{
					searchList.get(i).setCount(peoplelist.get(j).getCount());
				}
			}
		}
		Gson gson = new Gson();
		String search = gson.toJson(searchList);
		System.out.println(search);
		response.getWriter().print(search);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}