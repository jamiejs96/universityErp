package conn.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	Connection conn;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testDB";
	String user = "egoing";
	String pass = "1111";
	public Connection connect() throws Exception {
	Class.forName(driver);
	conn = DriverManager.getConnection(url,user,pass);
	return conn;
}
	
}
