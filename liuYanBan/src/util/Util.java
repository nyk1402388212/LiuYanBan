package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	private static Util util = new Util();

	private Util(){
		   try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  Util getInstance(){
		return util;
	}
	public Connection getConnection(){
		Connection conn= null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","140238821");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
