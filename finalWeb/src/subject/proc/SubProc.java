package subject.proc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.dao.SubjectDao;
import subject.dto.Subject;

@WebServlet("/subProc")
public class SubProc extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html; charset=UTF-8");
      request.setCharacterEncoding("utf-8");
      //post 방식일때 request로 받은 문자열을 한글로 받으려면
      //request.setCharacterEncoding("utf-8"); 필수
      response.setCharacterEncoding("UTF-8");
      SubjectDao subDao = new SubjectDao();
      try {
      subDao.connect();
      List<Subject> list = subDao.searchSub(request); 
      String json = subDao.getJSON(list);
      subDao.close();
      response.getWriter().write(json);

      }
      catch(Exception e) {
         e.printStackTrace();
      }
      
      
      
   }
}