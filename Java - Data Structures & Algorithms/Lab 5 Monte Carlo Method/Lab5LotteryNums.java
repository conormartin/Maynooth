import java.util.Scanner;
public class Lab5LotteryNums
{
	public static void main(String args[])
	{
        System.out.println("Enter highest number to be drawn for winning numbers:");
        Scanner sc = new Scanner(System.in);
        double winningNums = sc.nextDouble();
        double success = 0;
        double simulations = 1000000;
        boolean check = true;
        int[] lottoArray = {0,0,0,0,0,0};

        for(int i=0; i<simulations; i++)
        {
            int count=0;
            int lottoNum = 0;
            for(int j=0; j<6; j++)
            {
                lottoNum = (int)(Math.random()*45+1);
                while(check==true)
                {
                    check = arrayCheck(lottoNum,lottoArray);

                    if(check==false)
                    {
                        break;
                    }
                    else
                    {
                        lottoNum = (int)(Math.random()*45+1);
                    }
                }
                lottoArray[j] = lottoNum;
                
                if(lottoArray[j]<=winningNums)
                {
                    count++;
                }
            } 
            if(count==6)
            {
                success++;
            }
        }
        double result = ((success/simulations)*100);
        System.out.println("The probability of the winning lottery numbers all being less than "+winningNums+" is "+result+"%");
    }
    
    public static boolean arrayCheck(int x, int[]y)
    {
        boolean check = false;
        for(int i=0; i<6; i++)
        {
            if(y[i]==x)
            {
                check = true;
            }
        }
        return check;
    }
}