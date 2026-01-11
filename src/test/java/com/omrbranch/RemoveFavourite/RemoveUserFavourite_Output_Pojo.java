package com.omrbranch.RemoveFavourite;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveUserFavourite_Output_Pojo {
	   public int status;
	    public String message;
	    public ArrayList<Datum> data;
	    public int cart_count;
	    public String currency;
}
