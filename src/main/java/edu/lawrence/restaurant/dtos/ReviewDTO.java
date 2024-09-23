package edu.lawrence.restaurant.dtos;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import edu.lawrence.restaurant.entities.Response;
import edu.lawrence.restaurant.entities.Restaurant;
import edu.lawrence.restaurant.entities.Review;
import edu.lawrence.restaurant.entities.User;


public class ReviewDTO {
	private String idreview;
	private String userid;
	private String restaurantid;
	private String review;
	private Date date;
	private int foodquality;
	private int ambiance;
	private int price;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(Review core) {
		idreview = core.getReviewid().toString();
		userid = core.getUser().getUserid().toString();
		review = core.getReview();
		date = core.getDate();
		foodquality = core.getFoodquality();
		ambiance = core.getAmbiance();
		price = core.getPrice();
		restaurantid = core.getRestaurant().getRestaurantid().toString();
	}
	
	public String getReviewid() {
		return idreview;
	}

	public void setReviewid(String idreview) {
		this.idreview = idreview;
	}
	public Integer getFoodquality() {
		return foodquality;
	}

	public void setFoodquality(Integer foodquality) {
		this.foodquality = foodquality;
	}

	public Integer getAmbiance() {
		return ambiance;
	}

	public void setAmbiance(Integer ambiance) {
		this.ambiance = ambiance;
	}
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(String restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getUserid() {
		return userid;
		
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}

