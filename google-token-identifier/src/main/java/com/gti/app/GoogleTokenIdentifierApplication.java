package com.gti.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class GoogleTokenIdentifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleTokenIdentifierApplication.class, args);
	}

}


