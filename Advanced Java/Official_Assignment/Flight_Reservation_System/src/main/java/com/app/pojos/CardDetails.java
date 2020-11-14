package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cards")
public class CardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private Integer cardId;

	@Column(name = "card_number")
	private long cardNumber;

	@Column(name = "expiry_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;

	@Column(length = 25)
	private String name;

	// One To One BiDirectional Mapping
	@OneToOne
	@JoinColumn(name = "reservation_id")
	private Passenger cardOwner;

	public CardDetails() {
		System.out.println("In CardDetails Constructor");
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passenger getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(Passenger cardOwner) {
		this.cardOwner = cardOwner;
	}

	@Override
	public String toString() {
		return "CardDetails [cardId=" + cardId + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", name="
				+ name + "]";
	}
}
