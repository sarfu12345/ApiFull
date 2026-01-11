package com.omrbranch.jsonObject;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Simple {
public static void main(String[] args) throws  IOException, ParseException, org.json.simple.parser.ParseException {
	
	//1. create a object for a jsonParser class
	JSONParser jsonParser = new JSONParser();
	
	// 2. pass the json file to fetch the value
	Object object = jsonParser.parse(new FileReader("C:\\Users\\sarfu\\eclipse-workspace\\ApiTesting\\src\\test\\resources\\SimpleCreate.json"));
	
	// convert object to json object 
	JSONObject jsonObject = (JSONObject)object;
	Object name = jsonObject.get("name");
	System.out.println("employee name is :"+name);
	
	Object id = jsonObject.get("employeeId");
	System.out.println("employee id is :"+id);
	
	Object age = jsonObject.get("employeeAge");
	System.out.println("employeee age is :"+age);
	
	Object email = jsonObject.get("email");
	System.out.println("employeee emails is :"+email);
	
	Object number = jsonObject.get("phoneNO");
	System.out.println("employee number is :"+number);
	
	Object course = jsonObject.get("course");
	System.out.println("course details is :"+course);
	Collection values = jsonObject.values();
	for (Object value : values) {
		System.out.println(value);
	}
	Set keySet = jsonObject.keySet();
	for (Object key : keySet) {
		System.out.println(key);
	}

	Set entrySet = jsonObject.entrySet();
	System.out.println(entrySet);
		for (Object combination : entrySet) {
			System.out.println(combination);
	}
}
}
