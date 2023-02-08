package com.keyo.service;

import java.util.List;

import com.keyo.entities.Rating;

public interface RatingServiceIntr {
public Rating createRating(Rating rating);
public List<Rating> getAllRatings();
public List<Rating> getAllRatingsByUserID(String userId);
public List<Rating> getAllRatingsByHotelId(String hotelId);

}
