package com.Devtools.practise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {
	RequestSpecification requestSpec;
	
	public void login() {
	requestSpec = RestAssured.given();
	requestSpec = requestSpec.headers("content-type","applocation/json");
	requestSpec= requestSpec.body("{\\r\\n\" + \"    \\\"flightName\\\": \\\"AirIndia\\\",\\r\\n\" + \"    \\\"Country\\\": \\\"India\\\",\\r\\n\"\r\n"
			+ "				+ \"    \\\"Destinations\\\": \\\"87\\\",\\r\\n\"\r\n"
			+ "				+ \"    \\\"URL\\\": \\\"https:\\\\/\\\\/en.wikipedia.org\\\\/wiki\\\\/Air_India\\\"\\r\\n\" + \"");
	Response response = requestSpec.post("https://www.omrbranch.com/api/updateUserAddress");
	
			
	

	}
}
