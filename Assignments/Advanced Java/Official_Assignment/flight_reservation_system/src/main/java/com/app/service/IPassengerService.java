package com.app.service;

import com.app.pojos.CardDetails;
import com.app.pojos.Passenger;
import com.app.pojos.User;

public interface IPassengerService {
	String savePassenger(Passenger p, User u);

	String saveCardDetails(CardDetails c, Passenger p);

//	User getUserPassengerDetails(int id);
}
