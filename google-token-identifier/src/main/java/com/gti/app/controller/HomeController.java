package com.gti.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class HomeController {
	
	@GetMapping(value="/")
	public ResponseEntity<String> defaultApi() {
		return new ResponseEntity<>("API Running....", HttpStatus.OK);
	}
	
}
