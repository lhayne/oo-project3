package foods.decorators.condiments;

import java.util.*;
import foods.decorators.CondimentDecorator;
import foods.Food;

public class Topping extends CondimentDecorator {

	Food food;

	public Topping(Food food){
		this.food = food;
	}
	public String getDescription(){
		return food.getDescription() + " with extra topping";
	}
	public double cost(){
		return food.cost() + 1.50;
	}
}