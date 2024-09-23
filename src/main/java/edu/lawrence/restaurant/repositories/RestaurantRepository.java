package edu.lawrence.restaurant.repositories;

import java.util.List;
import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.restaurant.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,UUID>{
	List<Restaurant> findByName(String name);
	List<Restaurant> findAll();
	List<Restaurant> findByFoodtype(String foodtype);
	@Query("select r from Restaurant r where r.restaurantid=:restaurantid")
	Optional<Restaurant> findByRestaurantid(UUID restaurantid);
	
}
