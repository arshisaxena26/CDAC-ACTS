package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	public static Connection fetchDBConnection() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/employees?useSSL=false";
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(url, "root", "password");
	}
}
