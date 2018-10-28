package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.web.vo.Search;
import com.web.vo.codes;
import com.web.vo.peoplecount;
import com.web.vo.reserve;
import com.web.vo.startend;

public class SearchDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@aws-yht0827.cyrx1gmukuuo.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
	String user="HRT";
	String pwd="1234";
	
	public Connection getConn() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public List<codes> getName() {
		
		codes c=null;
		ArrayList<codes> clist=null;
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM S_CODE";
		
		con = getConn();
		clist = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				c= new codes();
				c.setSt_name(rs.getString("ST_NAME"));
				c.setCode_name(rs.getString("CODE_NAME"));
				clist.add(c);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clist;
	}
	
	public List<Search> getSearch(String start,String end,String date,String time,String updown){
		
		Search s=null;
		ArrayList<Search> slist=null;		
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT TRAIN_NAME,"+start+","+end+",LPAD(TRUNC(MOD(TO_DATE("+end+",'HH24:MI') - TO_DATE("+start+",'HH24:MI'),1)*24),2,'0')||':'||LPAD(ROUND(MOD((TO_DATE("+end+",'HH24:MI') - TO_DATE("+start+",'HH24:MI'))*24,1)*60),2,'0')AS leadtime FROM "+updown+" WHERE "+start+">? ORDER BY 2";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, time);
			rs = ps.executeQuery();
			
			slist= new ArrayList<>();
			while(rs.next()){
				s = new Search();
				s.setTrainnum(rs.getString("TRAIN_NAME"));
				s.setStart(start);
				s.setStart_time(rs.getString(start));
				s.setEnd(end);
				s.setEnd_time(rs.getString(end));
				s.setLeadtime(rs.getString("leadtime"));
				s.setDate(date);
				slist.add(s);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return slist;
	}
	
	public List<peoplecount> getCount(String start,String end,String date){
		
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		peoplecount p=null;
		ArrayList<peoplecount> plist=null;
		
		String sql = "SELECT TRAIN_NAME,COUNT(DISTINCT SEAT_NUM) AS CNT FROM RESERVE WHERE START_DATE=? AND (START_ST=? OR END_ST=?) GROUP BY TRAIN_NAME";
		
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,date);
			ps.setString(2,start);
			ps.setString(3,end);
			rs = ps.executeQuery();
			
			plist = new ArrayList<>();
			while(rs.next()){
				p= new peoplecount();
				p.setTraincode(rs.getString("TRAIN_NAME"));
				p.setCount(rs.getInt("CNT"));
				plist.add(p);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return plist;
	}
	
	public List<startend> getstartend(String tname, String date, String seat) {
		
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		startend st=null;
		ArrayList<startend> slist=null;
		
		String sql = "SELECT  START_ST,END_ST from RESERVE WHERE TRAIN_NAME=? AND SEAT_NUM=? AND START_DATE=?";
		
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,tname);
			ps.setString(2,seat);
			ps.setString(3,date);
			rs = ps.executeQuery();
			
			slist = new ArrayList<>();
			while(rs.next()){
				st= new startend();
				st.setStart((rs.getString("START_ST")));
				st.setEnd((rs.getString("END_ST")));
				slist.add(st);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return slist;
	}
	
	public void insertticket(reserve r){
		
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO RESERVE VALUES((SELECT MAX(TO_NUMBER(NO))+1 FROM RESERVE),?,?,?,?,?,?,?,?,?,?)";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,r.getDate());
			ps.setString(2,r.getTrainnum());
			ps.setString(3,r.getSeatnum());
			ps.setString(4,r.getStart());
			ps.setString(5,r.getEnd());
			ps.setString(6,r.getStime());
			ps.setString(7,r.getEtime());
			ps.setString(8,r.getMid());
			ps.setString(9,r.getSname());
			ps.setString(10,r.getEname());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 게시글 전체 조회
	public List<reserve> getreserve(String mid,int pg){
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<reserve> list = null;
		int startRN = 1 + (pg-1)*5; ///a0+(n-1)d

		String sql="SELECT * FROM (SELECT ROWNUM AS RN, N.* FROM (SELECT * FROM RESERVE WHERE MID=? ORDER BY TO_NUMBER(NO) DESC) N) WHERE RN BETWEEN ? AND ?";
		con=getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,mid); 
			ps.setInt(2, startRN);
			ps.setInt(3, startRN +4);
			rs=ps.executeQuery();

			list= new ArrayList<reserve>();
			while(rs.next()){
				reserve r = new reserve();   // 객체의 생성 위치 매우 중요
				r.setDate(rs.getString("START_DATE"));
				r.setTrainnum(rs.getString("TRAIN_NAME"));
				r.setSeatnum(rs.getString("SEAT_NUM"));
				r.setEname(rs.getString("ENAME"));
				r.setSname(rs.getString("SNAME"));
				r.setStart(rs.getString("START_ST"));
				r.setEnd(rs.getString("END_ST"));
				r.setStime(rs.getString("START_TIME"));
				r.setEtime(rs.getString("END_TIME"));
				list.add(r);
			}
		} catch (SQLException e) {
			System.out.println("회원 목록 조회중 오류가 발생하였습니다.");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();

			} catch (SQLException e) {
				System.out.println("접속해제에 실패하였습니다.");
				e.printStackTrace();
			}  
		}
		return list;
	}
	
	public int getnocount(String mid){
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		int count=0;
		
		String sql="SELECT COUNT(NO) CNT FROM RESERVE WHERE MID = ?";
		con=getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,mid);
			rs=ps.executeQuery();

			if(rs.next()){
				count = rs.getInt("CNT");
			}
		} catch (SQLException e) {
			System.out.println("회원 정보 조회중 오류가 발생하였습니다.");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();

			} catch (SQLException e) {
				System.out.println("접속해제에 실패하였습니다.");
				e.printStackTrace();
			}  
		}
		return count;
	}

	public int deleteticket(reserve rs) {
		
		String sql="DELETE FROM RESERVE WHERE START_DATE=? AND TRAIN_NAME=? AND SEAT_NUM=? AND START_ST=? AND END_ST=?";

		Connection con = getConn();
		PreparedStatement ps = null;
		int count=0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,rs.getDate());
			ps.setString(2,rs.getTrainnum());
			ps.setString(3,rs.getSeatnum());
			ps.setString(4,rs.getStart());
			ps.setString(5,rs.getEnd());
			count = ps.executeUpdate();
			System.out.println("count : "+count);
		} catch (SQLException e) {
			System.out.println("게시글 정보 삭제중 오류 발생");
			e.printStackTrace();
		} finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("접속 해제중 오류 발생");
				e.printStackTrace();
			}
		}
		return count;
	}
}