import java.util.Arrays;
import java.util.Scanner;
/**
 * W1007: Honors Intro to Computer Science
 * Homework 1
 * Talker.java
 * Purpose: In charge of input and output, and handles malevolent users. 
 * 
 * @author Akiko Iwamizu
 * @version 1.7 9/22/14
 */

public class Talker 
{	

	/**
	 * This constructor is called by the Tester class in order to begin the game.
	 */
	public Talker()
	{
		boolean playAgain = true;
		
		System.out.println("Which type of game would you like to play?");
		System.out.println("Options: (1)User vs. Random, (2)User vs. AI, or (3)Random vs. AI");
		System.out.println("Game(Please enter an integer 1-3): ");
		Scanner in = new Scanner(System.in);
		int gameType = in.nextInt();
		
		while((gameType < 1) || (gameType > 3))
		{
			System.out.println("Please enter an integer between 1-3: ");
			gameType = in.nextInt();
		}
		
		System.out.println("Welcome to the Game: Rock, Paper, Scissors, Lizard, Spock!");
		System.out.println("Rules:");
		System.out.println("Scissors cuts Paper covers Rock crushes Lizard,");
		System.out.println("Lizard poisons Spock smashes Scissors decapitates Lizard,");
		System.out.println("Lizard eats Paper disproves Spock vaporizes Rock crushes Scissors.");
		System.out.println("You can exit the game by entering 'z' as your throw.");
		
		while(playAgain)
		{
			if(gameType == 1)
			{
				String user = userThrow();
				String rand = (new Thrower()).setCompThrow();

				Winner whoWon = new Winner(user,rand,gameType);
				if(user.equals("z"))
				{
					System.out.println();
					whoWon.printStats();
					playAgain = false;			
				}				
			}	
			else if(gameType == 2)
			{
				String user = userThrow();
				String AI = (new AI(user)).setAIThrow();
				
				Winner whoWon = new Winner(user,AI,gameType);
				if(user.equals("z"))
				{
					System.out.println();
					whoWon.printStats();
					playAgain = false;			
				}
			}
			else 
			{
				System.out.println();
				System.out.println("How many games would you like the computers to play?");
				Scanner sc = new Scanner(System.in);
				int amountOfGames = sc.nextInt();
				

				
				for(int i = 1; i <= amountOfGames; i++)
				{
					String rand = (new Thrower()).setCompThrow();
					String AI = (new AI(rand)).setAIThrow();
					new Winner(rand,AI,gameType);
				}
				
				Winner whoWon = new Winner();
				whoWon.printStats();
				playAgain = false;
			}

		}
	}

	/**
	 * This method is called to ask for and set the user's input.
	 *
	 * @return A String representing the input by the user.
	 */
	private String userThrow()
	{
		System.out.println("Your throw (Options: r, p, s, l, k, z): ");
		String[] options = {"r", "p", "s", "l", "k", "z"};
		Scanner input = new Scanner(System.in);
		String userChoice = input.next();

		while(!Arrays.asList(options).contains(userChoice))
		{
			System.out.println("I'm sorry, but that isn't a valid option. Try again.");
			userChoice = input.next();
		}

		return(userChoice);		
	}

}