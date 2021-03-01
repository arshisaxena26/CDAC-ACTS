package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 10)
	private String name;

	@Column(length = 15, unique = true)
	private String email;

	@Column(length = 15)
	private String password;

	@Column(name = "reg_amount")
	private double regAmount;

	@Column(name = "reg_date")
	private LocalDate regDate;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Role role;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "accountHolder")
	private List<BankAccount> accounts = new ArrayList<>();

	@OneToOne(mappedBy = "vendor", cascade = CascadeType.ALL)
	private Location location;

	@Embedded
	private PaymentMode paymentMode;

	@ElementCollection
	@CollectionTable(name = "phone_numbers", joinColumns = @JoinColumn(name = "vendor_id"))
	@Column(name = "phone_number", length = 10)
	private List<String> phoneNumbers = new ArrayList<>();

	public Vendor() {
		// default Constructor
	}

	// Parameterized Constructor
	public Vendor(String name, String email, String password, double regAmount, LocalDate regDate, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.role = role;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", regAmount="
				+ regAmount + ", regDate=" + regDate + ", role=" + role + "]";
	}

	// Helper Methods for Bidirectional Association
	public void addBankAccountToList(BankAccount b) {
		this.accounts.add(b); // Adding to List
		b.setAccountHolder(this); // Setting FK Value
	}

	public void removeBankAccountFromList(BankAccount b) {
		this.accounts.remove(b); // Removing from List
		b.setAccountHolder(null); // Setting FK value to NULL
	}

	public void addVendorLocation(Location loc) {
		this.location = loc;
		loc.setVendor(this);
	}

	public void removeVendorLocation(Location loc) {
		this.location = null;
		loc.setVendor(null);
	}
}
