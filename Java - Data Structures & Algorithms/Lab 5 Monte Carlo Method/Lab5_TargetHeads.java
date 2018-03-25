/*
 * Given the number of tosses and a target number of heads to achieve
 * What's the probability that at some point you'll toss the target number of heads in a row?
*/
import java.util.Scanner;
public class Lab5_TargetHeads
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("How many times do you want to toss the coin?");
		double tosses = sc.nextDouble();
		System.out.println("What is your target number of heads in a row?");
		int target = sc.nextInt();

		int successes = 0;
		double simulations = 100000;

		for(int i = 0; i < simulations; i++)//Outer for loop runs 'simulations' times 
		{
			int count = 0; //Reset the counter for each simulation
			int targetRecorder = 0;//Counter to record whenever the target no of heads is reached in a simulation

			for(int j = 0; j < tosses; j++)//Inner for loop runs 'tosses' times for each iteration
			{
				if(Math.random() > 0.5)//If less than 0.5, assume tails has been tossed. For greater, assume heads so increment counter
				{
					count++; //Count how many times we get a head
					if(count >= target)
					{
						targetRecorder++; //Record if we reach the target number of head tosses in a row
					}
				}
				else//If random num is less than 0.5, don't increment anything
				{
					count = 0;
				}
			}
			if(targetRecorder >= 1) //If we reached the target number of heads once or more
			{
				successes++; //Increment the number of successful simulations
			}
		}
		int result = (int)(Math.round((successes/simulations)*100)); //Calculate the percentage chance of getting the target number of heads
		
		System.out.println("The probability of throwing "+target+" heads in a row from "+tosses+" tosses is "+result+"%");
	}
}