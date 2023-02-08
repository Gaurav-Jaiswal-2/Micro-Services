package com.keyo.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.keyo.entities.Hotel;
import com.keyo.entities.Rating;
import com.keyo.entities.Users;
import com.keyo.exception.UserNotFoundException;
import com.keyo.externalService.IHotelService;
import com.keyo.repository.UsersRepository;

@Service
public class UsersServiceimpl implements UsersServiceIntr{

	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UsersServiceimpl.class);
	
	@Autowired
	private IHotelService hotelInt;
	
	@Autowired
	private UsersRepository usersrepository;
	
	@Override
	public String saveUser(Users users) {
		this.usersrepository.save(users);
		return "user saved successfully...";
	}

	@Override
	public Users getUsers(String usersId) {

		
		Users users = usersrepository.findById(usersId).orElseThrow(()-> new UserNotFoundException("User is not present with given id"));
	      //api call to rating microservice;
		  Rating[] ratingsOfUsers = restTemplate.getForObject("http://RATING-SERVICE/ratings/all-rating/user/"+ users.getUserId(), Rating[].class);
	      List<Rating> ratings = Arrays.stream(ratingsOfUsers).toList();
	      //api call to hotel;
	       //we have list of ratings so we need the hotel id to call the hotel api so loop over it
	        
	      ratings.stream().map(rating->{
		  //Hotel hotels =    this.restTemplate.getForObject("http://HOTEL-SERVICE/hotels/hotel/" + rating.getHotelId(), Hotel.class);
	      //using feign client instead of rest template;
	    	 
	      Hotel hotels = hotelInt.getHotel(rating.getHotelId());
	     
	    	  rating.setHotels(hotels);
	    	return rating;
	    }).collect(Collectors.toList());
	   	
	      users.setRatings(ratings);
	      return users;
	}

	@Override
	public List<Users> getAllUsers() {
		
	     List<Users> users = usersrepository.findAll();
	     String trakingUserId;
	     Users trakingUser;
	     
	     for(int i=0;i<users.size();i++) {
	    	 trakingUserId = users.get(i).getUserId();	 
	    	 trakingUser = users.get(i);
	         List<Rating> ratingOfUses = restTemplate.getForObject("http://RATING-SERVICE/ratings/all-rating/user/" + trakingUserId, List.class);
	         trakingUser.setRatings(ratingOfUses);
	     }
	     return users;
	}

}
