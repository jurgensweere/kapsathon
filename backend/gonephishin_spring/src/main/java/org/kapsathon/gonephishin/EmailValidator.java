package org.kapsathon.gonephishin;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.stereotype.Component;

/*
 * Validates email address
 */
@Component
public class EmailValidator {

	private InternetAddress internetAddress; 
	private boolean isValid = false;
	public boolean validate(String senderEmail) {
		try {
			 internetAddress = new InternetAddress(senderEmail);
			 internetAddress.validate();
			 isValid = true;
		} catch (AddressException e) {
			e.printStackTrace();
		}
		return isValid;
		
	}

}
