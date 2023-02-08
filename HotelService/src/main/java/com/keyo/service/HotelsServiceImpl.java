package com.keyo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyo.entities.Hotels;
import com.keyo.exception.HotelNotFoundException;
import com.keyo.repository.HotelsRepositroy;

@Service
public class HotelsServiceImpl implements HotelsServiceIntr{

	@Autowired
	private HotelsRepositroy hotelRepository;
	
	@Override
	public String createHotels(Hotels hotels) {
		
		    String random = UUID.randomUUID().toString();
		    hotels.setHotelId(random);
	        this.hotelRepository.save(hotels);
	        return "hotel saved successfully...";
	     
	}

	@Override
	public Hotels getHotelByHotelId(String hotelId) {
        return  this.hotelRepository.findById(hotelId).orElseThrow(()-> new HotelNotFoundException("hotel not found with this given hotel id"));
	}

	@Override
	public List<Hotels> getAllhotels() {
		return this.hotelRepository.findAll();
	}

}
