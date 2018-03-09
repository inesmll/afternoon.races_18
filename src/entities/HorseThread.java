package entities;

import Stable.IStable_Horse;
import Paddock.IPaddock_Horse;

public class HorseThread extends Thread{
	private int race;
	private int maxUnits;
	private final int id;
	private final Stable.IStable_Horse mon_stable;
	private final Paddock.IPaddock_Horse mon_paddock;
	
	
	public HorseThread(int id){
		this.id = id;
		this.maxUnits = (int) Math.random();
		this.mon_stable = new Stable.StableMonitor();
		this.mon_paddock = new Paddock.PaddockMonitor();
	}
}
