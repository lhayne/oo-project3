package logs;
import java.util.*;

// Outages class tracks the outages for each roll
public class Outages {
	public Vector<String> customers = new Vector<String>(5);
	public Vector<String> rolls = new Vector<String>(5);
	public Vector<Integer> days = new Vector<Integer>(5);

	public Outages(){
		
	}
	public void addOutage(String roll, String customer, int day){
		this.customers.add(customer);
		this.rolls.add(roll);
		this.days.add(day);
	}  
	public double getTotalOutages(){ 
		return customers.size();
	}
	public double getOutagesByCustomerType(String customerType){ 
		int total = 0;
		for (int i = 0; i < customers.size(); i++){
			if (customers.get(i).equalsIgnoreCase(customerType)){
				total = total + 1;
			}
		}
		return total;
	}
	public double getOutagesByCustomerTypeAndDay(String customerType, int day){ 
		int total = 0;
		for (int i = 0; i < customers.size(); i++){
			if (customers.get(i).equalsIgnoreCase(customerType) && days.get(i) == day){
				total = total + 1;
			}
		}
		return total;
	}
	public double getOutagesByDay(int day){ 
		int total = 0;
		for (int i = 0; i < days.size(); i++){
			if (days.get(i) == day){
				total = total + 1;
			}
		}
		return total;
	}
}