package com.goldilock.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.goldilock.dto.LoginDto;
import com.goldilock.entity.User;
import com.goldilock.exception.UserException;
import com.goldilock.repo.UserRepo;

@Service
public class Services {

	@Autowired
	private UserRepo ur;
	public void registerUser(User user) throws UserException {
	User us = ur.findByEmail(user.getEmail());
	if(us!=null) {
		throw new UserException("User already Exist");
	}
	if(user.getEmail()==null||user.getName()==null||user.getPassword()==null) {
		throw new UserException("No Data Available");
	}
	
	ur.save(user);
	}
	public void loginUser(LoginDto loginData) throws UserException{
		// TODO Auto-generated method stub
		String email = loginData.getEmail();
	    String password = loginData.getPassword();

	    User u = ur.findByEmail(email);
	    if (u == null || !u.getPassword().equals(password)) {
	    	throw new UserException("Invalid Credential.");
	    }
	    if (u == null || !u.getPassword().equals(password)) {
	        throw new UserException("Invalid Credential. Please enter valid email and password");
	       
	    }
	}
}
