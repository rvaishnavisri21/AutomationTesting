package day11_handson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;




public class BDDStyle_PostJSONRequest_File {
  @Test
  public void f() throws IOException {
	   //4. Try to implement the logic for getting json request from file (from your project folder path ) 
	  //named as Payload.json and sent the the same json request to BDD style post method
	  String jsoninputdata=generateStringFromResource(".\\resources\\Payload.json");
	  RestAssured.given().header("Content-Type","application/json").
		
		body(jsoninputdata).
		when().post("https://restful-booker.herokuapp.com/booking").
		
		then().
		log().all();
	 
	  
  }

private String generateStringFromResource(String path) throws IOException {
	// TODO Auto-generated method stub
	return new String(Files.readAllBytes(Paths.get(path)));
}
}
