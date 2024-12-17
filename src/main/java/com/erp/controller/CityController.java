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
	
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getCityList(){
		return ResponseEntity
				.ok()
				.body(cityRepo.findAll());
	}
	
	
	

}
