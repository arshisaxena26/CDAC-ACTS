package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	@SuppressWarnings("unchecked")
	Passenger save(Passenger p);
}
