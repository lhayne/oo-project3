import stores.FoodStore;
import java.util.*;

public class myStore {

	// Starting point for program
	public static void main(String args[]){
		// Code for user input from https://www.javatpoint.com/how-to-take-string-input-in-java
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of days the Store should operate: ");
		int totalDays = Integer.parseInt(sc.nextLine());

		// POLYMORPHISM : This is an example of polymorphism because all of these
		// specific animals can be referred to as superclass Animals.
		String[] menuItems = {"Spring Roll", "Jelly Roll", "Sausage Roll", "Egg Roll", "Pastry Roll"};
		String[] extraItems = {"Sauce", "Topping", "Filling"};

		FoodStore myStore = new FoodStore("Boulder", menuItems, extraItems);

		String [] test = myStore.getMenu();
		for (int i = 0; i < test.length; i++){
			System.out.println(test[i]);
		}
	}	
}
