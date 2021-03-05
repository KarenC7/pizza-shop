package com.axosclearing.codingchallenge.model.services;

import com.axosclearing.codingchallenge.model.entities.Pizza;

/*
 * Class thread of pizzas
 * 
 */

public class BakePizzaThread implements Runnable{

	private Pizza pizza;
	
	
	
	/**
	 * Constructor to set Pizza
	*/
	public BakePizzaThread(Pizza pizza) {
		this.pizza = pizza;
	}



	/**
	 * @description method to run thread of pizza
	 * @param NA 
	 * @return NA
	*/
	@Override
	public void run() {
		try {
			System.out.println("########## Starting to bake Pizza "+ pizza.getOrder() + "... ###########");
            Thread.sleep(30000);
            System.out.println("##################### PIZZA ORDER "+ pizza.getOrder() + " FINISHED #####################");
        } catch (InterruptedException ex) {
        	 System.out.println(ex.getMessage());
        }
		
	}


}
