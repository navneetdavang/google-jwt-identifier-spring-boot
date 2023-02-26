package com.gti.app.security.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.gti.app.security.exception.InvalidTokenException;

@Component
public class GoogleJwtAuthenticator implements JwtAuthenticator {

	@Value("${spring.security.oauth2.client.registration.google.client-id}")
	private String clientId;

	public String extractEmail(String token) throws InvalidTokenException, GeneralSecurityException, IOException {

		System.out.println(clientId);

		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
				.setAudience(Collections.singletonList(clientId)).build();

		GoogleIdToken idToken = verifier.verify(token);

		if (idToken == null) {
			throw new InvalidTokenException("Invalid Token");
		}

		Payload payload = idToken.getPayload();

		String userId = payload.getSubject();
		System.out.println(userId);

		// Get profile information from payload
		String email = payload.getEmail();
		boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		String name = (String) payload.get("name");
		String pictureUrl = (String) payload.get("picture");
		String locale = (String) payload.get("locale");
		String familyName = (String) payload.get("family_name");
		String givenName = (String) payload.get("given_name");
		String iat = (String) payload.get("iat");
		String exp = (String) payload.get("exp");
		String jti = (String) payload.get("jti");
		
		
		System.out.println("email :" + email);
		System.out.println("emailVerified :" + emailVerified);
		System.out.println("name :" + name);
		System.out.println("pictureUrl :" + pictureUrl);
		System.out.println("locale :" + locale);
		System.out.println("familyName :" + familyName);
		System.out.println("givenName :" + givenName);
		System.out.println("iat :" + iat);
		System.out.println("exp :" + exp);
		System.out.println("jti :" + jti);
		
		
		return email;
	}
}
