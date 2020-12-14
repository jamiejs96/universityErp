package member.proc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.RestBackDao;

@WebServlet("/confirmRestBack")
public class RestBackConfirmProc extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] stdNums_ = request.getParameterValues("stdNums");
		int[] stdNums = new int[stdNums_.length];
		for(int i=0; i<stdNums.length;i++) {
			stdNums[i] = Integer.parseInt(stdNums_[i]);
		}
		RestBackDao rbDao = new RestBackDao();
		try {
			rbDao.connect();
			rbDao.confirmHyuForProf(stdNums);
			response.sendRedirect("hyuBoard");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
