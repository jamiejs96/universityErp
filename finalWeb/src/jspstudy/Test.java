package jspstudy;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test1")
public class Test extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String date = req.getParameter("date");
		String d2 = date.replaceAll("-", "");
		
		int year = Integer.parseInt(d2.substring(0,4));
		int month = Integer.parseInt(d2.substring(4,6));
		int date1 = Integer.parseInt(d2.substring(6));
		
	}
}

