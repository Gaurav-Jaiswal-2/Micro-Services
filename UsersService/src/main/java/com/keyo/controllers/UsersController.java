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

import com.keyo.entities.Users;
import com.keyo.service.UsersServiceimpl;

@RestController
@RequestMapping("users/")
public class UsersController {

	@Autowired
	private UsersServiceimpl userService;
	
	@PostMapping("save")
	ResponseEntity<String> saveUser(@RequestBody Users users){
		      String  message =    userService.saveUser(users);
	          return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("user/{userId}")
	ResponseEntity<Users> getUserByUserId(@PathVariable String userId){
		    Users users = this.userService.getUsers(userId);
		    return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("all-users")
	ResponseEntity<List<Users>> getAllUsers(){
		      List<Users> users =     this.userService.getAllUsers();
	          return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}
}
