package member.proc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.dao.RestBackDao;
import member.dto.HyuHakforProf;
import member.dto.Member;
import member.dto.StudentAdd;

@WebServlet("/restBack")
public class RestBackProc extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//휴복학 페이지
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//post 방식일때 request로 받은 문자열을 한글로 받으려면
		//request.setCharacterEncoding("utf-8"); 필수
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		int job = member.getJob();
		if(job == 1) {
			//학생이면 휴학고고페이지로
			//hyuList를 리퀘스트에 넣어줘야함***
			RestBackDao rbDao = new RestBackDao();
			ArrayList<HyuHakforProf> list = new ArrayList<>();
			try {
			rbDao.connect();
			list = rbDao.hyuHakBoard(request);
			request.setAttribute("hyuList", list);
			}catch(Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/restBack/hyuHak.jsp");
			dispatcher.forward(request, response);
			
		}else {
			//교수이면 확인게시판으로
			response.sendRedirect("hyuBoard");
		}

		
	}

}
