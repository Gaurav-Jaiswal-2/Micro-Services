package com.keyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyo.entities.Rating;
import com.keyo.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingServiceIntr{

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		 Rating fetched_rating =  this.ratingRepository.save(rating);
		 return fetched_rating;  
		
	}

	@Override
	public List<Rating> getAllRatings() {
	       return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserID(String userId) {
		   return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
	       return this.ratingRepository.findByHotelId(hotelId);
	    		   
	}

}
