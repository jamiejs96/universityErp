package member.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import conn.dao.DBConnection;
import member.dto.HyuHakforProf;
import member.dto.Member;
import member.dto.StudentAdd;

public class RestBackDao {
	
	private Connection conn;
	public void connect() throws Exception {
		DBConnection dbConn = new DBConnection();
		conn = dbConn.connect();
	}
	
	public void close() throws Exception{
		conn.close();
	}
	
	public void applyHyuHak(HttpServletRequest request) throws UnsupportedEncodingException {
		HttpSession session = request.getSession();
		StudentAdd stdAdd = (StudentAdd)session.getAttribute("stdAdd");
		
		String year_ = request.getParameter("year");
		String sem_ = request.getParameter("sem");
		int stdNo = stdAdd.getStdNo();
		int start = Integer.parseInt(year_ + sem_);
		int period = Integer.parseInt(request.getParameter("count"));
		String reason = request.getParameter("reason");
		System.out.println(reason);
		String sql = "insert into hyuhak values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, stdNo);
			pstm.setInt(2,start);
			pstm.setInt(3, period);
			pstm.setString(4, reason);
			pstm.setInt(5, 0);
			int result = pstm.executeUpdate();
			stdAdd.setStdStatus(4);
			session.setAttribute("stdAdd", stdAdd);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void bokhak(int stdNo) {
		String sql = "update studentAdd set std_status = 0 where std_no = ?";
		try {
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, stdNo);
		pstm.executeUpdate();
		pstm.close();
		conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<HyuHakforProf> hyuHakBoard(HttpServletRequest request) {
		ArrayList<HyuHakforProf> list = new ArrayList<>();
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		int job = member.getJob();
		int number;
		String sql = "select h.*,s.std_name from hyuhak h, (select std_no, std_name from student left join professor on PROFESSOR.PROF_MAJOR = STUDENT.STD_MAJOR where prof_no = ?) s where h.std_no = s.std_no and h.confirmed = 0";
		if(job==1) {
			sql = "select h.*,s.std_name from hyuhak h left join student s on h.std_no = s.std_no where s.std_no = ?";
			number = member.getNo();
		}else {
			number = member.getNo();
		}
		try {
			
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, number);
		
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int stdNo = rs.getInt("std_no");
			int start = rs.getInt("start_sem");
			int period = rs.getInt("sems");
			String reason = rs.getString("reason");
			String stdName = rs.getString("std_name");
			
			HyuHakforProf hyuhyu = new HyuHakforProf(stdNo, start, period, reason,stdName);
			list.add(hyuhyu);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return list;
		
	}
	
	public void confirmHyuForProf(int[] stdNums) {
		String updateStdAdd = "update studentAdd set std_status = 1 where std_no = ?";
		String updateHyuhak = "update hyuhak set confirmed = 1 where std_no = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(updateStdAdd);
			
			for(int i =0; i<stdNums.length;i++) {
				pstm.setInt(1, stdNums[i]);
				pstm.executeUpdate();
				System.out.println("stdAdd에서 수정");
			}
			for(int i = 0; i<stdNums.length; i++) {
				pstm = conn.prepareStatement(updateHyuhak);
				pstm.setInt(1, stdNums[i]);
				pstm.executeUpdate();
				System.out.println("휴학 status 수정");
			}
			pstm.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

