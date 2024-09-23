package edu.lawrence.restaurant.entities;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import edu.lawrence.restaurant.dtos.ResponseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="response")
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(columnDefinition = "VARCHAR(200)")
	@JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID responseid;
	@ManyToOne
	@JoinColumn(name="idreview")
	private Review review;
	private String response;
	public Response() {}
	public Response(ResponseDTO core) {
		response = core.getResponse().toString();
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public UUID getResponseid() {
		return responseid;
	}

	public void setResponseid(UUID responseid) {
		this.responseid = responseid;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
}
