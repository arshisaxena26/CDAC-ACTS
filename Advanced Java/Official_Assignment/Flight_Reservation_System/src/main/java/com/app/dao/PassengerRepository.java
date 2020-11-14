package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
	@SuppressWarnings("unchecked")
//	@Query("select u from User u join fetch u.passengers where u.userId = :id")
//	User getUserPassengerDetails(@Param("id") Integer userId);

	Passenger save(Passenger p);
}
