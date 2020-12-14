package subject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;

import conn.dao.DBConnection;
import jdbc.dbcp.DBconnMgr;
import member.dto.Member;
import subject.dto.Subject;

public class SubjectDao {
	private Connection conn;

	public void connect() throws Exception {
		DBConnection dbConn = new DBConnection();
		conn = dbConn.connect();
	}

	public List<Subject> searchSub(HttpServletRequest request) throws Exception {
		List<Subject> list = new ArrayList<>();
		String category = request.getParameter("category");
		String word = request.getParameter("word");
		String sql;
		if(word.equals("")) {
			sql = "select sub_no,"
					+ "sub_name,sub_time,"
					+ "sub_day,sub_credit,"
					+ "sub_capacity,"
					+ "prof_name "
					+ "from subject "
					+ "left join professor "
					+ "on subject.prof_no "
					+ "= professor.prof_no";
			
		}else {
		 sql = "select sub_no,"
				+ "sub_name,sub_time,"
				+ "sub_day,sub_credit,"
				+ "sub_capacity,"
				+ "prof_name "
				+ "from subject "
				+ "left join professor "
				+ "on subject.prof_no "
				+ "= professor.prof_no "
				+ "where "+category+ " like ?";
		
		}
		PreparedStatement psmt = conn.prepareStatement(sql);
		if(!word.equals("")) {
			psmt.setString(1, "%"+word+"%");
		}

		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			int dbSubNo = rs.getInt("sub_no");
			String dbSubName = rs.getString("sub_name");
			String dbProfName = rs.getString("prof_name");
			int dbSubTime = rs.getInt("sub_time");
			String dbSubDay = rs.getString("sub_day");
			int dbSubCredit = rs.getInt("sub_credit");
			int dbSubCapacity = rs.getInt("sub_capacity");
			Subject subject = new Subject(dbSubNo, dbSubName, dbProfName, dbSubTime, dbSubDay, dbSubCredit,
					dbSubCapacity);
			
			list.add(subject);

		}
		rs.close();
		psmt.close();

		return list;

	}

	public String getJSON(List<Subject> list) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\" : [");
		for (int i = 0; i < list.size(); i++) {
			result.append("[{a : \"" + list.get(i).getSubNo() + "\"},");
			result.append("{b: \"" + list.get(i).getSubName() + "\"},");
			result.append("{c: \"" + list.get(i).getProfName() + "\"},");
			result.append("{d: \"" + list.get(i).getSubTime() + "\"},");
			result.append("{e: \"" + list.get(i).getSubDay() + "\"},");
			result.append("{f: \"" + list.get(i).getSubCredit() + "\"},");
			result.append("{g : \"" + list.get(i).getSubCapacity() + "\"}],");
//			result.append("[{\"value1\" : \"" + list.get(i).getSubNo() + "\"},");
//			result.append("{\"value2\" : \"" + list.get(i).getSubName() + "\"},");
//			result.append("{\"value3\" : \"" + list.get(i).getProfName() + "\"},");
//			result.append("{\"value4\" : \"" + list.get(i).getSubTime() + "\"},");
//			result.append("{\"value5\" : \"" + list.get(i).getSubDay() + "\"},");
//			result.append("{\"value6\" : \"" + list.get(i).getSubCredit() + "\"},");
//			result.append("{\"value7\" : \"" + list.get(i).getSubCapacity() + "\"},],");
		}
		result.append("]}");
		return result.toString();
	}
	public void close() throws Exception{
		conn.close();
	}
	
	
	//교수가 출결 체크하기 위해 자신의 과목 목록을 받아올 수 있는 메소드
	public ArrayList<Subject> getSubListForProf(HttpServletRequest request) {
		String sql = "select * from subject where prof_no = ?";
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		int profNo = member.getNo();
		String profName = member.getName();
		
		ArrayList<Subject> list = new ArrayList<>();
		try {
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, profNo);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int subNo = rs.getInt("sub_no");
			String subName = rs.getString("sub_name");
			int subTime = rs.getInt("sub_time");
			String subDay = rs.getString("sub_day");
			int subCredit = rs.getInt("sub_credit");
			int subCapacity = rs.getInt("sub_capacity");
			Subject subject = new Subject(subNo, subName, profName, subTime, subDay, subCredit, subCapacity);
			list.add(subject);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
}
