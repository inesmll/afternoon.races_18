package entities;

import Stable.IStable_Broker;
import Paddock.IPaddock_Broker;

public class BrokerThread extends Thread{
	private final Stable.IStable_Broker mon_stable;
	private final Paddock.IPaddock_Broker mon_paddock;
	
	public BrokerThread(){
		this.mon_stable = new Stable.StableMonitor();
		this.mon_paddock = new Paddock.PaddockMonitor();
	}
}
