package com.erp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.repository.CityRepository;
import com.erp.service.MyMailService;

@RestController
public class CityController {
	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	MyMailService mailService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getCityList(){
		return ResponseEntity
				.ok()
				.body(cityRepo.findAll());
	}
	
	
	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendMail(@RequestBody Map<String, String> payload ){
		String to = "sengautami930@gmail.com";
		String subject = payload.get("subject");
		String text = payload.get("text");
		
		mailService.sendMail(to, subject, text);
		return ResponseEntity.ok().body("Email Sent...");
	}

}
