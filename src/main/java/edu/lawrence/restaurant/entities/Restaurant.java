package edu.lawrence.restaurant.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.restaurant.dtos.RestaurantDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID restaurantid;
	private String name;
	private String address;
	private String foodtype;

	
	public Restaurant() {}
	public Restaurant(RestaurantDTO core) {
		name = core.getName();
		address = core.getAddress();
		foodtype = core.getFoodtype();
		
	}

		

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public UUID getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(UUID restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

}
