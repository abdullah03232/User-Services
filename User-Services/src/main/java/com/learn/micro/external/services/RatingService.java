package com.learn.micro.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.learn.micro.entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICES")
public interface RatingService {
	
	@PostMapping("/rating")
	Rating createRating(Rating rating);
	
	
	@PutMapping("/rating/{ratingId}")
	Rating updateRating(@PathVariable("ratingId") String ratingid, Rating rating);
	
	@DeleteMapping("rating/{ratingId}")
	void deleteRating(@PathVariable("ratingId") String ratingId);

}
