package com.learn.micro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.micro.entities.Rating;
import com.learn.micro.external.services.RatingService;

@SpringBootTest
class UserServicesApplicationTests {

	@Autowired
	RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating() {
		//CREATE
		//Rating rating = Rating.builder().ratingid("12").userId("abdullah").hotelId("17").rating(8).feedback("Created by feign client").build();
		//Rating rating2 =  ratingService.createRating(rating);
		//System.out.println("Rating crated by feign -- "+rating2.toString());
		
		//DELETE
		//ratingService.deleteRating("cd340f36-80e6-4bb0-8551-b68da4c16b9a");
		
		Rating rating = Rating.builder().ratingid("62338f1c-f9a2-45b6-8d3b-640b949fa9d5").userId("abdullah").hotelId("17").rating(8).feedback("Updated by feign client").build();
		Rating rating2 =  ratingService.updateRating(rating.getRatingid(), rating);
		System.out.println("Rating updated by feign -- "+rating2.toString());
		
	}

}
