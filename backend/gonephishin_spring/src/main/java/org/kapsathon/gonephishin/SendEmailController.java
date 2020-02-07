/**
 * 
 */
package org.kapsathon.gonephishin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class to send email
 *
 */
@RestController
@RequestMapping("/sendemail")
public class SendEmailController {
	
	@Autowired
	SendEmailService sendEmailService;

	  @PostMapping()
	  public ResponseEntity<Void> emailSender(@RequestBody Email email) {
		return sendEmailService.sendEmail(email);
		  
	  }

}
