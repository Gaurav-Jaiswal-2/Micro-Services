package com.keyo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("staffs")
public class StaffController {

	@GetMapping("all-staffs")
    public ResponseEntity<List<String>> getAllStaffs(){
    	List<String> staffs = Arrays.asList("Gaurav","Suresh","Kamlesh","Pavan","Milan");
    	return new ResponseEntity<>(staffs,HttpStatus.OK);
    }
}
