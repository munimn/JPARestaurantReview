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

import edu.lawrence.restaurant.dtos.RestaurantDTO;
import edu.lawrence.restaurant.dtos.SummaryDTO;
import edu.lawrence.restaurant.entities.Restaurant;
import edu.lawrence.restaurant.services.RestaurantService;
import edu.lawrence.restaurant.services.RestaurantUserDetails;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "*")
public class RestaurantController {

	private RestaurantService restaurantService;
	
	public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
	
	@PostMapping
    public ResponseEntity<String> save(@RequestBody RestaurantDTO restaurant) {
		String key = restaurantService.save(restaurant);
        return ResponseEntity.ok().body(key);
	}
	
	@GetMapping()
	public ResponseEntity<List<Restaurant>> findAll() {
		List<Restaurant> result = restaurantService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/foodtype/{type}")
	public ResponseEntity<List<Restaurant>> RestaurantsByFoodtype(@PathVariable("type") String foodtype) {
		List<Restaurant> result = restaurantService.findByFoodtype(foodtype);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Restaurant>> RestaurantByname(@PathVariable("name") String name) {
		List<Restaurant> result = restaurantService.findByName(name);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findByRestaurantid(@PathVariable("id") UUID restaurantid) {
		Restaurant result = restaurantService.findByRestaurantid(restaurantid);
		if (result == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/{id}/foodquality")
	public ResponseEntity<Double> avgFoodquality(@PathVariable("id") UUID restaurantid) {
		Double key = restaurantService.avgFoodquality(restaurantid);
		if (key == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(key);
        } else {
        }
        return ResponseEntity.ok().body(key);
	}
	@GetMapping("/{id}/ambiance")
	public ResponseEntity<Double> avgAmbiance(@PathVariable("id") UUID restaurantid) {
		Double key = restaurantService.avgAmbiance(restaurantid);
		if (key == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(key);
        } else {
        }
        return ResponseEntity.ok().body(key);
	}
	@GetMapping("/{id}/price")
	public ResponseEntity<Double> avgPrice(@PathVariable("id") UUID restaurantid) {
		Double key = restaurantService.avgPrice(restaurantid);
		if (key == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(key);
        } else {
        }
        return ResponseEntity.ok().body(key);
	}
	
	@GetMapping("/{id}/numreviews")
	public ResponseEntity<Integer> numRating(@PathVariable("id") UUID restaurantid) {
		int result = restaurantService.numRating(restaurantid);
		return ResponseEntity.ok().body(result);
	}
	@GetMapping("/{id}/summary")
	public ResponseEntity<SummaryDTO> summary(@PathVariable("id") UUID restaurantid) {
		SummaryDTO key = restaurantService.summary(restaurantid);
		if (key == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(key);
        } else {
        }
        return ResponseEntity.ok().body(key);
	}
	
	
}
