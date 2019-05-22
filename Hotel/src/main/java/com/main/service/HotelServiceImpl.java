package com.main.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.HotelDao;
import com.main.model.Hotel;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelDao dao;
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		return dao.addHotel(hotel);
	}

}
