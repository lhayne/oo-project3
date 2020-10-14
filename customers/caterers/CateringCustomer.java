package customers.caterers;

import java.util.*;
import behaviors.PurchaseBehavior;
import customers.Customer;

public class CateringCustomer extends Customer {
	/*
	Customer class
	Attributes : name (String)
				 type (String)
	methods : arrive : prints arrive message
			  leave : prints leaving message
	*/
	public CateringCustomer(){
		super("Catering");
	}
}