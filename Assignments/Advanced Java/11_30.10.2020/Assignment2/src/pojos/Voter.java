package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "voters")
public class Voter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int voterID;
	private String name;
	private String email;
	private String password;
	private boolean status;
	private String role;

	public Voter() {
		// default constructor
	}

	// Parameterized Constructor
	public Voter(int voterID, String name, String email, String password, boolean status, String role) {
		super();
		this.voterID = voterID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	// Parameterized Constructor excluding auto-increment properties
	public Voter(String name, String email, String password, boolean status, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.role = role;
	}

	// Getters and Setters
	public int getVoterID() {
		return voterID;
	}

	public void setVoterID(int voterID) {
		this.voterID = voterID;
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Voter [voterID=" + voterID + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", status=" + status + ", role=" + role + "]";
	}
}
