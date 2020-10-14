package stores;

import java.util.*;
import foods.rolls.*;
import foods.decorators.condiments.*;
import foods.Food;
import logs.Sales;
import logs.Outages;

public class FoodStore {
	/*
	FoodStore class
	Attributes : name (String)
				 type (String)
	methods : orderFactory : makes food orders
			  getMenu : returns list of menu items
			  getRollCount : returns the number of rolls left with specific name
			  placeOrder : places customer order from list of wants
			  recordOrder : records the sale of an order
			  decrementInventory : subtracts order from inventory
			  recordSale : adds to salebook
			  getRevenueByCustomerType : returns revenue by customer type
			  restock : restocks empty rolls
			  inventoryLeft : checks to see what inventory is left
			  printDailyResults : prints daily results
			  printFinalResults : prints final results
	*/

	// ENCAPSULATION : This is an example of encapsulation because declaring these
	// variables private hides them from the inhereting subclasses.
	private String location;
	private String [] menu = new String[5];
	private String [] extras = new String[3];
	private Food [] inventory = new Food[5];
	private Sales salesBook;
	private Outages outageBook;
	private int day;
		
	public FoodStore(String givenLocation, String [] menuItems, String [] extraItems) {
		location = givenLocation;
		salesBook = new Sales();
		outageBook = new Outages();

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


	public int getRollCount(String rollName){
		for (int i = 0; i < inventory.length; i++){
			if (inventory[i].getDescription().equalsIgnoreCase(rollName)){
				return inventory[i].getQuantity();
			}
		}
		return 0;
	}

	public void placeOrder(String [] items, String customerType){

		// If there are rolls left
		if (inventoryLeft()){
			// Check inventory
			for (int i = 0; i < items.length; i++){
				//Roll out
				if (getRollCount(items[i]) == 0){
					//add to daily roll outage tally
					outageBook.addOutage(items[i],customerType,day);


					if (customerType.equalsIgnoreCase("CASUAL") || customerType.equalsIgnoreCase("CATERING")){
						Boolean replaced = false;
						for (int j = 0; j < menu.length; j++){
							if (getRollCount(menu[j]) != 0){
								items[i] = menu[j];
								replaced = true;
							}
						}
						if (replaced == false){
							items[i] = "NONE";
						}
					}

					else if (customerType.equalsIgnoreCase("BUSINESS")){
						// NO ORDER PLACED
						for (int j = 0; j < menu.length; j++){
							items[j] = "NONE";
						}
						break;
					}
				}

				if (!(items[i].equalsIgnoreCase("NONE"))){
					decrementInventory(items[i]);	
				}
			}

			recordOrder(items, customerType);			
		}
	}


	public void recordOrder(String [] items, String customerType){
		
		Random r = new Random();

		for (int i = 0; i < items.length; i++){
			int numberSauces = r.nextInt(4);
			int numberFillings = r.nextInt(2);
			int numberToppings = r.nextInt(3);
			String [] extras = new String[numberSauces + numberFillings + numberToppings];

			//add EXTRAS
			for (int e = 0; e < extras.length; e++){
				if (e < numberSauces){
					extras[e] = "SAUCE";	
				}
				else if (e >= numberSauces && e < (numberSauces + numberFillings)){
					extras[e] = "FILLING";
				}
				else{
					extras[e] = "TOPPING";
				}
			}

			if (!(items[i].equalsIgnoreCase("NONE"))){
				Food orderedItem = orderFactory(items[i], extras, 1);
				recordSale(orderedItem, customerType);
			}
			
		}
	}

	public void decrementInventory(String rollType){
		for (int j = 0; j < inventory.length; j++){
			if (inventory[j].getDescription().equalsIgnoreCase(rollType)){
				inventory[j].decrementQuantity();
			}
		}
	}

	public void recordSale(Food item, String customerType){
		salesBook.addOrder(item, customerType, day);
	}

	public double getRevenueByCustomerType(String customerType){
		return salesBook.getRevenueByCustomerType(customerType);
	}

	public void restock(){
		for (int i = 0; i < inventory.length; i++){
			if (inventory[i].getQuantity() == 0){
				inventory[i].setQuantity(30);
			}
		}
	}

	public void setDay(int day){
		this.day = day;
	}

	public Boolean inventoryLeft(){
		Boolean out = true;
		for (int i = 0; i < inventory.length; i++){
			if (inventory[i].getQuantity() != 0){
				out = false;
			}
		}
		return !(out);
	}

	public void printDailyResults(){
		System.out.println("Day " + Integer.toString(day));
		System.out.println("Rolls at Finish ");
		for (int i = 0; i < inventory.length; i++){
			System.out.println(inventory[i].getDescription() + " " + Integer.toString(inventory[i].getQuantity()));
		}
		salesBook.printSalesByDay(day);
		System.out.println("Total payment by Casual Customers " + salesBook.getRevenueByCustomerTypeAndDay("Casual",day));
		System.out.println("Total payment by Business Customers " + salesBook.getRevenueByCustomerTypeAndDay("Business",day));
		System.out.println("Total payment by Catering Customers " + salesBook.getRevenueByCustomerTypeAndDay("Catering",day));
		System.out.println("Total Casual rolls affected by outages " + outageBook.getOutagesByCustomerTypeAndDay("Casual",day));
		System.out.println("Total Business rolls affected by outages " + outageBook.getOutagesByCustomerTypeAndDay("Business",day));
		System.out.println("Total Catering rolls affected by outages " + outageBook.getOutagesByCustomerTypeAndDay("Catering",day));
		if (!(inventoryLeft())){
			System.out.println("Store closed today for inventory outage.");
		}
		System.out.println("\n");
	}

	public void printFinalResults(){
		System.out.println("Total Rolls Sold: " + Integer.toString(salesBook.totalSold()));
		System.out.println("Rolls sold by type: ");
		for (int i = 0; i < inventory.length; i++){
			System.out.println(inventory[i].getDescription() + " : " + Integer.toString(salesBook.totalSoldByType(inventory[i].getDescription())));
		}
		System.out.println("Outage impacts (total rolls) : " + outageBook.getTotalOutages());
	}
}




