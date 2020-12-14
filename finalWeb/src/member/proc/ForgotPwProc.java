package member.proc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.dto.Member;

@WebServlet("/forgotPw")
public class ForgotPwProc extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//post 방식일때 request로 받은 문자열을 한글로 받으려면
		//request.setCharacterEncoding("utf-8"); 필수
		response.setCharacterEncoding("UTF-8");
		MemberDAO mDao = new MemberDAO();
		Member member;
		try {
		mDao.connect();
		member = mDao.forgotPw(request);
		request.setAttribute("forgotPwMember", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login/forgotPwResult.jsp");
		dispatcher.forward(request, response);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
