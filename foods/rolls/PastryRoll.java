package foods.rolls;

import java.util.*;
import foods.Food;

public class PastryRoll extends Food {

	public PastryRoll(int quantity){
		description = "Pastry Roll";
		this.quantity = quantity;
	}
	public double cost(){
		return 3;
	}
}