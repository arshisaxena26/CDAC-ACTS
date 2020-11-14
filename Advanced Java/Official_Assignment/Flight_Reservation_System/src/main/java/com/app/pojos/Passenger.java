package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passengers")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer reservationId;

	@Column(length = 25)
	private String name;

	@Column(length = 20, unique = true)
	private String email;

	@Column(length = 10)
	private String phone;

	// Many to One Bidirectional Mapping
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// One to One Unidirectional Mapping
	@OneToOne(targetEntity = Flight.class, cascade = CascadeType.ALL)
	private Flight flight;

	@OneToOne(mappedBy = "cardOwner", cascade = CascadeType.ALL)
	private CardDetails card;

	public Passenger() {
		System.out.println("In Passenger Pojo's Default Constructor");

	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CardDetails getCard() {
		return card;
	}

	public void setCard(CardDetails card) {
		this.card = card;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Passenger [reservationId=" + reservationId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ "]";
	}
}
