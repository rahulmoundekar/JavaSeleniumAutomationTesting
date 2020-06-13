package com.app.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import org.testng.annotations.Test;

public class GetRequest {

	/*
	 * @Test public void getResponse() {
	 * given().when().get("https://reqres.in/api/users?page=2").prettyPrint(); }
	 */

	@Test
	public void getResponseValidation() {
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("page", equalTo(2))
				.body("data.id", hasItems(7, 8));

	}

	@Test
	public void getResponseContent() {
		given().when().get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
		.and().contentType(ContentType.JSON);	

	}
	
	@Test
	public void getResponseHeader() {
		given().when().get("https://reqres.in/api/users?page=2").getHeaders();
	}

	
	
	@Test
	public void postRequest() {
		int statuscode = given().when()
				.body("{\r\n" + "    \"name\": \"rahul\",\r\n" + "    \"job\": \"leader\"\r\n" + "}")
				.post("https://reqres.in/api/users").getStatusCode();
		System.out.println(statuscode);
	}

	@Test
	public void putRequest() {
		int statuscode = given().when()
				.body("{\r\n" + "    \"name\": \"rahul\",\r\n" + "    \"job\": \"Software dev\"\r\n" + "}")
				.put("https://reqres.in/api/users/2").getStatusCode();
		System.out.println(statuscode);
	}

	@Test
	public void deleteRequest() {
		int statuscode = given().when().delete("https://reqres.in/api/users/2").getStatusCode();
		System.out.println(statuscode);
	}

}
