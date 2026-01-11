package com.omrbranch.baseclass;

import io.restassured.response.Response;

public class JsonPath extends BaseClass {
	Object object;
	int id;

	public static void main(String[] args) {
		JsonPath jsonPath = new JsonPath();
		jsonPath.createFlight();
		jsonPath.updateFlight();
		jsonPath.updateFlightp();
		jsonPath.singleFlight();
		jsonPath.listFlight();
		jsonPath.delete();
	}

	public void createFlight() {
		initRestAssured();
		addHeader("Content-Type", "application/json");
		addPayload("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		Response res = getResponse("POST", "https://www.omrbranch.com/api/flights");
		printResponse(res);

		object = res.jsonPath().get("data.id");
		id = (int) object;
		System.out.println(id);
	}

	public void updateFlight() {
		addHeader("Content-Type", "application/json");
		addPayload("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 66,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		Response res = getResponse("PUT", "https://www.omrbranch.com/api/flights" + id);
		getStatusCode(res);
		getResBodyAsPrettyString(res);
	}

	public void updateFlightp() {
		addHeader("Content-Type", "application/json");
		addPayload("{\r\n" + "    \"Destinations\": 90\r\n" + "}");
		Response response2 = getResponse("PATCH", "https://www.omrbranch.com/api/flights" + id);
		getStatusCode(response2);
		getResBodyAsPrettyString(response2);
	}

	public void singleFlight() {
		addHeader("Content-Type", "application/json");
		Response response3 = getResponse("GET", "https://www.omrbranch.com/api/flights" + id);
		getStatusCode(response3);
		getResBodyAsPrettyString(response3);
	}

	public void listFlight() {
		addHeader("Content-Type", "application/json");
		Response response4 = getResponse("GET", "https://www.omrbranch.com/api/flights?page=1");
		getStatusCode(response4);
		getResBodyAsPrettyString(response4);
	}

	public void delete() {
		Response response5 = getResponse("DELETE", "https://www.omrbranch.com/api/flights" + id);

		getStatusCode(response5);
		getResBodyAsPrettyString(response5);
	}

}
