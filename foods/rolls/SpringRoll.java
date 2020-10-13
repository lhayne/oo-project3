package foods.rolls;

import java.util.*;
import foods.Food;

public class SpringRoll extends Food {

	public SpringRoll(int quantity){
		description = "Spring Roll";
		this.quantity = quantity;
	}
	public double cost(){
		return 2;
	}
}