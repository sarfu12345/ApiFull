package com.omrbranch.login;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.login.postmanBasicAuthLogin_Output_Pojo;

import io.restassured.response.Response;

public class Login extends BaseClass {
	public void login() {
		//1. initilize the restAssured
		initRestAssured();
		
		//2. add header
		
		addHeader("accept", "application/json");
		//3. add basic auth
		addBasicAuth("sarfuddinkhan48914@gmail.com", "Sarfu@2001");
		
		//4.requestType
		Response response = getResponse("POST", "https://www.omrbranch.com/api/postmanBasicAuthLogin");
		postmanBasicAuthLogin_Output_Pojo postmanBasicAuthLogin_Output_Pojo = response
				.as(postmanBasicAuthLogin_Output_Pojo.class);
		
		// print the request
		printResponse(response);
		
		String first_name = postmanBasicAuthLogin_Output_Pojo.getData().getFirst_name();
		System.out.println(first_name);
		
		String logtoken = postmanBasicAuthLogin_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);

	}

	public static void main(String[] args) {
		Login login = new Login();
		login.login();
	}
}
