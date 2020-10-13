package employees.keepers;

import employees.ZooEmployee;
import animals.*;
import java.util.Observable;
import java.util.Observer;
import clocks.ZooClock;

/*
OBSERVER PATTERN : 	Here the Zookeeper becomes observable by the 
					ZooAnnouncer observer. At the start of each day,
					the ZooAnnouncer observes the ZooKeeper. When the
					ZooKeeper starts a new task, the ZooAnnouncer gets
					updated and announces the change. At the end of the
					day, the ZooAnnouncer stops observing. The ZooKeeper
					also observes the clock throughout the day as all dilligent
					hard working folks do.
*/
public class Zookeeper extends Observable implements ZooEmployee, Observer {

	private String currentTask;
	private String name;
	private String type;
	private int day;
	private ZooClock clock;
	private Animal [] zoo;

	public Zookeeper(String givenName, Animal [] newZoo, ZooClock newClock) {
		name = givenName;
		type = "Zookeeper";
		day = 1;
		zoo = newZoo;
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
	public void wakeAnimals(){
		setValue("wake animals");
		for (int i = 0; i < zoo.length; i++){
			System.out.println(type + " " + name + " wakes " + zoo[i].getFullTitle());
			zoo[i].wake();
		}
	}
	public void rollCallAnimals(){
		setValue("roll call animals");
		for (int i = 0; i < zoo.length; i++){
			System.out.println(type + " " + name + " calls out for " + zoo[i].getFullTitle());
			zoo[i].makeNoise();
		}
	}
	public void feedAnimals(){
		setValue("feed animals");
		for (int i = 0; i < zoo.length; i++){
			System.out.println(type + " " + name + " feeds " + zoo[i].getFullTitle());
			zoo[i].eat();
		}
	}
	public void exerciseAnimals(){
		setValue("exercise animals");
		for (int i = 0; i < zoo.length; i++){
			System.out.println(type + " " + name + " exercises " + zoo[i].getFullTitle());
			zoo[i].roam();
		}
	}
	public void sleepAnimals(){
		setValue("put animals to sleep");
		for (int i = 0; i < zoo.length; i++){
			System.out.println(type + " " + name + " sleeps " + zoo[i].getFullTitle());
			zoo[i].sleep();
		}
	}
	public void dailyChores(int time){
		switch(time){
			case 8:
				arrive();
				break;
			case 9:
				wakeAnimals();
				break;
			case 10:
				rollCallAnimals();
				break;
			case 12:
				feedAnimals();
				break;
			case 17:
				exerciseAnimals();
				break;
			case 19:
				sleepAnimals();
				break;
			case 20:
				leave();
				break;
		}
	}
}