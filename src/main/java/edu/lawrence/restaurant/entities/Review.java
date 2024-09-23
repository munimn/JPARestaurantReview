package edu.lawrence.restaurant.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.restaurant.dtos.ReviewDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID idreview;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	@ManyToOne
	@JoinColumn(name="restaurantid")
	private Restaurant restaurant;
	private String review;
	private Date date;
	private int foodquality;
	private int ambiance;
	private int price;

	
	public Review() {}
	public Review(ReviewDTO core) {
		review = core.getReview();
		date = core.getDate();
		foodquality = core.getFoodquality();
		ambiance = core.getAmbiance();
		price = core.getPrice();	
	}

	public UUID getReviewid() {
		return idreview;
	}

	public void setReviewid(UUID idreview) {
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
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public User getUser() {
		return user;
		
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
