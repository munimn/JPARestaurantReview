package edu.lawrence.auction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer; 

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import edu.lawrence.restaurant.dtos.ResponseDTO;
import edu.lawrence.restaurant.dtos.RestaurantDTO;
import edu.lawrence.restaurant.dtos.ReviewDTO;
import edu.lawrence.restaurant.dtos.SummaryDTO;
import edu.lawrence.restaurant.dtos.UserDTO;
import edu.lawrence.restaurant.entities.User;
import edu.lawrence.restaurant.services.UserService;
import edu.lawrence.restaurant.JprestaurantApplication;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest(classes=JprestaurantApplication.class,webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APIBasicTests {
	private static UserDTO testSeller;
	private static UserDTO testBuyerOne;
	private static UserDTO testBuyerTwo;
	public static RestaurantDTO testRestaurantpostOne;
	public static RestaurantDTO testRestaurantpostTwo;
	private static ReviewDTO testReviewpostOne;
	private static ReviewDTO testReviewpostTwo;
	private static ResponseDTO testResponseOne;
	private static ResponseDTO testResponseTwo;
	private static SummaryDTO testSummaryRestOne;
	private static SummaryDTO testSummaryRestTwo;
	private static String sellerToken;
	private static String buyerOneToken;
	private static String buyerTwoToken;
	private static String sellerid;
	private static String buyerOneid;
	private static String buyerTwoid;
	private static String allRestaurants;
	
	private static String restIDOne;
	private static String restIDTwo;
	private static String revIDOne;
	private static String revIDTwo;
	
	
	@BeforeAll
	public static void setup() {
		RestAssured.port = 8085;
		RestAssured.baseURI = "http://localhost";
		
		testSeller = new UserDTO();
		testSeller.setName("TestSeller");
		testSeller.setPassword("hello");
		
		testBuyerOne = new UserDTO();
		testBuyerOne.setName("BuyerOne");
		testBuyerOne.setPassword("hello");
		testBuyerTwo = new UserDTO();
		testBuyerTwo.setName("BuyerTwo");
		testBuyerTwo.setPassword("hello");
		testRestaurantpostOne = new RestaurantDTO();
		testRestaurantpostOne.setName("Test Restaurant One");
		testRestaurantpostOne.setAddress("711 E Boldt Way");
		testRestaurantpostOne.setFoodtype("Bengali");
		testRestaurantpostTwo = new RestaurantDTO();
		testRestaurantpostTwo.setName("Test Restaurant Two");
		testRestaurantpostTwo.setAddress("209N Catherine St");
		testRestaurantpostTwo.setFoodtype("Ethiopian");
		testReviewpostOne = new ReviewDTO();
		testReviewpostOne.setReview("Very Good Food");
		testReviewpostOne.setFoodquality(10);
		testReviewpostOne.setAmbiance(10);
		testReviewpostOne.setFoodquality(10);
		testReviewpostOne.setDate(new Date());
		testReviewpostTwo = new ReviewDTO();
		testReviewpostTwo.setReview("Very Bad Food");
		testReviewpostTwo.setFoodquality(2);
		testReviewpostTwo.setAmbiance(2);
		testReviewpostTwo.setFoodquality(6);
		testReviewpostTwo.setDate(new Date());
		testResponseOne = new ResponseDTO();
		testResponseOne.setResponse("I agree");
		testResponseTwo = new ResponseDTO();
		testResponseTwo.setResponse("I Do not agree");
	}



	
	@Test
	@Order(1)
	public void testLogin() {
		sellerToken = given()
				.contentType("application/json")
				.body(testSeller)
				.when().post("/users/login")
				.then()
				.statusCode(200)
				.extract().asString();
		
		buyerOneToken = given()
				.contentType("application/json")
				.body(testBuyerOne)
				.when().post("/users/login")
				.then()
				.statusCode(200)
				.extract().asString();

		buyerTwoToken = given()
				.contentType("application/json")
				.body(testBuyerTwo)
				.when().post("/users/login")
				.then()
				.statusCode(200)
				.extract().asString();
	}
	@Test
	@Order(2)
	public void testLoginID() {
		sellerid = given()
				.header("Authorization","Bearer "+sellerToken)
				.contentType("application/json")
				.body(testSeller)
				.when().get("/users/login")
				.then()
				.statusCode(200)
				.extract().asString();
		
		
		buyerOneid = given()
				.header("Authorization","Bearer "+buyerOneToken)
				.contentType("application/json")
				.body(testBuyerOne)
				.when().get("/users/login")
				.then()
				.statusCode(200)
				.extract().asString();
		buyerTwoToken = given()
				.header("Authorization","Bearer "+buyerTwoToken)
				.contentType("application/json")
				.body(testBuyerTwo)
				.when().get("/users/login")
				.then()
				.statusCode(200)
				.extract().asString();
	}
	
	
	@Test
	@Order(3)
	public void testPostRestaurant() {
		
		
		restIDOne = given()
		.header("Authorization","Bearer "+sellerToken)
		.contentType("application/json")
		.body(testRestaurantpostOne)
		.when().post("/restaurant")
		.then()
		.statusCode(anyOf(is(200))).extract().asString();
		
		
		restIDTwo = given()
		.header("Authorization","Bearer "+sellerToken)
		.contentType("application/json")
		.body(testRestaurantpostTwo)
		.when().post("/restaurant")
		.then()
		.statusCode(anyOf(is(200))).extract().asString();
		
	}
	
	
	
	@Test
	@Order(4)
	public void testGetRestaurants() {
		allRestaurants =  
				when()
				.get("/restaurant")
				.then()
				.statusCode(200)
				.extract()
				.asString();
		
		System.out.println(allRestaurants);
	}
	@Test
	@Order(5)
	public void testGetRestaurantsbyname() {
		restIDOne =  
				when()
				.get("/restaurant/name/"+ testRestaurantpostOne.getName())
				.then()
				.statusCode(200)
				.extract()
				.path("[0].restaurantid");
		testRestaurantpostOne.setRestaurantid(restIDOne);
		
		System.out.println(restIDOne);
	}
	@Test
	@Order(6)
	public void testGetRestaurantsbyfoodtype() {
		restIDTwo =  
				when()
				.get("/restaurant/foodtype/"+ testRestaurantpostTwo.getFoodtype())
				.then()
				.statusCode(200)
				.extract()
				.path("[0].restaurantid");
		
		testRestaurantpostTwo.setRestaurantid(restIDTwo);
		System.out.println(restIDTwo);
	}
	@Test
	@Order(7)
	public void testGetRestaurantsbyid() {
		restIDOne =  
				given()
				.header("Authorization","Bearer "+sellerToken)
				.when()
				.get("/restaurant/"+ restIDOne)
				.then()
				.statusCode(200)
				.extract()
				.path("[0].restaurantid");
		
		System.out.println(restIDOne);
	}
	@Test
	@Order(8)
	public void testPostReview() {
		
		testReviewpostOne.setRestaurantid(testRestaurantpostOne.getRestaurantid());
		testReviewpostTwo.setRestaurantid(testRestaurantpostTwo.getRestaurantid());
		testReviewpostOne.setUserid(sellerid);
		testReviewpostTwo.setUserid(buyerOneid);
		

		revIDOne = given()
		.header("Authorization","Bearer "+sellerToken)
		.contentType("application/json")
		.body(testReviewpostOne)
		.when().post("/reviews")
		.then()
		.statusCode(anyOf(is(200)))
		.extract().asString();
		testReviewpostOne.setReviewid(revIDOne);
		
		
		revIDTwo = given()
		.header("Authorization","Bearer "+sellerToken)
		.contentType("application/json")
		.body(testReviewpostTwo)
		.when().post("/reviews")
		.then()
		.statusCode(anyOf(is(200)))
		.extract().asString();
		testReviewpostTwo.setReviewid(revIDTwo);
		
	}
	@Test
	@Order(9)
	public void testGetReviewbyRestaurant() {
		revIDOne =  
				given()
				.header("Authorization","Bearer "+sellerToken)
				.when()
				.get("/reviews/"+ testRestaurantpostOne.getRestaurantid() )
				.then()
				.statusCode(200)
				.extract()
				.path("[0].restaurantid");
		
		System.out.println(revIDOne);
		
	}
	@Test
	@Order(10)
    public void testPostResponse() {
		
		testResponseOne.setReviewid(testReviewpostOne.getReviewid());
		testResponseTwo.setReviewid(testReviewpostTwo.getReviewid());

		

	     given()
		.header("Authorization","Bearer "+sellerToken)
		.contentType("application/json")
		.body(testResponseOne)
		.when().post("/response")
		.then()
		.statusCode(anyOf(is(200)));

		
		
         given()
		.header("Authorization","Bearer "+sellerToken)
		.contentType("application/json")
		.body(testResponseTwo)
		.when().post("/response")
		.then()
		.statusCode(anyOf(is(200)));

		
	}
	@Test
	@Order(11)
	public void testGetResponsebyRev() {
				given()
				.header("Authorization","Bearer "+sellerToken)
				.when()
				.get("/response/"+ testReviewpostOne.getReviewid() )
				.then()
				.statusCode(200)
				.extract()
				.path("[0].restaurantid");
		
	}
	@Test
	@Order(12)
	public void testGetSummarybyRestID() {
				given()
				.header("Authorization","Bearer "+sellerToken)
				.when()
				.get("/restaurant/"+ testRestaurantpostOne.getRestaurantid() + "/summary" )
				.then()
				.statusCode(200)
				.extract()
				.path("[0].restaurantid");
		
	}

}
