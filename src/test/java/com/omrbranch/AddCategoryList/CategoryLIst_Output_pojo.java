package com.omrbranch.AddCategoryList;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryLIst_Output_pojo {
	public int status;
    public String message;
    public ArrayList<Datum> data;
}
	