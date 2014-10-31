/**
 * W1007: Honors Intro to Computer Science
 * Homework 1
 * AI.java
 * Purpose: This class keeps track of the User's throw and determines 
 * the smart computer's throw.
 * 
 * AI info: In my observations, the AI doesn't always win against either 
 * the random computer or the user.
 * 
 * On average, I noticed that the AI beat random but only by a few percent,
 * otherwise it lost. It seemed like a good idea to use 50 games in order 
 * for the AI to collect a lot of data from its opponent. It is possible
 * for the user to beat both the AI and random. 
 *
 * @author Akiko Iwamizu
 * @version 1.7 9/22/14
 */

public class AI 
{
	private static int totalUserThrows = 0;
	private static int totalUserRocks = 0;
	private static int totalUserPapers = 0;
	private static int totalUserScissors = 0;
	private static int totalUserLizards = 0;
	private static int totalUserSpocks = 0;
	private int[] userChoices = {totalUserRocks, totalUserPapers, totalUserScissors, totalUserLizards,totalUserSpocks};

	/**
	 * This constructor records the user's throws for each game played.
	 * 
	 * @param playerThrow
	 */
	public AI(String playerThrow)
	{
		totalUserThrows++;
		
		if(playerThrow.equals("r"))
			totalUserRocks++;
		else if(playerThrow.equals("s"))
			totalUserScissors++;
		else if(playerThrow.equals("p"))
			totalUserPapers++;		
		else if(playerThrow.equals("l"))
			totalUserLizards++;
		else if(playerThrow.equals("k"))
			totalUserSpocks++;
	}
	
	/**
	 * This method is called to set the AI's choice based on previous User choices
	 * 
	 * @return a string representing the AI's choice for the game.
	 */
	public String setAIThrow()
	{	
		if(totalUserThrows < 6)
		{
			String aiChoice = (new Thrower()).setCompThrow();
			return(aiChoice);
		}

		
		int mostCommonThrow = userChoices[0];
		int position = 0;
		for(int i = 1; i < userChoices.length; i++)
		{
			if(userChoices[i] > mostCommonThrow)
			{
				mostCommonThrow = userChoices[i];
				position = i;
			}
		}

		String aiChoice = "";

		if(position == 2 || position == 3)
			aiChoice = "r";
		else if(position == 0 || position == 4)
			aiChoice = "p";
		else 
			aiChoice = "l";
		
		
		return(aiChoice);

	}


}