package com.alasdoo.api;

import static io.restassured.RestAssured.get;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyRestAssured {

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in/api";
	}

	@Test
	public void test() {

		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		int statusCode = response.getStatusCode();
		Assertions.assertEquals(statusCode, 200);

	}

	@Test
	public void test_GetOneUser() {
		Integer userId = 2;
		Integer statusCode = 200;
		Response response = RestAssuredManager.getResponse("/users/", userId);

		HashMap<String, ?> responseMap = response.getBody().jsonPath().get("data");
		Integer responseId = (Integer) responseMap.get("id");

		Assertions.assertEquals(statusCode, response.statusCode());
		Assertions.assertEquals(userId, responseId);

	}

	@Test
	public void test_userNotFound() {
		Integer userId = 23;
		Integer statusCode = 404;
		Response response = RestAssuredManager.getResponse("/users/", userId);
		Assertions.assertEquals(statusCode, response.statusCode());
	}

	@Test
	public void test_getAllUsers() {
		Integer statusCode = 200;
		Response response = RestAssuredManager.getResponse("/unknown");
		Assertions.assertEquals(statusCode, response.statusCode());
		// System.out.println(response.jsonPath().prettify());
	}

	@Test
	public void test_createUser() {
		Integer statusCode = 201;

		HashMap<String, String> newUser = new HashMap<>();
		newUser.put("name", "morpheus");
		newUser.put("job", "leader");

		Response response = RestAssuredManager.updateResponse("post", "/users", newUser);

		Assertions.assertEquals(statusCode, response.statusCode());
		Assertions.assertEquals(newUser.get("name"), response.jsonPath().getString("name"));
		Assertions.assertEquals(newUser.get("job"), response.jsonPath().getString("job"));
		System.out.println(response.getCookies());

	}

	@Test
	public void test_userRegisteredSuccessfully() {
		Integer statusCode = 200;

		HashMap<String, String> newUser = new HashMap<>();
		newUser.put("email", "eve.holt@reqres.in");
		newUser.put("password", "pistol");

		Response response = RestAssuredManager.updateResponse("post", "/register", newUser);
		Assertions.assertEquals(statusCode, response.statusCode());

	}

	@Test
	public void test_updatePutUser() {
		Integer statusCode = 200;
		HashMap<String, String> updatedUser = new HashMap<>();
		updatedUser.put("name", "morpheus");
		updatedUser.put("job", "zion resident");
		updatedUser.put("id", "2");

		Response response = RestAssuredManager.updateResponse("put", "/users/", updatedUser);

		Assertions.assertEquals(statusCode, response.statusCode());
		Assertions.assertEquals(updatedUser.get("name"), response.jsonPath().getString("name"));
		Assertions.assertEquals(updatedUser.get("job"), response.jsonPath().getString("job"));
	}

	@Test
	public void test_updatePatchUser() {
		Integer statusCode = 200;
		HashMap<String, String> patchedUser = new HashMap<>();
		patchedUser.put("name", "morpheus");
		patchedUser.put("job", "matrix master");
		patchedUser.put("id", "2");

		Response response = RestAssuredManager.updateResponse("patch", "/users/", patchedUser);

		Assertions.assertEquals(statusCode, response.statusCode());
		Assertions.assertEquals(patchedUser.get("name"), response.jsonPath().getString("name"));
		Assertions.assertEquals(patchedUser.get("job"), response.jsonPath().getString("job"));
	}

	@Test
	public void test_deleteUser() {
		Integer userId = 2;
		Integer statusCode = 204;
		Response response = RestAssuredManager.deleteUser("/users/", userId);

		Assertions.assertEquals(statusCode, response.statusCode());
	}

}