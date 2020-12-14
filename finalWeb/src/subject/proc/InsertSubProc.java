package subject.proc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.Member;
import subject.dao.CurrentSubDAO;

@WebServlet("/insertSub")
public class InsertSubProc extends HttpServlet {
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      Member member = (Member)session.getAttribute("member");
      CurrentSubDAO subDao = new CurrentSubDAO();
      try {
         subDao.connect();
         int[] paramSubNo = subDao.getSubParamFromPage(request);
         //수강신청버튼을 눌러서 추가된 과목들의 과목코드 목록을 받아오는 메소드
         
         subDao.insertSub(member.getNo(), paramSubNo);
         //위에 getSubParamFromPage메소드에서 리턴된 과목코드배열과 학번을 통해 currSub테이블에 과목을 추가하는 메소드
         subDao.close();
         
         //현재 수강신청해도 페이지는 넘어가지 않음.
         response.sendRedirect("currSub");
         
      }catch(Exception e) {
         e.printStackTrace();
      }
      
   
   }
}