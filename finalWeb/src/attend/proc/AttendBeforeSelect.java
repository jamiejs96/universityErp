package attend.proc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attend.dao.AttendDAO;
import attend.dto.AttendDTO;
import member.dto.Member;

@WebServlet("/attendBeforeSelect")
public class AttendBeforeSelect extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      Member member = (Member)session.getAttribute("member");
      int job = member.getJob();
      int no = member.getNo();
      ArrayList<AttendDTO> list = new ArrayList<>(); //교수용
      AttendDAO aDao = new AttendDAO(); //학생용  ---> 
      //진행 방식
      //학생일 경우 먼저
      try {
         aDao.connect();
         
         //AttendDTO가 들어가있는 list를 DB를 통해 받음(여기 DTO에는 subNo과 subName뿐)
         if(job == 1) { // 학생일 경우
            list = aDao.getSubjectsByStdNo(no);
         }else {      //교수일 경우
            list = aDao.getSubjectsByProfNo(no);
         } 
         // -- job 기준 구분의 if/else문 끝
         
         aDao.close();
         session.setAttribute("subjectList", list); //request의 attribute에 넣어줌
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      response.sendRedirect("/class/studentAttend.jsp");
      
   }

}