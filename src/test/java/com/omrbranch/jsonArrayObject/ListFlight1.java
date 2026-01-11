package com.omrbranch.jsonArrayObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListFlight1 {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	JSONParser jsonParser = new JSONParser();
	Object object = jsonParser.parse(new FileReader("src\\test\\resources\\objectArray1.json"));
	System.out.println("............................................................................");
	//create the json object 
	JSONObject jsonObject = (JSONObject)object;
	Object page = jsonObject.get("page");
	System.out.println(page);
	
	Object per = jsonObject.get("per_page");
	System.out.println(per);
	
	Object total = jsonObject.get("total");
	System.out.println(total);
	
	Object totalp = jsonObject.get("total_pages");
	System.out.println(totalp);
	
	Object data = jsonObject.get("Data");
	System.out.println(data);
	System.out.println("............................................................................");
	// ceate json object for array
	JSONArray array = (JSONArray)data;
	for (int i = 0; i < array.size(); i++) {
		Object object2 = array.get(i);
		JSONObject jsonObject2 = (JSONObject)object2;
		System.out.println(jsonObject2.get("id"));
		System.out.println(jsonObject2.get("flightName"));
		System.out.println(jsonObject2.get("Country"));
		System.out.println(jsonObject2.get("Destinations"));
		System.out.println(jsonObject2.get("URL"));
		
	}
	Object obj0 = array.get(0);
	System.out.println(obj0);
	
	JSONObject jsonObject2 = (JSONObject)obj0;
	System.out.println(jsonObject2.get("id"));
	System.out.println(jsonObject2.get("flightName"));
	System.out.println(jsonObject2.get("Country"));
	System.out.println(jsonObject2.get("Destinations"));
	System.out.println(jsonObject2.get("URL"));
	System.out.println("............................................................................");
	// create a json object array
	Object object2 = array.get(1);
	System.out.println(object2);
	
	JSONObject jsonObject3 = (JSONObject)object2;
	System.out.println(jsonObject3.get("id"));
	System.out.println(jsonObject3.get("flightName"));
	System.out.println(jsonObject3.get("Country"));
	System.out.println(jsonObject3.get("Destinations"));
	System.out.println(jsonObject3.get("URL"));
	System.out.println("............................................................................");
	// create the json object
	Object object3 = array.get(2);
	System.out.println(object3);
	
	JSONObject jsonObject4 = (JSONObject)object3;
	System.out.println(jsonObject4.get("id"));
	System.out.println(jsonObject4.get("flightName"));
	System.out.println(jsonObject4.get("Country"));
	System.out.println(jsonObject4.get("Destinations"));
	System.out.println(jsonObject4.get("URL"));
	System.out.println("............................................................................");
	// create the object for json
	Object object4 = array.get(3);
	System.out.println(object4);
	
	JSONObject jsonObject5 = (JSONObject)object4;
	System.out.println(jsonObject5.get("id"));
	System.out.println(jsonObject5.get("flightName"));
	System.out.println(jsonObject5.get("Country"));
	System.out.println(jsonObject5.get("Destinations"));
	System.out.println(jsonObject5.get("URL"));
	System.out.println("............................................................................");
	// create object for json object
	Object object5 = array.get(4);
	System.out.println(object5);
	
	JSONObject jsonObject6 = (JSONObject)object5;
	System.out.println(jsonObject6.get("id"));
	System.out.println(jsonObject6.get("flightName"));
	System.out.println(jsonObject6.get("Country"));
	System.out.println(jsonObject6.get("Destinations"));
	System.out.println(jsonObject6.get("URL"));
	System.out.println("............................................................................");
	// create a object fo json object
	Object object6 = array.get(5);
	System.out.println(object6);
	
	JSONObject jsonObject7 = (JSONObject)object6;
	System.out.println(jsonObject7.get("id"));
	System.out.println(jsonObject7.get("flightName"));
	System.out.println(jsonObject7.get("Country"));
	System.out.println(jsonObject7.get("Destinations"));
	System.out.println(jsonObject7.get("URL"));
	System.out.println("............................................................................");
	//	// create object for json object array
	JSONObject support = (JSONObject)object;
	Object object7 = support.get("support");	
	
	JSONObject jsonObject9 = (JSONObject)object7;
	System.out.println(jsonObject9.get("url"));
	System.out.println(jsonObject9.get("text"));
	
	
	
}
}
