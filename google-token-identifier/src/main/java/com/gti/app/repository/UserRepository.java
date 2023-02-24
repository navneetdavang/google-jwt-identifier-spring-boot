package com.gti.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gti.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmailId(String emailId);

}
