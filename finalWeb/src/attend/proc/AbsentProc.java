package attend.proc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attend.dao.AbsentDAO;
import attend.dto.AbsentDTO;
import jspstudy.Test2;
import member.dto.Member;

@WebServlet("/absent")
public class AbsentProc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		int no = member.getNo();
		
		ArrayList<AbsentDTO> list = null;
		AbsentDAO absDAO = new AbsentDAO();
		AbsentDTO absDTO = null;
		
		
		String paramDate = request.getParameter("date");
		int paramDay_ = Integer.parseInt(request.getParameter("day"));
		String paramDay = absDAO.getDay(paramDay_);
		paramDate = paramDate.replaceAll("-", "");
		int pYear = Integer.parseInt(paramDate.substring(0, 4));
		int pMonth = Integer.parseInt(paramDate.substring(4, 6));
		int pDate = Integer.parseInt(paramDate.substring(6));
		int pD = absDAO.getDate(pYear, pMonth, pDate);
		int startD = absDAO.getDate(2020, 7, 20);
		int week = (pD - startD)/7 + 1;
		RequestDispatcher dispatcher = request.getRequestDispatcher("/class/studentAbsent.jsp");

		try {
			absDAO.connect();
			list = absDAO.getBogun(no); //학번으로 여태까지 신청한 결석 목록을 가져옴
			if (list.size() != 0) { //결석을 신청한적이 1번 이상이라면
				absDTO = list.get(0); //가장 위(가장최근)에 있는 로우의 날짜와 비교;
				Date dbDate = absDTO.getDate();
				int dbD = absDAO.getDate(dbDate.getYear() + 1900, dbDate.getMonth() + 1, dbDate.getDate());

				if (pD - dbD < 21) {
					request.setAttribute("absentFlag", 0);
				}else {
					absDAO.insertBogun(no, paramDate.substring(2));
					absDAO.updateAttend(no, paramDay,week);
					request.setAttribute("absentFlag", 1);
				}

			} else {

				absDAO.insertBogun(no, paramDate.substring(2));
				absDAO.updateAttend(no, paramDay,week);
				request.setAttribute("absentFlag", 1);

			}
			list = absDAO.getBogun(no);
			request.setAttribute("absList", list);
			dispatcher.forward(request, response);
			absDAO.close();
//	response.sendRedirect("/absentBeforeSelect");
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
