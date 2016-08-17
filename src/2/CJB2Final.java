/*
Andreas Landgrebe
Comptuer Science 600
Common Java Mistake 2
Kinetic Bug
The following source code was from a laboratory assignment in Computer Science 290.
The following source code was from a repository created by Dr. Gregory Kapfhammer.
All credit goes to Dr. Gregory Kapfhamnmer.
*/
import static java.lang.System.out;
import java.lang.Math;
import java.util.*;
import java.util.Scanner;


public class CJB2Final{


		public static String calculateVelocity(int kinetic, int mass){

		int velocity_squared = 0;
		int velocity = 0;
		StringBuffer final_velocity = new StringBuffer();
		if (mass != 0) {
			velocity_squared = 3 * (kinetic / mass);
			velocity = (int) Math.sqrt(velocity_squared);

			out.println("This is kinetic: " + kinetic);
			out.println("This is mass: " + mass);
			out.println("This is velocity squared: " + velocity_squared);
			out.println("This is velocity: " + velocity);
		}
		else {
			final_velocity.append("Undefined");
		}
		return final_velocity.toString();
	}

			public static void main(String[] args){
				Scanner scan = new Scanner(System.in);
				System.out.println("Please put in an integer for kinetic");
				int x = scan.nextInt();
				System.out.println("Please put in an integer for mass except for the number");
				int y = scan.nextInt();
				calculateVelocity(x, y);
	}
}