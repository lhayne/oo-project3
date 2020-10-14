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
import java.util.*;

public class myStore {
	// Starting point for program
	public static void main(String args[]){
		// Code for user input from https://www.javatpoint.com/how-to-take-string-input-in-java
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of days the Store should operate: ");
		int totalDays = Integer.parseInt(sc.nextLine());

		// //TEST 1
		// String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		// String[] extraItems = {"Sauce", "Topping", "Filling"};

		// FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);

		// String [] test = myStore.getMenu();
		// for (int i = 0; i < test.length; i++){
		// 	System.out.println(test[i]);
		// }


		// //TEST 2
		// String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		// CasualCustomer myCasualCustomer = new CasualCustomer("Customer1");

		// String [] test = myCasualCustomer.purchase(menuItems);
		// for (int i = 0; i < test.length; i++){
		// 	System.out.println(test[i]);
		// }


		// //TEST 3
		// String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		// BusinessCustomer myBusinessCustomer = new BusinessCustomer("Customer1");

		// String [] test = myBusinessCustomer.purchase(menuItems);
		// for (int i = 0; i < test.length; i++){
		// 	System.out.println(test[i]);
		// }


		// //TEST 4
		// String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		// CateringCustomer myCateringCustomer = new CateringCustomer("Customer1");

		// String [] test = myCateringCustomer.purchase(menuItems);
		// for (int i = 0; i < test.length; i++){
		// 	System.out.println(test[i]);
		// }


		// //TEST 5
		// CustomerFactory myCustomerFactory = new CustomerFactory();
		// Customer [] customerList = myCustomerFactory.generateCustomerList();
		// for (int i = 0; i < customerList.length; i++){
		// 	System.out.println(customerList[i].getType());
		// 	// String [] order = customerList[i].purchase();
		// 	// myStore.placeOrder(order, customerList[i].getCustomerType());
		// }	

		// //TEST 6
		// CustomerFactory myCustomerFactory = new CustomerFactory();
		// Customer [] customerList = myCustomerFactory.generateCustomerList();
		// String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};

		// for (int i = 0; i < customerList.length; i++){
		// 	System.out.println(customerList[i].getType());
		// 	String [] order = customerList[i].purchase(menuItems);
			
		// 	for (int j = 0; j < order.length; j++){
		// 		System.out.println(order[j]);
		// 	}
		// 	// myStore.placeOrder(order, customerList[i].getCustomerType());
		// }	


		// //TEST 6
		// String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		// String[] extraItems = {"Sauce", "Topping", "Filling"};
		// FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);
		// CustomerFactory myCustomerFactory = new CustomerFactory();
		// Customer c = new CasualCustomer();
		// String [] order = c.purchase(menuItems);
		// myStore.placeOrder(order, c.getType());
		// System.out.println(myStore.getRevenueByCustomerType("Casual"));

		// //TEST 7
		// String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		// String[] extraItems = {"Sauce", "Topping", "Filling"};
		// FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);
		// CustomerFactory myCustomerFactory = new CustomerFactory();
		// Customer [] customerList = myCustomerFactory.generateCustomerList();

		// for (int i = 0; i < customerList.length; i++){
		// 	System.out.println(customerList[i].getType());
		// 	String [] order = customerList[i].purchase(menuItems);
			
		// 	for (int j = 0; j < order.length; j++){
		// 		System.out.println(order[j]);
		// 	}

		// 	myStore.placeOrder(order, customerList[i].getType());
		// }

		// System.out.println(myStore.getRevenueByCustomerType("Casual"));	

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
