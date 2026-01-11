package com.omrbranch.UserAddTocart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddToCart_Output_Pojo {
	 public int status;
	    public String message;
	    public String currency;
	    public int cart_count;
	    public Datum data;
}
