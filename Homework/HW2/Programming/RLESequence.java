import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * RLESequence.java
 * 
 * This program uses an ArrayList<Entry> to compress the given array.
 * The benefit for using this data structure is the ability to take in an unknown
 * amount of data from the user, the ability to find, add, or remove Entries. 
 * 
 * @author Akiko Iwamizu, AMI2119
 *
 */

public class RLESequence 
{
	private ArrayList<Entry> entries; // holds the compressed sequence
	private int length; // holds the size of the sequence

	/**
	 * RLESequence(length) establishes a RLESequence(in compressed form)from a given length
	 * and the default of the values is 0. 
	 * @param someLength is the number of elements provided in the sequence
	 */
	public RLESequence(int someLength)
	{
		entries = new ArrayList<Entry>();
		length = someLength;
		entries.add(new Entry(length,0));		
	}

	/**
	 * RLESequence(input)takes a standard 1D array of ints and creates its compressed form
	 * @param input is the array provided and is uncompressed
	 */
	public RLESequence(int[] input)
	{
		entries = new ArrayList<Entry>();
		length = input.length;
		compress(input);
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
	 * and creates and fills the data structure ArrayList<Entry>
	 * @param input the uncompressed array
	 */
	private void compress(int[] input)
	{
		int value = input[0];
		int count = 1;

		for(int i = 1; i < input.length; i++)
		{
			if(value == input[i])
				count++;
			else
			{
				entries.add(new Entry(count, value));
				value = input[i]; // used to reset the value & count and move onto the next pair
				count = 1;
			}
		}
		entries.add(new Entry(count,value)); // adds the last pair to the ArrayList
	}

	/**
	 * Gets the compressed sequence as a String
	 * @return the compressed sequence as a String
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
	 * Used to debug and compare against the compressed sequence
	 * @return the uncompressed sequence as a String
	 */
	public String toString()
	{
		String seqString = "[";
		for(int i = 0; i < entries.size(); i++)
		{
			for(int j = 0; j < entries.get(i).getCount(); j++) // expands the compressed array
			{
				seqString += entries.get(i).getValue();
				seqString += " ";
			}
		}
		seqString += "]";
		String newSeqString = seqString.replaceAll(" ]", "]");
		return(newSeqString);
	}

	/**
	 * Compares two sequences using their compressed form
	 * and determines if their contents are the same
	 * @param myOtherRLESequence the other instance to compare
	 * @return true of false if the two instances are the same in contents
	 */
	public boolean equals(RLESequence myOtherRLESequence)
	{
		if(getLength() != myOtherRLESequence.getLength())
			return(false);
		else if(internalToString().equals(myOtherRLESequence.internalToString()))
			return(true);
		else
			return(false);
	}

	/**
	 * Decompresses the internally compressed sequence 
	 * @return the uncompressed array form of the RLESequence
	 */
	public int[] toArray()
	{
		int[] seqArray = new int[length]; // length that was set when the RLESeq object was first created
		int index = 0;
		int updatedIndex = 0;

		for(int i = 0; i < entries.size(); i++)
		{
			for(int j = 0; j < entries.get(i).getCount(); j++)
			{
				updatedIndex = index + j;
				seqArray[updatedIndex] = entries.get(i).getValue();
			}
			index += entries.get(i).getCount();
		}
		return(seqArray);
	}

	/**
	 * Gets the value of the element at index i of the original array
	 * @param index of the element to get
	 * @return the value at the given index
	 */
	public int get(int index)
	{
		int updatedIndex = 0;

		if(index < 0 || index >= length)
			throw new InputMismatchException("Invalid input. Please enter a valid index.");

		for(int i = 0; i < entries.size(); i++)
		{
			updatedIndex += entries.get(i).getCount();
			if(updatedIndex > index)
				return(entries.get(i).getValue());
		}

		throw new InputMismatchException("Invalid input. Please enter a valid index.");
	}

	/**
	 * Sets an element at index i of the original array to a different value
	 * @param index the index at which to change the value 
	 * @param newValue the new value of the element changed
	 */
	public void set(int index, int newValue)
	{
		int updatedIndex = 0;
		int oldCount, oldValue, leftEntryValue, leftEntryCount, newCount;

		if(index < 0 || index >= length)
			throw new InputMismatchException("Invalid input. Please enter a valid index.");

		for(int i = 0; i < entries.size(); i++)
		{
			updatedIndex += entries.get(i).getCount();
			oldCount = entries.get(i).getCount();
			oldValue = entries.get(i).getValue();

			if(updatedIndex > index)
			{
				if(oldValue != newValue)
				{
					entries.remove(i);

					if((updatedIndex - index -1) != 0)
						entries.add(i, new Entry((updatedIndex - index - 1), oldValue));

					entries.add(i, new Entry(1, newValue));

					if((oldCount - updatedIndex + index) != 0)
						entries.add(i, new Entry((oldCount - updatedIndex + index), oldValue));

					for(int j = 0; j < entries.size(); j++)
					{
						leftEntryValue = entries.get(j).getValue();
						leftEntryCount = entries.get(j).getCount();

						while(j != (entries.size() - 1) && leftEntryValue == entries.get(j + 1).getValue())
						{
							newCount = leftEntryCount + entries.get(j + 1).getCount();
							entries.remove(j);
							entries.set(j, new Entry(newCount, leftEntryValue));
						}
					}
					return; // exits the method after completing this if statement
				}
				else 
					return;
			}
		}	
	}

	/**
	 * "Overwrites elements" by removing the entries after a given index
	 * and then appending the new entries to this sequence
	 * Note: I uncompressed the specific entry that will be changed instead of
	 * uncompressing the entire sequence to make it more efficient
	 * @param position the index at which to begin appending values
	 * @param myOtherRLESequence the instance's values to append
	 */
	public void tailReplace(int position, RLESequence myOtherRLESequence)
	{
		int updatedIndex = 0;
		int lengthOfOtherRLESequence = 0;
		int oldCount, oldValue;

		if(position < 0 || position >= length)
			throw new InputMismatchException("Invalid input. Please enter a valid index.");

		for(int i = 0; i < entries.size(); i++)
		{
			updatedIndex += entries.get(i).getCount();
			oldCount = entries.get(i).getCount();
			oldValue = entries.get(i).getValue();

			if(updatedIndex > position)
			{
				entries.subList(i, entries.size()).clear();
				entries.addAll(myOtherRLESequence.entries);

				if((oldCount - updatedIndex + position) != 0)
					entries.add(i, new Entry((oldCount - updatedIndex + position), oldValue));
				for(int j = 0; j < entries.size(); j++)
					lengthOfOtherRLESequence += entries.get(j).getCount();
				length = lengthOfOtherRLESequence;
				return; // exits the method after completing this if statement
			}
		}


	}

	/**
	 * Increases or decreases every element in the sequence by
	 * the specified value
	 * Note: works for both positive and negative integers
	 * @param byWhat the value to add to every element
	 */
	public void increment(int byWhat)
	{
		for(int i = 0; i < entries.size(); i++)
		{
			entries.get(i).setValue(byWhat);
		}
	}


}	