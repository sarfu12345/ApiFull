package com.omrbranch.RemoveUserFavourite;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.AddCategoryList.CategoryLIst_Output_pojo;
import com.omrbranch.AddCategoryList.ChildCatList;
import com.omrbranch.AddCategoryList.Datum;
import com.omrbranch.EmptyFavourite.GetEmptyUser_Output_Pojo;
import com.omrbranch.Managefavourite.ManageUserfavourite_Output_Pojo;
import com.omrbranch.Managefavourite.manageUserFavourite_Input_pojo;
import com.omrbranch.RemoveFavourite.RemoveUserFavourite_Output_Pojo;
import com.omrbranch.RemoveFavourite.removeUserFavourite_Input_Pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.getManagefavourite.GetUserFavourite_Output_pojo;
import com.omrbranch.pojo.ProductList.AddProductList_Input_pojo;
import com.omrbranch.pojo.ProductList.AddProductList_Output_pojo;
import com.omrbranch.pojo.ProductList.Variation;
import com.omrbranch.pojo.login.postmanBasicAuthLogin_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RemoveFavourites extends BaseClass {
	 String logtoken;
	  String categoryListText;
	  String variantIdText;
	  String productIdText;

	  public void getEmptyFavourites() {
	    initRestAssured();
	    // 2. Header
	    List<Header> lstHeader = new ArrayList<>();
	    Header h1 = new Header("accept", "application/json");
	    Header h2 = new Header("Authorization", "Bearer " + logtoken);
	    lstHeader.add(h1);
	    lstHeader.add(h2);
	    Headers headers = new Headers(lstHeader);
	    addHeaders(headers);

	    Response response = getResponse("GET", "https://omrbranch.com/api/getUserFavourites");

	    GetEmptyUser_Output_Pojo getEmptyUser_Output_Pojo = response
	        .as(GetEmptyUser_Output_Pojo.class);
	    String message = getEmptyUser_Output_Pojo.getMessage();
	    System.out.println(message);

	  }

	  public void removeUserFavourites() {
	    initRestAssured();
	    // 2. Header
	    List<Header> lstHeader = new ArrayList<>();
	    Header h1 = new Header("accept", "application/json");
	    Header h2 = new Header("Authorization", "Bearer " + logtoken);
	    Header h3 = new Header("Content-Type", "application/json");
	    lstHeader.add(h1);
	    lstHeader.add(h2);
	    lstHeader.add(h3);
	    Headers headers = new Headers(lstHeader);
	    addHeaders(headers);

	    removeUserFavourite_Input_Pojo removeUserFavourite_Input_Pojo = new removeUserFavourite_Input_Pojo(productIdText,
	        variantIdText);
	    addPayload(removeUserFavourite_Input_Pojo);

	    Response response = getResponse("POST", "https://omrbranch.com/api/manageUserFavourite");
	    RemoveUserFavourite_Output_Pojo RemoveUserFavourite_Output_Pojo = response.as(RemoveUserFavourite_Output_Pojo.class);
	    String message = RemoveUserFavourite_Output_Pojo.getMessage();
	    System.out.println(message);

	  }


		public void getUserfavourites() {
		    initRestAssured();
		    // 2. Header
		    List<Header> lstHeader = new ArrayList<>();
		    Header h1 = new Header("accept", "application/json");
		    Header h2 = new Header("Authorization", "Bearer " + logtoken);
		    lstHeader.add(h1);
		    lstHeader.add(h2);
		    Headers headers = new Headers(lstHeader);
		    addHeaders(headers);

		    Response response = getResponse("GET", "https://omrbranch.com/api/getUserFavourites");
		    GetUserFavourite_Output_pojo getUserFavourite_Output_pojo = response.as(GetUserFavourite_Output_pojo.class);
		    String message = getUserFavourite_Output_pojo.getMessage();
		    System.out.println(message);

		  }

	  public void addUserFavourite() {
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
			manageUserFavourite_Input_pojo manageUserFavourite_Input_pojo = new manageUserFavourite_Input_pojo(productIdText, variantIdText);
			addPayload(manageUserFavourite_Input_pojo);
			Response response = getResponse("POST","https://omrbranch.com/api/manageUserFavourite");
		ManageUserfavourite_Output_Pojo manageUserfavourite_Output_Pojo = response.as(ManageUserfavourite_Output_Pojo.class);
		    String message = manageUserfavourite_Output_Pojo.getMessage();
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
			AddProductList_Input_pojo addProductList_Input_pojo = new AddProductList_Input_pojo(categoryListText, "0");
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
							System.out.println("VariantId"+variantId);
							variantIdText = String.valueOf(variantId);
							
							int product_id = variation.getProduct_id();
							System.out.println("productId:"+product_id);
							 productIdText = String.valueOf(product_id);
							break;
						}
					}
				}
			}

		}

	  public void GetcategoryList() {
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
							categoryListText = String.valueOf(id);

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
	    RemoveFavourites removeFavourites = new RemoveFavourites();
	    removeFavourites.login();
	    removeFavourites.GetcategoryList();
	    removeFavourites.getProductList();
	    removeFavourites.addUserFavourite();
	    removeFavourites.getUserfavourites();
	    removeFavourites.removeUserFavourites();
	    removeFavourites.getEmptyFavourites();

	  }

	}
