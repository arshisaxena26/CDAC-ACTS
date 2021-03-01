package dao;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Customer;

public class CustomersDaoImpl implements ICustomersDao {
	private Connection conn;
	private PreparedStatement ps1, ps2, ps3, ps4;

	public CustomersDaoImpl() throws ClassNotFoundException, SQLException {
		conn = fetchDBConnection();
		ps1 = conn.prepareStatement("select * from my_customers where email=? and password=?");
		ps2 = conn.prepareStatement("insert into my_customers values(default,?,?,?,?,?,?)");
		ps3 = conn.prepareStatement("update my_customers set password=? where email=? and password=?");
		ps4 = conn.prepareStatement("delete from my_customers where id=?");
	}

	@Override
	public Customer authenticateUser(String email, String password) throws SQLException {
		ps1.setString(1, email);
		ps1.setString(2, password);

		try (ResultSet rst = ps1.executeQuery()) {
			if (rst.next()) {
				return new Customer(rst.getInt(1), rst.getDouble(2), email, rst.getString(4),
						password, rst.getDate(6), rst.getString(7));
			}
		}
		return null;
	}

	@Override
	public String customerRegistration(double depositAmount, String email, String name, String password, Date regDate,
			String role) throws SQLException {

		ps2.setDouble(1, depositAmount);
		ps2.setString(2, email);
		ps2.setString(3, name);
		ps2.setString(4, password);
		ps2.setDate(5, regDate);
		ps2.setString(6, role);

		int insert = ps2.executeUpdate();
		if (insert == 1)
			return "Table Updated";
		return "Table Updation Failed";
	}

	@Override
	public String changeCustomerPassword(String email, String oldPassword, String newPassword) throws SQLException {
		ps3.setString(1, newPassword);
		ps3.setString(2, email);
		ps3.setString(3, oldPassword);

		int update = ps3.executeUpdate();
		if (update == 1)
			return "Table Updated";
		return "Table Updation Failed";
	}

	@Override
	public String unsubscribeCustomer(int customerID) throws SQLException {
		ps4.setInt(1, customerID);

		int delete = ps4.executeUpdate();
		if (delete == 1)
			return "Table Updated";
		return "Table Updation Failed";
	}

	public void cleanup() throws SQLException {
		if (ps1 != null)
			ps1.close();
		if (ps2 != null)
			ps2.close();
		if (ps3 != null)
			ps3.close();
		if (ps4 != null)
			ps4.close();
		if (conn != null)
			conn.close();

	}

}
