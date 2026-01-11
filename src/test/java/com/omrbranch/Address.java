package com.omrbranch;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.getuserAdress.GetUserAdress_Output_Pojo;
import com.omrbranch.pojo.addUserAddress.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.addUserAddress.AddUserAddress_Output_pojo;
import com.omrbranch.pojo.city.CityList_Input_Pojo;
import com.omrbranch.pojo.city.CityList_Output_Pojo2;
import com.omrbranch.pojo.delete.DeleteUser_Input_pojo;
import com.omrbranch.pojo.delete.DeleteUser_Output_Pojo;
import com.omrbranch.pojo.login.postmanBasicAuthLogin_Output_Pojo;
import com.omrbranch.pojo.state.Datum;
import com.omrbranch.pojo.state.StateList_Output_Pojo;
import com.omrbranch.updateUserAddress.UpdateUserAddress_Input_pojo;
import com.omrbranch.updateUserAddress.UpdateUserAdress_Output_pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Address extends BaseClass {
	String stateIdText;
	String logtoken;
	int id2;
	int id;
	String addressIdText;
	int address_Id;
	

	public void updateUser() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		FirstHeader.add(h3);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		// add payload
		UpdateUserAddress_Input_pojo address_Input_pojo = new UpdateUserAddress_Input_pojo(addressIdText,"sarfu", "khan", "9951066978",
				"hrt58", id2, id, 101, "530044", "visakhapatnam", "Home");
		addPayload(address_Input_pojo);
		// request
		Response response = getResponse("PUT", "https://www.omrbranch.com/api/updateUserAddress");
		UpdateUserAdress_Output_pojo updateUserAddress_output_pojo = response.as(UpdateUserAdress_Output_pojo.class);
		String message = updateUserAddress_output_pojo.getMessage();
		System.out.println(message);
		
	
	}
	
	public void DeleteUser() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		FirstHeader.add(h3);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		// add payload
		DeleteUser_Input_pojo deleteUser_Input_pojo = new DeleteUser_Input_pojo(addressIdText);
		addPayload(deleteUser_Input_pojo);
		
		// request
		Response response = getResponse("DELETE","https://www.omrbranch.com/api/deleteAddress");
		DeleteUser_Output_Pojo deleteUser_Output_Pojo = response.as(DeleteUser_Output_Pojo.class);
		String message = deleteUser_Output_Pojo.getMessage();
		System.out.println(message);
		
		
	}
	
	public void addAddress() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		FirstHeader.add(h3);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		// payload
		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo("sarfu", "khan", "9951066978",
				"hrt58", id2, id, 101, "530044", "visakhapatnam", "Home");
		addPayload(address_Input_Pojo);
		// request type
		Response response = getResponse("POST", "https://www.omrbranch.com/api/addUserAddress");
		AddUserAddress_Output_pojo addUserAddress_Output_pojo = response.as(AddUserAddress_Output_pojo.class);
		String message = addUserAddress_Output_pojo.getMessage();
		System.out.println("print the message:"+message);
		int address_id = addUserAddress_Output_pojo.getAddress_id();
		addressIdText = String.valueOf(address_id);
		System.out.println(addressIdText);
		
	}

	public void getCityid() {
		initRestAssured();

		// 2. Header
		List<Header> FirstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);

		// 3.payload
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateIdText);
		addPayload(cityList_Input_Pojo);

		// 4.req Type

		Response response = getResponse("POST", "https://www.omrbranch.com/api/cityList");
		CityList_Output_Pojo2 cityList_Output_Pojo2 = response.as(CityList_Output_Pojo2.class);
		ArrayList<com.omrbranch.pojo.city.Datum> data = cityList_Output_Pojo2.getData();
		for (com.omrbranch.pojo.city.Datum datum : data) {
			String cityName = datum.getName();
			if (cityName.equals("Yercaud")) {
				id = datum.getId();
				System.out.println("print the city id:"+id);
				break;
			}
		}

	}

	public void login() {
		//1.inilitize
		initRestAssured();
		//2.add header
		addHeader("accept", "application/json");
		//3 add basic Auth
		addBasicAuth("sarfuddinkhan48914@gmail.com", "Sarfu@2001");
		//4. add getResponse
		Response response = getResponse("POST", "https://www.omrbranch.com/api/postmanBasicAuthLogin");
		postmanBasicAuthLogin_Output_Pojo postmanBasicAuthLogin_Output_Pojo = response
				.as(postmanBasicAuthLogin_Output_Pojo.class);

		// printResponse(response);

		String first_name = postmanBasicAuthLogin_Output_Pojo.getData().getFirst_name();
		System.out.println("print the first name :"+first_name);

		logtoken = postmanBasicAuthLogin_Output_Pojo.getData().getLogtoken();
		System.out.println("print the logToken:"+logtoken);

	}

	public void getStateId() {
		// 1.initilize
		initRestAssured();
		//2. add header
		addHeader("accept", "applocation/json");
		//3.add basicAuth
		addBasicAuth("sarfuddinkhan48914@gmail.com", "Sarfu@2001");
		//4. get Response
		Response response = getResponse("GET", "https://www.omrbranch.com/api/stateList");
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		String message = stateList_Output_Pojo.getMessage();
		System.out.println("print the getMessage:"+message);

		ArrayList<Datum> data = stateList_Output_Pojo.getData();

		for (Datum stateName : data) {
			String name = stateName.getName();
			if (name.equals("Tamil Nadu")) {
				id2 = stateName.getId();
				stateIdText = String.valueOf(id2);
				System.out.println("print the StateName id:"+id2);
			}
		}

	}

	public void getUserAdress() {
				initRestAssured();
			List<Header> lstHeader = new ArrayList<>();
			Header h1 = new Header("accept", "application/json");
			Header h2 = new Header("Authorization", "Bearer " + logtoken);		
			lstHeader.add(h1);
			lstHeader.add(h2);
			Headers headers = new Headers(lstHeader);
			addHeaders(headers);
			Response response = getResponse("GET", "https://omrbranch.com/api/getUserAddress");
			GetUserAdress_Output_Pojo getUserAdress_Output_Pojo = response.as(GetUserAdress_Output_Pojo.class);
			String message = getUserAdress_Output_Pojo.getMessage();
			System.out.println(message);
		}
	public static void main(String[] args) {
		Address address = new Address();
		address.login();
		address.getStateId();
		address.getCityid();
		address.addAddress();
		address.getUserAdress();
		address.updateUser();
		address.DeleteUser();
	}
}
