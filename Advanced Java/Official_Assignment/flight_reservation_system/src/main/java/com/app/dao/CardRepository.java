package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CardDetails;

public interface CardRepository extends JpaRepository<CardDetails, Integer> {
	@SuppressWarnings("unchecked")
	CardDetails save(CardDetails c);
}
