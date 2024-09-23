package edu.lawrence.restaurant.repositories;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.lawrence.restaurant.entities.Response;

public interface ResponseRepository extends JpaRepository<Response,UUID>{
	@Query("select r from Response r where r.review.idreview=:id")
	List<Response> findByReviewid(UUID id);
	
}
