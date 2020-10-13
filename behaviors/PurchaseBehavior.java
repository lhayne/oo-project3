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
	private String name;
	private String type;
	private Boolean fullAwake;

	public WakeBehavior(String givenName, String givenType, Boolean mode){
		name = givenName;
		type = givenType;
		fullAwake = mode;
	}
	public void wake(){
		if (fullAwake){
			System.out.println(name + " the " + type + " wakes up.");
		}
		else {
			System.out.println(name + " the " + type + " sleepily wakes up and enters a sleepy state.");
		}
	}
}