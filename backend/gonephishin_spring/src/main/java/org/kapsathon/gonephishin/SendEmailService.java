package org.kapsathon.gonephishin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class SendEmailService {

	@Autowired
	EmailValidator emailValidator;
	
	public ResponseEntity<Void> sendEmail(Email email) {
		emailValidator.validate(email.getSender());
		return null;
		
	}
}
