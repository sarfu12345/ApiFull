package com.omrbranch.readValues.pojo1;

import java.io.File;
import java.util.ArrayList;

import lombok.Data;
import tools.jackson.databind.ObjectMapper;

public class Sample {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Root value = mapper.readValue(new File("src\\test\\resources\\objectArray1.json"), Root.class);
		ArrayList<Data> data = value.getData();
		for (Data data2 : data) {
			System.out.println(data2);

		}
		System.out.println("\n");
		System.out.println(value.getPage());
		System.out.println(value.getPer_page());
		System.out.println(value.getTotal());
		System.out.println(value.getTotal_pages());

		System.out.println("\n");
		Support support = value.getSupport();
		System.out.println(support.getUrl());
		System.out.println(support.getText());

	}

}
