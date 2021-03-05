package com.axosclearing.codingchallenge.model.entities;

import java.util.Map;

public class Pizza {
	
	int order;
	int name;
	Map<String,Integer> ingredients;
	
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public Map<String, Integer> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Map<String, Integer> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	

}
