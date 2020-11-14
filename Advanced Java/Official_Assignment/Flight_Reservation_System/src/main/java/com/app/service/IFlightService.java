package com.app.service;

import java.util.List;

import com.app.pojos.City;
import com.app.pojos.Flight;

public interface IFlightService {
	List<Flight> getAvailableFlights(City departureCity, City arrivalCity);

	Flight getSelectedFlight(int flightId);
}
