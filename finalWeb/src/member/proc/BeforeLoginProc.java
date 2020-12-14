package member.proc;

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

//아이디 입력한 상태로 아직 로그인 버튼을 누르기 전에
//ajax로 전달된 id와 job이 일치하는 회원(학생 혹은 교수)를 가져오고(memberDao.getMember)
//그 member객체의 비밀번호를 json으로 전달해주는 역할
@WebServlet("/jsonPw")
public class BeforeLoginProc extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO memberDao = new MemberDAO();
		//ajax로 전달받은 학번 혹은 교수번호(no)와 job(학생여부)를 통해 DB에서 객체를 얻음
		String no_ = request.getParameter("id");
		String job_ = request.getParameter("job");
		//login창에 숫자가 아닌 문자열을 입력할 경우 정규표현식 테스트에 의해 걸러지므로 걱정 없이 Integer로 파싱 가능.
		int no = Integer.parseInt(no_);
		int job = Integer.parseInt(job_);
		Member member;
		//얻은 데이터를 JSON형태로 작성해주는 API
		JSONObject json = new JSONObject();
		//화면에 텍스트로 출력된 json을 ajax가 가져가서 pw를 변수화 하여야하기 때문에 화면에 출력해줄 PrintWriter를 구함
		PrintWriter out = response.getWriter();
		try {
		memberDao.connect();
		member = memberDao.getMember(no, job);
		//혹시나 일치하는 아이디가 없다면 member.getPw에서 NullPointerException이 뜨므로
		//일치하는 아이디가 없는 경우 json의 pw에 빈 문자열을 넣어줌.
		//pw에 빈문자열로 반환하더라도 로그인 창에서 비밀번호를 공란으로 하고 로그인 버튼을 누를 경우
		//로그인이 되지 않아서 괜찮음.
		if(member !=null) {
			json.put("pw",member.getPw());
		}else {
			json.put("pw","");
		}
		//json에 { "pw" : "해당 비밀번호" } 형태로 저장하기 위해 put메소드 사용
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//사용이 끝난 Connection 객체를 닫아줌 --> 참고로 Connection객체는 memberDao의 필드에 선언된 static 객체임
				//PreparedStatement나 ResultSet은 memberDao의 getMember메소드에서 이미 닫혀있는 상태
				memberDao.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			//비밀번호를 json형태로 저장하였기 때문에 저장된 json형태의 데이터를 페이지에 출력해줌.
			out.print(json);
		}
	}

}
