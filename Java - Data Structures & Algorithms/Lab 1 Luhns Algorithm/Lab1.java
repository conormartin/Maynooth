import java.util.*;
import java.util.Scanner;
public class Lab1 {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String testCase1 = sc.nextLine();
        check(testCase1);
    }

public static void check(String cardNum)
{ 
    int sum = 0;
    int[] cardArray = new int[cardNum.length()];
    for(int j=0; j<cardArray.length; j++)
    {
        cardArray[j] = Integer.parseInt(String.valueOf(cardNum.charAt(j)));
    }
    
    for(int i=0; i<cardArray.length; i++)
    {
        int digit = (cardArray[cardArray.length-i-1]);
        if (i%2==1)
        {
            digit = digit*2;
        }
        if(digit>9)
        {
            sum = sum+digit-9;
        }
        else
        {
            sum = sum+digit;
        }
    }
    if (sum%10==0)
    {
        System.out.println("VALID");
    }
    else
    {
        System.out.println("INVALID");
    }
}
}