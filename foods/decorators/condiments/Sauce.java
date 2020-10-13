package foods.decorators.condiments;

import java.util.*;
import foods.decorators.CondimentDecorator;
import foods.Food;

public class Sauce extends CondimentDecorator {

	Food food;

	public Sauce(Food food){
		this.food = food;
	}
	public String getDescription(){
		return food.getDescription() + " with extra sauce";
	}
	public double cost(){
		return food.cost() + 0.50;
	}
}