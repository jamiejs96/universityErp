//package attend.proc;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import attend.dao.AttendDAO;
//import attend.dto.AttendDTO;
//import member.dto.Member;
//
//@WebServlet("/attendProc")
//public class AttendProc extends HttpServlet {
//   @Override
//   protected void doPost(HttpServletRequest request, HttpServletResponse response)
//         throws ServletException, IOException {
//      HttpSession session = request.getSession();
//      Member member = (Member) session.getAttribute("member");
//      AttendDAO aDao = new AttendDAO();
//
//      try {
//         aDao.connect();
//
//         if (member.getJob() == 1) {
//            // job이 1일 경우(학생) 이전 페이지의 허니콤보박스에서 선택된 과목 한개만 받아서 그것을 출력해주는것.
//            AttendDTO aDto = aDao.getAttendForStd(request);
//
//            request.setAttribute("attendForStd", aDto);
//
//         } else { // job이 0일 경우 교수이므로 자신의 과목을 수강하는 학생들의 리스트를 보여줌.
//            int profNo = member.getNo();
//            String subNo_ = request.getParameter("sub_no");
//            int subNo = Integer.parseInt(subNo_);
//            ArrayList<AttendDTO> list = aDao.getAttendForProf(profNo, subNo);
//            request.setAttribute("attendList", list);
//         }
//
//         RequestDispatcher dispatcher = request.getRequestDispatcher("/class/studentAttend.jsp");
//         dispatcher.forward(request, response);
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//
//   }
//}
package attend.proc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import attend.dao.AttendDAO;
import attend.dto.AttendDTO;
import member.dto.Member;

@WebServlet("/attendProc")
public class AttendProc extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      response.setContentType("text/html; charset=UTF-8");
      request.setCharacterEncoding("utf-8");
      //post 방식일때 request로 받은 문자열을 한글로 받으려면
      //request.setCharacterEncoding("utf-8"); 필수
      response.setCharacterEncoding("UTF-8");
      HttpSession session = request.getSession();
      Member member = (Member) session.getAttribute("member");
      AttendDAO aDao = new AttendDAO();
      PrintWriter out = response.getWriter();
      JSONArray jArr = new JSONArray();
      try {
         aDao.connect();

         if (member.getJob() == 1) {
            // job이 1일 경우(학생) 이전 페이지의 허니콤보박스에서 선택된 과목 한개만 받아서 그것을 출력해주는것.
            AttendDTO aDto = aDao.getAttendForStd(request);
            
            JSONObject json = aDao.createADTOJSON(aDto);
            
            jArr.put(json);
            
            
            

            //sub_no를 받고 그 과목 한개에 대한 출석만 확인 되는 aDto를 request에 넣어줌
            
            //sub_no를 받고 그 과목 한개에 대한 출석만 확인 되는 aDto를 request에 넣어줌
//            request.setAttribute("attendForStd", aDto);

         } else { // job이 0일 경우 교수이므로 자신의 과목을 수강하는 학생들의 리스트를 보여줌.
            int profNo = member.getNo();
            String subNo_ = request.getParameter("sub_no");
            int subNo = Integer.parseInt(subNo_);
            ArrayList<AttendDTO> list = aDao.getAttendForProf(profNo, subNo);
            jArr = aDao.createADTOJSONListForProf(list);
            //교수는 복수의 출결을 확인하므로 aDto의 list를 request를 넣어줌.
//            request.setAttribute("attendList", list);
            
         }

         out.print(jArr.toString());
//         RequestDispatcher dispatcher = request.getRequestDispatcher("/attend/studentAttend.jsp");
//         dispatcher.forward(request, response);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
   
}