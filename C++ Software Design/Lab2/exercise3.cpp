/* NAME: Conor MARTIN
STUDENT NUMBER: 17185581*/

#include <iostream>
#include <cstdlib>

using namespace std;

void rollDice(int x)
{
  srand(time(NULL));
	int roll1, roll2, sum;
	//Create array and set each index to 0
	int diceTotals [11];
	for (int i=0; i<11; i++)
	{
		diceTotals[i] = 0;
	}

	//Rolls two dice and adds total then increments each array index by 1
	for(int j=0; j<x; j++)
	{	
		roll1 = rand() % 6 + 1;
		roll2 = rand() % 6 + 1;
		sum = roll1 + roll2;
		diceTotals[sum-2]++;
	}

	//For loop to print out each index of the array as a percentage value
	for (int z=0; z<11; z++)
	{
	  int percentage = diceTotals[z]*100/x;
		cout << z+2 << " was rolled " << percentage << "% of the time" << endl;
	}
}

int main()
{
	cout << "Please enter the number of times you wish to roll the two dice: " << endl;	
	int numberOfRolls;
	cin >> numberOfRolls;
	rollDice(numberOfRolls);
}