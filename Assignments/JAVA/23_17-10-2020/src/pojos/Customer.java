package pojos;

import java.sql.Date;

public class Customer {

	// POJO Properties
	private int id;
	private double depositAmount;
	private String email, name, password;
	private Date registrationDate;
	private String role;

	public Customer() {
		// default Constructor
	}

	// Parameterized Constructor -- all properties
	public Customer(int id, double depositAmount, String email, String name, String password, Date registrationDate,
			String role) {
		super();
		this.id = id;
		this.depositAmount = depositAmount;
		this.email = email;
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
		this.role = role;
	}

	// Parameterized Constructor -- excluding auto-increment properties
	public Customer(double depositAmount, String email, String name, String password, Date registrationDate,
			String role) {
		super();
		this.depositAmount = depositAmount;
		this.email = email;
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
		this.role = role;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", depositAmount=" + depositAmount + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", registrationDate=" + registrationDate + ", role=" + role + "]";
	}
}
