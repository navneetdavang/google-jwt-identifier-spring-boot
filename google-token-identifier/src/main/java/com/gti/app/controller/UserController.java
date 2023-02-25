package com.gti.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gti.app.entity.User;
import com.gti.app.service.UserService;

@RestController
@RequestMapping(value="/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.fetchAllUsers();
		HttpStatus responseStatus = users.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<>(users, responseStatus);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> getUserInfo(@PathVariable("id") Long id){
		User user = userService.fetchUserInfo(id);
		HttpStatus responseStatus = user == null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(user, responseStatus);
	}
	
}
