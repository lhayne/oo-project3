package customers.businesses;

import java.util.*;
import behaviors.PurchaseBehavior;
import customers.Customer;

public class BusinessCustomer extends Customer {
	/*
	Customer class
	Attributes : name (String)
				 type (String)
	methods : arrive : prints arrive message
			  leave : prints leaving message
	*/
	public BusinessCustomer(){
		super("Business");
	}
}