package org.kapsathon.gonephishin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// @DynamoDBTable(tableName = "emails")
@Entity
@Table(name = "emails")
public class Email {
	@Id
    private String id;
    private String sender;
    private String receiver;
    private String subject;
    private String body;
    private String date;
    private String meta;

	

	
    public String getId() {
        return id;
    }

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

    
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

    
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

    
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

    
	public String getMetadata() {
		return meta;
	}

	public void setMetadata(String meta) {
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "Email [body=" + body + ", date=" + date + ", id=" + id + ", meta=" + meta + ", receiver="
				+ receiver + ", sender=" + sender + "]";
	}

	public Email() {
	}

	public Email(String id, String sender, String receiver, String subject, String body, String date, String meta) {
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.body = body;
		this.date = date;
		this.meta = meta;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}
 
    // standard setters/constructors
}