/**
 * Tester.java
 * 
 * This program tests that the methods work in the RLEImage and RLESequence classes
 * I chose the third option from Step 4 in the programming assignment as my creativity step.
 * 
 * @author Akiko Iwamizu, AMI2119
 *
 */
public class Tester
{
	public static void main(String[] args) 
	{
		System.out.println("RLESequence Tests:");
		System.out.println();
		//------------------------------------------------------------------------
		int length = 7;
		RLESequence testA = new RLESequence(length);
		System.out.println("Test A with length 7: " + testA.toString());
		System.out.println("The compressed array: " + testA.internalToString());
		System.out.println();
		//------------------------------------------------------------------------
		int[] array = {0,0,0,0,0,0,0};
		RLESequence testF = new RLESequence(array);
		System.out.println("Test F with an array sequence: " + testF.toString());
		System.out.println("The compressed array: " + testF.internalToString());
		System.out.println();
		//------------------------------------------------------------------------
		if(testA.equals(testF))
			System.out.println("The sequences from Test A and Test F are the same.");
		System.out.println();
		//------------------------------------------------------------------------
		int[] arraySeq = {5,5,5,5,1,1,3,3,3,3};
		RLESequence testB = new RLESequence(arraySeq);
		System.out.println("Test B with an array sequence: " + testB.toString());
		System.out.println("The compressed array of Test B: " + testB.internalToString());
		System.out.println();

		//------------------------------------------------------------------------
		int[] testD = testB.toArray();
		System.out.print("Uncompressed array from Test B using toArray: [");
		for(int i = 0; i < testD.length; i++)
		{
			System.out.print(testD[i]);
			if(i != (testD.length - 1))
				System.out.print(" ");
		}
		System.out.println("]");
		System.out.println();
		
		//------------------------------------------------------------------------
		int testC = testB.get(5);
		System.out.println("Test C gives the value when index = 5 of the array from Test B: " + testC);
		System.out.println();
		
		//------------------------------------------------------------------------
		testB.set(2,4);
		System.out.println("The sequence when the value at index 2 of Test B is set to 4: " + testB.internalToString());
		testB.set(3,4);
		System.out.println("The sequence when the value at index 3 of Test B is set to 4: " + testB.internalToString());
		testB.set(8,3);
		System.out.println("The sequence when the value at index 8 of Test B is set to 3: " + testB.internalToString());
		System.out.println();
		
		//------------------------------------------------------------------------
		System.out.println("The length of Test B's sequence before tailReplace: " + testB.getLength());
		testB.tailReplace(6,testA);
		System.out.println("After tailReplacing Test A into Test B: " + testB.internalToString());
		System.out.println("The length of Test B's sequence after tailReplace: " + testB.getLength());
		System.out.println();
		//------------------------------------------------------------------------
		testB.increment(3);
		System.out.println("Test B's sequence after incrementing by 3: " + testB.internalToString());
		testB.increment(-1);
		System.out.println("Test B's sequence after incrementing by -1: " + testB.internalToString());		
		System.out.println();
	
		
		//------------------------------------------------------------------------
		System.out.println();
		System.out.println();
		System.out.println("RLEImage Tests:");
		System.out.println();
		int[][] input = {{9,9,9,9}, {8,8,8,8}, {7,7,7,7}, {0,0,0,0}};
		RLEImage image = new RLEImage(input);
		
		System.out.println("Length of the 2D Sequence: " + image.getLength());
		System.out.println("Uncompressed 2D Sequence: " + image.toString());
		System.out.println("Compressed 2D Sequence: " + image.internalToString());
		
		int[][] newInput = image.to2DArray();
		System.out.print("Uncompressed 2D Sequence using to2DArray: [");
		for(int i = 0; i < newInput.length; i++)
		{
			System.out.print("[");
			for(int j = 0; j < newInput[i].length; j++)
			{
				System.out.print(newInput[i][j]);
				if(j != (newInput[i].length - 1))
					System.out.print(" ");
			}
			System.out.print("]");
		}
		System.out.println("]");
		
		
		RLEImage newImage = new RLEImage(newInput);
		if(newImage.equals(image))
			System.out.println("The original image is the same as the image returned by to2DArray.");
		
		
		System.out.println();
		
		System.out.println("Original uncompressed 2D Sequence: " + image.toString());
		newInput[0][0] = 1;
		newInput[1][0] = 2;
		newInput[2][0] = 3;
		newInput[3][0] = 4;
		System.out.print("New uncompressed 2D Sequence using to2DArray: [");
		for(int i = 0; i < newInput.length; i++)
		{
			System.out.print("[");
			for(int j = 0; j < newInput[i].length; j++)
			{
				System.out.print(newInput[i][j]);
				if(j != (newInput[i].length - 1))
					System.out.print(" ");
			}
			System.out.print("]");
		}
		System.out.println("]");
			
		if(!newInput.equals(image))
			System.out.println("The original image is the not same as the new image returned by to2DArray.");
		
	}
}