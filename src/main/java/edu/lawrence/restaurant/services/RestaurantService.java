package edu.lawrence.restaurant.services;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lawrence.restaurant.dtos.RestaurantDTO;
import edu.lawrence.restaurant.dtos.SummaryDTO;
import edu.lawrence.restaurant.entities.Restaurant;
import edu.lawrence.restaurant.repositories.RestaurantRepository;
import edu.lawrence.restaurant.repositories.ReviewRepository;



@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	
	public String save(RestaurantDTO restaurant) {
		Restaurant newRestaurant = new Restaurant(restaurant);
		restaurantRepository.save(newRestaurant);
		return newRestaurant.getRestaurantid().toString();
	}
	
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}
	
	public List<Restaurant> findByFoodtype(String foodtype) {
		return restaurantRepository.findByFoodtype(foodtype);
	}
	public List<Restaurant> findByName(String name) {
		return restaurantRepository.findByName(name);
	}
	
	
	public Restaurant findByRestaurantid(UUID restaurantid) {
		Optional<Restaurant> maybeRestaurant = restaurantRepository.findByRestaurantid(restaurantid);
		if(!maybeRestaurant.isPresent())
			return null;
		Restaurant restaurant = maybeRestaurant.get();

		return restaurant;
	}
	public int numRating(UUID restaurantid) {
		return reviewRepository.countByRestaurantid(restaurantid);
	}
	
	public Double avgFoodquality(UUID restaurantid) {
		SummaryDTO result = new SummaryDTO();
		result.setAvgFoodquality(reviewRepository.avgFoodquality(restaurantid));
		result.setAvgAmbiance(reviewRepository.avgAmbiance(restaurantid));
		result.setAvgPrice(reviewRepository.avgPrice(restaurantid));
		Double Foodquality = result.getAvgFoodquality();
		return Foodquality;
	}
	public Double avgAmbiance(UUID restaurantid) {
		SummaryDTO result = new SummaryDTO();
		result.setAvgFoodquality(reviewRepository.avgFoodquality(restaurantid));
		result.setAvgAmbiance(reviewRepository.avgAmbiance(restaurantid));
		result.setAvgPrice(reviewRepository.avgPrice(restaurantid));
		Double Ambiance = result.getAvgAmbiance();
		return Ambiance;
	}
	public Double avgPrice(UUID restaurantid) {
		SummaryDTO result = new SummaryDTO();
		result.setAvgFoodquality(reviewRepository.avgFoodquality(restaurantid));
		result.setAvgAmbiance(reviewRepository.avgAmbiance(restaurantid));
		result.setAvgPrice(reviewRepository.avgPrice(restaurantid));
		Double Price = result.getAvgPrice();
		return Price;
	}
	public SummaryDTO summary(UUID restaurantid) {
		SummaryDTO result = new SummaryDTO();
		result.setAvgFoodquality(reviewRepository.avgFoodquality(restaurantid));
		result.setAvgAmbiance(reviewRepository.avgAmbiance(restaurantid));
		result.setAvgPrice(reviewRepository.avgPrice(restaurantid));
		return result;
	}
	
	
	
	

}