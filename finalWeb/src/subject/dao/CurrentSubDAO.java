package subject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import conn.dao.DBConnection;
import member.dto.Member;
import subject.dto.Subject;

public class CurrentSubDAO {
   private Connection conn;

   public void connect() throws Exception {
      DBConnection dbConn = new DBConnection();
      conn = dbConn.connect();
   }
   public void close() throws Exception{
      conn.close();
   }
   
   public int[] getSubParamFromPage(HttpServletRequest request) {
      // subNo는 0번부터 시작 
      String[] subNo_ = new String[10];
      int subNo[];
      int num = 0;
      while(true) {
         subNo_[num] = request.getParameter("subNo" +(num));
         
         if(subNo_[num]==null) {
            subNo = new int[num];
            break;
         }
         System.out.println(subNo_[num]);
         num++;
         
      }
      for(int i = 0; i< subNo.length;i++) {
         subNo[i] = Integer.parseInt(subNo_[i]);
      }
      
      return subNo;
   }
   
   public void insertSub(int stdNo, int[] subNo) throws Exception{
      String sql = "insert into currSub values( ? , ?)";
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setInt(1, stdNo);
      int count = 0;
      for(int no : subNo) {  //현재 수강신청기간. 수강신청기간 내 신청된 과목들을 추가
         pstm.setInt(2, no);
         pstm.executeUpdate();
      }
      
      
      sql = "insert into attend(std_no, sub_no, att_start) values(?,?,?)"; 
      pstm = conn.prepareStatement(sql);
      pstm.setInt(1, stdNo);
      String startDate = "200803";
      for(int no : subNo) {
         pstm.setInt(2, no);
         pstm.setString(3, startDate);
         pstm.executeUpdate();
      }
      
      
      pstm.close();
   }
   
   public List<Subject> getCurrSub(int no, int job) throws Exception {
      String sql = "select prof_name, a.* from professor right join (select s.*,c.std_no from currsub c left join subject s on s.sub_no = c.sub_no) a on a.prof_no = professor.prof_no where std_no = ?";
      
      List<Subject> list = new ArrayList<Subject>();
      
      if(job == 0) {
         sql = "select prof_name, a.* from professor right join (select s.* from currsub c left join subject s on s.sub_no = c.sub_no) a on a.prof_no = professor.prof_no where a.prof_no = ?";
      }
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setInt(1, no);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()) {
         int dbSubNo = rs.getInt("sub_no");
         String dbSubName = rs.getString("sub_name");
         String dbProfName = rs.getString("prof_name");
         int dbSubTime = rs.getInt("sub_time");
         String dbSubDay = rs.getString("sub_day");
         int dbSubCredit = rs.getInt("sub_credit");
         int dbSubCapacity = rs.getInt("sub_capacity");
         
         Subject subject = new Subject(dbSubNo, dbSubName, dbProfName, dbSubTime, dbSubDay, dbSubCredit,
               dbSubCapacity);
         
         if(job == 0) { //교수이면
//            subject.setStdNo(rs.getInt("std_no"));
         }
         list.add(subject);
      }
      
      return list;
   }
   
   public String getCurrSubJSON(List<Subject> list) {
      JSONObject json = new JSONObject();
      char title = 'a';
      for(int i =0; i<list.size();i++) {
         
         JSONObject j = new JSONObject();
         Subject  s= list.get(i);
         j.put("name",s.getProfName());
         j.put("stdNo",s.getStdNo());
         j.put("subCapacity",s.getSubCapacity());
         j.put("subCredit",s.getSubCredit());
         j.put("subDay",s.getSubDay());
         j.put("subName",s.getSubName());
         j.put("subTime",s.getSubTime());
         j.put("subNo",s.getSubNo());
         json.put(Character.toString(title++), j);
         
      }
      return json.toString();
   }
   
   public void deleteSub(int stdNo, int subNo) throws Exception{
      
      String sql = "delete from currSub where std_no = ? and sub_no = ?";
      //현재 수강된 과목 삭제
      PreparedStatement pstm = conn.prepareStatement(sql);
      pstm.setInt(1, stdNo);
      pstm.setInt(2, subNo);
      
      pstm.executeUpdate();
      
      //attend(출석) 삭제
      sql = "delete from attend where std_no = ? and sub_no =?";
      pstm = conn.prepareStatement(sql);
      pstm.setInt(1, stdNo);
      pstm.setInt(2, subNo);
      pstm.executeUpdate();
      
      pstm.close();
   }

}