package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.City;
import com.app.pojos.Flight;
import com.app.service.IFlightService;

@Controller
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private IFlightService flightService;

	@GetMapping("/search")
	public String searchFlights(Flight flight) {
		return "/flight/search";
	}

	@PostMapping("/search")
	public String displayFlights(@RequestParam City departureCity, @RequestParam City arrivalCity, Model modelMap) {
		modelMap.addAttribute("flight_list", flightService.getAvailableFlights(departureCity, arrivalCity));
		return "/flight/display";
	}

}
