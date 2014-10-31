import java.util.Random;
/**
 * W1007: Honors Intro to Computer Science
 * Homework 1
 * Thrower.java
 * Purpose: This class is in charge of randomizing the computer's throw. 
 * 
 * @author Akiko Iwamizu
 * @version 1.7 9/22/14
 */

public class Thrower
{
	String compThrow = "";
	Random generator = new Random();
	
	/**
	 * This method is called in order to set what the computer will throw randomly.
	 *
	 * @return A string representing the computer's choice between r, p, s, l, and k.
	 */
	public String setCompThrow()
	{
		int comp = generator.nextInt(5); 
		if(comp == 0)
			compThrow = "r";
		else if(comp == 1)
			compThrow = "p";
		else if(comp == 2)
			compThrow = "s";
		else if (comp == 3)
			compThrow = "l";
		else
			compThrow = "k";
		return(compThrow);
	}
}