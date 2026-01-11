package com.omrbranch.deletecart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCart_Output_Pojo {
public int status;
public String message;
public int cart_count;

}
