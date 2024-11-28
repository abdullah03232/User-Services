package com.learn.micro.entities.dao;

import java.util.List;

import org.apache.catalina.User;

import com.learn.micro.entities.Users;

public interface UsersService {

	// create users
	Users createUser(Users user);

	// update users
	Users updateUsers(Users user);

	// delete users
	void deleteUsers(String userId);

	// get single user
	Users getSingleUser(String usersId);

	// get all users
	List<Users> getAllUsers();
	
	Users getUserRating(String usersId);
	
	Users getUserRatingWithHotel(String usersId);
}
