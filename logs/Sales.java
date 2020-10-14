package logs;
import java.util.*;
import foods.Food;

// Sales class tracks the sales of rolls at store.
public class Sales {
	public Vector<String> customers = new Vector<String>(5);
	public Vector<Food> sales = new Vector<Food>(5);
	public Vector<Integer> days = new Vector<Integer>(5);

	public Sales(){
		
	}
	public void addOrder(Food order, String customer, int day){
		this.customers.add(customer);
		this.sales.add(order);
		this.days.add(day);
	}  
	public double getTotalRevenue(){ 
		double total = 0;
		for (int i = 0; i < sales.size(); i++){
			total = total + sales.get(i).cost();
		}
		return total;
	}
	public double getRevenueByCustomerType(String customerType){ 
		double total = 0;
		for (int i = 0; i < sales.size(); i++){
			if (customers.get(i).equalsIgnoreCase(customerType)){
				total = total + sales.get(i).cost();
			}
		}
		return total;
	}
	public double getRevenueByCustomerTypeAndDay(String customerType, int day){ 
		double total = 0;
		for (int i = 0; i < sales.size(); i++){
			if (customers.get(i).equalsIgnoreCase(customerType) && (days.get(i) == day)){
				total = total + sales.get(i).cost();
			}
		}
		return total;
	}
	public double getRevenueByFoodType(String foodType){ 
		double total = 0;
		for (int i = 0; i < sales.size(); i++){
			String rollOrdered = sales.get(i).getDescription().substring(0, sales.get(i).getDescription().indexOf(' '));
			String rollType = foodType.substring(0, foodType.indexOf(' '));

			if (rollOrdered.equalsIgnoreCase(rollType)){
				total = total + sales.get(i).cost();
			}
		}
		return total;
	}
	public int totalSoldByType(String foodType){ 
		int total = 0;
		for (int i = 0; i < sales.size(); i++){
			String rollOrdered = sales.get(i).getDescription().substring(0, sales.get(i).getDescription().indexOf(' '));
			String rollType = foodType.substring(0, foodType.indexOf(' '));

			if (rollOrdered.equalsIgnoreCase(rollType)){
				total = total + 1;
			}
		}
		return total;
	}
	public int totalSold(){ 
		return sales.size();
	}
	public void printSales(){
		for (int i = 0; i < sales.size(); i++){
			System.out.println(customers.get(i) + " bought " + sales.get(i).getDescription() + " for " + sales.get(i).cost());
		}
	}

	public void printSalesByDay(int day){
		for (int i = 0; i < sales.size(); i++){
			if (days.get(i) == day){
				System.out.println(customers.get(i) + " bought " + sales.get(i).getDescription() + " for " + sales.get(i).cost());	
			}
		}
	}
}