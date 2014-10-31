/**
 * W1007: Honors Intro to Computer Science
 * Homework 1
 * Rules.java
 * Purpose: This class encapsulates the rules and strings that are non-negotiable. 
 *
 * @author Akiko Iwamizu
 * @version 1.7 9/22/14
 */

public class Rules
{
	private String rock = "r";
	private String paper = "p";
	private String scissors = "s";
	private String lizard = "l";
	private String spock = "k";

	protected boolean didP1Win = false;
	protected boolean didP2Win = false;
	protected boolean didTie = false;

	/**
	 * Call this constructor to create a Rules object.
	 */
	public Rules()
	{

	}
	
	/**
	 * This method is called to reset the boolean variables.
	 */
	protected void reset()
	{
		didP1Win = false;
		didP2Win = false;
		didTie = false;
	}


	/**
	 * This method is called when the user inputs the throw "rock".
	 *
	 * @param t the randomized String input by the computer
	 */
	protected void rockRules(String t)
	{
		if(t.equals(rock))
			didTie = true;
		else if(t.equals(paper) || t.equals(spock))
			didP2Win = true;
		else 
			didP1Win = true;
	}

	/**
	 * This method is called when the user inputs the throw "paper".
	 *
	 * @param t the randomized String input by the computer
	 */
	protected void paperRules(String t)
	{
		if(t.equals(paper))
			didTie = true;
		else if(t.equals(scissors) || t.equals(lizard))
			didP2Win = true;
		else 
			didP1Win = true;
	}

	/**
	 * This method is called when the user inputs the throw "scissors".
	 *
	 * @param t the randomized String input by the computer
	 */
	protected void scissorRules(String t)
	{
		if(t.equals(scissors))
			didTie = true;
		else if(t.equals(spock) || t.equals(rock))
			didP2Win = true;
		else 
			didP1Win = true;
	}

	/**
	 * This method is called when the user inputs the throw "lizard".
	 *
	 * @param t the randomized String input by the computer
	 */
	protected void lizardRules(String t)
	{
		if(t.equals(lizard))
			didTie = true;
		else if(t.equals(scissors) || t.equals(rock))
			didP2Win = true;
		else 
			didP1Win = true;
	}

	/**
	 * This method is called when the user inputs the throw "spock".
	 *
	 * @param t the randomized String input by the computer
	 */
	protected void spockRules(String t)
	{
		if(t.equals(spock))
			didTie = true;
		else if(t.equals(paper) || t.equals(lizard))
			didP2Win = true;
		else 
			didP1Win = true;
	}



}