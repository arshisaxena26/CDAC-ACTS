package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.City;
import com.app.pojos.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	List<Flight> findByDepartureCityAndArrivalCity(City departureCity, City arrivalCity);

	Flight findByFlightId(Integer flightId);
}
