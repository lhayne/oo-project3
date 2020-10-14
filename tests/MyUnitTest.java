package tests;

import org.junit.Test;
import static org.junit.Assert.*;
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

//Testing outline courtesy of 
//http://tutorials.jenkov.com/java-unit-testing/simple-test.html

public class MyUnitTest {

	@Test
	public void testMenu() {
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		String[] extraItems = {"Sauce", "Topping", "Filling"};
		
		FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);

		String [] test = myStore.getMenu();

		for (int i = 0; i < test.length; i++){
			assertEquals(test[i], menuItems[i]);
		}
	}

	@Test
	public void testCasualCustomer() {
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		CasualCustomer myCasualCustomer = new CasualCustomer();

		String [] test = myCasualCustomer.purchase(menuItems);
		assertTrue(test.length < 4);
	}

	@Test
	public void testBusinessCustomer() {
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		BusinessCustomer myBusinessCustomer = new BusinessCustomer();

		String [] test = myBusinessCustomer.purchase(menuItems);
		assertTrue(test.length == 10);
	}

	@Test
	public void testCateringCustomer() {
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		CateringCustomer myCateringCustomer = new CateringCustomer();

		String [] test = myCateringCustomer.purchase(menuItems);
		assertTrue(test.length == 15);
	}

	@Test
	public void testCustomerFactory1() {
		CustomerFactory myCustomerFactory = new CustomerFactory();
		Customer [] customerList = myCustomerFactory.generateCustomerList();

		int numCasuals = 0;
		for (int i = 0; i < customerList.length; i++){
			if (customerList[i].getType().equalsIgnoreCase("CASUAL")){
				numCasuals = numCasuals + 1;
			}
		}
		assertTrue(numCasuals <= 12);
	}	

	@Test
	public void testCustomerFactory2() {
		CustomerFactory myCustomerFactory = new CustomerFactory();
		Customer [] customerList = myCustomerFactory.generateCustomerList();

		int numBusinesses = 0;
		for (int i = 0; i < customerList.length; i++){
			if (customerList[i].getType().equalsIgnoreCase("BUSINESS")){
				numBusinesses = numBusinesses + 1;
			}
		}
		assertTrue(numBusinesses <= 3);
	}	

	@Test
	public void testCustomerFactory3() {
		CustomerFactory myCustomerFactory = new CustomerFactory();
		Customer [] customerList = myCustomerFactory.generateCustomerList();

		int numCaterers = 0;
		for (int i = 0; i < customerList.length; i++){
			if (customerList[i].getType().equalsIgnoreCase("CATERING")){
				numCaterers = numCaterers + 1;
			}
		}
		assertTrue(numCaterers <= 3);
	}

	@Test
	public void testPlaceOrder() {
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		String[] extraItems = {"Sauce", "Topping", "Filling"};
		FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);
		Customer c = new CasualCustomer();
		String [] order = c.purchase(menuItems);
		myStore.placeOrder(order, c.getType());
		assertTrue(myStore.getRevenueByCustomerType("Casual") > 0);
	}	

	@Test
	public void testInventoryLeft() {
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		String[] extraItems = {"Sauce", "Topping", "Filling"};
		FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);

		assertTrue(myStore.inventoryLeft());
	}		

	@Test
	public void testInventoryDecrement() {
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		String[] extraItems = {"Sauce", "Topping", "Filling"};
		FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);

		String [] order = {"Jelly Roll"};
		myStore.placeOrder(order, "Casual");
		System.out.println(myStore.getRollCount("Jelly Roll"));
		assertTrue(myStore.getRollCount("Jelly Roll") != 30);
	}
}