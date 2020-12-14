package member.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.dto.Member;


@WebServlet("/getJson")
public class GetJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("type/html;charset=UTF-8");
		String strNo = request.getParameter("no");
		System.out.println(strNo);
		int no = Integer.parseInt(strNo);
		try {
		response.getWriter().write(getJSON(no));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getJSON(int no) throws Exception {
		MemberDAO mDao = new MemberDAO();
		mDao.connect();
		Member member = mDao.getMember(1,1);
		String result = "{\"no\":" + member.getNo() 
		+ ",\"pw\":\"" + member.getPw()+"\"}";
		//'({"no":1,"pw":"abc"})'
		return result;
	}

}
