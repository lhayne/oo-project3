package foods.decorators.condiments;

import java.util.*;
import foods.decorators.CondimentDecorator;
import foods.Food;

public class Filling extends CondimentDecorator {

	Food food;

	public Filling(Food food){
		this.food = food;
	}
	public String getDescription(){
		return food.getDescription() + " with extra filling";
	}
	public double cost(){
		return food.cost() + 2.00;
	}
}