package day12_handson;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class RestAPI_Get {
  @Test
  public void f() {
	   //1.To implement RESTAssured  Get Implementation for the url
	  //contentType=ContentType.JSON
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  RequestSpecification rs=RestAssured.given().contentType(ContentType.JSON);
	
	  	  
	  Response res=rs.get("/booking/445");
	  System.out.println("GET::Response status code:"+res.getStatusCode());
		System.out.println("Response:"+res.prettyPrint());
		
		
	  
  }
}
