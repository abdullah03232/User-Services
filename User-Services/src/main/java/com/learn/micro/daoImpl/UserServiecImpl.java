package com.learn.micro.daoImpl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.micro.dao.UsersService;
import com.learn.micro.entities.Hotel;
import com.learn.micro.entities.Rating;
import com.learn.micro.entities.Users;
import com.learn.micro.exception.ResourseNotFound;
import com.learn.micro.external.services.HotelService;
import com.learn.micro.repositories.UserRepository;

@Service
public class UserServiecImpl implements UsersService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;
	
	@Override
	public Users createUser(Users user) {
		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		//logger.info("Data: "+user.toString());
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
				"http://RATING-SERVICES/rating/users/"+usersId, ArrayList.class);
		user.setRating(ratingsOfUser);

		return user;
	}

	@Override
	public Users getUserRatingWithHotel(String usersId) {
		Users user = userRepository.findById(usersId).orElseThrow(() -> new ResourseNotFound());

		Rating[] ratingsOfUser = restTemplate.getForObject(
				"http://RATING-SERVICES/rating/users/"+usersId, Rating[].class);
		
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();	
	
		List<Rating> ratingList = ratings.stream().map(rating -> {
		//ResponseEntity<Hotel> hotelData = restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/"+rating.getHotelId(), Hotel.class);
		//Hotel hotel = hotelData.getBody();
			
		Hotel hotel = hotelService.getHotel(rating.getHotelId());
		
			
		System.out.println("Line------------------94");
		System.out.println(hotel.toString());
		rating.setHotel(hotel);
		return rating;
		}).collect(Collectors.toList());
		
		user.setRating(ratingList);

		return user;
	}

}
