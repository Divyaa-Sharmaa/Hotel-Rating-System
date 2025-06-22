package com.rating.service.RatingService;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {
	
	//create rating
	Rating createRating(Rating rating);
	
	//get all ratings
	List<Rating> getAllRatings();
	
	// get all ratings by userId
	List<Rating> getRatingByUserId(String userId);
	
	//get all ratings by hotelId
	List<Rating> getRatingByHotelId(String hotelId);

}
