package stores;

import java.util.*;
import foods.rolls.*;
import foods.decorators.condiments.*;
import foods.Food;

// ABSTRACTION : This class represents animals generally, but can be overridden by 
// more concrete subclasses.
public class FoodStore {
	/*
	Animal class
	Attributes : name (String)
				 type (String)
	methods : wake : animal prints wake message
			  makeNoise : animal prints noise message
			  eat : animal prints eating message
			  roam : animal prints roaming message
			  sleep : animal prints sleeping message
			  getName : returns the name of the animal
			  getFullTitle : returns full animal title
	*/

	// ENCAPSULATION : This is an example of encapsulation because declaring these
	// variables private hides them from the inhereting subclasses.
	private String location;
	private String [] menu = new String[5];
	private String [] extras = new String[3];
	private Food [] inventory = new Food[5];
		
	public FoodStore(String givenLocation, String [] menuItems, String [] extraItems) {
		location = givenLocation;

		String [] noExtras = {};
		for (int i = 0; i < menuItems.length; i++){
			menu[i] = menuItems[i];
			inventory[i] = orderFactory(menuItems[i],noExtras, 30);
		}
		for (int i = 0; i < extraItems.length; i++){
			extras[i] = extraItems[i];
		}
	}

	// FACTORY PATTERN
	private Food orderFactory(String item, String [] extras, int quantity) {

		Food foodItem;

		if (item.equalsIgnoreCase("SPRING ROLL")){
			foodItem = new foods.rolls.SpringRoll(quantity);
		}
		else if (item.equalsIgnoreCase("EGG ROLL")){
			foodItem = new foods.rolls.EggRoll(quantity);	
		}
		else if (item.equalsIgnoreCase("PASTRY ROLL")){
			foodItem = new foods.rolls.PastryRoll(quantity);	
		}
		else if (item.equalsIgnoreCase("SAUSAGE ROLL")){
			foodItem = new foods.rolls.SausageRoll(quantity);	
		}
		else if (item.equalsIgnoreCase("JELLY ROLL")){
			foodItem = new foods.rolls.JellyRoll(quantity);	
		}
		else{
			return null;
		}

		for (int i = 0; i < extras.length; i++){
			if (extras[i].equalsIgnoreCase("SAUCE")){
				foodItem = new foods.decorators.condiments.Sauce(foodItem);
			}
			else if (extras[i].equalsIgnoreCase("TOPPING")){
				foodItem = new foods.decorators.condiments.Topping(foodItem);
			}
			else if (extras[i].equalsIgnoreCase("FILLING")){
				foodItem = new foods.decorators.condiments.Filling(foodItem);
			}
		}

		return foodItem;
	}

	public String[] getMenu() {
		return menu;
	}
}