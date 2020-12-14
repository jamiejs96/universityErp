package json.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

@WebServlet("/ajaxTest/AABB")
public class AA extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost로 AABB로 들어옴");
		String id = "101";
		String pw = "aaa";
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("pw", pw);
		PrintWriter out = response.getWriter();
		if(request.getParameter("id").equals(id)) {
			out.print(json);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet으로 AABB 들어옴");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		Mm mm = new Mm(id, pw);
		session.setAttribute("mm", mm);
		response.sendRedirect("ajax.jsp");
		
	}

}
