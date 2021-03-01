package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FlightRepository;
import com.app.pojos.City;
import com.app.pojos.Flight;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {

	@Autowired
	private FlightRepository flightRepo;

	@Override
	public List<Flight> getAvailableFlights(City departureCity, City arrivalCity) {
		return flightRepo.findByDepartureCityAndArrivalCity(departureCity, arrivalCity);
	}

	@Override
	public Flight getSelectedFlight(int flightId) {
		return flightRepo.findByFlightId(flightId);
	}

}
