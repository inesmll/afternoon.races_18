package entities;

public interface IHorse {
	//public void proceedToStable();
	//public void proceedToPaddock();
	public void proceedToStartLine(int race);
	public void makeAMove(int race);
	public boolean hasFinishLineBeenCrossed(int race);
	public int maxUnits();
}
