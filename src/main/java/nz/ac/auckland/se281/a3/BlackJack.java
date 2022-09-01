package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.DealerStrategy;
import nz.ac.auckland.se281.a3.dealer.TargetHighestBidderStrategy;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	private List<Player> players;
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * This constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	/**
	 * @return List<Player>
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * @return String
	 */
	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * TODO This method initializes the Bots, you should change this method for
	 * Task1
	 */
	protected void initBots() {
		// initialised new bots
		Bot bot1 = new Bot("Bot1");
		Bot bot2 = new Bot("Bot2");
		String botStrategyString = getBotStrategy(); // UNCOMMENT THIS
		// create and set Bots strategy here
		players.add(bot1);
		players.add(bot2);
		bot1.setBotStrategy(botStrategyString);
		bot2.setBotStrategy(botStrategyString);
	}

	/**
	 * TODO This method initializes the Dealer, you should change this method for
	 * Task2
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		dealer = new Dealer("Dealer");
		// set initial strategy to target highest bidder
		DealerStrategy strategy = new TargetHighestBidderStrategy();
		dealer.setDealerStrategy("Dealer", strategy);
		// give dealer the list of players
		dealer.setPlayers(getPlayers());

	}

	/**
	 * TODO This method prints and updates the results (wins and losses) you should
	 * change this method for Task 2 and Task 3
	 */
	protected void printAndUpdateResults(int round) {
		// iterate through each player and determine if they won or lost
		for (Participant p : players) {
			Boolean playerWon = false;
			if (dealer.getHand().getScore() == 21 || p.getHand().getScore() > 21
					|| dealer.getHand().getScore() == p.getHand().getScore()
					|| ((dealer.getHand().getScore() < 21) && (dealer.getHand().getScore() > p.getHand().getScore()))) {
				// if dealer won, update the players losses
				((Player) p).setLosses();
			} else if (p.getHand().getScore() == 21 || dealer.getHand().getScore() > 21
					|| p.getHand().getScore() > dealer.getHand().getScore()) {
				// if player won, update the players wins
				((Player) p).setWins();
				playerWon = true;
			}
			// print out the results for the round
			System.out.println("Round " + round + ": " + p.getName() + " " + wonRound(playerWon) + p.getHand().getBet()
					+ " chips");
		}
	}

	/**
	 * TODO This method should print the statistic of the game when it ends
	 */
	protected void printGameStatistics() {
		// iterate through all the players and print their results from the game
		for (Player p : players) {
			System.out.println(p.getName() + " won " + p.getWins() + " times and lost " + p.getLosses() + " times");
		}
	}

	/**
	 * 
	 * Print round results if the player won, return the words won.
	 * 
	 * @param playerWon
	 * @return String of if the player won or lost
	 */
	private String wonRound(Boolean playerWon) {
		// if the player won, return the words won, used when printing round results
		if (playerWon) {
			return "won ";
		} else {
			return "lost ";
		}
	}

}
