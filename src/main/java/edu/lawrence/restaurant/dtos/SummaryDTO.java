package edu.lawrence.restaurant.dtos;


public class SummaryDTO {
	private Double avgFoodquality;
	private Double avgAmbiance;
	private Double avgPrice;
	
	public SummaryDTO() {}
	
	public Double getAvgFoodquality() {
		return avgFoodquality;
	}

	public void setAvgFoodquality(Double avgFoodquality) {
		this.avgFoodquality = avgFoodquality;
	}

	public Double getAvgAmbiance() {
		return avgAmbiance;
	}

	public void setAvgAmbiance(Double avgAmbiance) {
		this.avgAmbiance = avgAmbiance;
	}

	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}
	
}