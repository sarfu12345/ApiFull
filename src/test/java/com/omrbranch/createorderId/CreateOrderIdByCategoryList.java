package com.omrbranch.createorderId;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.AddCategoryList.CategoryLIst_Output_pojo;
import com.omrbranch.AddCategoryList.ChildCatList;
import com.omrbranch.AddCategoryList.Datum;
import com.omrbranch.Setaddress.SetAddress_Input_Pojo;
import com.omrbranch.Setaddress.SetAddress_Output_Pojo;
import com.omrbranch.UserAddTocart.AddToCart_Output_Pojo;
import com.omrbranch.UserAddTocart.AddTocart_Input_Pojo;
import com.omrbranch.UserGetCartItems.GetCartItems_Output_pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.createorder.CreateOrder_Input_Pojo;
import com.omrbranch.createorder.CreateOrder_Output_Pojo;
import com.omrbranch.createorder.Datam;
import com.omrbranch.pojo.ProductList.AddProductList_Input_pojo;
import com.omrbranch.pojo.ProductList.AddProductList_Output_pojo;
import com.omrbranch.pojo.ProductList.Variation;
import com.omrbranch.pojo.addUserAddress.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.addUserAddress.AddUserAddress_Output_pojo;
import com.omrbranch.pojo.city.CityList_Input_Pojo;
import com.omrbranch.pojo.city.CityList_Output_Pojo2;
import com.omrbranch.pojo.login.postmanBasicAuthLogin_Output_Pojo;
import com.omrbranch.pojo.state.StateList_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CreateOrderIdByCategoryList extends BaseClass {
	String logtoken;
	String variantText;
	String type;
	String stateIdText;
	int stateId;
	int cityId;
	int address_Id;
	String itemIdText;
	String cart_IdText;
	String addressIdText;
	int order_id;
	int order_no;
	String orderIdtext;
	String productIdText;

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
		System.out.println("print logtoken:" + logtoken);
	}

	public void getcategoryList() {
		initRestAssured();
		addHeader("accept", "application/json");
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
						int categoryid = childCatList.getId();
						cart_IdText = String.valueOf(categoryid);
						System.out.println("categoryId:" + cart_IdText);
						break;
					}
				}
			}
		}
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
		AddProductList_Input_pojo addProductList_Input_pojo = new AddProductList_Input_pojo(cart_IdText, "0");
		addPayload(addProductList_Input_pojo);
		Response response = getResponse("POST", "https://www.omrbranch.com/api/productList");
		AddProductList_Output_pojo addProductList_Output_pojo = response.as(AddProductList_Output_pojo.class);
		ArrayList<com.omrbranch.pojo.ProductList.Datum> data2 = addProductList_Output_pojo.getData();
		for (com.omrbranch.pojo.ProductList.Datum datum : data2) {
			String productName = datum.getName();
			if (productName.equals("Nuts & Seeds - Raw Peanut")) {
				System.out.println("Product name"+productName);
				ArrayList<Variation> variations = datum.getVariations();
				for (Variation variation : variations) {
					String specifications = variation.getSpecifications();
					if (specifications.equals("1 kg")) {
						int variantId = variation.getId();
						System.out.println("VariantId:" + variantId);
						variantText = String.valueOf(variantId);
						int product_id = variation.getProduct_id();
						productIdText = String.valueOf(product_id);
						System.out.println("Product Id: " + productIdText);
						break;
					}
				}
			}
		}
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
		AddTocart_Input_Pojo addTocart_Input_Pojo = new AddTocart_Input_Pojo(productIdText, variantText, "plus");
		addPayload(addTocart_Input_Pojo);
		Response response = getResponse("POST", "https://www.omrbranch.com/api/addToCart");
		AddToCart_Output_Pojo addToCart_Output_Pojo = response.as(AddToCart_Output_Pojo.class);
		String message = addToCart_Output_Pojo.getMessage();
		System.out.println("print the message:" + message);
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
		System.out.println("print message:" + message);
		ArrayList<com.omrbranch.UserGetCartItems.Datum> data = getCartItems_Output_pojo.getData();
		for (com.omrbranch.UserGetCartItems.Datum datum : data) {
			int itemId = datum.getId();
			itemIdText = String.valueOf(itemId);
			System.out.println("print itemid:" + itemIdText);
			int cart_id = datum.getCart_id();
			cart_IdText = String.valueOf(cart_id);
			System.out.println("print cartId:" + cart_IdText);
			String product_name = datum.getProduct_name();
			System.out.println(product_name);
		}
	}
	
	public void getStateId() {
		initRestAssured();
		addHeader("accept", "applocation/json");
		Response response = getResponse("GET", "https://www.omrbranch.com/api/stateList");
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		ArrayList<com.omrbranch.pojo.state.Datum> data = stateList_Output_Pojo.getData();
		for (com.omrbranch.pojo.state.Datum stateName : data) {
			String name = stateName.getName();
			if (name.equals("Tamil Nadu")) {
				stateId = stateName.getId();
				stateIdText = String.valueOf(stateId);
				System.out.println("print the StateName id:" + stateIdText);
				break;
			}
		}
	}
	public void getCityid() {
		initRestAssured();
		List<Header> FirstHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		FirstHeader.add(h1);
		FirstHeader.add(h2);
		Headers headers = new Headers(FirstHeader);
		addHeaders(headers);
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateIdText);
		addPayload(cityList_Input_Pojo);
		Response response = getResponse("POST", "https://www.omrbranch.com/api/cityList");
		CityList_Output_Pojo2 cityList_Output_Pojo2 = response.as(CityList_Output_Pojo2.class);
		ArrayList<com.omrbranch.pojo.city.Datum> data = cityList_Output_Pojo2.getData();
		for (com.omrbranch.pojo.city.Datum datum : data) {
			String cityName = datum.getName();
			if (cityName.equals("Yercaud")) {
				cityId = datum.getId();
				System.out.println("print the city id:" + cityId);
				break;
			}
		}
	}
	
	public void addAddress() {
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
		AddUserAddress_Input_Pojo address_Input_Pojo = new AddUserAddress_Input_Pojo("sarfu", "khan", "9951066978",
				"hrt58", stateId, cityId, 101, "530044", "visakhapatnam", "Home");
		addPayload(address_Input_Pojo);
		Response response = getResponse("POST", "https://www.omrbranch.com/api/addUserAddress");
		AddUserAddress_Output_pojo addUserAddress_Output_pojo = response.as(AddUserAddress_Output_pojo.class);
		String message = addUserAddress_Output_pojo.getMessage();
		System.out.println("print the message:" + message);
		int address_id = addUserAddress_Output_pojo.getAddress_id();
		addressIdText = String.valueOf(address_id);
		System.out.println("print adress Id:" + addressIdText);
	}
	
	public void setAddress() {
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
		SetAddress_Input_Pojo setaddress_Input_Pojo = new SetAddress_Input_Pojo(addressIdText, cart_IdText);
		addPayload(setaddress_Input_Pojo);
		Response response = getResponse("POST", "https://www.omrbranch.com/api/setAddress");
		SetAddress_Output_Pojo setAddress_Output_Pojo = response.as(SetAddress_Output_Pojo.class);
		String message = setAddress_Output_Pojo.getMessage();
		System.out.println("print message:" + message);
	}
	
	public void createOrder() {
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
		CreateOrder_Input_Pojo createOrder_Input_Pojo = new CreateOrder_Input_Pojo("debit_card", "5555555555552222",
				"visa", "2027", "09", "123");
		addPayload(createOrder_Input_Pojo);
		Response response = getResponse("POST", "https://www.omrbranch.com/api/createOrder");
		CreateOrder_Output_Pojo createOrder_Output_Pojo = response.as(CreateOrder_Output_Pojo.class);
		order_id = createOrder_Output_Pojo.getOrder_id();
		orderIdtext = String.valueOf(order_id);
		System.out.println("Order Id: "+orderIdtext);
		Datam data = createOrder_Output_Pojo.getData();
		int order_no = data.getOrder_no();
		String orderNotext = String.valueOf("Order no: "+order_no);
		System.out.println(orderNotext);
	}
	public static void main(String[] args) {
		CreateOrderIdByCategoryList order=new CreateOrderIdByCategoryList();
		order.login();
		order.getcategoryList();
		order.getProductList();
		order.addToCart();
		order.getCartItems();
		order.getStateId();
		order.getCityid();
		order.addAddress();
		order.setAddress();
		order.createOrder();
	}
}
