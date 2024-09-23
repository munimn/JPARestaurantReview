package edu.lawrence.restaurant.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lawrence.restaurant.dtos.ResponseDTO;
import edu.lawrence.restaurant.entities.Response;
import edu.lawrence.restaurant.entities.Review;
import edu.lawrence.restaurant.repositories.ResponseRepository;
import edu.lawrence.restaurant.repositories.ReviewRepository;



@Service
public class ResponseService {
	
	@Autowired
	ResponseRepository responseRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
		
	public String save(ResponseDTO response) {
		Response newResponse = new Response(response);

		Optional<Review> maybeReview = reviewRepository.findById(UUID.fromString(response.getReviewid()));
		Review review = maybeReview.get();
		newResponse.setReview(review);
		responseRepository.save(newResponse);
		return newResponse.getResponseid().toString();
	}
	public List<Response> findByReviewid(UUID reviewid) {
		return responseRepository.findByReviewid(reviewid);
	}

}

