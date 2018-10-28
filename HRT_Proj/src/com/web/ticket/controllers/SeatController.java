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
import com.web.vo.startend;

@WebServlet("/ticket/Seatcheck.do")
public class SeatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doDispatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("tname");
		String tname = request.getParameter("tname");
		String start = (String) session.getAttribute("start");
		String end = (String)session.getAttribute("end");
		String date = (String) session.getAttribute("date");
		session.setAttribute("tname",tname);
		SearchDAO dao = new SearchDAO();
		int seatchker[] = new int[20];
		String seat[] = {"1A","2A","3A","4A","5A",
						 "1B","2B","3B","4B","5B",
						 "1C","2C","3C","4C","5C",
						 "1D","2D","3D","4D","5D"};
		String seatchk[] = new String[20];
		List<startend> slist = null;
		int cnt=0;
		String updown = (String)session.getAttribute("updown");
		
		
		if(updown.equals("DOWN_TIME1")){
			
			System.out.println(updown);
			
		for(int i=0;i<seat.length;i++){
			slist = dao.getstartend(tname,date,seat[i]);
			if(slist.size()!=0){
				for(int j=0;j<slist.size();j++){
					if(Integer.parseInt(slist.get(j).getStart().substring(1,3)) > Integer.parseInt(start.substring(1,3)) 
							&& Integer.parseInt(slist.get(j).getEnd().substring(1,3)) < Integer.parseInt(end.substring(1,3))){
						seatchk[cnt++]=seat[i];
						continue;
					}else if(start.equals(slist.get(j).getStart())){//시작위치 같을때
					seatchk[cnt++]=seat[i];
					continue;
				}else if(end.equals(slist.get(j).getEnd())){//마지막위치 같을때
					seatchk[cnt++]=seat[i];
					continue;
				}else if(Integer.parseInt(slist.get(j).getStart().substring(1,3))
									<= Integer.parseInt(start.substring(1,3)) && Integer.parseInt(slist.get(j).getEnd().substring(1,3))
											> Integer.parseInt(start.substring(1,3))){
					seatchk[cnt++]=seat[i];
					continue;
				}else if(Integer.parseInt(slist.get(j).getStart().substring(1,3))
								< Integer.parseInt(end.substring(1,3)) && Integer.parseInt(slist.get(j).getEnd().substring(1,3))
									>= Integer.parseInt(end.substring(1,3))){
						seatchk[cnt++]=seat[i];
						continue;
				}
				}
			}
		}
		}else{
			System.out.println(updown);
			
			for(int i=0;i<seat.length;i++){
				slist = dao.getstartend(tname,date,seat[i]);
				if(slist.size()!=0){
					for(int j=0;j<slist.size();j++){
					if(start.equals(slist.get(j).getStart())){//시작위치 같을때
						seatchk[cnt++]=seat[i];
						continue;
					}else if(end.equals(slist.get(j).getEnd())){//마지막위치 같을때
						seatchk[cnt++]=seat[i];
						continue;
					}else if(Integer.parseInt(slist.get(j).getEnd().substring(1,3))
										< Integer.parseInt(start.substring(1,3)) && Integer.parseInt(slist.get(j).getStart().substring(1,3))
												>= Integer.parseInt(start.substring(1,3))){
						seatchk[cnt++]=seat[i];
						continue;
					}else if(Integer.parseInt(slist.get(j).getEnd().substring(1,3))
									<= Integer.parseInt(end.substring(1,3)) && Integer.parseInt(slist.get(j).getStart().substring(1,3))
										> Integer.parseInt(end.substring(1,3))){
							seatchk[cnt++]=seat[i];
							continue;
					}
					}
				}
			
		}
		}
		for(int i=0;i<20;i++){
			if(seatchk[i] == null){
				break;
			}
			System.out.println(seatchk[i]);
			for(int j=0;j<20;j++){
				if(seatchk[i].equals(seat[j]))
				{
					seatchker[j]=1;
				}
			}
		}
		Gson gson = new Gson();
		String schk = gson.toJson(seatchker);
		System.out.println(schk.toString());
		response.getWriter().print(schk);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatcher(request, response);
	}
}
