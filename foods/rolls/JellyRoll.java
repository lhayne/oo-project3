package foods.rolls;

import java.util.*;
import foods.Food;

public class JellyRoll extends Food {

	public JellyRoll(int quantity){
		description = "Jelly Roll";
		this.quantity = quantity;
	}
	public double cost(){
		return 4;
	}
}