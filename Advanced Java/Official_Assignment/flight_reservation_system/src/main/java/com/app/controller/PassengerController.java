package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.CardDetails;
import com.app.pojos.Passenger;
import com.app.pojos.User;
import com.app.service.IFlightService;
import com.app.service.IPassengerService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private IPassengerService passService;
	@Autowired
	private IFlightService flightService;

	@GetMapping("/details")
	public String showPassengerForm(Passenger p, @RequestParam int flightId, Model modelMap) {
		modelMap.addAttribute("selected_flight", flightService.getSelectedFlight(flightId));
		return "/passenger/details";
	}

	@PostMapping("/details")
	public String showCardDetailsForm(Passenger p, HttpSession session, CardDetails card, @RequestParam int flightId) {
		User user = (User) session.getAttribute("user_credentials");
		p.setFlight(flightService.getSelectedFlight(flightId));
		System.out.println(passService.savePassenger(p, user));
		session.setAttribute("passenger", p);
		return "/passenger/card_dtls";
	}

	@PostMapping("/card")
	public String showReservationStatus(CardDetails card, HttpSession session) {
		Passenger p = (Passenger) session.getAttribute("passenger");
		System.out.println(passService.saveCardDetails(card, p));
		return "/passenger/status";
	}
}
