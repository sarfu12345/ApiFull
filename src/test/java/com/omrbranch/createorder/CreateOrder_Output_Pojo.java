package com.omrbranch.createorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrder_Output_Pojo {
	public int status;
    public String message;
    public String currency;
    public Datam data;
    public int order_id;
}
