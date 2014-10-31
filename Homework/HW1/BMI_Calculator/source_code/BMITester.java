import java.util.Scanner;

/**
 * @author Akiko Iwamizu, UNI:AMI2119
 *
 * This is the class that is used to test the BMI Calculator. It takes in user input. 
 */
public class BMITester{

	private static boolean playAgain = true;

	public static void main(String[] args)
	{
		while(playAgain)
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your weight: ");
			double weight = input.nextDouble();

			Scanner in = new Scanner(System.in);
			System.out.println("Enter your height: ");
			double height = in.nextDouble();

			new BMICalc(weight, height);

			Scanner in2 = new Scanner(System.in);
			System.out.println("Would you like to calculate another BMI? (y/n): ");
			String again = in2.nextLine();
			if(again.equals("y")) {
				playAgain = true; 
			} else
				playAgain = false;
		}
	}
}