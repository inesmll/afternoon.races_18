package entities;

import Paddock.IPaddock_Broker;
import WatchingStand.IWatchingStand_Broker;

public class SpectatorThread extends Thread{
	private final int id;
	private final Stable.IStable_Broker mon_stable;
	private final Paddock.IPaddock_Broker mon_paddock;
	private final WatchingStand.IWatchingStand_Broker mon_wc;

	public SpectatorThread(int id) {
		this.id = id;
		this.mon_stable = new Stable.StableMonitor();
		this.mon_paddock = new Paddock.PaddockMonitor();
		this.mon_wc = new WatchingStand.WatchingStandMonitor();
	}
}
