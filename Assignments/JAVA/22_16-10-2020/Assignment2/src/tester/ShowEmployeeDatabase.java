package tester;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowEmployeeDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		try (Connection conn = fetchDBConnection();
				Statement st = conn.createStatement();
				ResultSet set = st.executeQuery("select * from my_emp")) {
			
			System.out.println("EmpID\tName\tAddress\tSalary\tDeptID\tJoin Date");
			
			while (set.next())
				System.out.println(set.getInt(1) + "\t" + set.getString(2) + "\t" + set.getString(3) + "\t"
						+ set.getDouble(4) + "\t" + set.getString(5) + "\t" + set.getDate(6));
		}
	}
}
