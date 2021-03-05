package com.axosclearing.codingchallenge.model.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.axosclearing.codingchallenge.model.entities.Pizza;

/*
 * Class to take an order and check ingredients
 * 
 */

public class SetOrder {
	

	/**
	 * @description General method to take order, first show ingredients and ask for a new order, 
	 * after validate ingredients and finally call the method to bake pizza
	 * @param Map<String,Integer> ingredients, String csv, GetUpdateIngredients in - Current ingredients, route of CSV file, object of GetUpdateIngredients to update 
	 * @return NA 
	*/
	public void getOrder(Map<String,Integer> ingredients, String csv, GetUpdateIngredients in) {
    	try (Scanner scan = new Scanner(System.in)) {
			
    		//Initialize number of order
    		int numOrder = 0;
    		
    		//While you have a new order
			while(true) {
				
				numOrder ++;
				
				//Show available ingredients if there is more than one
				System.out.println("Available ingredients: ");
				for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
					if(entry.getValue()!=0)
						System.out.println("- " + entry.getKey() + ": " +entry.getValue());
				}
				
			    // create a new scanner 
			    System.out.println("New order? (y/n)");
			    char order = scan.nextLine().charAt(0);
			    if(order == 'n') {
			    	break;
			    }else if(order != 'n' && order != 'y') {
			    	System.out.println("Incorrect option selected");
			    	continue;
			    }
			    //Set my pizza
			    Pizza myPizza = new Pizza();
			    myPizza.setOrder(numOrder);
			    
			    //Get ingredients
			    Map<String,Integer> ingredientsMyPizza =  ingredientsMyPizza(ingredients, myPizza, scan);
			    
			   
			    //Set ingredients to myPizza
			    myPizza.setIngredients(ingredientsMyPizza);
			    
			   //If pizza has ingredients then update the CSV
			    if(ingredientsMyPizza!=null)	
			    	ingredients = in.updateIngredients(myPizza, ingredients, csv);
			    
			    //Sent to bake pizza
			    BakePizzaThread bake = new BakePizzaThread(myPizza);
				Thread th = new Thread(bake);
				th.start();
			    
			}
		}catch(Exception ex) {
			System.out.println("You give a wrong input");
		}
    }
    
	/**
	 * @description General method to take order, first show ingredients and ask for a new order, 
	 * after validate ingredients and finally call the method to bake pizza
	 * @param Map<String,Integer> ingredients, Pizza myPizza, Scanner scan - Current ingredients, Pizza object, Scan to read the information 
	 * @return  Map<String,Integer> : ingredients for the current pizza
	*/
    public static Map<String,Integer> ingredientsMyPizza(Map<String,Integer> ingredients, Pizza myPizza, Scanner scan) {
    	Map<String,Integer> ingredientsMyPizza = new HashMap<>();
    	
    	//Count only 3 different toppings
        int countToppings = 3;
	    do {
	    	
	    	//Ask topping
	    	 System.out.println("Write Topping (Can choose "+ countToppings +") >");
	    	 String topping = scan.nextLine();
	    	 
	    	 //Check topping
	         if(ingredients.get(topping)==null)
	        	 System.out.println("The topping not exist");
	         else {
	        	 
	        	 boolean correctNum = true;
	        	 do {
	        		 
	        		 //Ask quantity of topping
		        	 System.out.println("How many "+ topping +"? >");
		 	         int numTopping = Integer.parseInt(scan.nextLine());
		        	 
		 	         //Check quantity
		 	         if(numTopping > ingredients.get(topping)) {
		        		 System.out.println("We dont have this quantity of "+ topping +" available"); 
		        	 	 correctNum = false;
		        	 	
		        	 } else {
		        		 ingredientsMyPizza.put(topping, numTopping);
		        		 correctNum = true;
		        		 countToppings--;
		        	 }
	        	 }while(!correctNum);
	         
	         }
	    
	         
	    }while(countToppings>0);
	    
		return ingredientsMyPizza;
    }
    

}
