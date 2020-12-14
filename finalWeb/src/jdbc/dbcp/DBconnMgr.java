package jdbc.dbcp;

import java.sql.Connection;

import org.apache.tomcat.jdbc.pool.DataSource;

public class DBconnMgr {
	
	DataSource ds = new DataSource();
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testDB";
	String user = "egoing";
	String pass = "1111";
	
	public DBconnMgr() {
	ds.setDriverClassName(driver);
	ds.setMaxActive(100);
	ds.setUrl(url);
	ds.setUsername(user);
	ds.setPassword(pass);
	ds.setMaxWait(5000);
	ds.setInitialSize(100);
	
	}
	public Connection getConn() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
