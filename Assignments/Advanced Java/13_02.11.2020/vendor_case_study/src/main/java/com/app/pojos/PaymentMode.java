package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class PaymentMode {

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_mode", length = 15)
	private PaymentType paymentType;

	@Column(name = "payment_amount")
	private double amount;

	@Column(name = "payment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	public PaymentMode() {
		// default Constructor
	}

	// Parameterized Constructor
	public PaymentMode(PaymentType paymentType, double amount, LocalDate date) {
		super();
		this.paymentType = paymentType;
		this.amount = amount;
		this.date = date;
	}

	// Getters and Setters
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PaymentMode [paymentType=" + paymentType + ", amount=" + amount + ", date=" + date + "]";
	}
}
