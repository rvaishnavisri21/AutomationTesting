package day12_handson;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class JSONPathClass_ValidateAttributes {
	
  @Test
  public void f() throws JsonProcessingException {
	   //3.Use JSONPath class to validate the each response attribute like firstname, lastname etc using Request 
	  //Specification and Response interface for Http  post method
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  Booking b=new Booking();
	  b.setFirstname("Vaishnavi");
	  b.setLastname("R");
	  b.setTotalprice(1000);
	  b.setDepositpaid(false);
	  BookingDates bd=new BookingDates();
	  bd.setCheckin("2024-12-01");
	  bd.setCheckout("2024-12-12");
	  b.setBookingdates(bd);
	  
	  
	  ObjectMapper objmap=new ObjectMapper();
	  String inputjson=objmap.writeValueAsString(b);
	  System.out.println("Json input:"+inputjson);
	  
	  
	  RequestSpecification rs=RestAssured.given().header("Content-Type","application/json").header("Accept","application/json")
			  .body(inputjson);
			  //API call
			  Response res=rs.post("/booking");
			  System.out.println("response status code:"+res.getStatusCode());
			  System.out.println("response:"+res.asString());
			  JsonPath js=new JsonPath(res.asString());
			  String fname=js.get("booking.firstname");
			  String lname=js.get("booking.lastname");
			  int tp=js.getInt("booking.totalprice");
			  Boolean dp=js.getBoolean("booking.depositpaid");
			  String cin=js.get("booking.bookingdates.checkin");
			  String cout=js.get("booking.bookingdates.checkout");
			  
			  Assert.assertEquals(fname,b.getFirstname());
			  Assert.assertEquals(lname,b.getLastname());
			  Assert.assertEquals(tp,b.getTotalprice());
			  Assert.assertEquals(dp,b.getDepositpaid());
			  Assert.assertEquals(cin,b.getBookingdates().getCheckin());
			  Assert.assertEquals(cout,b.getBookingdates().getCheckout());
			 System.out.println("Validation passed");
			  
			  
  }
}
