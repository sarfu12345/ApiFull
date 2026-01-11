package com.omrbranch.writeValues01;

import java.io.File;
import java.util.ArrayList;

import tools.jackson.databind.ObjectMapper;

public class Simple {
public static void main(String[] args) {
	File file = new File("src\\test\\resources\\myDoc.json");
	
	ObjectMapper mapper = new ObjectMapper();
	
	Support support = new Support("For Joining Automation Course, Please Contact-Velmurugan 9944152058", "https:\\\\/\\\\/www.omrbranch.com");
	
	ArrayList<Lenovo> data = new ArrayList<Lenovo>();
	Lenovo obj = new Lenovo(845, "AirIndia", "India", "85","https://www.omrbranch.com");
	Lenovo obj1 = new Lenovo(845, "UsaAirLines", "USA", "96","https://www.omrbranch.com");
	Lenovo obj2 = new Lenovo(845, "DubaiEmriates", "Dubai", "23","https://www.omrbranch.com");
	Lenovo obj3 = new Lenovo(845, "AirKoria", "Koria", "98","https://www.omrbranch.com");
	data.add(obj);
	data.add(obj1);
	data.add(obj2);
	data.add(obj3);
	
	Root root = new Root("sarfu","sarfu@gmal.com","API",9951066978l,data,support);
	
	mapper.writeValue(file, root);
	System.out.println("Done............");
	
	
}
}
