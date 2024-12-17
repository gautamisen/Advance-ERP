package com.erp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.erp.service.MyMailService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	
	@Autowired
	MyMailService mailService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/sendEmail")
	public String sendMail(HttpServletRequest payload , Model m ){
		String to = "sengautami930@gmail.com";
		String subject = "Inquiry About The Service.";
		
		String name = payload.getParameter("name");
		String email = payload.getParameter("email");
		String number = payload.getParameter("number");
		String requiremnets = payload.getParameter("requirements");
		
		
		if(name.isEmpty()) {
			m.addAttribute("error", "Full Name Is Empty");
			return "home";
		}
		if(email.isEmpty()) {
			m.addAttribute("error", "Email Is Required");
			return "home";
		}
		
		if(number.isEmpty()) {
			m.addAttribute("error", "number Is Required");
			return "home";
		}
		if(requiremnets.isEmpty()) {
			m.addAttribute("error", "requiremnets Is Required");
			return "home";
		}
		String text = "\nname ="+ name+
				"\nemail ="+email
				+ "\nnumber = "+number
				+ "\nrequirements = "+requiremnets;
		
		mailService.sendMail(to, subject, text);
		
		name = null;
		email = null;
		number = null;
		requiremnets = null;
		m.addAttribute("success", "Email Sent Successfully...");
		return "home";
	}

}
