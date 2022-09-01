package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Player;

/**
 * 
 * You should change this class for Task 2
 *
 * Dealer in blackjack game
 * 
 */
public class Dealer extends Participant {
	private DealerStrategy strategy;
	private List<Player> players;

	/**
	 * This constructor get dealer's name and sends it to the super class for
	 * dealer.
	 * 
	 * @param name
	 */
	public Dealer(String name) {
		super(name);
	}

	/**
	 * This method gets the dealers strategy from blackjack and sets it to this
	 * dealers strategy.
	 * 
	 * @param name
	 * @param strategy
	 */
	public void setDealerStrategy(String name, DealerStrategy strategy) {
		// sets the dealers strategy
		this.strategy = strategy;
	}

	/**
	 * Changes the dealers strategy based on the players wins or bets.
	 * 
	 * @param hand
	 * @return Action of the dealer.
	 */
	@Override
	public Action decideAction(Hand hand) {
		// gets the players in the game
		this.strategy.getPlayers(this.players);
		// loops through the players to check if they have 2 or more net wins
		for (Player p : players) {
			if (p.getNetWins() >= 2) {
				/*
				 * if player has 2 or more net wins change strategy to target the player with
				 * the most net winner. If multiple players have the most, target the player
				 * that comes first in play order
				 */
				DealerStrategy targetTopWinner = new TargetTopWinnerStrategy();
				this.strategy = targetTopWinner;
				targetTopWinner.getPlayers(this.players);
				return targetTopWinner.decideAction(hand);
			}
		}
		// if players have less than 2 net wins then use current strategy
		return this.strategy.decideAction(hand);

	}

	/**
	 * Set the list of players playing for the dealer to get their hands.
	 * 
	 * @param players
	 */
	public void setPlayers(List<Player> players) {
		// set the list of players to dealer
		this.players = players;
	}

	/**
	 * Get the list of players playing for the dealer to get their hands.
	 * 
	 * @return List<Player>
	 */
	public List<Player> getPlayers() {
		// gets list of players
		return this.players;

	}
}
