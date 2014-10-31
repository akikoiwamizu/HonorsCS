/**
 * Entry2D.java
 * 
 * This class is a "helping class" for this assignment
 * It stores a RLESequence and the count of that sequence
 * 
 * @author Akiko Iwamizu, AMI2119
 *
 */

public class Entry2D
{
	private int count; // the number that a value shows up consecutively in a sequence 
	private RLESequence value;

	/**
	 * Constructs an Entry2D instance from an int[] and a given count
	 * @param someCount the number of times a value is consecutive
	 * @param someArray the array of integers
	 */
	public Entry2D(int someCount, int[] someArray)
	{
		count = someCount;
		value = new RLESequence(someArray);
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
	 * Gets the RLESequence
	 * @return the RLESequence
	 */
	public RLESequence getValue()
	{
		return value;
	}
	
	/** 
	 * Gets the count and the RLESequence as a String
	 * @return the count and the RLESequence as a String 
	 */
	public String toString()
	{
		return("(" + count + "," + value.internalToString() + ")");
	}
	
}