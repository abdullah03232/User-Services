package com.learn.micro.entities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.micro.entities.Users;
import com.learn.micro.entities.dao.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService userService;
	
	@PostMapping
	ResponseEntity<Users> createUser(@RequestBody Users user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}
	
	@PutMapping
	ResponseEntity<Users> updateUser(@RequestBody Users user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUsers(user));
	}
	
	@DeleteMapping("/{userId}")
	ResponseEntity<String> deleteUser(@PathVariable String userId){
	userService.deleteUsers(userId);
	return new ResponseEntity<String>("User has been deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	ResponseEntity<Users> getSingleUsers(@PathVariable String userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getSingleUser(userId));
	}
	
	@GetMapping
	ResponseEntity<List<Users>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
	}
	
	@GetMapping("/rating/{userId}")
	ResponseEntity<Users> getUserRating(@PathVariable String userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserRating(userId));
	}
	
	@GetMapping("/ratingWithHotel/{userId}")
	ResponseEntity<Users> ratingWithHotel(@PathVariable String userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserRatingWithHotel(userId));
	}
	
	
	
	
}
