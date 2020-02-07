package org.kapsathon.gonephishin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*
 * Service class to process the send email requests
 */
public class SendEmailService {

	private static final String INBOX = "inbox";

	private static final String SPAM = "spam";

	@Autowired
	EmailValidator emailValidator;
	
	@Autowired
	EmailRepository emailRepository;
	
	public ResponseEntity<Object> sendEmail(Email email) {
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
