package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 * 
 * Bot is a type of player This class controls the actions of the bot each
 * round.
 * 
 */
public class Bot extends Player {
	private String botStrategy;

	/**
	 * This constructor Bot get bot players name and send it to the super class.
	 * 
	 * @param name
	 */
	public Bot(String name) {
		super(name);
	}

	/**
	 * set the bots strategy for this bot from the user input of bot strategy.
	 * 
	 * @param botStrategyString
	 */
	public void setBotStrategy(String botStrategyString) {
		// set the bots strategy
		this.botStrategy = botStrategyString;
	}

	/**
	 * strategy factory is used to determine which strategy the bot should use.
	 * 
	 * @param hand
	 * @return Action the action the bot should take.
	 */
	@Override
	public Action decideAction(Hand hand) {
		// use bot strategy's factory to determine bot strategy and play
		if (BotStrategyFactory.chooseBotStrategy(this.botStrategy) != null) {
			return BotStrategyFactory.chooseBotStrategy(this.botStrategy).play(hand);
		} else {
			return null;
		}
	}

	/**
	 * determine the strategy the bot should use and make a bet based on that
	 * strategy.
	 * 
	 * @return int
	 */
	@Override
	public int makeABet() {
		// use bot strategy's factory to determine bot strategy and make a bet
		if (BotStrategyFactory.chooseBotStrategy(this.botStrategy) != null) {
			return BotStrategyFactory.chooseBotStrategy(this.botStrategy).makeABet();
		} else {
			return 0;
		}

	}

}
