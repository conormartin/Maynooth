/* Name: Conor MARTIN
Student Number: 17185581*/

#include <iostream>
using namespace std;

//function to find all prime numbers up to the input integer
void findPrimeNums(int x)
{
//Outer loop runs x times
  for(int i=2; i<=x; i++)
  {
    /*Declare boolean as true, if any value of i modulo j is 0 
      then number is not prime so boolean changed to false*/
    bool isPrime = true;
    for (int j=2; j<=i/2; j++)
    {
      if (i%j==0)
      {
        isPrime = false;
	//Break statement to stop loop running again needlessly
	break;
      }
    }
   //If i%j==0 never verifies and x isnt 1, the number is prime
   if (isPrime==true && x!=1)
   {
     cout << i << " is a prime number" << endl;
   }
  }
}

int main()
{
//Calling function to find prime numbers	  
findPrimeNums(5000);
}
