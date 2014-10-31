/**
 * Entry.java
 * 
 * This class is a "helping class" for this assignment
 * It stores the count and value in a sequence and creates an Entry
 * 
 * @author Akiko Iwamizu, AMI2119
 *
 */

public class Entry 
{
	private int count; // the number that a value shows up consecutively in a sequence
	private int value; 
	
	/**
	 * Constructs an Entry object from a given count and value
	 * @param someCount the number of times a value is consecutive
	 * @param someValue the value of the element in the sequence
	 */
	public Entry(int someCount, int someValue)
	{
		count = someCount;
		value = someValue;				
	}
	
	/**
	 * Gets the count
	 * @return the count
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * Gets the value
	 * @return the value
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Sets the count and adds to it by a certain amount
	 * @param addAmount the amount to be added
	 */
	public void setCount(int addAmount)
	{
		count += addAmount;
	}
	
	/** 
	 * Sets the value and adds to it by a certain amount
	 * 
	 * @param addAmount the amount to be added
	 */
	public void setValue(int addAmount)
	{
		value += addAmount;
	}
	
	/** 
	 * Gets the count and value of an Entry as a String
	 * @return the count and value of an Entry as a String 
	 */
	public String toString()
	{
		return("(" + count + "," + value + ")");
	}
		
}