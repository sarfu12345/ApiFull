package com.omrbranch.AddTocart;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.AddCategoryList.CategoryLIst_Output_pojo;
import com.omrbranch.AddCategoryList.ChildCatList;
import com.omrbranch.AddCategoryList.Datum;
import com.omrbranch.UserAddTocart.AddToCart_Output_Pojo;
import com.omrbranch.UserAddTocart.AddTocart_Input_Pojo;
import com.omrbranch.UserClearCart.ClearToCart_Output_Pojo;
import com.omrbranch.UserGetCartItems.Address;
import com.omrbranch.UserGetCartItems.GetCartItems_Output_pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.ProductList.AddProductList_Input_pojo;
import com.omrbranch.pojo.ProductList.AddProductList_Output_pojo;
import com.omrbranch.pojo.ProductList.Variation;
import com.omrbranch.pojo.login.postmanBasicAuthLogin_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AddToCart extends BaseClass {
	String logToken;
	String category_id;
	String logtoken;
	String variantText;
	String productIdText;
	String type;
	
	public void clearCartItems() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		
		Response response = getResponse("GET", "https://www.omrbranch.com/api/clearCart");
		ClearToCart_Output_Pojo ClearToCart_Output_Pojo = response.as(ClearToCart_Output_Pojo.class);
		String message = ClearToCart_Output_Pojo.getMessage();
		System.out.println(message);

		
	}

	public void getCartItems() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		Response response = getResponse("GET", "https://www.omrbranch.com/api/getCartItems");
		GetCartItems_Output_pojo getCartItems_Output_pojo = response.as(GetCartItems_Output_pojo.class);
		String message = getCartItems_Output_pojo.getMessage();
		System.out.println(message);
		ArrayList<com.omrbranch.UserGetCartItems.Datum> data = getCartItems_Output_pojo.getData();
		for (com.omrbranch.UserGetCartItems.Datum datum : data) {
			int product_id = datum.getProduct_id();
			System.out.println(product_id);
		}
	Address address = getCartItems_Output_pojo.getAddress();
	String first_name = address.getFirst_name();
	System.out.println(first_name);
	
	}

	public void addToCart() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		FirstHeader.add(h3);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		AddTocart_Input_Pojo addTocart_Input_Pojo = new AddTocart_Input_Pojo(productIdText, variantText, type);
		addPayload(addTocart_Input_Pojo);
		Response response = getResponse("POST", "https://www.omrbranch.com/api/addToCart");
		AddToCart_Output_Pojo addToCart_Output_Pojo = response.as(AddToCart_Output_Pojo.class);
		String message = addToCart_Output_Pojo.getMessage();
		System.out.println(message);
	}

	public void getProductList() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		// add pay load
		AddProductList_Input_pojo addProductList_Input_pojo = new AddProductList_Input_pojo(category_id, "0");
		addPayload(addProductList_Input_pojo);
		// add request
		Response response = getResponse("POST", "https://www.omrbranch.com/api/productList");
		AddProductList_Output_pojo addProductList_Output_pojo = response.as(AddProductList_Output_pojo.class);
		ArrayList<com.omrbranch.pojo.ProductList.Datum> data = addProductList_Output_pojo.getData();
		for (com.omrbranch.pojo.ProductList.Datum datum : data) {
			String Productname = datum.getName();
			if (Productname.equals("Nuts & Seeds - Raw Peanut")) {
				ArrayList<Variation> variations = datum.getVariations();
				for (Variation variation : variations) {
					String specifications = variation.getSpecifications();
					if (specifications.equals("1 kg")) {
						int variantId = variation.getId();
						System.out.println("VariantId" + variantId);
						variantText = String.valueOf(variantId);

						int product_id = variation.getProduct_id();
						System.out.println("productId:" + product_id);
						productIdText = String.valueOf(product_id);
						break;
					}
				}
			}
		}

	}

	public void getcategoryList() {
		initRestAssured();
		addHeader("accept", "application/json");
		addBasicAuth("sarfuddinkhan48914@gmail.com", "Sarfu@2001");
		Response response = getResponse("GET", "https://www.omrbranch.com/api/categoryList");
		CategoryLIst_Output_pojo CategoryLIst_Output_pojo = response.as(CategoryLIst_Output_pojo.class);
		String message = CategoryLIst_Output_pojo.getMessage();
		System.out.println("print the message" + message);
		ArrayList<Datum> data = CategoryLIst_Output_pojo.getData();
		for (Datum datum : data) {
			String Categoryname = datum.getName();
			if (Categoryname.equals("Grocery")) {
				ArrayList<ChildCatList> child_cat_list = datum.getChild_cat_list();
				for (ChildCatList childCatList : child_cat_list) {
					String Subcategoryname = childCatList.getName();
					if (Subcategoryname.equals("Fruit & Nuts")) {
						int id = childCatList.getId();
						category_id = String.valueOf(id);

						System.out.println("Fruit and nut cat Id:" + id);
						break;
					}
				}

			}

		}

	}

	public void login() {
		initRestAssured();
		addHeader("accept", "application/json");
		addBasicAuth("sarfuddinkhan48914@gmail.com", "Sarfu@2001");
		Response response = getResponse("POST", "https://www.omrbranch.com/api/postmanBasicAuthLogin");
		postmanBasicAuthLogin_Output_Pojo postmanBasicAuthLogin_Output_Pojo = response
				.as(postmanBasicAuthLogin_Output_Pojo.class);
		String first_name = postmanBasicAuthLogin_Output_Pojo.getData().getFirst_name();
		System.out.println(first_name);
		logtoken = postmanBasicAuthLogin_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);
	}

	public static void main(String[] args) {

		AddToCart addToCart = new AddToCart();
		addToCart.login();
		addToCart.getcategoryList();
		addToCart.getProductList();
		addToCart.clearCartItems();
		addToCart.addToCart();
		addToCart.getCartItems();
	}
}
