package com.goldilock.controller;

//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goldilock.dto.LoginDto;
import com.goldilock.entity.User;
import com.goldilock.exception.UserException;
import com.goldilock.service.Services;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Services serve;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user)throws UserException{
		serve.registerUser(user);
		return new ResponseEntity<>("User has been successfully Registered",HttpStatus.CREATED);
	
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDto loginData) throws UserException {
		serve.loginUser(loginData);
	    
	    return ResponseEntity.ok("Login Successful");
	}
	
}