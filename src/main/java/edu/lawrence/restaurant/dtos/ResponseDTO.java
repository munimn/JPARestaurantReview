package edu.lawrence.restaurant.dtos;




import edu.lawrence.restaurant.entities.Response;


public class ResponseDTO {
	private String responseid;
	private String response;
	private String idreview;
	
	public ResponseDTO() {
	}

	public ResponseDTO(Response core) {
		responseid = core.getResponseid().toString();
		response = core.getResponse();
		idreview = core.getReview().getReviewid().toString();
	}
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getResponseid() {
		return responseid;
	}

	public void setResponseid(String responseid) {
		this.responseid = responseid;
	}
	public String getReviewid() {
		return idreview;
	}
	public void setReviewid(String idreview) {
		this.idreview = idreview;
	}
}

