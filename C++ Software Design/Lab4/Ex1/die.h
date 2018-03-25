/* NAME: Conor MARTIN
 STUDENT NUMBER: 17185581*/

#include <iostream>
#include <cstdlib>

using namespace std;

class die
{
  public:
    
    //Constructor
    die (int x);
    
    //Public functions
    int roll(int numOfRolls);
    int getValue();
    int getNumsides();
  
  //private variables
  private:
    int value;
    int numSides;
};