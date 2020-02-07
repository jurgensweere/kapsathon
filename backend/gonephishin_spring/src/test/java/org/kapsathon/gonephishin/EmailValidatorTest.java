package org.kapsathon.gonephishin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmailValidatorTest {
	
	
	@Test
	public void isValidEmailId() {
		EmailValidator emailValidator = new EmailValidator();
		String senderEmail = "hello@crunchify.com";
		assertEquals(true, emailValidator.validate(senderEmail));
				
	}
}
