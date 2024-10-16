package com.learn.micro.entities.daoImpl;

import java.util.List;
import java.util.UUID;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.micro.entities.Users;
import com.learn.micro.entities.dao.UsersService;
import com.learn.micro.entities.exception.ResourseNotFound;
import com.learn.micro.entities.repositories.UserRepository;

@Service
public class UserServiecImpl implements UsersService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users createUser(Users user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public Users updateUsers(Users user) {
		Users users = userRepository.findById(user.getUserId()).orElseThrow(() -> new ResourseNotFound());
		return userRepository.save(user);
	}

	@Override
	public void deleteUsers(String userId) {
		Users users = userRepository.findById(userId).orElseThrow(() -> new ResourseNotFound());
		userRepository.deleteById(userId);
		
	}

	@Override
	public Users getSingleUser(String usersId) {
		return userRepository.findById(usersId).orElseThrow(() -> new ResourseNotFound());
	}

	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

}
