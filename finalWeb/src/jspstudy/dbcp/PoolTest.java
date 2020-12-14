package jspstudy.dbcp;

import java.util.ArrayList;

public class PoolTest {
public static void main(String[] args) {
	PoolDAO dao = new PoolDAO();
	ArrayList<PoolDTO> list = dao.select();
	
	for(PoolDTO dto : list) {
		int subNo = dto.getSubNo();
		String subName = dto.getSubName();
		System.out.printf("%s는 %s\n",subNo,subName);
	}
}


}
