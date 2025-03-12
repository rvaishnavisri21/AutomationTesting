package day11_handson;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class HamcrestValidation_GetPost {
  @Test
  public void f() {
	   //3. To Implement hamcrest validation for Post and Get methods
	  String requestjson="{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2024-12-01\",\"checkout\":\"2024-12-10\"},\"additionalneeds\":\"Lunch\"}";
		//post
	  RestAssured.given().contentType(ContentType.JSON).
	  body(requestjson).
		when().post("https://restful-booker.herokuapp.com/booking").
		then().
		body("booking.firstname",equalTo("John")).

		body("booking.lastname",equalTo("Doe")).
		body("booking.totalprice",equalTo(123)).
		body("booking.depositpaid",equalTo(true)).
				body("booking.bookingdates.checkin",equalTo("2024-12-01")).
						body("booking.bookingdates.checkout",equalTo("2024-12-10")).
								body("booking.additionalneeds",equalTo("Lunch")).
		
		log().all();
	  
	  
	  
		//get
				RestAssured.given().header("Content-Type","application/json").
				when().get("https://restful-booker.herokuapp.com/booking/1").
		then().
	body(matchesJsonSchema("{\n"
			+ "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n"
			+ "  \"type\": \"object\",\n"
			+ "  \"properties\": {\n"
			+ "    \"firstname\": {\n"
			+ "      \"type\": \"string\"\n"
			+ "    },\n"
			+ "    \"lastname\": {\n"
			+ "      \"type\": \"string\"\n"
			+ "    },\n"
			+ "    \"totalprice\": {\n"
			+ "      \"type\": \"integer\"\n"
			+ "    },\n"
			+ "    \"depositpaid\": {\n"
			+ "      \"type\": \"boolean\"\n"
			+ "    },\n"
			+ "    \"bookingdates\": {\n"
			+ "      \"type\": \"object\",\n"
			+ "      \"properties\": {\n"
			+ "        \"checkin\": {\n"
			+ "          \"type\": \"string\"\n"
			+ "        },\n"
			+ "        \"checkout\": {\n"
			+ "          \"type\": \"string\"\n"
			+ "        }\n"
			+ "      },\n"
			+ "      \"required\": [\n"
			+ "        \"checkin\",\n"
			+ "        \"checkout\"\n"
			+ "      ]\n"
			+ "    }\n"
			+ "  },\n"
			+ "  \"required\": [\n"
			+ "    \"firstname\",\n"
			+ "    \"lastname\",\n"
			+ "    \"totalprice\",\n"
			+ "    \"depositpaid\",\n"
			+ "    \"bookingdates\"\n"
			+ "  ]\n"
			+ "}")).
	
	
		/*body("firstname",equalTo("Eric")).

				body("lastname",equalTo("Jones")).
				body("totalprice",equalTo(751)).
				body("depositpaid",equalTo(false)).
						body("bookingdates.checkin",equalTo("2024-02-07")).
								body("bookingdates.checkout",equalTo("2024-08-09")).
										body("additionalneeds",equalTo("Breakfast")).*/
	log().all();
	 
	  
  }
}
