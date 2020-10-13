package foods.rolls;

import java.util.*;
import foods.Food;

public class SausageRoll extends Food {

	public SausageRoll(int quantity){
		description = "Sausage Roll";
		this.quantity = quantity;
	}
	public double cost(){
		return 8;
	}
}