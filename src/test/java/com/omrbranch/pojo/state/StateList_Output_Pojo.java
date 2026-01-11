package com.omrbranch.pojo.state;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateList_Output_Pojo {
	 public int status;
	    public String message;
	    public ArrayList<Datum> data;
}
