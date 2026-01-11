package com.omrbranch.readValues.pojo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import tools.jackson.core.exc.StreamReadException;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.ObjectMapper;

public class Read {
public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
	// create object for mapper class
	ObjectMapper mapper = new ObjectMapper();
	// pass the json file to fetch the value
	Employee value = mapper.readValue(new File("src\\test\\resources\\readFiles.json"),Employee.class);
	System.out.println(value.getPage());
	System.out.println(value.getPer_page());
	System.out.println(value.getTotal());
	System.out.println(value.getTotal_pages());
	
	System.out.println("\n");
 // data 
	List<Data> data = value.getData();
	for (Data data2 : data) {
		System.out.println(data2.getId());
		System.out.println(data2.getFlightName());
		System.out.println(data2.getCountry());
		System.out.println(data2.getDestinations());
		System.out.println(data2.getURL());
		
	}
		System.out.println("\n");

	// support
		Support support = value.getSupport();
		System.out.println(support.getUrl());
		System.out.println(support.getText());
}
}
