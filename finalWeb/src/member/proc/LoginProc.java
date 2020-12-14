package member.proc;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import member.dao.MemberDAO;
import member.dto.Member;
import member.dto.StudentAdd;

@WebServlet("/loginProc")
public class LoginProc extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		Member member;
		StudentAdd stdAdd = null;
		
		int no = Integer.parseInt(request.getParameter("id"));
		int s = Integer.parseInt(request.getParameter("job"));
		
		try {
			dao.connect();
			member = dao.getMember(no, s);
			
				HttpSession session = request.getSession();
				
				if(s==1) { //학생 로그인일 경우 학생의 추가정보(StudentAdd)를 받고, 그것을 session에 넣어줌.
					stdAdd = dao.getStdAdd(no);
					session.setAttribute("stdAdd", stdAdd);
				}
				session.setAttribute("id", no);
				session.setAttribute("member", member);
				response.sendRedirect("main.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			dao.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
