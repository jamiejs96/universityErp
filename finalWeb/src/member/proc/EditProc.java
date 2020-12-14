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

@WebServlet("/editProc")
public class EditProc extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//post 방식일때 request로 받은 문자열을 한글로 받으려면
		//request.setCharacterEncoding("utf-8"); 필수
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberDAO();
		
		try {
			dao.connect();
			Member member = dao.editMember(request);
			//request값을 넣어주면 editMember 메소드 내부에서
			//session값에 들어가있는 member와 수정된 값들을 얻고 set 해준 다음
			//DB에 업데이트 하고 수정된 member를 반환해줌.
			
			if(member != null) {
				//수정된 member 객체를 session에 다시 넣어줌.
				session.setAttribute("member",member);
				response.sendRedirect("personal/personalInfo.jsp");
				//이미 파라메터로 값을 다 사용하였고, session에는 이미 값이 들어가있는데다가
				//request에서 별도로 쓸 값이 없기때문에 dispatcher가 아닌 response로 sendRedirect해줌.
			}
			else {
				response.sendRedirect("errorPage.html");
			}
			
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
