package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * 
 * Bot's low risk strategy holds if the current hand has a score of at least 17,
 * hits otherwise. It bets from 10 to 50 chips (inclusive).
 * 
 */

public class LowRiskStrategy implements BotStrategy {

	/**
	 * Bot's low risk strategy holds if the current hand has a score of at least 17,
	 * hits otherwise.
	 * 
	 * @param hand
	 * @return Action
	 */
	@Override
	public Action play(Hand hand) {
		// if the bot hand is at least 17, hold
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	/**
	 * Bot's low risk strategy bets from 10 to 50 chips (inclusive).
	 * 
	 * @return int
	 */
	@Override
	public int makeABet() {
		// bet a random value between 10 and 50
		return new Random().nextInt(51 - 10) + 10;

	}

}
