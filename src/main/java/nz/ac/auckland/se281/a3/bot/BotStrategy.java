package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * Interface to initialise the bot strategy of action methods and betting
 * amounts.
 * 
 */
public interface BotStrategy {

	/**
	 * Bots action to hit or hold based on the bots strategy.
	 * 
	 * @param hand
	 * @return bots action to hit or hold
	 */
	Action play(Hand hand);

	/**
	 * Bots amount to bet based on the bot strategy between 1 and 100 inclusive.
	 * 
	 * @return bot bet amount
	 */
	int makeABet();

}
