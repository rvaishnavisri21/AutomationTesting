package day12_handson;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class RestAPI_PostPut {
  @Test
  public void f() {
	  String requestjson="{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2024-12-01\",\"checkout\":\"2024-12-10\"},\"additionalneeds\":\"Lunch\"}";
	  //1.To implement REST API  for POST and PUT
	  //post
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  RequestSpecification rs=RestAssured.given().header("Content-Type","application/json").body(requestjson);
	
	Response res=rs.post("/booking");
	System.out.println("POST::Response status code:"+res.getStatusCode());
	System.out.println("Response:"+res.prettyPrint());
	
	
	  //put
	
	Response res1=rs.get("/booking/445");
		System.out.println("GET::Response status code:"+res1.getStatusCode());
	System.out.println("Response:"+res1.prettyPrint());
		
	  
		rs.body(requestjson);
		Response res2=rs.put("/booking/445");
		
		System.out.println("PUT::Response status code:"+res2.getStatusCode());
		System.out.println("Response:"+res2.prettyPrint());
	  
  }
}
