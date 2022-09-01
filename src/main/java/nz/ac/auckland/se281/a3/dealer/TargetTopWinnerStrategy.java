package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

/**
 * 
 * Target top winner strategy targets the player with the highest net wins. If
 * two or three players have the same highest net wins, the Dealer selects a
 * player based on their order in the players list.
 * 
 */
public class TargetTopWinnerStrategy implements DealerStrategy {
	private List<Player> players;

	/**
	 * uses the list of players to decide which player has the highest net wins for
	 * the dealer to target.
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
		if ((hand.getScore() >= getTopWinner().getScore())
				|| ((getTopWinner().getScore() == 21) && hand.getScore() >= 17) || (getTopWinner().getScore()) > 21) {
			return Action.HOLD;
		}
		// else dealer hits
		return Action.HIT;
	}

	/**
	 * Gets list of players playing for the dealer to get their hands.
	 * 
	 * @param players
	 */
	@Override
	public void getPlayers(List<Player> players) {
		// gets list of players
		this.players = players;
	}

	/**
	 * Loops through the list of players and return the player with the highest net
	 * wins.
	 * 
	 * @return top winners hand.
	 */
	public Hand getTopWinner() {
		// sets first player in the list of players to the player with the most net wins
		Player topWinner = players.get(0);
		for (Player p : players) {
			/*
			 * loops through all the players, if a player has more net wins than the current
			 * top winner, they are now the new player with the most net wins
			 */
			int mostWins = topWinner.getNetWins();
			if (p.getNetWins() > mostWins) {
				topWinner = p;
			}
		}
		// return the top winners hand
		return topWinner.getHand();
	}
}
