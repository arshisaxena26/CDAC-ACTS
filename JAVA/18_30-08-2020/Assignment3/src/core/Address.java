package core;

public class Address {
	//private data members
	private String city, state, phoneNo;

	public Address(String city, String state, String phoneNo) {
		super();
		this.city = city;
		this.state = state;
		this.phoneNo = phoneNo;
	}

	//Overriding toString 
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", phoneNo=" + phoneNo + "]";
	}

	//Getters
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
}
