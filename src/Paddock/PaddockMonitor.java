package Paddock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PaddockMonitor implements IPaddock_Broker,IPaddock_Horse,IPaddock_Spectator{
	private final ReentrantLock r;
	private final Condition h;
	private final Condition b;
	private final Condition s;
	private int inc = 0;
	
	public PaddockMonitor(){
		this.r = new ReentrantLock();
		this.h = r.newCondition();
		this.b = r.newCondition();
		this.s = r.newCondition();
	}
	
	public void goCheckHorses() {
		// TODO Auto-generated method stub
		
	}

	public void proceedToPaddock() {
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

	public void waitSpectators() {
		// TODO Auto-generated method stub
		r.lock();
		try{
			try{
				while(true){
					b.wait();
					break;
				}
			}catch (Exception ec){}
		}finally{
			r.unlock();
		}
	}

}
