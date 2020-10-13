package clocks;
import java.util.Observable;

/*
OBSERVER PATTERN : 	Here the ZooClock is observable by everyone
					at the zoo and updates them with the time
					so that they can perform their chores.
*/

public class ZooClock extends Observable{
	public int time;

	public ZooClock(){
		time = 8;
	}
	public void setValue(int newTime){
		this.time = newTime;
		setChanged();
		notifyObservers();
	}  
	public int getValue(){ 
		return time; 
	}
	public void dayAtTheZoo(){
		for (int i = 8; i < 21; i++){
			if (i < 13){
				System.out.println(Integer.toString(i) + "AM");
			}
			else {
				System.out.println(Integer.toString(i - 12) + "PM");
			}
			setValue(i);
		}
	}
}