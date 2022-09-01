package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

/**
 * 
 * Dealer wants to win against the player with the highest bet. If multiple bots
 * have placed the same highest bet, the Dealer chooses the player as ordered in
 * the players list.
 * 
 */

public class TargetHighestBidderStrategy implements DealerStrategy {
	private List<Player> players;

	/**
	 * 
	 * Dealer decides whether to holds or hit based on their score and the target
	 * players score.
	 * 
	 * @param hand
	 * @return Action
	 */
	@Override
	public Action decideAction(Hand hand) {
		/*
		 * dealer holds if against the player they have a higher or equal hand score
		 * (win), has greater or equal to 17 and the player has 21 (player got
		 * blackjack, dealer can not win) or is the player is bust (win)
		 */
		if ((hand.getScore() >= getHighestBidder().getScore())
				|| ((getHighestBidder().getScore() == 21) && hand.getScore() >= 17)
				|| (getHighestBidder().getScore()) > 21) {
			return Action.HOLD;
		}
		// else dealer hits
		return Action.HIT;

	}

	/**
	 * Gets list of players for the dealer to see their hands.
	 * 
	 * @param players
	 */
	@Override
	public void getPlayers(List<Player> players) {
		// gets list of players
		this.players = players;
	}

	/**
	 * Gets the player with the highest bet in the game for the dealer to target.
	 * 
	 * @return Hand
	 */
	public Hand getHighestBidder() {
		// sets first player in the list of players to the highest bidder
		Participant highestBidder = players.get(0);
		for (Participant p : players) {
			/*
			 * loops through all the players, if a player has a valid bid greater than the
			 * current highest bidder, they are now the new highest bidder
			 */
			int highestBidderBet = highestBidder.getHand().getBet();
			if ((p.getHand().getBet() > highestBidderBet) && (p.getHand().getBet() <= 100)) {
				highestBidder = p;
			}
		}
		// return the highest bidders hand
		return highestBidder.getHand();
	}

}