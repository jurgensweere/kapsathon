package org.kapsathon.gonephishin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SendEmailService {

	private static final String INBOX = "inbox";

	private static final String SPAM = "spam";

	@Autowired
	EmailValidator emailValidator;
	
	@Autowired
	EmailRepository emailRepository;
	
	public ResponseEntity<Void> sendEmail(Email email) {
		if(emailValidator.validate(email.getSender())) {
			email.setMeta(INBOX);
		emailRepository.save(email);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			email.setMeta(SPAM);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
}
