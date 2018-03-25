import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arraySize = num*num;
        boolean[] array = new boolean[arraySize];
        array[0]=false;
        array[1]=false;
        
        for(int i=2; i<arraySize; i++)
        {
            array[i] = true;
        }
        int closestPrime=0;
        int dist1=num;
		int dist2=0;
        for(int j=2; j<arraySize; j++)
        {
            if(array[j]==true)
            {
                for(int x=j+j; x<arraySize; x+=j)
                {
                    array[x]=false;
                }
                if(Math.abs(num-j)<dist1)
                {
                    dist1=(Math.abs(num-j));
                    closestPrime = j;
                }
                
				if(closestPrime<num && array[closestPrime+1]==true)
                {
					dist2=(Math.abs(closestPrime+1));
				}
                else if(closestPrime>num && array[closestPrime-1]==true)
                {
					dist2=(Math.abs(closestPrime-1));
                }
            }
        }
		System.out.println(dist1+dist2);
        
    }
}