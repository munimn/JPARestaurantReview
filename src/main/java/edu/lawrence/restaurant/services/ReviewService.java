package edu.lawrence.restaurant.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lawrence.restaurant.dtos.ReviewDTO;
import edu.lawrence.restaurant.entities.Restaurant;
import edu.lawrence.restaurant.entities.Review;
import edu.lawrence.restaurant.entities.User;
import edu.lawrence.restaurant.repositories.RestaurantRepository;
import edu.lawrence.restaurant.repositories.ReviewRepository;
import edu.lawrence.restaurant.repositories.UserRepository;


@Service
public class ReviewService {
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	
	@Autowired
	UserRepository userRepository;
	
	public String save(ReviewDTO review) {
		Review newReview = new Review(review);
		
		
		Optional<Restaurant> maybeRestaurant = restaurantRepository.findByRestaurantid(UUID.fromString(review.getRestaurantid()));
		Restaurant restaurant = maybeRestaurant.get();
		newReview.setRestaurant(restaurant);
		
		Optional<User> maybeUser = userRepository.findById(UUID.fromString(review.getUserid()));
		User user = maybeUser.get();
		newReview.setUser(user);
		
		reviewRepository.save(newReview);
		return newReview.getReviewid().toString();
	}
	
	public List<Review> findByRestaurantid(UUID restaurantid) {
		return reviewRepository.findByRestaurantid(restaurantid);
	}
	

}
