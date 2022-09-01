package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * 
 * Bot's high risk strategy holds if the current hand has a score of at least
 * 19, hits otherwise. It bets from 50 to 100 chips (inclusive).
 * 
 */

public class HighRiskStrategy implements BotStrategy {

	/**
	 * 
	 * Bot's high risk strategy holds if the current hand has a score of at least
	 * 19, hits otherwise.
	 * 
	 * @param hand
	 * @return Action
	 */
	@Override
	public Action play(Hand hand) {
		// if the bot hand is at least 19, hold
		if (hand.getScore() >= 19) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	/**
	 * 
	 * Bot's high risk strategy bets from 50 to 100 chips (inclusive).
	 * 
	 * @return int
	 */
	@Override
	public int makeABet() {
		// bet a random value between 50 and 100
		return new Random().nextInt(101 - 50) + 50;

	}

}
