package com.omrbranch;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import org.apache.commons.io.monitor.FileAlterationObserver;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.changeProfilePic.ChangeProfile_Output_Pojo;
import com.omrbranch.pojo.login.postmanBasicAuthLogin_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ChangeProfile extends BaseClass {
	
	String logtoken;

	public void login() {
		initRestAssured();
		addHeader("accept", "application/json");
		addBasicAuth("sarfuddinkhan48914@gmail.com", "Sarfu@2001");
		Response response = getResponse("POST", "https://www.omrbranch.com/api/postmanBasicAuthLogin");
		postmanBasicAuthLogin_Output_Pojo postmanBasicAuthLogin_Output_Pojo = response
				.as(postmanBasicAuthLogin_Output_Pojo.class);
		String first_name = postmanBasicAuthLogin_Output_Pojo.getData().getFirst_name();
		System.out.println("print the first name :"+first_name);

		logtoken = postmanBasicAuthLogin_Output_Pojo.getData().getLogtoken();
		System.out.println("print the logToken:"+logtoken);

	}
	
	public void addProfilePic() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		FirstHeader.add(h3);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		addMultiPart("profile_picture", new File("C:\\\\Users\\\\sarfu\\\\Downloads\\\\hexaware.png"))
//		addMultiPart("profile_picture", new File("C:\\Users\\sarfu\\Downloads\\hexaware.png"));
		Response response = getResponse("POST", "https://omrbranch.com/api/changeProfilePic");
		ChangeProfile_Output_Pojo changeProfilePic_Output_Pojo = response.as(ChangeProfile_Output_Pojo.class);
		String message = changeProfilePic_Output_Pojo.getMessage();
		System.out.println(message);
		
	}
	public static void main(String[] args) {
		
		ChangeProfile changeProfile = new ChangeProfile();
		changeProfile.login();
		changeProfile.addProfilePic();
	}
	
}
