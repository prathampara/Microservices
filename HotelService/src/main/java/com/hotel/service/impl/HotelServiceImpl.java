package com.hotel.service.impl;

import com.hotel.entity.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepo;
import com.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel create(Hotel hotel) {
       String id= UUID.randomUUID().toString();
       hotel.setId(id);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with this id not found"));
    }
}
