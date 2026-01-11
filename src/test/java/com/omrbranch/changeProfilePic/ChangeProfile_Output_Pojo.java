package com.omrbranch.changeProfilePic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProfile_Output_Pojo {
	public int status;
    public String message;
    public Datum data;
    public int cart_count;

}
