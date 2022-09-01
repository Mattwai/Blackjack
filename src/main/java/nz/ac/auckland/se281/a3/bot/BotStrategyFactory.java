package nz.ac.auckland.se281.a3.bot;

/**
 * 
 * Bot strategy factory is a factory design to choose which stategy the bot
 * should implement based on the users input
 * 
 */
public class BotStrategyFactory {

	/**
	 * Bot strategy factory chooses which stategy the bot should implement based on
	 * the users input.
	 * 
	 * @param strategy
	 * @return the bots strategy
	 */
	public static BotStrategy chooseBotStrategy(String strategy) {
		// if user input strategy is random (R), bot uses random strategy
		if (strategy.equals("R")) {
			return new BotRandomStrategy();
		}
		// if user input strategy is low risk (LR), bot uses low risk strategy
		else if (strategy.equals("LR")) {
			return new LowRiskStrategy();
		}
		// if user input strategy is high risk (HR), bot uses high risk strategy
		else if (strategy.equals("HR")) {
			return new HighRiskStrategy();
		} else
			return null;
	}

}
