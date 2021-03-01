package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;

	public static Connection fetchDBConnection() {
		return cn;
	}

	public static void createSingletonConnection(String driverClass, String url, String username, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(driverClass);
		cn = DriverManager.getConnection(url, username, password);
	}

	public static void cleanup() throws SQLException {
		if (cn != null)
			cn.close();
	}
}
