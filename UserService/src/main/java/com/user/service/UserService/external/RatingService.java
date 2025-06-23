package com.user.service.UserService.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.UserService.entities.Rating;

@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingService {
	
	//get
	@GetMapping
	Rating getRating(@PathVariable String ratingId);
	
	//post
	@PostMapping("/ratings")
	Rating createRating(Rating values);
	
	//update
	@PutMapping("/ratings/{ratingid}")
	Rating updateRatings(@PathVariable("ratingId") String ratingId,Rating values);
	
	//delete
	@DeleteMapping("/ratings/{ratingid}")
	public void deleteRating(@PathVariable("ratingId") String ratingId);

}
