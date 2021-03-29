package com.alasdoo.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyRestAssured {
	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in";
	}

	// @Test
	public void test() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		Assertions.assertEquals(statusCode, 200);

	}

	// @Test
	public void getOneUser() {
		Response response = RestAssured.given().contentType(ContentType.JSON).when().get("/api/users/2").then()
				.extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}

	// @Test
	public void userNotFound() {
		Response response = RestAssured.given().contentType(ContentType.JSON).when().get("/api/users/23").then()
				.extract().response();

		Assertions.assertEquals(404, response.statusCode());
	}

	//@Test
	public void getAllUsers() {
		Response response = RestAssured.given().contentType(ContentType.JSON).when().get("/api/unknown").then()
				.extract().response();

		System.out.println(response.getBody().asString());

		Assertions.assertEquals(200, response.statusCode());
	}

	private static String requestBody = "{\n" + "  \"name\": \"morpheus\",\n" + "  \"job\": \"leader\"\n" + "  \n}";

	// @Test
	public void createUser() {
		Response response = RestAssured.given().header("Content-type", "application/json").and().body(requestBody)
				.when().post("/api/users").then().extract().response();
		Assertions.assertEquals(201, response.statusCode());
		Assertions.assertEquals("morpheus", response.jsonPath().getString("name"));
		Assertions.assertEquals("leader", response.jsonPath().getString("job"));
	}

	private static String requestBody2 = "{\n" + "  \"name\": \"morpheus\",\n" + "  \"job\": \"zion resident\"\n"
			+ " \n}";

	// @Test
	public void updatePutUser() {
		Response response = RestAssured.given().header("Content-type", "application/json").and().body(requestBody2)
				.when().put("/api/users/2").then().extract().response();

		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals("morpheus", response.jsonPath().getString("name"));
		Assertions.assertEquals("zion resident", response.jsonPath().getString("job"));
	}
	
	//@Test
	public void updatePatchUser() {
		Response response = RestAssured.given().header("Content-type", "application/json").and().body(requestBody2)
				.when().patch("/api/users/2").then().extract().response();

		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals("morpheus", response.jsonPath().getString("name"));
		Assertions.assertEquals("zion resident", response.jsonPath().getString("job"));
	}

	// @Test
	public void deleteUser() {
		Response response = RestAssured.given().header("Content-type", "application/json").when().delete("/api/users/2")
				.then().extract().response();

		int statusCode = response.getStatusCode();
		Assertions.assertEquals(statusCode, 204);
	}
	private static String requestBody3 = "{\n" + "  \"email\": \"eve.holt@reqres.in\",\n" + "  \"password\": \"pistol\"\n"
			+ " \n}";
	@Test
	public void userRegisteredSuccessfully() {
		Response response = RestAssured.given().header("Content-type", "application/json").and().body(requestBody3)
				.when().post("/api/register").then().extract().response();
		Assertions.assertEquals(200, response.statusCode());
		
	}

}