package foods;

import java.util.*;

public abstract class Food {
	/*
	Customer class
	Attributes : name (String)
				 type (String)
	methods : arrive : prints arrive message
			  leave : prints leaving message
	*/

	public String description = "Unknown description";
	public int quantity;
	
	public String getDescription(){
		return description;
	}
	public int getQuantity(){
		return quantity;
	}
	public void decrementQuantity(){
		quantity = quantity - 1;
	}
	public void setQuantity(int value){
		quantity = value;
	}

	public abstract double cost();
}