package com.hcl.controller;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.MainApp;
import com.hcl.model.User;
import com.hcl.service.UserService;

@RestController
public class MainAppController {
	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);
	
	@Autowired
	UserService userService;
	@RequestMapping("/addUser")
	public User message(@RequestBody User user) {
		logger.info("user added successfully");
		return userService.save(user);
		
	}
	
	
	
	
}
