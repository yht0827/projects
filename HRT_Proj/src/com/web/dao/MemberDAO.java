package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.web.vo.Member;

public class MemberDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="";
	String user="";
	String pwd="";
	
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

	public int getMember(String mid) {
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		
		String sql = "SELECT COUNT(*) AS CNT FROM MEMBERS WHERE MID=?";
		
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				count = Integer.parseInt(rs.getString("CNT"));
			} 
			System.out.println("count : "+ count);
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
		return count;
	}

	public int addMember(Member m) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="INSERT INTO MEMBERS(MID, PWD, NAME, GENDER, AGE, BIRTHDAY, PHONE, REGDATE,POINT) VALUES(?, ?, ?, ?, ?, ?, ?,SYSDATE,50000)";
		
		con = getConn();
		int changeRow = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getMid());
			ps.setString(2, m.getPwd());
			ps.setString(3, m.getName());
			ps.setString(4, m.getGender());
			ps.setInt(5, m.getAge());
			ps.setString(6, m.getBirthday());
			ps.setString(7, m.getPhone());
			
			changeRow = ps.executeUpdate();
			
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
		return changeRow;
	}
	
	public Member getMid(String mid) {
		Member m = null;
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBERS WHERE MID=? AND ACTIVE ='T'";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				m = new Member();
				m.setMid(rs.getString("mid"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setBirthday(rs.getString("birthday"));
				m.setPhone(rs.getString("phone"));
				m.setRegdate(rs.getString("regdate"));
				m.setGrade(rs.getString("grade"));
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
		return m;
	}
	
	public int updateMember(Member m) {
		
		String sql="UPDATE MEMBERS SET PWD=?, AGE=?, BIRTHDAY=?, PHONE=? WHERE MID=?";
		
		Connection con = getConn();
		PreparedStatement ps = null;
		int cr = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getPwd());
			ps.setInt(2, m.getAge());
			ps.setString(3, m.getBirthday());
			ps.setString(4, m.getPhone());
			ps.setString(5, m.getMid());
			
			cr = ps.executeUpdate();
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
		System.out.println("cr : "+cr);
		return cr;
	}
	
	public int deleteMember(String mid) {
		
		String sql="UPDATE MEMBERS SET ACTIVE='F' WHERE MID=?";
		
		Connection con = getConn();
		PreparedStatement ps = null;
		int cr = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,mid);
			
			cr = ps.executeUpdate();
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
		System.out.println("cr : "+cr);
		return cr;
	}
	
	public int getPwd (String pwd,String mid) {
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		
		String sql = "SELECT COUNT(*) AS CNT FROM MEMBERS WHERE PWD=? AND MID=?";
		
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, mid);
			rs = ps.executeQuery();
			if(rs.next()){
				count = Integer.parseInt(rs.getString("CNT"));
			} 
			System.out.println("count : "+ count);
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
		return count;
	}
	
	public int getMoney(String mid) {
		int money=0;
		Connection con;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT POINT FROM MEMBERS WHERE MID=?";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()){
				money = Integer.parseInt(rs.getString("POINT"));
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
		return money;
	}
	
	public void updateMoney(String mid,int money) {
		Connection con;
		PreparedStatement ps = null;
		String sql = "UPDATE MEMBERS SET POINT=POINT+? WHERE MID=?";
		con = getConn();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,money);
			ps.setString(2, mid);
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
}
