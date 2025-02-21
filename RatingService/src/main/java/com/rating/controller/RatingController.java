package com.rating.controller;

import com.rating.entity.Rating;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping("/create")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        Rating created= ratingService.create(rating);
        return new ResponseEntity<>(created,HttpStatus.CREATED);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsForUser(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsForHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }
}
