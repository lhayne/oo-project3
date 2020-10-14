import stores.FoodStore;
import customers.casuals.CasualCustomer;
import customers.businesses.BusinessCustomer;
import customers.caterers.CateringCustomer;
import customers.Customer;
import behaviors.PurchaseBehavior;
import factories.CustomerFactory;
import foods.rolls.SpringRoll;
import foods.rolls.EggRoll;
import foods.rolls.JellyRoll;
import foods.rolls.SausageRoll;
import foods.rolls.PastryRoll;
import foods.decorators.condiments.Sauce;
import foods.decorators.condiments.Topping;
import foods.decorators.condiments.Filling;
import logs.Sales;
import logs.Outages;
import tests.MyUnitTest;
import java.util.*;

public class myStore {
	// Starting point for program
	public static void main(String args[]){

		// TESTS
		MyUnitTest test = new MyUnitTest();
		test.testMenu();
		test.testCasualCustomer();
		test.testBusinessCustomer();
		test.testCateringCustomer();
		test.testCustomerFactory1();
		test.testCustomerFactory2();
		test.testCustomerFactory3();
		test.testPlaceOrder();
		test.testInventoryLeft();	
		test.testInventoryDecrement();

		// Code for user input from https://www.javatpoint.com/how-to-take-string-input-in-java
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of days the Store should operate: ");
		int totalDays = Integer.parseInt(sc.nextLine());

		//MAIN LOOP
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		String[] extraItems = {"Sauce", "Topping", "Filling"};
		FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);
		CustomerFactory myCustomerFactory = new CustomerFactory();

		for (int d = 0; d < totalDays; d++){
			//Restock and set day
			myStore.restock();
			myStore.setDay(d);

			//Generate customer list
			Customer [] customerList = myCustomerFactory.generateCustomerList();

			//Purchases from each customer
			for (int i = 0; i < customerList.length; i++){
				String [] order = customerList[i].purchase(menuItems);
				myStore.placeOrder(order, customerList[i].getType());
			}

			//Print results
			myStore.printDailyResults();
		}

		myStore.printFinalResults();
	}	
}
