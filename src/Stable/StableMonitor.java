package Stable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class StableMonitor implements IStable_Horse, IStable_Broker{
	private final ReentrantLock r;
	private final Condition h;
	private final Condition b;
	
	public StableMonitor(){
		this.r = new ReentrantLock();
		this.h = r.newCondition();
		this.b = r.newCondition();
	}

	
	// Horses blocked waiting for broker
	public void proceedToStable() {
		r.lock();
		try{
			try{
				while(true){
					h.wait();
					break;
				}
			}catch (Exception ec){}
		}finally{
			r.unlock();
		}
	}

	public void summonHorsesToPaddock() {
		r.lock();
		try{
			h.signalAll();
		}finally{
			r.unlock();
		}
	}

	public void entertainTheGuests() {
		
	}
}
