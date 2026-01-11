package com.omrbranch.pojo.city;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityList_Output_Pojo2 {
	 public int status;
	    public String message;
	    public ArrayList<Datum> data;	    
}
