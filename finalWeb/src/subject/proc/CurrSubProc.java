package subject.proc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.Member;
import subject.dao.CurrentSubDAO;
import subject.dto.Subject;

@WebServlet("/currSub")
public class CurrSubProc extends HttpServlet {
   
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   response.setContentType("text/html; charset=UTF-8");
   request.setCharacterEncoding("utf-8");
   //post 방식일때 request로 받은 문자열을 한글로 받으려면
   //request.setCharacterEncoding("utf-8"); 필수
   response.setCharacterEncoding("UTF-8");
   CurrentSubDAO subDao = new CurrentSubDAO();
   HttpSession session = request.getSession();
   Member member = (Member)session.getAttribute("member");
   int no = member.getNo();
   int job = member.getJob();

   List<Subject> list;
   try {
      
   subDao.connect();
   list = subDao.getCurrSub(no,job);
      //이부분 지워야함
   //if(list != null) {
//   String json = subDao.getCurrSubJSON(list);
//   out.print(json);
   //
   request.setAttribute("currSubList", list);
   RequestDispatcher dispatcher = request.getRequestDispatcher("/class/studentClassApply.jsp");
   dispatcher.forward(request, response);
   
/*   //}else {
      out.print("");
   }*/
   }
   catch(Exception e) {
      e.printStackTrace();
   }
   
}
}