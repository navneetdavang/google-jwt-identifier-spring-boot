package com.gti.app.security.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gti.app.security.auth.GoogleJwtAuthenticator;
import com.gti.app.security.exception.InvalidTokenException;

@Service
public class JwtService {

	@Autowired
	private GoogleJwtAuthenticator googleAuth;

	public String extractUserEmail(String token) {

		try {
			String email = googleAuth.extractEmail(token);
			return email;
		} catch (InvalidTokenException e) {
			System.out.println("InvalidTokenException : ");
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			System.out.println("GeneralSecurityException : ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException : ");
			e.printStackTrace();
		}
		
		return null;
	}
}
