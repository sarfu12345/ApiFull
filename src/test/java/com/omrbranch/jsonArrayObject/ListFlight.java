	package com.omrbranch.jsonArrayObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.mapper.ObjectMapper;

public class ListFlight {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	JSONParser jsonParser = new JSONParser();
	Object object = jsonParser.parse(new FileReader("src\\test\\resources\\objectarray.json"));
	com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
	ListFlight value = mapper.readValue(new File("C:\\Users\\sarfu\\eclipse-workspace\\ApiTesting\\target\\hello.file"), ListFlight.class);
	
	
	System.out.println("............................................................................");
	//create a object for page
	JSONObject jsonObject = (JSONObject)object;
	Object pag = jsonObject.get("page");
	System.out.println(pag);
	
	Object per = jsonObject.get("per_page");
	System.out.println(per);
	
	Object total = jsonObject.get("total");
	System.out.println(total);
	
	Object pages = jsonObject.get("total_pages");
	System.out.println(pages);

	Object object3 = jsonObject.get("Data");
	System.out.println(object3);
	
	
	System.out.println("............................................................................");
	// create the object for Data array 
	JSONArray array = (JSONArray)object3;
	for (int i = 0; i < array.size(); i++) {
		Object object2 = array.get(i);
		JSONObject jsonObject2 = (JSONObject)object2;
		System.out.println(jsonObject2.get("id"));
		System.out.println(jsonObject2.get("flightName"));
		System.out.println(jsonObject2.get("Country"));
		System.out.println(jsonObject2.get("Destinations"));
		System.out.println(jsonObject2.get("URL"));
		
	}	
	Object data = array.get(0);
	System.out.println(data);

	JSONObject jsonObject2 = (JSONObject)data;
	Object id = jsonObject2.get("id");
	System.out.println(id);
	
	Object name = jsonObject2.get("flightName");
	System.out.println(name);
	
	Object count = jsonObject2.get("Country");
	System.out.println(count);

	Object dest = jsonObject2.get("Destinations");
	System.out.println(dest);

	Object url = jsonObject2.get("URL");
	System.out.println(url);

	System.out.println("............................................................................");
	// cerate next object
	Object object1 = array.get(1);
	System.out.println(object1);
	
	JSONObject jsonObject3 = (JSONObject)object1;
	Object object2 = jsonObject3.get("id");
	System.out.println(object2);

	Object fName = jsonObject3.get("flightName");
	System.out.println(fName);

	Object country = jsonObject3.get("Country");
	System.out.println(country);

	Object desti = jsonObject3.get("Destinations");
	System.out.println(desti);
	
	Object url1 = jsonObject3.get("URL");
	System.out.println(url1);

	System.out.println("............................................................................");
	// create next object for json object array
	Object object4 = array.get(2);
	System.out.println(object4);

	JSONObject jsonObject4 = (JSONObject)object4;
	Object id1 = jsonObject4.get("id");
	System.out.println(id1);

	Object fname1 = jsonObject4.get("flightName");
	System.out.println(fname1);
	
	Object country2 = jsonObject4.get("Country");
	System.out.println(country2);
	
	Object destin = jsonObject4.get("Destinations");
	System.out.println(destin);
	
	Object url3 = jsonObject4.get("URL");
	System.out.println(url3);


	System.out.println("............................................................................");
	// create a new object for json array 
	
	Object object5 = array.get(3);
	System.out.println(object5);
	
	JSONObject jsonObject5 = (JSONObject)object5;
	Object id3 = jsonObject5.get("id");
	System.out.println(id3);
	
	Object flightName = jsonObject5.get("flightName");
	System.out.println(flightName);
	
	Object country3 = jsonObject5.get("Country");
	System.out.println(country3);
	
	Object destina = jsonObject5.get("Destinations");
	System.out.println(destina);
	
	Object url4 = jsonObject5.get("URL");
	System.out.println(url4);
	
	System.out.println("............................................................................");
	// again create the new json array object
	Object object6 = array.get(4);
	System.out.println(object6);
	
	JSONObject jsonObject6 = (JSONObject)object6;
	Object id5 = jsonObject6.get("id");
	System.out.println(id5);
	
	Object flightName2 = jsonObject6.get("flightName");
	System.out.println(flightName2);
	
	Object country5 = jsonObject6.get("Country");
	System.out.println(country5);
	
	Object destinat = jsonObject6.get("Destinations");
	System.out.println(destinat);
	
	Object url5 = jsonObject6.get("URL");
	System.out.println(url5);
	
	System.out.println("............................................................................");
	// create again the json array object 
	Object object7 = array.get(5);
	System.out.println(object7);
	
	JSONObject jsonObject7 = (JSONObject)object7;
	Object id6 = jsonObject7.get("id");
	System.out.println(id6);
	
	Object flightName3 = jsonObject7.get("flightName");
	System.out.println(flightName3);
	
	Object country1 = jsonObject7.get("Country");
	System.out.println(country1);
	
	Object destinati = jsonObject7.get("Destinations");
	System.out.println(destinati);
	
	Object url6 = jsonObject7.get("URL");
	System.out.println(url6);
	
	System.out.println("............................................................................");
	// crearte the json object
	JSONObject jsonObject8 = (JSONObject)object;
	Object object8 = jsonObject8.get("support");
	System.out.println(object8);
	
	JSONObject jsonObject9 = (JSONObject)object8;
	Object url7 = jsonObject9.get("url");
	System.out.println(url7);
	
	Object text = jsonObject9.get("text");
	System.out.println(text);
	
	}
}
