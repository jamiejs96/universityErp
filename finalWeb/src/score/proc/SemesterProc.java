package score.proc;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.Member;
import score.dao.ScoreDAO;
import score.dto.Score;

@WebServlet("/semesterProc")
public class SemesterProc extends HttpServlet {
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // 출결과 수강신청에 사용됨.
      response.setContentType("text/html; charset=UTF-8");
      request.setCharacterEncoding("utf-8");
      // post 방식일때 request로 받은 문자열을 한글로 받으려면
      // request.setCharacterEncoding("utf-8"); 필수
      response.setCharacterEncoding("UTF-8");
      ScoreDAO sDao = new ScoreDAO();
      HttpSession session = request.getSession();
      List<Score> list;
      Map<String,List<Score>> map;
      Member member = (Member) session.getAttribute("member");
      int job = member.getJob();

      try {
         sDao.connect();
         list = sDao.getScores(request);
         map = sDao.getScoreMap(list);
//         sDao.getScoreMap(list);
//         request.setAttribute("scores", list);
         request.setAttribute("scores", map);

         sDao.close();
         
         RequestDispatcher dispatcher =  request.getRequestDispatcher("/score/score.jsp");
         dispatcher.forward(request, response);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      service(req, resp);
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      service(req, resp);
   }
}