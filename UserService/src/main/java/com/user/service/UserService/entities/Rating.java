package com.user.service.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
	
	private String ratingId;
	private String hotelId;
	private String userId;
	private int rating;
	private String feedback;
	
	private Hotel hotel;

}
