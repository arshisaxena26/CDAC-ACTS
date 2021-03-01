package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dto.SearchDTO;
import com.app.pojos.Flight;
import com.app.service.IFlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private IFlightService flightService;

	@GetMapping("/search")
	public String searchFlights(SearchDTO s) {
		return "/flight/search";
	}

	@PostMapping("/search")
	public String displayAvailableFlights(SearchDTO s, Model modelMap) {

		if (s.getDepartureDate().isBefore(LocalDate.now()))
			throw new ResourceNotFoundException("No Flights Available for Back Dates");

		List<Flight> flight_list = flightService.getAvailableFlights(s.getDepartureCity(), s.getArrivalCity());

		if (flight_list.isEmpty())
			throw new ResourceNotFoundException("No Flights Available for the Selection");

		modelMap.addAttribute("flight_list", flight_list);
		return "/flight/display";
	}
}
