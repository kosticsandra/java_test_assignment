package com.alasdoo.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

public class RestAssuredManager {

	public static Response getResponse(String url, Object... params) {

		Response response = given().param("id", params).contentType(ContentType.JSON).when().get(url).then().extract()
				.response();

		return response;

	}

	public static Response updateResponse(String httpRequest, String url, HashMap<String, String> usersData) {
		
		JSONObject request = new JSONObject();
		request.putAll(usersData);
		Response response = null;
		
		switch(httpRequest) {
		case "post":
			 response = given().header("Content-type", "application/json").and().body(request.toJSONString()).when()
			.post(url).then().extract().response();
			break;
		case "put":
			response = given().param("id", Integer.parseInt(usersData.get("id"))).header("Content-type", "application/json").and().body(request.toJSONString()).when()
			.put(url).then().extract().response();
			break;
		case "patch":
			response = given().header("Content-type", "application/json").and().body(request.toJSONString()).when()
			.patch(url).then().extract().response();
			break;
		}

		return response;
	}
	
	public static Response deleteUser(String url, Object...params) {
		Response response = given().param("id", params).contentType(ContentType.JSON).when().delete(url).then().extract()
				.response();

		return response;
	}

}
