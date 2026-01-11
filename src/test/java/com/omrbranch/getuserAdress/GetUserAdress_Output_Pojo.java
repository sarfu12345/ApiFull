package com.omrbranch.getuserAdress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserAdress_Output_Pojo {
	public int status;
    public String message;
    public ArrayList<Datum> data;
}
