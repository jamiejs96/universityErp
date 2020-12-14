package bbs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {

   private Connection conn;

   private ResultSet rs;

   public BbsDAO() {
      try {
         String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
         String dbID = "egoing";
         String dbPassWord = "1111";
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(dbURL, dbID, dbPassWord);
      } catch (Exception e) {
         e.printStackTrace();

      }
   }

   public String getDate() {
      String SQL = "select to_char(sysdate, 'YYYY-MM-DD') from dual";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            return rs.getString(1);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return ""; 
   }

   public int getNext() {   
      String SQL = "select a.rn from (SELECT bbsNo, rownum as rn from BBS ORDER BY bbsNo DESC) a order by a.rn desc"; 
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            return rs.getInt(1) + 1;
         }
         return 1;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1; 
   }

   public int write(String bbsTitle, String userID, String bbsContent) {
      String SQL = "INSERT INTO BBS VALUES (?,?,?,?,?,?)";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setInt(1, getNext());
         pstmt.setString(2, bbsTitle);
         pstmt.setString(3, userID);
         pstmt.setString(4, getDate());
         pstmt.setString(5, bbsContent);
         pstmt.setInt(6, 1);
         return pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1; //      ͺ  ̽          
   }



   public ArrayList<Bbs> getList(int pageNumber) { 
      ArrayList<Bbs> list = new ArrayList<Bbs>();
      int number = pageNumber;
      System.out.println(pageNumber);
   String SQL = "select * from (select row_number() over(order by bbsNo desc) row_num, bbs.* from bbs where BbsAvailable = 1) where ? <= row_num and row_num < ?";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         int firstNum = (number - 1) * 10 + 1;
         int secondNum = firstNum + 10;
         pstmt.setInt(1, firstNum);
         pstmt.setInt(2, secondNum);
         rs = pstmt.executeQuery(); 
         while (rs.next()) {
            Bbs bbs = new Bbs();
            bbs.setBbsNo(rs.getInt(2));
            bbs.setBbsTitle(rs.getString(3));
            bbs.setUserID(rs.getString(4));
            bbs.setBbsDate(rs.getString(5));
            bbs.setBbsContent(rs.getString(6));
            bbs.setBbsAvailable(rs.getInt(7));
            list.add(bbs);
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return list;
   }
   
   public boolean nextPage(int pageNumber) {
      String SQL = "SELECT * FROM BBS WHERE bbsNo <= ? AND bbsAvailable = 1";
      ArrayList<Bbs> list = new ArrayList<Bbs>();
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setInt(1,getNext()-(pageNumber-1)*10);
         rs = pstmt.executeQuery();
         if (rs.next()) {
            return true;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return false; 
   }

   public Bbs getBbs(int bbsNo) {
      String SQL = "SELECT * FROM BBS WHERE bbsNo=?"; 
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setInt(1, bbsNo);
         rs = pstmt.executeQuery(); 
         if (rs.next()) {
            Bbs bbs = new Bbs();
            bbs.setBbsNo(rs.getInt(1));
            bbs.setBbsTitle(rs.getString(2));
            bbs.setUserID(rs.getString(3));
            bbs.setBbsDate(rs.getString(4));
            bbs.setBbsContent(rs.getString(5));
            bbs.setBbsAvailable(rs.getInt(6));
            return bbs;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   public int update(int bbsNo, String bbsTitle, String bbsContent) {
      String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsNo = ? ";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, bbsTitle);
         pstmt.setString(2, bbsContent);
         pstmt.setInt(3, bbsNo);
         return pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1; 
   }

   public int delete(int bbsNo) {
      String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsNo = ? ";
      try {
         PreparedStatement pstmt = conn.prepareStatement(SQL);
         pstmt.setInt(1, bbsNo);
         return pstmt.executeUpdate();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return -1; 
   }
}