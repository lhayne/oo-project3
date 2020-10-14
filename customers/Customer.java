package customers;

import java.util.*;
import behaviors.PurchaseBehavior;

//STRATEGY PATTERN : Here we've delegated the purchasing behavior to another
// class through the strategy pattern.
public class Customer {
	/*
	Customer class
	Attributes : type (String)
				 performPurchase (PurchaseBehavior)
	methods : purchase : purchase items
			  getType : returns customer type
	*/
	String type;
	behaviors.PurchaseBehavior performPurchase;

	public Customer(String givenType){
		type = givenType;

		performPurchase = new behaviors.PurchaseBehavior(givenType);
	}
	
	public String [] purchase(String [] menu){
		return performPurchase.purchase(menu);
	}

	public String getType(){
		return type;
	}
}