/* NAME: Conor MARTIN
STUDENT NUMBER: 17185581*/
  
#include <iostream>
#include <cstdlib>
#include "die.h"
#include <ctime>
  
using namespace std;

int main()
{
  srand(time(NULL));
  cout << "How many sides do the die have?" << endl;	
  int sides;
  cin >> sides;
  die dice1(sides);
  int numOfSides = dice1.getNumsides();

  cout << "Please enter the number of times you wish to roll the die: " << endl;	
  int numOfRolls;
  cin >> numOfRolls;
  
  int diceFaces = numOfSides*2;
    
  //Create array and set each index to 0
  int diceTotals [diceFaces-1];
  for (int i=0; i<diceFaces; i++)
  {
    diceTotals[i] = 0;
  }
  
  //Rolls two dice and adds total then increments each array index by 1
  for(int j=0; j<numOfRolls; j++)
  {	
    int rollResult = dice1.roll(numOfSides);
    int rollValue = dice1.getValue();
    diceTotals[rollValue-2]++;
  }

  //For loop to print out each index of the array as a percentage value
  for (int z=0; z<diceFaces-1; z++)
  {
    int percentage = diceTotals[z]*100/numOfRolls;
    cout << z+2 << " was rolled " << percentage << "% of the time" << endl;
  }
}