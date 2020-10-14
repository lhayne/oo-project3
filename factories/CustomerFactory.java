package factories;

import customers.casuals.CasualCustomer;
import customers.businesses.BusinessCustomer;
import customers.caterers.CateringCustomer;
import customers.Customer;
import behaviors.PurchaseBehavior;
import java.util.*;


//FACTORY PATTERN : Creates customers using a factory design.
public class CustomerFactory {
	public CustomerFactory(){

	}
	public Customer [] generateCustomerList(){
		Random r = new Random();

		int numberCasuals = r.nextInt(12)+1;
		int numberBusinesses = r.nextInt(3)+1;
		int numberCaterers = r.nextInt(3)+1;

		Customer [] customers = new Customer[numberCasuals + numberBusinesses + numberCaterers];

		for (int e = 0; e < customers.length; e++){
			if (e < numberCasuals){
				customers[e] = new CasualCustomer();	
			}
			else if (e >= numberCasuals && e < (numberCasuals + numberBusinesses)){
				customers[e] = new BusinessCustomer();
			}
			else{
				customers[e] = new CateringCustomer();
			}
		}

		return customers;
	}	
}
