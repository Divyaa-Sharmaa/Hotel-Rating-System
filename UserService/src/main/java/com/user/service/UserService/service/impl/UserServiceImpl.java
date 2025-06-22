package com.user.service.UserService.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.UserService.entities.Hotel;
import com.user.service.UserService.entities.Rating;
import com.user.service.UserService.entities.User;
import com.user.service.UserService.exceptions.ResourceNotFoundException;
import com.user.service.UserService.external.HotelService;
import com.user.service.UserService.repository.UserRepo;
import com.user.service.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelServ;
	
	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		//generate unique id
		String randomId = UUID.randomUUID().toString();
		user.setId(randomId);
		return userRepo.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findUserById(String userId) {
		User user =  userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User doesn't exist with the id: "+ userId));
		
		Rating[] ratingsOfUsers = restTemplate.getForObject("http://RATINGSERVICE/ratings/user/"+user.getId(), Rating[].class);
		log.info("{} ", ratingsOfUsers);
		
		List<Rating> ratingListt =Arrays.stream(ratingsOfUsers).toList();
		List<Rating> ratingList = ratingListt.stream().map(rating->{
		
//		ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/hotel/"+rating.getHotelId(), Hotel.class);
//		Hotel hotel = forEntity.getBody();
		Hotel hotel = hotelServ.getHotel(rating.getHotelId());	
//		log.info("response status code: {} ",forEntity.getStatusCode());
		
		rating.setHotel(hotel);
		return rating;
		
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
	}

	@Override
	public void deleteUser(String id) {
		userRepo.deleteById(id);
		System.out.println("User has been deleted successfully");
		
	}

	@Override
	public User updateUserById(User user, String userId) {
		User u= userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User doesn't exist with the id: "+ userId));
        u.setEmail(user.getEmail());
        u.setMobile(user.getMobile());
        u.setName(user.getName());
		return userRepo.save(u);
	}

}
