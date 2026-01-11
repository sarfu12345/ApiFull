package com.omrbranch.UserClearCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClearToCart_Output_Pojo {
private int  status;
private String message;
public int cart_count;


}
