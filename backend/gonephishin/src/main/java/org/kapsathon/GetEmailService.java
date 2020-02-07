package org.kapsathon;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
public class GetEmailService {

    public String getEmails() {
        return "EMAILS";
    }

}
