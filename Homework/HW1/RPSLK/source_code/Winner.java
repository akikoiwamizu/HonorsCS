/**
 * W1007: Honors Intro to Computer Science
 * Homework 1
 * Winner.java
 * Purpose: This class evaluates who won each game and prints the game statistics.
 *
 * @author Akiko Iwamizu
 * @version 1.7 9/22/14
 */

public class Winner extends Rules
{
	private static double p1Wins = 0;
	private static double p2Wins = 0;
	private static int games = 0;
	private static double ties = 0;
	private static String player1 = "";
	private static String player2 = "";
	
	/**
	 * Call this constructor to make a Winner object to access class methods without using any params 
	 */
	public Winner()
	{
		
	}
	
	/**
	 * This constructor prints which player won each game & resets for the next game
	 * 
	 * @param p1
	 * @param p2
	 * @param gameType
	 */
	public Winner(String p1, String p2, int gameType)
	{		
		if(gameType == 1)
		{
			player1 = "You";
			player2 = "Random";
		}
		else if(gameType == 2)
		{
			player1 = "You";
			player2 = "AI";
		}
		else
		{
			player1 = "Random";
			player2 = "AI";
		}
		
		if(!p1.equals("z"))
		{
			games++;
			
			decideWinner(p1,p2);
			
			System.out.print(player1 + " chose: ");
			switchARoo(p1);
			System.out.print(player2 + " chose: ");
			switchARoo(p2);
		
			if(didTie == true)
			{
				ties++;
				System.out.println("There was a tie.");
			}
			else if(didP2Win == true)
			{
				p2Wins++;
				System.out.println(player2 + " won!");
			}
			else 
			{
				p1Wins++;	
				System.out.println(player1 + " won!");
			}
			
			System.out.println();
			reset();
		}
	}
	
	/**
	 * This method determines the winner while referring to the the Rules class.
	 * 
	 * @param userChoice
	 * @param compChoice
	 */
	private void decideWinner(String userChoice, String compChoice)
	{
		if(userChoice.equals("r"))
			rockRules(compChoice);
		else if(userChoice.equals("p"))
			paperRules(compChoice);
		else if(userChoice.equals("s"))
			scissorRules(compChoice);
		else if(userChoice.equals("l"))
			lizardRules(compChoice);
		else 
			spockRules(compChoice);
	}
	
	/**
	 * This method switches the character for the actual name of the String for a nicer printed output.
	 * 
	 * @param choice
	 */
	private void switchARoo(String choice)
	{
		if(choice.equals("r"))
			System.out.println("Rock");
		else if(choice.equals("p"))
			System.out.println("Paper");
		else if(choice.equals("s"))
			System.out.println("Scissors");
		else if(choice.equals("l"))
			System.out.println("Lizard");
		else 
			System.out.println("Spock");
	}
	
	/**
	 * This method prints out the game statistics.
	 */
	public void printStats()
	{
		if(games == 0)
			System.out.println("There are no game statistics available since you didn't play a game.");
		else
		{
	        System.out.println("Game Statistics:");
	        System.out.println("Total number of games played: "+ games);
	        System.out.println(player1 + " won: "+ (int)p1Wins + " games");
	        System.out.println(player2 + " won: " + (int)p2Wins + " games");
	        System.out.println("Tied: " + (int)ties + " games");
	        System.out.println("Percentage of " + player1 + " wins: " + (int)((p1Wins/games)*100) + "%");
	        System.out.println("Percentage of " + player2 + " wins: " + (int)((p2Wins/games)*100) + "%");
	        System.out.println("Percentage of ties: " + (int)((ties/games)*100) + "%");
		}
	}
	


	
}