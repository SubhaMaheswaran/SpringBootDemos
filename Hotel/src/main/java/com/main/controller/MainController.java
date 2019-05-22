package com.main.controller;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.main.model.Hotel;
import com.main.service.HotelService;


@RestController
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	HotelService hotelService;
	
	@RequestMapping(value="/one/{name},{address},{rating},{phoneNumber}")
	public Hotel addHotel(@PathVariable("address") String address,@PathVariable("name") String name,@PathVariable("phoneNumber") String phoneNumber,@PathVariable("rating") int rating){
		Hotel hotel = new Hotel();
		hotel.setHotelName(name);
		hotel.setAddress(address);
		hotel.setRating(rating);
		hotel.setPhoneNumber(phoneNumber);
		logger.info("Hotels added Successfully...");
		return hotelService.addHotel(hotel);
		
	}
}
