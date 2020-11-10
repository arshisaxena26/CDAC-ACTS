package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Vendor;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {
	@PersistenceContext
	private EntityManager session;

	@Override
	public Vendor authenticateUser(String email, String pass) {
		String jpql = "select v from Vendor v where v.email = :em and v.password = :pass";
		Vendor vendor = session.createQuery(jpql, Vendor.class).setParameter("em", email).setParameter("pass", pass)
				.getSingleResult();
		vendor.getAccounts().size();
		return vendor;
	}

}
