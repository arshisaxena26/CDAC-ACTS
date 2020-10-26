package pojos;

public class User {
	// properties
	private String name, password;

	public User() {
		// default Constructor
	}

	// Parameterized Constructor
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	// Getters and Setters
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

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
}
