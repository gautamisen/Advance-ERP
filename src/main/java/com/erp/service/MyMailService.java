package com.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MyMailService {
	
	@Autowired
	private JavaMailSender sendMail;
	
	public void sendMail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("sengautami930@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		
		sendMail.send(message);
	}

}
