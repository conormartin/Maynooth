/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
#include <cstdlib>
#include <ctime>
#include "die.h"

using namespace std;

//die class takes in int as number of sides
die::die(int x)
{
  if(x<4)
  {
    numSides = 6;
    cout << "Dice must have a minimum of 4 sides, default dice with 6 sides has been selected" << endl;
  }
  else
  {
    numSides = x;
  }
}
//roll function calculates two rolls of die with x sides and returns the sum of the values
int die::roll(int numSides)
{
  int roll1 = rand() % (numSides) + 1;
  int roll2 = rand() % (numSides) + 1;
  value = roll1 + roll2;
  return value;
}
//getNumsides returns the value for the number of sides stored in the object
int die::getNumsides()
{
  return numSides;
}

//getValue returns the value of the two dice rolls of the object
int die::getValue()
{
  return value;
}




