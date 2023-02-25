package com.gti.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.app.entity.User;
import com.gti.app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> fetchAllUsers(){
		return userRepo.findAll();
	}
	
	public User fetchUserInfo(Long id) {
		Optional<User> _user = userRepo.findById(id);
		if(_user.isEmpty())
			return null;
		return _user.get();
	}
	
	public User fetchUserInfo(String emailId) {
		Optional<User> _user = userRepo.findByEmailId(emailId);
		return null;
	}
}
