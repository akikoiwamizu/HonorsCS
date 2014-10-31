/*
UNI: AMI2119
This is the class that is used to calculate the BMI
*/

import java.text.DecimalFormat;

public class BMICalc{
	
	public BMICalc(double w, double h)
	{
		double formula = ((w / Math.pow(h,2)) * 703);
		DecimalFormat df = new DecimalFormat(".#");
		System.out.println("Your BMI is: " + df.format(formula));
	}
}