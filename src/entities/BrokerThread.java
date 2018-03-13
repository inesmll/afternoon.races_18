package entities;

import Stable.IStable_Broker;
import Paddock.IPaddock_Broker;
import RacingTrack.IRacingTrack_Broker;

public class BrokerThread extends Thread{
	private final Stable.IStable_Broker mon_stable;
	private final Paddock.IPaddock_Broker mon_paddock;
	private final RacingTrack.IRacingTrack_Broker mon_track;
	
	public BrokerThread(){
		this.mon_stable = new Stable.StableMonitor();
		this.mon_paddock = new Paddock.PaddockMonitor();
		this.mon_track = new RacingTrack.RacingTrackMonitor();
	}
}
