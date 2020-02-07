package org.kapsathon.gonephishin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * Service class for get and create gift services
 */
@Service
public class EmailService {

	public EmailService() {
	}

	@Autowired
    EmailRepository emailRepository;
	
	public Optional<Email> getEmail(String id) {
		return emailRepository.findById(id);
    }

	public Email saveEmail(Email email) {
		return emailRepository.save(email);
	}


    public List<Email> getEmails() {
        return emailRepository.findAll();
    }
}
