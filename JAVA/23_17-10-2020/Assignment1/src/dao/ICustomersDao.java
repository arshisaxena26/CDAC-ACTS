package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojos.Customer;

public interface ICustomersDao {

	Customer authenticateUser(String email, String password) throws SQLException;

	String customerRegistration(double depositAmount, String email, String name, String password, Date regDate,
			String role) throws SQLException;

	String changeCustomerPassword(String email, String oldPassword, String newPassword) throws SQLException;

	String unsubscribeCustomer(int customerID) throws SQLException;
}
