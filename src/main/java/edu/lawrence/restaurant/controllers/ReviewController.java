package edu.lawrence.restaurant.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.restaurant.dtos.ReviewDTO;
import edu.lawrence.restaurant.entities.Review;
import edu.lawrence.restaurant.services.RestaurantUserDetails;
import edu.lawrence.restaurant.services.ReviewService;
import edu.lawrence.restaurant.services.WrongUserException;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
	
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
	
	@PostMapping
    public ResponseEntity<String> save(Authentication authentication,@RequestBody ReviewDTO review) {
		String key;
		key = reviewService.save(review);
        return ResponseEntity.ok().body(key);
	}
	@GetMapping("/{restaurantname}")
	public ResponseEntity<List<Review>> findByName(@PathVariable("restaurantname") UUID restaurantname) {
		List<Review> result = reviewService.findByRestaurantid(restaurantname);
		return ResponseEntity.ok().body(result);
	}
	
}