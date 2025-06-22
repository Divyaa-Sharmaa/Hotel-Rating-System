package com.hotel.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}
