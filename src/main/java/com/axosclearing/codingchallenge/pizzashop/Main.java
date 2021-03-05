package com.axosclearing.codingchallenge.pizzashop;


import java.io.IOException;
import java.util.Map;
import com.axosclearing.codingchallenge.model.services.GetUpdateIngredients;
import com.axosclearing.codingchallenge.model.services.SetOrder;

/*
 * Main class
 * 
 */
public class Main {
	

    public static void main(String[] args) throws IOException {
    	String csv = "";
    	
    	//You can pass by args the route or take it from the project
    		csv = "D:/Documents/GitHub/pizza-shop/src/main/resources/ingredient_inventory.csv";

    	
    	//Get ingredients to start from excel
    	GetUpdateIngredients in = new GetUpdateIngredients();	
    	Map<String,Integer> ingredients= in.takeIngredients(csv);
   	
    	//Get order
    	SetOrder order = new SetOrder();
    	order.getOrder(ingredients,csv,in);
    	
    	
    }
    
    
}