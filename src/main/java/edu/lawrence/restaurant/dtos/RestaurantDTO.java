package edu.lawrence.restaurant.dtos;


import edu.lawrence.restaurant.entities.Restaurant;


public class RestaurantDTO {
	private String name;
	private String address;
	private String foodtype;
	private String restaurantid;
	
	public RestaurantDTO() {
	}

	public RestaurantDTO(Restaurant core) {
		name = core.getName();
		address = core.getAddress();
		foodtype = core.getFoodtype();
		restaurantid = core.getRestaurantid().toString();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(String restaurantid) {
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

