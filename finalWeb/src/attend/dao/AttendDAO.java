package attend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import attend.dto.AttendDTO;
import conn.dao.DBConnection;
import member.dto.Member;

public class AttendDAO {
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
//학생으로 로그인 된 상태라면 이 메소드로 선택된 과목에 대한 자신의 출석을 확인할 수 있음.
public AttendDTO getAttendForStd(HttpServletRequest request) throws SQLException {
   AttendDTO aDto = null;
   HttpSession session = request.getSession();
   Member member = (Member)session.getAttribute("member");
   int stdNo = member.getNo();
   int paramSubNo = Integer.parseInt(request.getParameter("sub_no"));
   
   String sql = "select professor.prof_name, aa.* from professor "+
         "left join "+ 
          "(select subject.prof_no, subject.sub_name,attend.* " + 
          "from attend left join subject " + 
          "on attend.sub_no = subject.sub_no) aa " +
          "on professor.prof_no = aa.prof_no " +
          "where std_no = ? and sub_no = ?";
   
   PreparedStatement pstm = conn.prepareStatement(sql);
   pstm.setInt(1, stdNo);
   pstm.setInt(2, paramSubNo);
   
   ResultSet rs = pstm.executeQuery(); 
   while(rs.next()) {
      String profName = rs.getString(1);
      int profNo = rs.getInt(2);
      String subName = rs.getString(3);
//      int stdNo = rs.getInt(4);
      int subNo = rs.getInt(5);
      int attWeek1 = rs.getInt(6);
      int attWeek2 = rs.getInt(7);
      int attWeek3 = rs.getInt(8);
      int attWeek4 = rs.getInt(9);
      int attWeek5 = rs.getInt(10);
      int attWeek6 = rs.getInt(11);
      int attWeek7 = rs.getInt(12);
      int attWeek8 = rs.getInt(13);
      int attWeek9 = rs.getInt(14);
      int attWeek10 = rs.getInt(15);
      int attWeek11 = rs.getInt(16);
      int attWeek12 = rs.getInt(17);
      int attWeek13 = rs.getInt(18);
      int attWeek14 = rs.getInt(19);
      int attWeek15 = rs.getInt(20);
      Timestamp date = rs.getTimestamp(21);
      
      aDto = new AttendDTO(profName, 
            profNo, 
            subName, 
            subNo, 
            stdNo, 
            attWeek1, 
            attWeek2, 
            attWeek3, 
            attWeek4, 
            attWeek5, 
            attWeek6, attWeek7, attWeek8, attWeek9, attWeek10, attWeek11, attWeek12, attWeek13, attWeek14, attWeek15, 
            date);
   }
   return aDto;
}

//교수로 로그인 된 상태라면 이 메소드로 선택된 1개 과목의 모든 학생의 출석을 확인할 수 있음.
public ArrayList<AttendDTO> getAttendForProf(int profNo,int subNo){
   ArrayList<AttendDTO> list = new ArrayList<>();
//   String sql = "select * from attend left join (select s.sub_no , s.sub_name, p.prof_no, p.prof_name from subject s left join professor p on s.prof_no = p.prof_no) pp on attend.sub_no = pp.sub_no where prof_no = ? and pp.sub_no = ?";
   String sql = "select student.std_name, cc.* from student right join (select attend.*, bb.* from attend right join (select aa.*,professor.prof_name from professor left join (select sub_no subNo, sub_name, prof_no from subject where sub_no = ?) aa on professor.prof_no = aa.prof_no) bb on bb.subno = attend.sub_no where prof_no = ?) cc on cc.std_no = student.std_no";
   try {
   PreparedStatement pstm = conn.prepareStatement(sql);
   pstm.setInt(1, subNo);
   pstm.setInt(2, profNo);
   ResultSet rs = pstm.executeQuery();
   while(rs.next()) {
      String profName = rs.getString("prof_name");
      //int profNo = rs.getInt("prof_no"); 이미 로그인되어있으므로
      String subName = rs.getString("sub_name");
      int stdNo = rs.getInt("std_no");
      //int subNo = rs.getInt("sub_no");
      int attWeek1 = rs.getInt("att_week1");
      int attWeek2 = rs.getInt("att_week2");
      int attWeek3 = rs.getInt("att_week3");
      int attWeek4 = rs.getInt("att_week4");
      int attWeek5 = rs.getInt("att_week5");
      int attWeek6 = rs.getInt("att_week6");
      int attWeek7 = rs.getInt("att_week7");
      int attWeek8 = rs.getInt("att_week8");
      int attWeek9 = rs.getInt("att_week9");
      int attWeek10 = rs.getInt("att_week10");
      int attWeek11 = rs.getInt("att_week11");
      int attWeek12 = rs.getInt("att_week12");
      int attWeek13 = rs.getInt("att_week13");
      int attWeek14 = rs.getInt("att_week14");
      int attWeek15 = rs.getInt("att_week15");
      Timestamp date = rs.getTimestamp("att_start");
      AttendDTO aDto = new AttendDTO(profName, profNo, subName, subNo, stdNo, attWeek1, attWeek2, attWeek3, attWeek4, attWeek5, attWeek6, attWeek7, attWeek8, attWeek9, attWeek10, attWeek11, attWeek12, attWeek13, attWeek14, attWeek15, date);
      aDto.setStdName(rs.getString("std_name"));
      list.add(aDto);
   }
   }
   catch(Exception e) {
      e.printStackTrace();
   }
   
   
   return list;
}
//교수의 번호로 자신의 과목을 조회
   public ArrayList<AttendDTO> getSubForProf(HttpServletRequest request) {
//      String sql = "select * from subject where prof_no = ?";
      String sql = "select * from attend left join (select s.sub_no , s.sub_name, p.prof_no, p.prof_name from subject s left join professor p on s.prof_no = p.prof_no) pp on attend.sub_no = pp.sub_no where prof_no = ?";
      ArrayList<AttendDTO> list = new ArrayList<>();
      HttpSession session = request.getSession();
      Member member = (Member)session.getAttribute("member");
      int profNo = member.getNo();
      String profName = member.getName();
      try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setInt(1, profNo);
         ResultSet rs = pstm.executeQuery();
         while(rs.next()) {
            String subName = rs.getString("sub_name");
            int subNo = rs.getInt("sub_no");

            AttendDTO aDto = new AttendDTO(subNo, subName);
            list.add(aDto);
            
            
         }
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      return list;
   }
   public ArrayList<AttendDTO> getSubjectsByStdNo(int stdNo) {
      String sql = "select attend.sub_no, attend.std_no,subject.sub_name from attend join subject on subject.sub_no = attend.sub_no where attend.std_no = ?  and attend.sub_no like '20%'";
      ResultSet rs;
      ArrayList<AttendDTO> list = new ArrayList<>();
      try {
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setInt(1, stdNo);
      rs = pstm.executeQuery();
      while(rs.next()) {
         String subName= rs.getString("sub_name");
         int subNo = rs.getInt("sub_no");
         AttendDTO aDto = new AttendDTO(subNo, subName);
         list.add(aDto);
      }
      }catch(Exception e) {
         e.printStackTrace();
      }
      return list;
   }
   public ArrayList<AttendDTO> getSubjectsByProfNo(int profNo) {
      String sql = "select * from subject where prof_no = ? and sub_no like '20%'";
      ResultSet rs;
      ArrayList<AttendDTO> list = new ArrayList<>();
      try {
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setInt(1, profNo);
         rs = pstm.executeQuery();
         while(rs.next()) {
            String subName= rs.getString("sub_name");
            int subNo = rs.getInt("sub_no");
            AttendDTO aDto = new AttendDTO(subNo, subName);
            list.add(aDto);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }
      return list;
   }
   public JSONObject createADTOJSON(AttendDTO aDto) {
      JSONObject json = new JSONObject();
   
      json.put("profName", aDto.getProfName());
      json.put("profNo", aDto.getProfNo());
      json.put("subName", aDto.getSubName());
      json.put("subNo", aDto.getSubNo());
      json.put("stdNo", aDto.getStdNo());
      json.put("attWeek1", aDto.getAttWeek1());
      json.put("attWeek2", aDto.getAttWeek2());
      json.put("attWeek3", aDto.getAttWeek3());
      json.put("attWeek4", aDto.getAttWeek4());
      json.put("attWeek5", aDto.getAttWeek5());
      json.put("attWeek6", aDto.getAttWeek6());
      json.put("attWeek7", aDto.getAttWeek7());
      json.put("attWeek8", aDto.getAttWeek8());
      json.put("attWeek9", aDto.getAttWeek9());
      json.put("attWeek10", aDto.getAttWeek10());
      json.put("attWeek11", aDto.getAttWeek11());
      json.put("attWeek12", aDto.getAttWeek12());
      json.put("attWeek13", aDto.getAttWeek13());
      json.put("attWeek14", aDto.getAttWeek14());
      json.put("attWeek15", aDto.getAttWeek15());
      json.put("date", aDto.getDate());
      return json;
   }
   public JSONArray createADTOJSONListForProf(ArrayList<AttendDTO> list) {
      JSONArray JSONArr = new JSONArray();
      JSONObject JSONList = new JSONObject();
      for(int i =0; i<list.size(); i++) {
         JSONObject json = this.createADTOJSON(list.get(i));
         json.put("stdName", list.get(i).getStdName());
         JSONArr.put(json);
      }
      return JSONArr;
   }

}