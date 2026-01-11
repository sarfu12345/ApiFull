package com.omrbranch.baseclass;

public class Simple extends BaseClass {
	public void createFlight() {
		initRestAssured();
		addHeader("Content-type", "application/json");
		addPayload("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		getResponse("POST", "https://www.omrbranch.com/api/flights");
		printResponse(response);
	}

	// updateFlight
	public void updateFlight() {
		addHeader("content-Type", "application/json");
		addPayload("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 84,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");
		getResponse("PUT", "https://www.omrbranch.com/api/flight/55169");
		printResponse(response);
	}
	// update partial in flight

	public void updateFlighPart() {
		addHeader("content-type", "application/json");
		addPayload("{\r\n" + "    \"Destinations\": 50\r\n" + "}");
		getResponse("PATCH", "https://www.omrbranch.com/api/flight/55169");
		printResponse(response);
	}

	// SingleFlight
	public void singleFlight() {
		addHeader("content-type", "application/json");
		getResponse("GET", "https://www.omrbranch.com/api/flight/55196");
		printResponse(response);
	}

	public void ListFlights() {

		addHeader("content-type", "application/json");
		getResponse("GET", "https://www.omrbranch.com/api/flights?page=1");
		printResponse(response);
	}

	public void delete() {
		addHeader("content-type", "application/json");
		getResponse("DELETE", "https://www.omrbranch.com/api/flight/55169");
		printResponse(response);
		System.out.println("deleteDone.....................");
	}

	public static void main(String[] args) {
		Simple simple = new Simple();
		simple.createFlight();
		simple.updateFlight();
		simple.updateFlighPart();
		simple.singleFlight();
		simple.ListFlights();
		simple.delete();
	}
}
