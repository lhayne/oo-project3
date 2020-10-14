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