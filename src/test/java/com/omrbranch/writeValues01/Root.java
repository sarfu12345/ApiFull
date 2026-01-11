package com.omrbranch.writeValues01;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Root {
private String name;
private String email;
private String course;
private long phone;
private ArrayList<Lenovo> data;
private Support support;



}
