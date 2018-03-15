package entities;

import Stable.IStable_Horse;
import Paddock.IPaddock_Horse;
import RacingTrack.IRacingTrack_Horse;

public class HorseThread extends Thread{
	private int maxUnits;
	private final int id;
	private final int moves;
	private final Stable.IStable_Horse mon_stable;
	private final Paddock.IPaddock_Horse mon_paddock;
	private final RacingTrack.IRacingTrack_Horse mon_track;
	
	
	public HorseThread(int id){
		this.id = id;
		this.maxUnits = (int) Math.random();
		this.moves = 0;
		this.mon_stable = new Stable.StableMonitor();
		this.mon_paddock = new Paddock.PaddockMonitor();
		this.mon_track = new RacingTrack.RacingTrackMonitor();
	}
	@Override
	void run(){
		proceedToStable()
		proceedToPaddock();
		proceedToStartLine();
		do{
			makeMove()
		}while(!hasFinishLineBeenCrossed())
		proceedToStable()
	}
}
