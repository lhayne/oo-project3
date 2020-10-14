package behaviors;

import java.util.*;

public class PurchaseBehavior{
	/*
	This is a wake behavior that can be used by any animal

	STRATEGY Pattern:
		Removing this behavior from animal allows us to more easily modify the code later
		Some animals in our zoo don't want to wake up and instead enter a sleepy,
		half-conscious state.
	*/
	private String type;

	public PurchaseBehavior(String givenType){
		type = givenType;
	}
	public String [] purchase(String [] menu){

		Random r = new Random();

		if (type.equalsIgnoreCase("CASUAL")){
			int numberRolls = r.nextInt(3) + 1;
			String [] rolls = new String[numberRolls]; 
			for (int i = 0; i < numberRolls; i++){
				int rollIndex = r.nextInt(menu.length);
				rolls[i] = menu[rollIndex];
			}

			return rolls;
		}

		else if (type.equalsIgnoreCase("BUSINESS")){
			String [] rolls = new String[10]; 
			for (int i = 0; i < 10; i++){
				rolls[i] = menu[i % 5];
			}

			return rolls;
		}

		else if (type.equalsIgnoreCase("CATERING")){
			String [] rolls = new String[15];
			for (int j = 0; j < 3; j++){
				int rollIndex = r.nextInt(menu.length);
				for (int i = 0; i < 5; i++){
					rolls[5*j+i] = menu[rollIndex];
				}
			}

			return rolls;
		}

		String [] empty = {};
		return empty;
	}
}