package edu.lawrence.restaurant.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.lawrence.restaurant.dtos.ResponseDTO;
import edu.lawrence.restaurant.entities.Response;
import edu.lawrence.restaurant.services.ResponseService;



@RestController
@RequestMapping("/response")
@CrossOrigin(origins = "*")
public class ResponseController {

	private ResponseService responseService;
	
	public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }
    
	@PostMapping
    public ResponseEntity<String> save(@RequestBody ResponseDTO response) {
		String key = responseService.save(response);
        return ResponseEntity.ok().body(key);
	}
	
	@GetMapping("/{reviewid}")
	public ResponseEntity<List<Response>> findByReviewid(@PathVariable UUID reviewid) {
		List <Response> result = responseService.findByReviewid(reviewid);
		return ResponseEntity.ok().body(result);
	}
	
}
