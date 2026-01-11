package com.omrbranch.UserAddTocart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTocart_Input_Pojo {
	  public String product_id;
	    public String product_variation_id;
	    public String type;
}
