package com.omrbranch.singleFlight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Single {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	JSONParser jsonParser = new JSONParser();
	Object object = jsonParser.parse(new FileReader("src\\test\\resources\\Single.json"));
	JSONObject jsonObject = (JSONObject)object;
	Object id = jsonObject.get("Data");
	System.out.println(id);

	// create object for Data
	JSONObject jsonObject2 = (JSONObject)id;
	Object id1 = jsonObject2.get("id");
	System.out.println(id1);
	
	Object name = jsonObject2.get("flightName");
	System.out.println(name);
	
	Object country = jsonObject2.get("Country");
	System.out.println(country);
	
	Object dest = jsonObject2.get("Destinations");
	System.out.println(dest);
	
	Object url = jsonObject2.get("URL");
	System.out.println(url);
	
	Object create = jsonObject2.get("Created_Date");
	System.out.println(create);
	
	Object update = jsonObject2.get("Updated_Date");
	System.out.println(update);
	
	// create objectfor support
	JSONObject jsonObject3 = (JSONObject)object;
	Object object2 = jsonObject3.get("support");
	System.out.println(object2);

	//	JSONObject jsonObject4 = (JSONObject)url1;
	JSONObject jsonObject4 = (JSONObject)object2;
	Object printUrl = jsonObject4.get("url");
	System.out.println(printUrl);
	
	
	Object text = jsonObject4.get("text");
	System.out.println(text);	
}
}
