package com.learn.micro.entities.daoImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.micro.entities.Rating;
import com.learn.micro.entities.Users;
import com.learn.micro.entities.dao.UsersService;
import com.learn.micro.entities.exception.ResourseNotFound;
import com.learn.micro.entities.repositories.UserRepository;

@Service
public class UserServiecImpl implements UsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

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

	@Override
	public Users getUserRating(String usersId) {
		Users user = userRepository.findById(usersId).orElseThrow(() -> new ResourseNotFound());

		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject(
				"http://localhost:8082/rating/users/e6dcb28b-f10b-4249-9055-1317c6433289", ArrayList.class);
		user.setRating(ratingsOfUser);

		return user;
		//return userRepository.findById(usersId).orElseThrow(() -> new ResourseNotFound());
	}

}
