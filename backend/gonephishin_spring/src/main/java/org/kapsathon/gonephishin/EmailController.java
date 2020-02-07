package org.kapsathon.gonephishin;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Controller class to map the requests
 */

@RestController
public class EmailController {

    private final Logger log = LoggerFactory.getLogger(EmailController.class);
    
    @Autowired
    private EmailService emailService;

    public EmailController() {
    }

    @GetMapping(value="/get_email/{id}")
    public ResponseEntity<Email> getMethodName(@PathVariable String id) {
        log.info("Param {}", id);
    
        Optional<Email> email = emailService.getEmail(id);

        log.info("Param email {}", email);

        return ResponseEntity.ok(email.orElseThrow());
    }

    @GetMapping(value="/get_emails")
    public ResponseEntity<List<Email>> getEmails() {
    
        List<Email> email = emailService.getEmails();

        log.info("Param email {}", email);

        return ResponseEntity.ok().body(email);
    }

    /*
     * Method to map create gift request
     */
    @PostMapping(value="/send_email")
    public ResponseEntity<Email> sendEmail(@Valid @RequestBody Email gift) {
    	Email email = emailService.saveEmail(gift);

        return ResponseEntity.ok(email);
    }

}
