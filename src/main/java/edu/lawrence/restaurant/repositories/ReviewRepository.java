package edu.lawrence.restaurant.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.restaurant.entities.Restaurant;
import edu.lawrence.restaurant.entities.Review;

public interface ReviewRepository extends JpaRepository<Review,UUID>{
	@Query("select avg(r.foodquality) from Review r where r.restaurant.restaurantid=:restaurantid")
    Double avgFoodquality(UUID restaurantid);
	
	@Query("select avg(r.ambiance) from Review r where r.restaurant.restaurantid=:restaurantid")
    Double avgAmbiance(UUID restaurantid);
	
	@Query("select avg(r.price) from Review r where r.restaurant.restaurantid=:restaurantid")
    Double avgPrice(UUID restaurantid);
	
	@Query("select count(r) from Review r where r.restaurant.restaurantid=:restaurantid")
	int countByRestaurantid(UUID restaurantid);

	@Query("select r from Review r where r.restaurant.restaurantid=:restaurantid")
	List<Review> findByRestaurantid(UUID restaurantid);
}
