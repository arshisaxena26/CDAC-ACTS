package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;

	@Column(length = 10)
	private String city;

	@Column(length = 10)
	private String state;

	@Column(length = 10)
	private String country;

	@OneToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

	public Location() {
		// default Constructor
	}

	// Parameterized Constructor
	public Location(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}

	// Getters and Setters
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", city=" + city + ", state=" + state + ", country=" + country
				+ "]";
	}
}
