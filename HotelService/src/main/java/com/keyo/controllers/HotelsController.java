package com.keyo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyo.entities.Hotels;
import com.keyo.service.HotelsServiceImpl;

@RestController
@RequestMapping("hotels/")
public class HotelsController {
    
	@Autowired
	private HotelsServiceImpl hotelService;
	
	@PostMapping("save")
	ResponseEntity<String> createHotel(@RequestBody Hotels hotels){
		      String message =   this.hotelService.createHotels(hotels);
	          return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("hotel/{hotelId}")
	ResponseEntity<Hotels> getHotelsByHotelId(@PathVariable String hotelId){
		      Hotels hotel =   this.hotelService.getHotelByHotelId(hotelId);
	          return new ResponseEntity<>(hotel,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("all-hotels")
	ResponseEntity<List<Hotels>> getAllHotels(){
	      List<Hotels> hotels =   this.hotelService.getAllhotels();
        return new ResponseEntity<>(hotels,HttpStatus.ACCEPTED);
    }
	
	
	
	
	
}
