package score.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import conn.dao.DBConnection;
import jdbc.dbcp.DBconnMgr;
import member.dto.Member;
import score.dto.Score;
public class ScoreDAO {
   private Connection conn;

   public void connect() throws Exception {
      DBConnection dbConn = new DBConnection();
      conn = dbConn.connect();
   }
   
   public void close() throws Exception{
      conn.close();
   }
   
   public List<Score> getScores(HttpServletRequest request) throws Exception{
      
      HttpSession session = request.getSession();
      //request에서 session 객체를 얻음
      
      List<Score> list = new ArrayList<>();
      //학기별 성적은 1개만 나오는게 아니라 여러개가 나오는것이기 때문에 List 객체를 만들어줌.
      Member member = (Member)session.getAttribute("member");
      
      int stdNo = member.getNo();
      //session에서 얻은 멤버의 학번을 얻음.
      
      
      PreparedStatement pstm;
      /*
         String year = request.getParameter("year").substring(2);
         //년도를 입력받음. DB에는 2020년에서 앞의 20을 때고 하기때문에 substring으로 2번째 인덱스 이후의 글자만 받음.
         String semester = request.getParameter("semester");
         
         request.setAttribute("yearVal", "20"+year);
         //수정함 원래 session이엇음 위 아래
         request.setAttribute("semVal", semester);
         */
      String sql = "select a.*,score.std_score from score left join (select s.sub_no, s.sub_name,s.sub_credit, p.prof_name from subject s left join professor p on s.prof_no = p.prof_no) a on score.sub_no = a.sub_no where score.std_no = ? order by score.sub_no";
//      String sql = "select a.*,score.std_score from score left join (select s.sub_no, s.sub_name,s.sub_credit, p.prof_name from subject s left join professor p on s.prof_no = p.prof_no) a on score.sub_no = a.sub_no where a.sub_no like ? and score.std_no = ?";
      pstm = conn.prepareStatement(sql);
//      String aa = year + "0" + semester + "%";
//      pstm.setString(1, aa);
//      pstm.setInt(2, member.getNo());
      pstm.setInt(1, member.getNo());
      
      ResultSet rs = pstm.executeQuery();
      
      while(rs.next()) {
         int subNo = rs.getInt("sub_no");
         String subName = rs.getString("sub_name");
         int subCredit = rs.getInt("sub_credit");
         String profName = rs.getString("prof_name");
         String stdScore = rs.getString("std_score");
         Score score = new Score(subNo, subName, stdScore, subCredit,profName);
         list.add(score);
   
      }
      rs.close();
      pstm.close();      
      return list;
   }
   
   public Map<String, List<Score>> getScoreMap(List<Score> list){
      
      Map<String,List<Score>> map = new HashMap<>();
//      List<Score> eachSemester = new ArrayList<>();
      List<Score> eachSemester = null;
      for(Score s : list) {
         String subNo_ = new String(s.getSubNo()+"").substring(0,4);
         System.out.println(subNo_);
         if(!map.containsKey(subNo_)) {
            eachSemester = new ArrayList<>();
            map.put(subNo_, eachSemester);
         }
         eachSemester.add(s);
      }
      /*
       * --1. list에 ResultSet의 값을 넣는다.
         --2. list에 들어가있는 값들 중 0번 인덱스의 substring 0,4의 값을 list에 넣고 그값이 list에 없다면 
         --새로운 map으로 그 이름으로 값을 넣음
       * 
       * */
      
      return map;
   }


}