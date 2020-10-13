package employees.servers;

import employees.ZooEmployee;
import java.util.Observable;
import java.util.Observer;
import clocks.ZooClock;

public class ZooFoodServer extends Observable implements ZooEmployee, Observer {
	private String currentTask;
	private String name;
	private String type;
	private int day;
	private ZooClock clock;

	public ZooFoodServer(String givenName, ZooClock newClock) {
		name = givenName;
		type = "ZooFoodServer";
		day = 1;
		clock = newClock;
		clock.addObserver(this);
	}

	// OBSERVER FUNCTIONS:
	// Courtesy of Lecture 12 Slides and 
	// https://www.infoworld.com/article/2077258/observer-and-observable.html
	public void setValue(String task){
		this.currentTask = task;
		setChanged();
		notifyObservers();
	}  
	public String getValue(){ 
		return currentTask; 
	}

	public void update(Observable obs, Object obj)
	{
		if (obs == clock)
		{
			dailyChores(clock.getValue());
		}
	}

	public void arrive(){
		System.out.println(type + " " + name + " arrives on Day " + Integer.toString(day));
	}
	public void leave(){
		System.out.println(type + " " + name + " leaves on Day " + Integer.toString(day));
		day = day + 1;
	}
	public void makeFood(){
		System.out.println(type + " " + name + " is making food.");
	}
	public void serveFood(String meal){
		setValue("serving " + meal);
		System.out.println(type + " " + name + " is serving " + meal + ".");
	}
	public void clean(){
		System.out.println(type + " " + name + " is cleaning.");
	}

	public void dailyChores(int time){
		switch(time){
			case 8:
				arrive();
				break;
			case 10:
				makeFood();
				break;
			case 12:
				serveFood("Lunch");
				break;
			case 13:
				clean();
				break;
			case 16:
				makeFood();
				break;
			case 17:
				serveFood("Dinner");
				break;
			case 18:
				clean();
				break;
			case 20:
				leave();
				break;
		}
	}
}