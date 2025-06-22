package com.rating.service.RatingService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.RatingService.RatingService;
import com.rating.service.entities.Rating;
import com.rating.service.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
