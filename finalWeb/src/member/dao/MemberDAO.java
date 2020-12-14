package member.dao;

import java.net.HttpRetryException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jdbc.pool.DataSource;

import conn.dao.DBConnection;
import jdbc.dbcp.DBconnMgr;
import member.dto.Member;
import member.dto.StudentAdd;

public class MemberDAO {
	private Connection conn;

	public void connect() throws Exception {
		DBConnection dbConn = new DBConnection();
		conn = dbConn.connect();
	}

	public Member getMember(int no, int job) throws Exception {
		// 로그인 시도 시 radio버튼에서 Student면 job이 1, professor면 job이 0이고
		// 학번 혹은 교수번호인 no을 함께 받아 멤버객체를 반환하는 메소드

		String sql = "select * from student where std_no=?";
		// 기본으로 job이 1(학생)이라고 가정하고 student 테이블 내에서 검색하도록 하는 sql문

		Member member = null;
		StudentAdd stdAdd = null;

		if (job != 1) { // 혹시나 job이 1이 아니면(0, 교수이면) professor에서 찾도록 sql문을 수정.
			sql = "select * from professor where prof_no=?";
		}

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, no + "");

		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			if (job == rs.getInt(8)) {
				int dbNo = rs.getInt(1); // 학번 혹은 교수번호
				String dbPw = rs.getString(2); // 비번
				String dbName = rs.getString(3); // 이름
				String dbBirth = rs.getString(4); // 생일
				String dbMajor = rs.getString(5); // 전공
				String dbEmail = rs.getString(6); // 이메일
				String dbGender = rs.getString(7); // 성별

				member = new Member(dbNo, dbPw, dbName, dbBirth, dbMajor, dbEmail, dbGender, job);
				System.out.println("여기여기");
				System.out.println(member.getJob());
				System.out.println("여기여기");
			}
		}
		rs.close();
		pstm.close();

		return member;
	}

	public StudentAdd getStdAdd(int no) throws Exception {
		// 추가 개인정보 - 위에 있는 메소드로 얻은 객체의 job이 1(학생)일 경우 조건문이 실행되어
		// StudentAdd 객체를 반환하도록 하는 메소드

		PreparedStatement pstm;
		ResultSet rs;
		StudentAdd stdAdd = null;
		String sql = "select * from studentadd where std_no = ?";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, no);
		rs = pstm.executeQuery();
		while (rs.next()) {
			int stdNo = rs.getInt("std_no");
			int stdGrade = rs.getInt("std_grade");
			int stdStatus = rs.getInt("std_status");
			int stdTotalCredit = rs.getInt("std_total_credit");
			stdAdd = new StudentAdd(stdNo, stdGrade, stdStatus, stdTotalCredit);
		}
		rs.close();
		pstm.close();
		return stdAdd;

	}

	public Member editMember(HttpServletRequest request) throws Exception {
		// 개인정보를 수정하는 메소드
		// (로그인 시 이미 세션에 member객체를 넣어놓은 상태임을 기억해둬야함)
		// 세션에서 얻은 member객체와 수정하고자하는 정보(현재는 email만 수정하도록 넣음)
		// MemberProc에서 request를 매개변수로 전달받아 request에서 session을 얻고 session에서 member변수를
		// 얻음.
		// getParameter를 통해 수정된 정보들을 얻고
		//
		StringBuilder sql = new StringBuilder("update ");
		// StringBuilder는 String과 같이 문자열 객체임.
		// 다만 "A" + "B" 이라는 연산시 앞쪽에 있는 A문자열 뒤에 B가 단순히 붙는것이 아니라
		// "AB"라는 새로운 문자열이 만들어지고 기존 객체는 메모리상에서 방치되어 메모리 낭비가 되기때문에
		// StringBuilder를 사용해서 메모리 낭비를 줄임.
		// sql.append("문자열")방식으로 사용후 완성된 문자열은 sql.toString()으로 사용함.

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		// request에 있는 session, 그 session에 있는 member를 얻음.

		// 여기는 앞으로 '개인정보수정'에 추가될 정보들이 들어갈곳
		String email = request.getParameter("email");
		// 여기는 앞으로 '개인정보수정'에 추가될 정보들이 들어갈곳

		if (member.getJob() == 1) {
			sql.append("student set std_email = ? where std_no = ?");
		} else {
			sql.append("professor set prof_email = ? where prof_no = ?");
		}

		PreparedStatement pstm = conn.prepareStatement(sql.toString());
		pstm.setString(1, email);
		pstm.setInt(2, member.getNo());
		pstm.executeUpdate();

		// DB에 업데이트가 완료된 이후 세션에 다시 올릴 member객체 내의 값들을 변경.
		member.setEmail(email);
		// session에 member를 다시 넣어주는건 밖(editMember를 호출한 MemberProc에서 할거임.

		// 학생일 경우 추가정보에 대한 수정이 있기 때문에 한번 더 수정 프로세스 진행됨
//---------------------여기에 넣어야함 ---------------------
		// 현재 학생 추가정보는 학년, 휴복학상태, 총이수학점이기때문에 수정이 가능하지 않아 넣지 않았음.
		// 학생일 경우 추가정보에 대한 수정이 있기 때문에 한번 더 수정 프로세스 진행됨

		pstm.close();
		return member;
	}

	public void close() throws Exception {
		conn.close();
	}

	// member라는 객체가 session에 이미 들어가있는 상태(전페이지에서)
	//
	public Member getMemberFromRequest(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		member.setEmail(email);
		member.setName(name);

		return member;
	}

	public Member forgotPw(HttpServletRequest request) {
		String name = request.getParameter("name");
		String no_ = request.getParameter("no");
		String job_ = request.getParameter("job");
		String email = request.getParameter("email");
		
		int no = (no_ != null)?Integer.parseInt(no_) : 0;
		int job = (job_ != null)? Integer.parseInt(no_) : 0;
		
		
		
		
		
		Member member = null;
		String sql;
		if (job == 1) {
			sql = "select * from student where std_name=? and std_no = ? and std_email = ?";
		} else {
			sql = "select * from professor where prof_name=? and prof_no = ? and prof_email = ?";
		}
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setInt(2, no);
			pstm.setString(3, email);
			ResultSet rs = pstm.executeQuery();
			System.out.println(no);
			System.out.println(job);
			System.out.println(email);
			System.out.println(name);
			if(rs.next()) {
				System.out.println("rs이 있긴하네용");

			int dbNo = rs.getInt(1); // 학번 혹은 교수번호
			String dbPw = rs.getString(2); // 비번
			String dbName = rs.getString(3); // 이름
			String dbBirth = rs.getString(4); // 생일
			String dbMajor = rs.getString(5); // 전공
			String dbEmail = rs.getString(6); // 이메일
			String dbGender = rs.getString(7); // 성별

			member = new Member(dbNo, dbPw, dbName, dbBirth, dbMajor, dbEmail, dbGender, job);
			}else {
				System.out.println("헐.. rs가 없다니..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;

	}

}
