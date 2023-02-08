package com.keyo.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyo.entities.Users;
import com.keyo.service.UsersServiceimpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("users/")
public class UsersController {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private UsersServiceimpl userService;
	
	@PostMapping("save")
	ResponseEntity<String> saveUser(@RequestBody Users users){
		      String  message =    userService.saveUser(users);
	          return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@CircuitBreaker(name = "RatingHotelBreaker", fallbackMethod = "RatingHotelFallback")
	@GetMapping("user/{userId}")
	ResponseEntity<Users> getUserByUserId(@PathVariable String userId){
		    Users users = this.userService.getUsers(userId);
		    return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<Users> ratingHotelFallback(String userId, Exception ex){
	logger.info("Fallback executed because service is down" , ex.getMessage());
	
	//if you are creating user with build method use @builder on the user class
	Users users = new Users("000", "dummy", "this is a dummy user because service is down", null);
	return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("all-users")
	ResponseEntity<List<Users>> getAllUsers(){
		      List<Users> users =     this.userService.getAllUsers();
	          return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}
}
