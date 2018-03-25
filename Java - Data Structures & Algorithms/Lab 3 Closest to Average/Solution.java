import java.util.Scanner;

public class Solution 
{
    public static void main(String args[] )
    {
        //enter number of boxes in array
        System.out.println("Enter a number");
        Scanner sc1 = new Scanner(System.in);
        int indices = sc1.nextInt();
        int[] numArray = new int[indices];
        int sum = 0;
        //populate array
        for(int i=0; i<indices; i++)
        {
            System.out.println("Enter numbers");
            Scanner sc2 = new Scanner(System.in);
            numArray[i] = sc2.nextInt();
            sum = sum + numArray[i];
        }
        //get average
        int average = sum/indices;
        System.out.println("average is " + average);
        
       //find closest to average
        int closestToAvg=numArray[0];
        for(int x=0; x<numArray.length; x++)
        {
            if(closestToAvg>(numArray[x]-average))
            {
                closestToAvg=numArray[x]-average;
                closestToAvg = numArray[x];
            }
        }
        System.out.println("closest to average is "+closestToAvg);
    }
}
