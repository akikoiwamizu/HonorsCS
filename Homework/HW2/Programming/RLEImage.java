import java.util.ArrayList;

/**
 * RLEImage.java
 * 
 * This class follow the third choice from Step 4 of this project and can
 * compress a 2D array of integers.
 * An ArrayList<Entry2D> was used in order to store and compress the 2D sequence
 * The benefit for using this data structure is the ability to take in an unknown
 * amount of data from the user, the ability to find, add, or remove Entries. 
 * 
 * @author Akiko Iwamizu, AMI2119
 *
 */

public class RLEImage
{
	private ArrayList<Entry2D> entries;
	private int length;

	/**
	 * Constructs an instance of RLEImage object
	 * @param input the uncompressed 2D array 
	 */
	public RLEImage(int[][] input)
	{
		entries = new ArrayList<Entry2D>();
		compressImage(input);
		length = entries.size();
	}

	/**
	 * Gets the length of the sequence
	 * @return the length of the sequence
	 */
	public int getLength()
	{
		return(length);
	}

	/**
	 * Takes input, iterates over it looking for runs of same values, 
	 * and creates and fills the data structure ArrayList<Entry2D>
	 * @param input the uncompressed 2D array
	 */
	private void compressImage(int[][] input)
	{
		int[] value = input[0];
		int count = 1;

		for(int i = 1; i < input.length; i++)
		{
			if(value == input[i])
				count++;
			else
			{
				entries.add(new Entry2D(count, value));
				value = input[i]; // used to reset the value & count and move onto the next pair
				count = 1;
			}
		}
		entries.add(new Entry2D(count,value)); // adds the last pair to the ArrayList
	}
	
	/**
	 * Gets the compressed 2D sequence as a String
	 * @return the compressed 2D sequence as a String
	 */
	public String internalToString()
	{
		String seqString = "[";
		for(int i = 0; i < entries.size(); i++)
		{
			seqString += entries.get(i).toString();
			if(i != (entries.size() - 1))
				seqString += ",";
		}
		seqString += "]";
		return(seqString);
	}

	/** 
	 * Used to debug and compare against the 2D compressed sequence
	 * @return the uncompressed 2D sequence as a String
	 */
	public String toString()
	{
		String seqString = "[";
		for(int i = 0; i < entries.size(); i++)
		{
			seqString += entries.get(i).getValue().toString();
			seqString += " ";
		}
		seqString += "]";
		String newSeqString = seqString.replaceAll(" ]", "]");
		return(newSeqString);
	}

	/**
	 * Compares two 2D sequences using their compressed form
	 * and determines if their contents are the same
	 * @param myOtherRLEImage the other instance to compare
	 * @return true or false if the two instances are the same in contents
	 */
	public boolean equals(RLEImage myOtherRLEImage)
	{
		if(getLength() != myOtherRLEImage.getLength())
			return(false);
		else if(internalToString().equals(myOtherRLEImage.internalToString()))
			return(true);
		else
			return(false);	
	}

	/**
	 * Decompresses the internally compressed 2D array
	 * @return the uncompressed 2D array form of the array
	 */
	public int[][] to2DArray()
	{
		int[][] seqArray = new int[length][];

		for(int i = 0; i < entries.size(); i++)
		{
			seqArray[i] = entries.get(i).getValue().toArray();
		}
		return(seqArray);
	}
}