package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

/**
 * Interface to initialise the dealer strategy of action methods.
 * 
 */

public interface DealerStrategy {

	/**
	 * Dealers action to hit or hold based on the stategies the dealer can use.
	 * 
	 * @param hand
	 * @return dealers action to hit or hold
	 */
	Action decideAction(Hand hand);

	/**
	 * Dealer gets the list of players to get their hands to decide which strategy
	 * to use.
	 * 
	 * @param players
	 */
	public abstract void getPlayers(List<Player> players);

}
