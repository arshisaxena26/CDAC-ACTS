package com.app.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.pojos.City;

public class SearchDTO {
	private City departureCity;
	private City arrivalCity;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;

	public SearchDTO() {
		// Default Constructor
	}

	public City getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(City departureCity) {
		this.departureCity = departureCity;
	}

	public City getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(City arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

}
