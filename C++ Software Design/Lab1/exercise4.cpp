/* Name: Conor MARTIN
Student Number: 17185581*/

#include <iostream>
using namespace std;

int main()
{
	int creditLimit = 2000;
	int accNumber;
	bool exit = false;
	/*Set boolean to false, if -1 is entered, boolean will change 
        to true and while loop will break*/
	while(exit==false)
	{
	    cout << "Please enter your account number" << endl;
	    cout << "To exit the program, press -1 and hit enter" << endl;
	    cin >> accNumber;

	    if(accNumber==-1)
	    {
	        exit = true;
	        break;
	    }
	    //User inputs details to get new balance
            int startBal;
	    cout << "Please enter your starting balance" << endl;
    	    cin >> startBal;
    	    int charges;
    	    cout << "Please enter your total charges to your account for the month" << endl;
    	    cin >> charges;
    	    int credits;
    	    cout << "Please enter your total credits for the month" << endl;
    	    cin >> credits;
	
    	    int newBalance = startBal+charges-credits;	
    	    cout << "Your new balance is: " << newBalance << endl;

    	    /*If new balance exceeds credit limit, the if statement activates, 
	    otherwise loop restarts*/
	    if (newBalance>creditLimit)
  	    {
	  	    cout << "Account number: " << accNumber << "\n" << "Balance: " << newBalance 		  	    << "\n" << "Credit limit: " << creditLimit << endl;	
	  	    cout << "Credit Limit Exceeded" << endl;
	    }
	}
	    cout << "You have exited the program" << endl;
}
