package attend.proc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import member.dto.Member;
@WebServlet("/absentBeforeSelect")
public class AbsentBeforeSelect extends HttpServlet{
@Override
protected void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	AbsentDAO absDAO = new AbsentDAO();
	HttpSession session = request.getSession();
	Member member = (Member)session.getAttribute("member");
	ArrayList<AbsentDTO> list;
	AbsentDTO absDTO = null;
	try {
		absDAO.connect();
		list = absDAO.getBogun(member.getNo());
		request.setAttribute("absList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/class/studentAbsent.jsp");
		dispatcher.forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
service(req,resp);
}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
service(req,resp);
}
}
