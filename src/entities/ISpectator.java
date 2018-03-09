package entities;

public interface ISpectator {
	public void waitForNextRace();
	public void goCheckHorses();
	public void placeABet(int race, int horse);
	public void goWatchTheRace(int race);
	public boolean haveIWon(int race, int horse);
	public void goCollectTheGains(int race);
}
