package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CardRepository;
import com.app.dao.PassengerRepository;
import com.app.pojos.CardDetails;
import com.app.pojos.Passenger;
import com.app.pojos.User;

@Service
@Transactional
public class PassengerServiceImpl implements IPassengerService {

	@Autowired
	private PassengerRepository passRepo;
	@Autowired
	private CardRepository cardRepo;

	@Override
	public String savePassenger(Passenger p, User u) {
		String message = "Passengers Table Updation Failed.";
		p.setUser(u);
		if (passRepo.save(p) != null) {
//			u.addPassengerToList(p);
			message = "Passengers Table Updated Successfully.";
		}
		return message;
	}

	@Override
	public String saveCardDetails(CardDetails c, Passenger p) {
		String message = "Cards Table Updation Failed.";
		c.setCardOwner(p);
		if (cardRepo.save(c) != null) {
			message = "Cards Table Updated Successfully.";
		}
		return message;
	}

	/*
	 * @Override public User getUserPassengerDetails(int id) { return
	 * passRepo.getUserPassengerDetails(id); }
	 */

}
