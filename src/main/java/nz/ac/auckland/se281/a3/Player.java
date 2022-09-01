package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 * This is a class specific to all the player in the game intialises their
 * actions and keeps track of wins and losses
 * 
 */
public abstract class Player extends Participant {
	private int wins;
	private int losses;

	/**
	 * This constructor Player get players name and sends to super class.
	 * 
	 * @param name
	 */
	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	/**
	 * Set the players wins by increrasing the players wins by 1.
	 */
	public void setWins() {
		this.wins = this.wins + 1;
	}

	/**
	 * gets players total wins from this win in the player class.
	 * 
	 * @return int
	 */
	public int getWins() {
		// gets players total wins
		return this.wins;
	}

	/**
	 * Set the players losses by increrasing the players losses by 1.
	 */
	public void setLosses() {
		this.losses = this.losses + 1;
	}

	/**
	 * gets players total losses from this win in the player class.
	 * 
	 * @return int
	 */
	public int getLosses() {
		// gets players total losses
		return this.losses;
	}

	/**
	 * gets players net wins by returning the players wins minus their losses.
	 * 
	 * @return int
	 */
	public int getNetWins() {
		// gets players net wins
		return this.wins - this.losses;
	}

}
