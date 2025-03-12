package day11_handson;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;




public class RestAssured_Get {
  @Test
  public void f() {
	   //1.To implement RESTAssured  Get Implementation for the url
	  //contentType=ContentType.JSON

	  	  RestAssured.given().contentType(ContentType.JSON).
		when().get("https://restful-booker.herokuapp.com/booking/445").
		
		then().
		log().all();
	 
	  
  }
}
