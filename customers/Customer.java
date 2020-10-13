package customers;

import java.util.*;
import behaviors.PurchaseBehavior;

public class Customer {
	/*
	Customer class
	Attributes : name (String)
				 type (String)
	methods : arrive : prints arrive message
			  leave : prints leaving message
	*/

	String name;
	String type;
	behaviors.PurchaseBehavior performPurchase;

	public Customer(String givenName, String givenType, String purchaseMode){
		name = givenName;
		type = givenType;

		performPurchase = new behaviors.PurchaseBehavior(givenType, purchaseMode);
	}
	
	public void purchase(){
		performPurchase();
	}
}