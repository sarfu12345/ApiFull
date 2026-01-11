package com.omrbranch.writeValues;

import java.util.ArrayList;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root {
	private String name;
	private String email;
	private String course;
	private ArrayList<DataObj> datainfo;
	private Support support;
	
}
