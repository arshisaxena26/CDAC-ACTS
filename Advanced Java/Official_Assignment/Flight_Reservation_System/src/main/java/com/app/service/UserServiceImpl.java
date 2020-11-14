package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UserRepository;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User authenticateUser(String email, String pass) {
		return userRepo.findByEmailAndPassword(email, pass);
	}

//	@Override
//	public User getUserPassengerDetails(int id) {
//		return userRepo.anyname(id);
//	}
}
