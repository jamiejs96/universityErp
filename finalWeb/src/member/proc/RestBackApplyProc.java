package member.proc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.dao.RestBackDao;
import member.dto.Member;
import member.dto.StudentAdd;

@WebServlet("/restBackApply")
public class RestBackApplyProc extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		//post 방식일때 request로 받은 문자열을 한글로 받으려면
		//request.setCharacterEncoding("utf-8"); 필수
		response.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		RestBackDao rDao = new RestBackDao();
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		int stdNo = member.getNo();

		try {
			rDao.connect();

			if(flag.equals("휴학신청")) {
				System.out.println("휴학으로 들어왓따");
				rDao.applyHyuHak(request);
			}else {
				System.out.println("복학으로 들어왓따");
				//복학 Process
				rDao.bokhak(stdNo);
				StudentAdd stdAdd = (StudentAdd)session.getAttribute("stdAdd");
				stdAdd.setStdStatus(0);
				session.setAttribute("stdAdd", stdAdd);
				
			}
			
			response.sendRedirect("/personal/personalInfo.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
