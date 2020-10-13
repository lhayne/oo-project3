package foods.rolls;

import java.util.*;
import foods.Food;

public class EggRoll extends Food {

	public EggRoll(int quantity){
		description = "Egg Roll";
		this.quantity = quantity;
	}
	public double cost(){
		return 2.50;
	}
}