package entities;

public interface IBroker {
	//public void summonHorsesToPaddock();
	public void acceptTheBets(int spectator);
	public void startTheRace(int race);
	public void reportResults(int race);
	public boolean areThereAnyWinners(int race);
	public void honourTheBets(int spectator);
	public void entertainTheGuests();
}
