package customers.casuals;

import java.util.*;
import behaviors.PurchaseBehavior;
import customers.Customer;

public class CasualCustomer extends Customer {
	/*
	Customer class
	Attributes : name (String)
				 type (String)
	methods : arrive : prints arrive message
			  leave : prints leaving message
	*/
	public CasualCustomer(){
		super("Casual");
	}
}