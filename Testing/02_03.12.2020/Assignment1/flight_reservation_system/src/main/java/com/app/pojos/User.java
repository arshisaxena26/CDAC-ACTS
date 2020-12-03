package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer userId;

	@NotNull(message = "User Email cannot be Null")
	@Email(message = "Invalid Email ID")
	@Column(length = 25, unique = true)
	private String email;

	@NotNull(message = "User Name cannot be Null")
	@Column(length = 25)
	private String name;

	@NotNull(message = "User Password cannot be Null")
	@Column(length = 10)
	private String password;

	// One To Many Bidirectional Mapping
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Passenger> passengers = new ArrayList<>();

	public User() {
		// Default Constructor
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", name=" + name + ", password=" + password + "]";
	}
}
