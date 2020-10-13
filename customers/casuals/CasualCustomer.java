package employees.announcers;

import employees.ZooEmployee;
import employees.keepers.Zookeeper;
import employees.servers.ZooFoodServer;
import clocks.ZooClock;
import java.util.Observer;
import java.util.Observable;

/*
OBSERVER PATTERN : 	Here the Zookeeper becomes observable by the 
					ZooAnnouncer observer. At the start of each day,
					the ZooAnnouncer observes the ZooKeeper. When the
					ZooKeeper starts a new task, the ZooAnnouncer gets
					updated and announces the change. At the end of the
					day, the ZooAnnouncer stops observing.
*/
public class ZooAnnouncer implements ZooEmployee, Observer {

	private Zookeeper keeper;
	public String name;
	public String type;
	public int day;
	private ZooClock clock;
	private ZooFoodServer server;

	public ZooAnnouncer(String givenName, Zookeeper givenKeeper, ZooClock newClock, ZooFoodServer newServer) {
		name = givenName;
		type = "ZooAnnouncer";
		day = 1;
		keeper = givenKeeper;
		clock = newClock;
		clock.addObserver(this);
		server = newServer;
	}
	public void arrive(){
		System.out.println(type + " " + name + " arrives on Day " + Integer.toString(day));
		keeper.addObserver(this);
		server.addObserver(this);
	}
	public void leave(){
		System.out.println(type + " " + name + " leaves on Day " + Integer.toString(day));
		keeper.deleteObserver(this);
		server.addObserver(this);
		day = day + 1;
	}
	public void update(Observable obs, Object obj)
	{
		if (obs == keeper)
		{
			System.out.println("Hi, this is the Zoo Announcer. The ZooKeeper is about to " + 
								keeper.getValue() + ".");
		}
		else if (obs == clock){
			dailyChores(clock.getValue());
		}
		else if (obs == server){
			System.out.println("Hi, this is the Zoo Announcer. The ZooFoodServer is " + 
								server.getValue() + ".");
		}
	}
	public void dailyChores(int time){
		switch(time){
			case 8:
				arrive();
				break;
			case 20:
				leave();
				break;
		}
	}
}