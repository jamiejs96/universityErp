package attend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import attend.dto.AbsentDTO;
import conn.dao.DBConnection;
import subject.dto.Subject;

public class AbsentDAO {
	private Connection conn;

	public void connect() throws Exception {
		DBConnection dbConn = new DBConnection();
		conn = dbConn.connect();
	}
	public void close() {
		try {
		conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AbsentDTO> getBogun(int stdNo) {
//	public AbsentDTO getBogun(int stdNo) {
		String sql = "select * from bogun where std_no = ? order by ab_date desc";
		ArrayList<AbsentDTO> list = new ArrayList<>();
		AbsentDTO absDTO = null;
		try {
			
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, stdNo);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
		Date date = rs.getDate("ab_date");
		int kind = rs.getInt("kind");
		absDTO = new AbsentDTO(stdNo, date, kind);
		list.add(absDTO);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getDate(int year, int month, int day) {

		int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int dayCount = 0; // 출력자료

		boolean leap; // 윤년여부


		// 윤년여부 결정

		leap = isLeap(year);

		// 이전 월까지 일수 계산

		for (int i = 0; i < month - 1; i++) {

			dayCount += monthDays[i];

		}

		// 월의 일수

		dayCount += day;

		// 윤년 여부에 따라

		if (leap && month >= 3) {

			dayCount++;

		}

		return dayCount;

	}

	public boolean isLeap(int year) {

		boolean leap = false;

		if ((year % 4 == 0) && (year % 100 != 0) || year % 400 == 0) {

			leap = true;

		}

		return leap;

	}
	
	public void insertBogun(int stdNo, String date) {
		String sql = "insert into bogun values(?,?,1)";
		try {
			
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, stdNo);
		pstm.setString(2, date);
		pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void updateAttend(int stdNo, String day, int week) {
		ArrayList<Subject> list = getSubjectByDay(stdNo,day);
		String sql = "update attend set att_week" + week + " = 1 where std_no = ? and sub_no = ?";
		try {
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, stdNo);
		for(Subject s : list) {
			pstm.setInt(2, s.getSubNo());
			pstm.executeUpdate();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Subject> getSubjectByDay(int stdNo, String day) {
		String sql = "select * from subject left join attend on subject.sub_no = attend.sub_no where std_no = ? and subject.sub_no like '20%' and sub_day = ?";
		ArrayList<Subject> list = new ArrayList<>();
		try {
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, stdNo);
		pstm.setString(2, day);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int subNo = rs.getInt("sub_no");
			Subject subject = new Subject(subNo);
			list.add(subject);
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	public String getDay(int day) {
		String day_ = "";
		switch(day) {
		case 1 : 
		day_ = "월";
		break;
		case 2 :
		day_ = "화";
		break;
		case 3 :
		day_ = "수";
		break;
		case 4 :
		day_ = "목";
		break;
		case 5 :
		day_ = "금";
		break;
		
		}
		return day_;
		
	}
}
