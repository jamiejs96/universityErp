package json.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import member.dao.MemberDAO;
import member.dto.Member;

@WebServlet("/beforeLoginJSON")
public class JSONlogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int no = Integer.parseInt(request.getParameter("no"));
		int job = Integer.parseInt(request.getParameter("job"));
		System.out.println(no);
		System.out.println(job);
		JSONObject json = new JSONObject();
		MemberDAO memberDao = new MemberDAO();
		try {
			memberDao.connect();
			Member member = memberDao.getMember(no, job);
			if(member != null) {
			json.put("pw", member.getPw());
			memberDao.close();
			}else {
				json.put("pw", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			out.print(json);
			out.flush();
			out.close();
		}
	}

}
