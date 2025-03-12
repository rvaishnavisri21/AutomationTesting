package day11_handson;

import org.testng.annotations.Test;

import io.restassured.RestAssured;




public class BDDStyle_PostPut {
  @Test
  public void f() {
	  String requestjson="{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2024-12-01\",\"checkout\":\"2024-12-10\"},\"additionalneeds\":\"Lunch\"}";
	  //1.To implement REST API with BDD Style  POST and PUT method implementation
	  //post
	  RestAssured.given().header("Content-Type","application/json").
	
	body(requestjson).
	when().post("https://restful-booker.herokuapp.com/booking").
	
	then().
	log().all();
	  //put
	  RestAssured.given().header("Content-Type","application/json").
		when().get("https://restful-booker.herokuapp.com/booking/445").
		
		then().
		log().all();
	  RestAssured.given().header("Content-Type","application/json").
		body(requestjson).
		when().put("https://restful-booker.herokuapp.com/booking/445").
		
		then().
		log().all();
	  
  }
}
