package com.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Hotel;
import com.main.repository.HotelRepository;

@Repository
public class HotelDaoImpl implements HotelDao{
	
	@Autowired
	HotelRepository repo;
	@Override
	public Hotel addHotel(Hotel hotel) {
		return repo.save(hotel);
	}

}
