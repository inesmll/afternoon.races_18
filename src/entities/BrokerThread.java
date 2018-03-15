package entities;

import Stable.IStable_Broker;
import Paddock.IPaddock_Broker;
import RacingTrack.IRacingTrack_Broker;
import WatchingStand.IWatchingStand_Broker;

public class BrokerThread extends Thread{
	private final int id;
	private final Stable.IStable_Broker mon_stable;
	private final Paddock.IPaddock_Broker mon_paddock;
	private final RacingTrack.IRacingTrack_Broker mon_track;
	private final WatchingStand.IWatchingStand_Broker mon_wc;

	public BrokerThread(int id) {
		this.id = id;
		this.mon_stable = new Stable.StableMonitor();
		this.mon_paddock = new Paddock.PaddockMonitor();
		this.mon_track = new RacingTrack.RacingTrackMonitor();
		this.mon_wc = new WatchingStand.WatchingStandMonitor();
	}

	@Override
	//draft
	public void run(){
	//R is the number of races
	//k is the current race
		for(int k=0;k < R;k++){
			summonHorsesToPaddock();
			acceptBets();
			startRace();
			reportResults();
			if(areThereAnyWinners()) honourBets();
		}
		entertainTheGuests();

	}
}
