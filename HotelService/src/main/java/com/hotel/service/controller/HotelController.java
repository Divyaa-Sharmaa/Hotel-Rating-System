package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.entity.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelServ;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel h = hotelServ.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(h);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> h = hotelServ.getAllHotels();
		return ResponseEntity.ok(h);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
		Hotel h = hotelServ.getHotelById(hotelId);
		return ResponseEntity.ok(h);
	}
	
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<String> deleteHotelDetailsById(@PathVariable String hotelId){
		hotelServ.deleteHotel(hotelId);
		return ResponseEntity.ok("Hotel details has been deleted successfully");
	}
	
	@PutMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> updateHotelDetails(@RequestBody Hotel hotel, @PathVariable String hotelId){
		Hotel h = hotelServ.updateHotelDetails(hotel, hotelId);
		return ResponseEntity.ok(h);
	}
	

}
