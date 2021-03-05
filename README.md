# Pizza Shop - Coding Challenge

## Description

Develop a component that bakes virtual pizzas.  It should be a command line program that accepts an order from the user on the command line and bakes the virtual pizza.  See the `com.axosclearing.codingchallenge.pizzashop.Main` class for a starting point.

## Requirements

* Read available ingredients and quantities from the provided ingredient_inventory.csv file.
* Accept orders on the command line interactively as a list of ingredients terminated with a blank line.
* On receipt of an order, simulate baking the pizza in the background for 30 seconds.
* Allow the user to enter another order while a pizza is baking.
* Immediately notify the user when a pizza has finished baking.
* Ingredient quantities should be decreased as new orders are filled.
* Immediately notify the user when they order ingredients that are no longer available.

## Example Order

```
Topping> mushrooms[enter]
Topping> sausage[enter]
Topping> [enter]
Placing an order for a mushroom and sausage pizza…

Topping> 
```
-----------------------------------------------------------------
## How does it work

Available ingredients: 
- ham: 7
- pineapples: 5
- sausage: 10
- pepperoni: 10
- mushroom: 10
- jalapeno: 5
- cheese: 100

New order? (y/n)
- y (enter)

Write Topping (Can choose 3) >
- ham (enter)

How many ham? >
- 1 (enter)

Write Topping (Can choose 2) >
- cheese (enter)

How many cheese? >
- 2 (enter)

Write Topping (Can choose 1) >
- sausage (enter)

How many sausage? >
- 2 (enter)


########## Starting to bake Pizza 1... ###########

Available ingredients: 
- ham: 6
- pineapples: 5
- sausage: 8
- pepperoni: 10
- mushroom: 10
- jalapeno: 5
- cheese: 98


New order? (y/n)
- y (enter)

Write Topping (Can choose 3) >
- ham (enter)


How many ham? >
- 1 (enter)


##################### PIZZA ORDER 1 FINISHED #####################   <------- Inmediatelly when it ends show the result

Write Topping (Can choose 2) >
- cheese (enter)

... continue
