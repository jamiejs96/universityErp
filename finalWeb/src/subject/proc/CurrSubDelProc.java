package subject.proc;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.Member;
import subject.dao.CurrentSubDAO;

@WebServlet("/delCurrSub")
public class CurrSubDelProc extends HttpServlet{
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=UTF-8");
      request.setCharacterEncoding("utf-8");
      //post 방식일때 request로 받은 문자열을 한글로 받으려면
      //request.setCharacterEncoding("utf-8"); 필수
      response.setCharacterEncoding("UTF-8");
      
      CurrentSubDAO cDao = new CurrentSubDAO();
      
      HttpSession session = request.getSession();
      Member member = (Member)session.getAttribute("member");
      int no = member.getNo();
      int subNo = Integer.parseInt(request.getParameter("subNo"));
      
      try {
      cDao.connect();
      cDao.deleteSub(no, subNo );
      cDao.close();
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      
   }

}