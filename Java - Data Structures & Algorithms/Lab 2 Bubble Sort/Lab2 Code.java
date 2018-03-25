import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        
    int[] numArray = new int[3];
    Scanner sc1 = new Scanner(System.in);
    for(int k=0; k<numArray.length; k++)
    {
        numArray[k] = sc1.nextInt();
    }
    
    //Sort from smallest to largest
    int temp = 0;
    for(int i=0; i<numArray.length-1; i++)
    {
        for(int j=0; j<numArray.length-i-1; j++)
        {
            if(numArray[j]>numArray[j+1])
               {
                   temp = numArray[j];
                   numArray[j] = numArray[j+1];
                   numArray[j+1] = temp;
               }
        }    
    }
    
    int num1 = numArray[1]-numArray[0];
    int num2 = numArray[2]-numArray[1];
    if(num1>num2)
    {
        System.out.println(numArray[0]);
    }
    
   else if (num2>num1)
   {
       System.out.println(numArray[2]);
    }
    
    else
    {
        System.out.println("NA");
    }
}
}