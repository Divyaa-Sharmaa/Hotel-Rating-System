package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entity.Hotel;

public interface HotelService {
	
	//create hotel
	Hotel create(Hotel hotel);
	
	// get all hotels
	List<Hotel> getAllHotels();
	
    // get hotel by id
	Hotel getHotelById(String hotelId);
	
	// delete hotel
	void deleteHotel(String hotelId);
	
	//update hotel
	Hotel updateHotelDetails(Hotel hotel, String hotelId);
}
