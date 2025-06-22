package com.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entity.Hotel;
import com.hotel.service.repo.HotelRepo;
import com.hotel.service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		String randomId = UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelRepo.findById(hotelId).orElseThrow(()-> new RuntimeException("hotel doesn't exist with this id: "+ hotelId));
	}

	@Override
	public void deleteHotel(String hotelId) {
		hotelRepo.deleteById(hotelId);
		System.out.println("hotel details has been deleted.");
	}

	@Override
	public Hotel updateHotelDetails(Hotel hotel, String hotelId) {
		Hotel h = hotelRepo.findById(hotelId).orElseThrow(()-> new RuntimeException("hotel doesn't exist with this id: "+ hotelId));
        h.setName(hotel.getName());
        h.setAbout(hotel.getAbout());
        h.setLocation(hotel.getLocation());
		return hotelRepo.save(h);
	}
	
	

}
