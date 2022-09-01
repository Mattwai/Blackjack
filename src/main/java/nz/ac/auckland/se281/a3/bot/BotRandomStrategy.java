package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * Bot Random Strategy randomly chooses to hit or hold and randomly choosing an
 * amount to bet.
 */

public class BotRandomStrategy implements BotStrategy {

	/**
	 * Bot randomly chooses to hit or hold using a random number to do this.
	 * 
	 * @param hand
	 * @return Action
	 */
	@Override
	public Action play(Hand hand) {
		// generate a random number between 1 and 100
		int randomNumber = new Random().nextInt(101 - 0) + 0;
		// if number is greater or equal to 50, hit, if lower then hold
		if (randomNumber <= 50) {
			return Action.HIT;
		} else {
			return Action.HOLD;
		}
	}

	/**
	 * 
	 * Bot randomly choosing an amount to bet between 1 and 100 inclusive.
	 * 
	 * @return int
	 */
	@Override
	public int makeABet() {
		// randomly generate a number between 1 and 100 to bet
		return new Random().nextInt(101 - 1) + 1;

	}

}
