package com.omrbranch.pojo.ProductList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductList_Output_pojo {
	 public int status;
	    public String message;
	    public String currency;
	    public ArrayList<Datum> data;
	    public String banner;
	    public int cart_count;
}
