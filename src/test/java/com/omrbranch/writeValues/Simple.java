package com.omrbranch.writeValues;

import java.io.File;
import java.util.ArrayList;


import tools.jackson.databind.ObjectMapper;

public class Simple {
public static void main(String[] args) {
	File file = new File("src\\test\\resources\\Hello.json");
	
	ObjectMapper mapper = new ObjectMapper();
	// assign the value
	Support support = new Support("https:\\/\\/www.omrbranch.com","For Joining Automation Course, Please Contact-Velmurugan 9944152058");
	ArrayList<DataObj> datainfo=new ArrayList<>();
	DataObj obj=new DataObj(845, "AirIndia", "India","85","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	DataObj obj1=new DataObj(845, "AirIndia", "India","85","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	DataObj obj2=new DataObj(845, "AirIndia", "India","85","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	DataObj obj3=new DataObj(845, "AirIndia", "India","85","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
	
	datainfo.add(obj);
	datainfo.add(obj1);
	datainfo.add(obj2);
	datainfo.add(obj3);
	Root teacher = new Root("khan","khan@gamil.com", "Api",datainfo,support);



mapper.writeValue(file, teacher);
System.out.println("done...............");
	
	
	
	
}
}
