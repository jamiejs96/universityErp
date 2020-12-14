package member.proc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.RestBackDao;
import member.dto.HyuHakforProf;

@WebServlet("/hyuBoard")
public class HyuBoardforProf extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RestBackDao rDao = new RestBackDao();
		ArrayList<HyuHakforProf> list;
		try {
		rDao.connect();
		list = rDao.hyuHakBoard(request);
		session.setAttribute("boardList", list);
		response.sendRedirect("/restBack/hyuHak.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
