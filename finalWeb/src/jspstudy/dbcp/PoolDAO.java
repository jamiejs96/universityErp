package jspstudy.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;

public class PoolDAO {

	BasicDataSource ds;
	
	public PoolDAO() {
		ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("egoing");
		ds.setPassword("1111");
		ds.setInitialSize(10);
	}
	public ArrayList<PoolDTO> select(){
		ArrayList<PoolDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String query = "select * from subject";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PoolDTO dto = new PoolDTO();
				dto.setSubName(rs.getString("sub_name"));
				dto.setSubNo(rs.getInt("sub_no"));
				list.add(dto);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
