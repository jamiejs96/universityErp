package jspstudy;

import attend.dao.AbsentDAO;

//년 월 일을 입력받아 1년중 몇번째 날인가

public class Test2 {
public static void main(String[] args) {
	AbsentDAO a = new AbsentDAO();
	System.out.println(a.getDate(2020, 7, 24));
	System.out.println(a.getDate(2020, 7, 25));
	//뒤에꺼 - 시작일  : 만약 8월1일 시작 8월2일 신청일 경우 day는 2가 나옴.
	//0~6 사이 1주차
	//7~13 사이 2주차
	// day/7이 0이면 1주차
	// day/7이 1이면 2주차이므로
	// day/7 + 1 이 주차가됨.
	
}
	

}
