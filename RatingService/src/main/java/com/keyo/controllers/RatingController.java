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

import com.keyo.entities.Rating;
import com.keyo.service.RatingServiceImpl;

@RestController
@RequestMapping("ratings/")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingService;
	
	@PostMapping("save")
	ResponseEntity<Rating> createRating(@RequestBody Rating rating){
	    Rating ratings =   ratingService.createRating(rating);	   
        return new ResponseEntity<>(ratings,HttpStatus.CREATED);
	}
	
	@GetMapping("all-ratings")
	ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> ratings =   ratingService.getAllRatings();	   
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
	
	@GetMapping("all-rating/user/{userId}")
	ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
        List<Rating> ratings =   ratingService.getAllRatingsByUserID(userId);	   
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
	@GetMapping("all-rating/hotel/{hotelId}")
	ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
        List<Rating> ratings =  this.ratingService.getAllRatingsByHotelId(hotelId); 
        return new ResponseEntity<>(ratings, HttpStatus.OK);
	}
	
}
