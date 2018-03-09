package entities;

public class SpectatorThread extends Thread{
	private final int id;
	
	public SpectatorThread(int id){
		this.id = id;
	}
}
