package member.proc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.dto.Member;
import member.dto.StudentAdd;

/**
 * Servlet implementation class GraduateProf
 */
@WebServlet("/GraduateProc")
public class GraduateProc extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("=================================================================================");
      System.out.println("졸업요건 취득페이지로 들어간다");
      response.setContentType("text/html; charset=UTF-8");
      request.setCharacterEncoding("utf-8");
      //post 방식일때 request로 받은 문자열을 한글로 받으려면
      //request.setCharacterEncoding("utf-8"); 필수
      response.setCharacterEncoding("UTF-8");
      HttpSession session = request.getSession();
      
      MemberDAO dao = new MemberDAO();
      
      try {
         dao.connect();
         Member member = (Member)session.getAttribute("member");

         
       StudentAdd stdadd =dao.getStdAdd(member.getNo());
         
       System.out.println(stdadd.toString());

           session.setAttribute("stdadd",stdadd);
           response.sendRedirect("graduate/graduate.jsp");

      }catch(Exception e) {
         e.printStackTrace();
      }
      
   }

}