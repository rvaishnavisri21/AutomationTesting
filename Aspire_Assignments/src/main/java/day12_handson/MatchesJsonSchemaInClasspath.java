package day12_handson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static org.hamcrest.Matchers.*;



public class MatchesJsonSchemaInClasspath {
  @Test
  public void f() throws IOException {
	   //4. Use matchesJsonSchemaInClasspath concept  for validating whole response message with json input request 
	  //template using post method:
	  RestAssured.baseURI="https://restful-booker.herokuapp.com";
	  String jsoninput="{\"firstname\":\"Vaishnavi\",\"lastname\":\"R\",\"totalprice\":1000,\n"
	  		+ "\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2024-12-01\"\n"
	  		+ ",\"checkout\":\"2024-12-12\"},\n"
	  		+ "\"additionalneeds\":\"Lunch\"}\n"
	  		+ "";
	  
	  RequestSpecification rs= RestAssured.given().header("Content-Type","application/json").header("Accept","application/json").body(jsoninput);
	  Response res=rs.post("/booking");
	  System.out.println("response status code:"+res.getStatusCode());
	  System.out.println("response:"+res.asString());
	  
	  
	  assertThat(res.asString(),matchesJsonSchemaInClasspath("booking-schema.json"));
	 System.out.println("Schema Validation passed");
	  
  }


}
