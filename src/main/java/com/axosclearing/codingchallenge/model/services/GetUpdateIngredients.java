package com.axosclearing.codingchallenge.model.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.axosclearing.codingchallenge.model.entities.Pizza;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/*
 * 
 * Class with methods to Get and Update the CSV File
 * 
 */

public class GetUpdateIngredients {
	

	/**
	 * @description Method to get ingredients from CSV file
	 * @param String CSV - route where you find the file
	 * @return Map<String,Integer> - HashMap where save temporally the ingredients 
	*/
	 public Map<String,Integer> takeIngredients(String csv) {
	    	
	    	Map<String,Integer> ingredients= new HashMap<>();
	    	CSVReader reader;
			try {
				
				//Try to read the file
				reader = new CSVReader(new FileReader(csv), ',' , '"' , 1);
				List<String[]> myEntries = reader.readAll();
			    
				//Declare a HashMap to save the values from the csv
				
			    for(String[] row2 : myEntries){
			      	ingredients.put(row2[0], Integer.valueOf(row2[1].trim()));
				}
			
			
			} catch (FileNotFoundException e) {
				System.out.println("Cannot find the file");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot read the file");
			}
			return ingredients;
	           
	       
	    }
	    
	    
	 /**
		 * @description Method to update (append) the new quantity of the ingredients after to order a Pizza
		 * @param Pizza pizza, Map<String,Integer> ingredients, String csv : Pizza object, original ingredients, route of CSV file
		 * @return Map<String,Integer> - HashMap where save take the new values of the ingredients
		*/
	    public Map<String,Integer> updateIngredients(Pizza pizza, Map<String,Integer> ingredients, String csv) {
	    	
	    	
	        try {
	        	
	        	//Declare reader and writer for CSV file, to add the new updated records
	        	CSVReader reader = new CSVReader(new FileReader(csv), ',' , '"' , 1);
	        	
	        	CSVWriter writer = new CSVWriter(new FileWriter(csv, true), ',', '"', "\r\n");
	        	
	        	List<String[]> myEntries = reader.readAll();
		        
		    	for (Map.Entry<String, Integer> entry : pizza.getIngredients().entrySet()) {
		    		//Update ingredients	
		    		ingredients.put(entry.getKey(), ingredients.get(entry.getKey())-entry.getValue());
		    		// Replaces the String at this array index
			        
		    	}
		    	
		    	//Full list
		    	for (String[] entry : myEntries)
		    	{
		    		entry[1] = ingredients.get(entry[0]).toString();
		    	}
		    	
		    	//Append list at the csv file
		    	writer.flush();
		    	writer.writeAll(myEntries,false);
		    	writer.close();
		        
		        	
	        } catch (IOException e) {
				System.out.println("Cannot access file to update");
			}
	    	
			return ingredients;
	           
	       
	    }

}
